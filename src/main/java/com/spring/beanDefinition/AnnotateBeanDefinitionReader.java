package com.spring.beanDefinition;

import com.spring.annotation.Scope;
import com.spring.beanFactory.DefaultListableBeanFactory;

/**
 * @author haoze
 * @create 2025/3/24 14:20
 * @description
 */
public class AnnotateBeanDefinitionReader {

    private BeanDefinitionRegistry registry;
    public AnnotateBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public void register(Class<?> componentClass) {
        registerBean(componentClass);
    }

    private void registerBean(Class<?> componentClass) {
        doRegisterBean(componentClass);
    }

    private void doRegisterBean(Class<?> componentClass) {
        //把 appConfig 读成一个BeanDefinition定义
        AnnotatedGenericBeanDefinition beanDefinition= new AnnotatedGenericBeanDefinition();
        beanDefinition.setClazz(componentClass);
        beanDefinition.setScope("");
        if (componentClass.isAnnotationPresent(Scope.class)){
            String scope = componentClass.getAnnotation(Scope.class).value();
        }else {
            beanDefinition.setScope("singleton");
        }
        //beanDefinition 创建完之后得给 beanFactory 进行bean注册
        BeanDefinitionReaderUtils.registerBeanDefinition(beanDefinition,this.registry);
    }
}
