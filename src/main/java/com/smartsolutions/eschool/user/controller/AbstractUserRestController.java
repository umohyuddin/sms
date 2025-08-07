package com.smartsolutions.eschool.user.controller;

import com.smartsolutions.eschool.user.model.UserRoleEntity;
import com.smartsolutions.eschool.util.ResourceObject;
import com.smartsolutions.eschool.user.model.UserEntity;
import com.smartsolutions.eschool.user.facade.UserServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractUserRestController {
	private UserServiceFacade userServiceFacade;

	@Autowired
	public AbstractUserRestController(UserServiceFacade userServiceFacade) {
		this.userServiceFacade = userServiceFacade;
	}

	public UserServiceFacade asCurrentUser() throws Exception {
		return userServiceFacade.changeUser();
	}

	protected static ResourceObject toResourceObject(UserEntity userEntity) {
		if (userEntity == null) {
			return null;
		}
		final Map<String, Object> resourceAttributes = new HashMap<>(2);
		resourceAttributes.put("Id", userEntity.getId());
		resourceAttributes.put("Role ID", userEntity.getRoleId());
		resourceAttributes.put("Employee ID", userEntity.getEmpId());
		resourceAttributes.put("Campus ID", userEntity.getCmpId());
		resourceAttributes.put("Is Active", userEntity.isActive());
		resourceAttributes.put("Account NON Expired", userEntity.isAccountNonExpired());
		resourceAttributes.put("Account NON Locked", userEntity.isAccountNonLocked());
		resourceAttributes.put("Credentials Non Expired", userEntity.isCredentialsNonExpired());
		resourceAttributes.put("email", userEntity.getEmail());
		resourceAttributes.put("Enabled", userEntity.getEnabled());
		resourceAttributes.put("Created at", userEntity.getCreatedAt());
		resourceAttributes.put("updated at", userEntity.getUpdatedAt());

		return new ResourceObject(String.valueOf(userEntity.getId()), "User", resourceAttributes);
	}

	protected static ResourceObject roleToResourceObject(UserRoleEntity userRoleEntity) {
		if (userRoleEntity == null) {
			return null;
		}
		final Map<String, Object> resourceAttributes = new HashMap<>(2);
		resourceAttributes.put("Id", userRoleEntity.getId());
		resourceAttributes.put("Role ID", userRoleEntity.getCreatedAt());
		resourceAttributes.put("Created at", userRoleEntity.getCreatedAt());
		resourceAttributes.put("updated at", userRoleEntity.getUpdatedAt());

		return new ResourceObject(String.valueOf(userRoleEntity.getId()), "User Role", resourceAttributes);
	}

	protected static ResourceObject strToResourceObject(String str) {
		if (str.isEmpty()) {
			return null;
		}
		final Map<String, Object> resourceAttributes = new HashMap<>(2);

		resourceAttributes.put("message", str);
		return new ResourceObject("id", "message", resourceAttributes);
	}
}
