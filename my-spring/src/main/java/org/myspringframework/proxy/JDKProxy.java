package org.myspringframework.proxy;

import org.myspringframework.aop.ProceedingJoinPoint;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模拟 Spring中采用的 JDK代理
 *
 * @author anicaa
 */
public class JDKProxy {
    //aop的类
    Class<?> aopClass;

    //被代理的类
    Class<?> targetClass;

    //被代理的类的对象
    Object targetObject;

    //Around注解中， 内部execution的方法名
    String targetMethodName;

    //被Around注解的方法, aop中的
    Method aopMethod;

    /**
     * 构造方法。
     * @param aopClass 项目中，AOP包中的类（实现具体代理逻辑的类）
     * @param targetClass 被代理的类
     * @param targetObject 被代理的类在Spring IoC容器中的具体实例对象
     * @param targetMethodName AOP包中的 类 中的 方法 上，注解的值（Around，Before, After = （“value”））
     * @param aopMethod AOP保重的 类。我们通过调用这个来实现 代理。
     */
    public JDKProxy(Class<?> aopClass, Class<?> targetClass, Object targetObject, String targetMethodName, Method aopMethod) {
        this.aopClass = aopClass;
        this.targetClass = targetClass;
        this.targetObject = targetObject;
        this.targetMethodName = targetMethodName;
        this.aopMethod = aopMethod;
    }

    /**
     * 生成代理类对象。
     * @return
     */
    public Object getProxyObject() {
        return Proxy.newProxyInstance(targetClass.getClassLoader(), targetClass.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object invokeResult;
                //不是所有方法都需要代理的，需要判断 aroundMethod 是不是与我们 around 中， execution 的值相同
                if (method.getName().equals(targetMethodName)) {
                    //可以理解称 aop类的方法被调用了， 调用aop方法需要具体的aop类实例， 并且传入切入点（aopMethod的方法参数必是ProceedingJoinPoint)。切入点指的是被代理的类的对象、方法、以及参数
                    invokeResult = aopMethod.invoke(aopClass.newInstance(), new ProceedingJoinPoint(targetObject, method, args));
                } else {
                    // 正常调用。
                    invokeResult = method.invoke(targetObject, args);
                }
                return 0;
            }
        });
    }

    public Class<?> getAopClass() {
        return aopClass;
    }

    public void setAopClass(Class<?> aopClass) {
        this.aopClass = aopClass;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(Class<?> target) {
        this.targetClass = target;
    }

    public Object getTargetObject() {
        return targetObject;
    }

    public void setTargetObject(Object targetObject) {
        this.targetObject = targetObject;
    }

    public String getTargetMethodName() {
        return targetMethodName;
    }

    public void setTargetMethodName(String methodName) {
        this.targetMethodName = methodName;
    }

    public Method getAopMethod() {
        return aopMethod;
    }

    public void setAopMethod(Method aopMethod) {
        this.aopMethod = aopMethod;
    }
}
