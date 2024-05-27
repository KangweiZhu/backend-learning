package com.anicaaz.test;

import com.anicaaz.springplayground.controller.UserController;
import com.anicaaz.springplayground.service.UserService;
import org.myspringframework.factory.ClassPathXmlApplicationContext;

public class TestDI {

    @org.junit.jupiter.api.Test
    public void test() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //byName
        //UserService userServiceImpl = (UserService) classPathXmlApplicationContext.getBeanByValue("aaa");
        //userServiceImpl.add();
//        UserService userServiceImpl = (UserService) classPathXmlApplicationContext.getBeanByValue("userServiceImpl");
//        userServiceImpl.add();
        //byType
        UserController userController = (UserController) classPathXmlApplicationContext.getBeanByType(UserController.class);
        userController.serviceMethod();
    }
}
