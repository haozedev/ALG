package com.spring.beanFactory;

import com.spring.annotation.ComponentScan;
import com.spring.beanDefinition.AnnotatedBeanDefinition;
import com.spring.beanDefinition.AnnotatedGenericBeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author haoze
 * @create 2025/3/24 15:37
 * @description
 */
public class DefaultListableBeanFactory implements BeanFactory {

    private final Map<String, AnnotatedBeanDefinition> beanDefinitionMap =
            new ConcurrentHashMap<String, AnnotatedBeanDefinition>(256);

    @Override
    public void registerBeanDefinition(String beanName,
                                       AnnotatedBeanDefinition beanDefinition) {
        this.beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public Object getBean(String beanName) {

        //只有bean都注册完，才有getBean
        return null;
    }

    /**
     *
     */
    public void doScan() {
        for (String beanName : beanDefinitionMap.keySet()) {
            AnnotatedGenericBeanDefinition bd = (AnnotatedGenericBeanDefinition) beanDefinitionMap.get(beanName);
            if (bd.getClazz().isAnnotationPresent(ComponentScan.class)){
                ComponentScan componentScan = (ComponentScan) bd.getClazz().getAnnotation(ComponentScan.class);
                String basePackage ="my.self.test.bean";
            }
        }
    }
}
