package com.anicaaz.test;

import com.anicaaz.springplayground.controller.UserController;
import com.anicaaz.springplayground.service.UserService;
import org.myspringframework.factory.ClassPathXmlApplicationContext;

/**
 * 这段代码用于演示在 依赖注入 后，进行 AOP代理 会产生的问题。
 * 需要在ClassPathXmlApplication.java中， 手动调整 doAOP() 和 doDI() 的前后顺序。
 *
 * @author anicaa
 */
public class DoAspectAfterDIShowcase {

    @org.junit.jupiter.api.Test
    public void test() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 理解： 当doAOP放在di后面是， service已经被替换成代理，不受影响，因此会输出Before | add() is called | After 三行
        UserService userServiceImpl = (UserService) classPathXmlApplicationContext.getBeanByValue("userServiceImpl");
        userServiceImpl.add();

        // 而 UserController中注入的Service依旧是原来的未被代理的ServiceImpl对象， 因此不会输出 Before 和 After. 只会输出 add() is called
        UserController userController = (UserController) classPathXmlApplicationContext.getBeanByType(UserController.class);
        userController.serviceMethod();
    }
}
