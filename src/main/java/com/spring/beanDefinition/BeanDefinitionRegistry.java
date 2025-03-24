package com.spring.beanDefinition;

/**
 * @author haoze
 * @create 2025/3/24 14:52
 * @description
 */
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String beanName, AnnotatedBeanDefinition beanDefinition);
}
