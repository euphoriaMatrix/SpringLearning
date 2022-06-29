package com.xia.spring;

/**
 * @author xwfstart
 * @create 2022-06-29 0:05
 */
public interface BeanPostProcessor {

    public Object postProcessBeforeInitialization(String beanName, Object bean);
    public Object postProcessAfterInitialization(String beanName, Object bean);

}
