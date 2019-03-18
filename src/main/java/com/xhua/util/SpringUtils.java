package com.xhua.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Administrator on 2019/3/14.
 */
@Component
public class SpringUtils implements ApplicationContextAware{

    private static ApplicationContext applicationContext;

    public static <T> T getBean(Class<T> clazz){
        return (T) applicationContext.getBean(clazz);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringUtils.applicationContext == null){
            SpringUtils.applicationContext = applicationContext;
        }
    }
}
