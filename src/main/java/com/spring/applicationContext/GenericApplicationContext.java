package com.spring.applicationContext;

import com.spring.beanDefinition.AnnotatedBeanDefinition;
import com.spring.beanDefinition.BeanDefinitionRegistry;
import com.spring.beanFactory.DefaultListableBeanFactory;
import org.springframework.beans.BeansException;

/**
 * @author haoze
 * @create 2025/3/24 15:52
 * @description
 */
public class GenericApplicationContext implements BeanDefinitionRegistry {
    private DefaultListableBeanFactory beanFactory;

    public GenericApplicationContext() {
        this.beanFactory = new DefaultListableBeanFactory();
    }

    @Override
    public void registerBeanDefinition(String beanName, AnnotatedBeanDefinition beanDefinition) {
        this.beanFactory.registerBeanDefinition(beanName, beanDefinition);
    }

    public void refresh() {
        //获取bean工厂
        DefaultListableBeanFactory beanFactory = obtainBeanFactory();
        //把appConfig下的bean
        invokeBeanFactoryPostProcessors(beanFactory);
        //初始化beanDefinition所代表的单例bean，放到单例bean的容器(缓存)中
        finishBeanFactoryInitialization(beanFactory);
    }

    private void finishBeanFactoryInitialization(DefaultListableBeanFactory beanFactory) {
        //
    }

    private void invokeBeanFactoryPostProcessors(DefaultListableBeanFactory beanFactory) {
        //doScan
        beanFactory.doScan();
    }

    private DefaultListableBeanFactory obtainBeanFactory() {
        return this.beanFactory;
    }
}
