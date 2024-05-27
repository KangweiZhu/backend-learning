package com.anicaaz.test;

import com.anicaaz.springplayground.service.UserService;
import com.anicaaz.springplayground.service.impl.UserServiceImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * JDK 动态代理
 */
public class SpringProxyShowcase {

    @Test
    public void testJDKProxy() {
        UserService userService = (UserService) Proxy.newProxyInstance(UserServiceImpl.class.getClassLoader(), UserServiceImpl.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("[JDK]Before UserService's add().");
                Object invokeResult = method.invoke(new UserServiceImpl(), args);
                System.out.println("[JDK]After UserService's add().");
                return invokeResult;
            }
        });
        userService.add();
        System.out.println("--------------------------");
    }

    /**
     * needs to add :
     *      --add-opens java.base/java.lang=ALL-UNNAMED
     * to your idea compile option
     */
    @Test
    public void testCGLIBProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("[cglib]Before UserService's add()");
                Object invokeResult = methodProxy.invokeSuper(o, objects);
                System.out.println("[cglib]After UserService's add()");
                return invokeResult;
            }
        });
        UserService userService = (UserService) enhancer.create();
        userService.add();
    }
}