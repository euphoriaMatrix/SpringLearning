package com.xia.service;

import com.xia.spring.*;

/**
 * @author xwfstart
 * @create 2022-06-23 23:53
 */
@Component("userService")
@Scope("singleton")
//@Scope("prototype") //原型模式, 多例
public class UserService implements BeanNameAware , InitializingBean, UserInterface {

    @Autowired
    private OrderService orderService;

    private String beanName;

    public void test() {
        System.out.println(orderService);
    }

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    @Override
    public void afterPropertiesSet() {

        System.out.println("初始化");
    }
}
