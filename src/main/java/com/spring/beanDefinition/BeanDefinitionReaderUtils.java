package com.spring.beanDefinition;



/**
 * @author haoze
 * @create 2025/3/24 14:48
 * @description
 */
public class BeanDefinitionReaderUtils {
    public static void registerBeanDefinition
            (AnnotatedBeanDefinition beanDefinition,
             BeanDefinitionRegistry registry) {
        String beanName = ((AnnotatedGenericBeanDefinition)beanDefinition).getClazz().getSimpleName();
        registry.registerBeanDefinition(beanName,beanDefinition);
    }
}
