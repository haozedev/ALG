package com.spring.beanFactory;

import com.spring.beanDefinition.AnnotatedBeanDefinition;

/**
 * @author haoze
 * @create 2025/3/24 13:37
 * @description
 */
public interface BeanFactory {
    void registerBeanDefinition(String beanName,
                                AnnotatedBeanDefinition beanDefinition);

    public Object getBean(String beanName);
}
