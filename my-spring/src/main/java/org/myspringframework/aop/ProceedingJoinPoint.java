package org.myspringframework.aop;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ProceedingJoinPoint {

    //目标类的对象
    Object targetObject;

    //目标方法
    Method targetMethod;

    //目标方法的参数
    Object[] targetParam;

    public ProceedingJoinPoint(Object targetObject, Method targetMethod, Object[] targetParam) {
        this.targetObject = targetObject;
        this.targetMethod = targetMethod;
        this.targetParam = targetParam;
    }

    public Object getTargetObject() {
        return targetObject;
    }

    public void setTargetObject(Object targetObject) {
        this.targetObject = targetObject;
    }

    public Method getTargetMethod() {
        return targetMethod;
    }

    public void setTargetMethod(Method targetMethod) {
        this.targetMethod = targetMethod;
    }

    public Object[] getTargetParam() {
        return targetParam;
    }

    public void setTargetParam(Object[] targetParam) {
        this.targetParam = targetParam;
    }

    /**
     * 调用 需要被代理的方法。
     *
     * @return
     */
    public Object proceed() {
        Object result = null;
        try {
            // 调用被代理类的方法。
            result = targetMethod.invoke(targetObject, targetParam);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        //System.out.println(result);
        return 0;//bug
    }
}
