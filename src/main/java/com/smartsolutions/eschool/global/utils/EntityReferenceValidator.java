package com.smartsolutions.eschool.global.utils;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.global.error.AppModule;
import com.smartsolutions.eschool.global.error.BaseErrorCode;
import com.smartsolutions.eschool.global.error.ErrorCategory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.metamodel.Attribute;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.Metamodel;
import jakarta.persistence.metamodel.SingularAttribute;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class EntityReferenceValidator {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Dynamically checks if the given target entity is currently referenced by any other entity
     * in the database via a ManyToOne or OneToOne association.
     * Hibernate's @SQLRestriction("deleted = false") is automatically applied to Criteria queries,
     * so only active (non-soft-deleted) references are considered.
     *
     * @param targetEntityClass The class of the entity being deleted (e.g., CampusEntity.class)
     * @param targetId          The primary key ID of the entity being deleted
     */
    public void ensureNotReferenced(Class<?> targetEntityClass, Object targetId) {
        Metamodel metamodel = entityManager.getMetamodel();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        for (EntityType<?> entityType : metamodel.getEntities()) {
            for (Attribute<?, ?> attribute : entityType.getAttributes()) {
                if (attribute.isAssociation() && attribute instanceof SingularAttribute) {
                    SingularAttribute<?, ?> singularAttribute = (SingularAttribute<?, ?>) attribute;

                    if (targetEntityClass.isAssignableFrom(singularAttribute.getJavaType())) {

                        log.debug("Checking references in {} via attribute {}", entityType.getName(), attribute.getName());

                        CriteriaQuery<Integer> cq = cb.createQuery(Integer.class);
                        Root<?> root = cq.from(entityType.getJavaType());
                        cq.select(cb.literal(1));
                        cq.where(cb.equal(root.get(singularAttribute.getName()).get("id"), targetId));

                        List<Integer> results = entityManager.createQuery(cq)
                                .setMaxResults(1)
                                .getResultList();

                        if (!results.isEmpty()) {
                            String referencingEntity = entityType.getName().replace("Entity", "");
                            String targetName = targetEntityClass.getSimpleName().replace("Entity", "");

                            throw new ApiException(
                                    buildErrorCode(targetName, referencingEntity),
                                    HttpStatus.CONFLICT
                            );
                        }
                    }
                }
            }
        }
    }

    /**
     * Builds a dynamic BaseErrorCode for reference-violation errors.
     */
    private BaseErrorCode buildErrorCode(String targetName, String referencingEntity) {
        String msg = "Cannot delete " + targetName + ". It is currently referenced by active " + referencingEntity + " records.";
        return new BaseErrorCode() {
            @Override
            public AppModule module() {
                return AppModule.COMMON;
            }

            @Override
            public ErrorCategory category() {
                return ErrorCategory.BUSINESS;
            }

            @Override
            public int number() {
                return 999;
            }

            @Override
            public String message() {
                return msg;
            }
        };
    }
}
