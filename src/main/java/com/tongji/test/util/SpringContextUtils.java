package com.tongji.test.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// <bean id="springContextUtils" class="com.tongji.test.util.SpringContextUtils" />
public class SpringContextUtils implements ApplicationContextAware {

    /**
     * spring 上下文环境
     */
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtils.applicationContext = applicationContext;
    }

    /**
     * 获取 Bean 对象
     *
     * @param name
     * @return
     */

    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }
}
