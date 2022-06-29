package com.xia.service;

import com.xia.spring.BeanPostProcessor;
import com.xia.spring.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xwfstart
 * @create 2022-06-29 0:07
 */
@Component
public class XiaBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(String beanName, Object bean) {
        if (beanName.equals("userService")) {
            System.out.println("before");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(String beanName, Object bean) {
        if (beanName.equals("userService")) {
            System.out.println("after");
            Object proxyInstance = Proxy.newProxyInstance(XiaBeanPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("切面逻辑"); // 代理逻辑
                    return method.invoke(bean, args);
                }
            });
            // 返回代理对象, 代理method
            return proxyInstance;
        }
        return bean;
    }
}
