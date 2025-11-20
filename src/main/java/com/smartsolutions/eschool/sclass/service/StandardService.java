package com.smartsolutions.eschool.sclass.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.sclass.model.SClassEntity;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import com.smartsolutions.eschool.sclass.repository.SClassDao;
import com.smartsolutions.eschool.sclass.repository.StandardDao;
import com.smartsolutions.eschool.sclass.repository.StandardDaoImp;
import com.smartsolutions.eschool.util.ResourceObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StandardService {
    @Autowired
    private StandardDao standardDao;

    @Autowired
    private ObjectMapper objectMapper; //

    public List<ResourceObject> getAll() {
        log.info("Fetching all standards from database");
        List<StandardEntity> result = standardDao.findAll();
        log.info("Successfully fetched {} standards", result.size());
        return result.stream().map(entity -> {
            Map<String, Object> resourceAttributes = objectMapper.convertValue(entity, Map.class);
            return new ResourceObject(String.valueOf(entity.getId()), "standards",
                    resourceAttributes);
        }).collect(Collectors.toList());
    }
//    public SClassEntity getById(Long id) {
//        return SClassDao.findById(id);
//    }
//
//    public List<SClassEntity> getByTeacherId(Long id) {
//        return SClassDao.findByTeacherId(id);
//    }
//
//    public List<SClassEntity> getByCourseId(Long id) {
//        return SClassDao.findByCourseId(id);
//    }
//
//    public List<SClassEntity> getByStudentId(Long id) {
//        return SClassDao.findByStudentId(id);
//    }
//
//    public String create(SClassEntity pSClassEntity) {
//        return SClassDao.save(pSClassEntity) == 1 ? "class created" : "Error creating class";
//    }
//
//    public String update(SClassEntity pSClassEntity) {
//        return SClassDao.update(pSClassEntity) == 1 ? "class updated" : "Error updating class";
//    }
//
//    public String delete(Long id) {
//        return SClassDao.delete(id) == 1 ? "class deleted" : "Error deleting class";
//    }
}
