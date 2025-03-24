package com.spring.applicationContext;

import com.spring.beanDefinition.AnnotateBeanDefinitionReader;
import com.spring.beanDefinition.BeanDefinitionRegistry;

/**
 * @author haoze
 * @create 2025/3/24 14:06
 * @description
 */
public class AnnotationConfigApplicationContext
        extends GenericApplicationContext
        implements BeanDefinitionRegistry {

    private AnnotateBeanDefinitionReader reader;

    public AnnotationConfigApplicationContext() {
        this.reader=new AnnotateBeanDefinitionReader(this );
    }

    public AnnotationConfigApplicationContext(Class<?> componentClass) {
        //1.componentClass 即扫描路径所在的类 -- AppConfig。定义阅读器
        //专门读取 AnnotateBeanDefinitionReader
        this();
        //2.先把这个类AppConfig 注册到 bean 工厂里(BeanDefinition +
        // registerBeanDefinition + FactoryBean)
        register(componentClass);
        //3.扫描路径，然后提取路径下所有的bean，然后注册到bean工厂(单例bean的初始化)
        //refresh方法作为核心方法，放到父类中，让所有子类都能使用
        refresh();
    }

    private void register(Class<?> componentClass) {
        this.reader.register(componentClass);
    }


}
