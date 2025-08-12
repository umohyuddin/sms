package com.smartsolutions.eschool.user.controller;

import com.smartsolutions.eschool.util.ResourceObject;
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

//	protected static ResourceObject toResourceObject(User user) {
//		if (user == null) {
//			return null;
//		}
//		final Map<String, Object> resourceAttributes = new HashMap<>(2);
//		resourceAttributes.put("schoolId", user.getSchoolId());
//		resourceAttributes.put("campusUuid", user.getCampusUuid());
//		resourceAttributes.put("firstName", user.getFirstName());
//		resourceAttributes.put("lastName", user.getLastName());
//		resourceAttributes.put("email", user.getEmail());
//
//		return new ResourceObject(String.valueOf(user.getId()), "students", resourceAttributes);
//	}
}
