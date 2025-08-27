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

}
