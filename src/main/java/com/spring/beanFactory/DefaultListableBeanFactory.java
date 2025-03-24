package com.spring.beanFactory;

import com.spring.annotation.ComponentScan;
import com.spring.annotation.Scope;
import com.spring.annotation.Service;
import com.spring.beanDefinition.AnnotatedBeanDefinition;
import com.spring.beanDefinition.AnnotatedGenericBeanDefinition;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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

    private List<String> beanDefinitionNames = new ArrayList<String>();

    private Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);

    @Override
    public void registerBeanDefinition(String beanName,
                                       AnnotatedBeanDefinition beanDefinition) {
        this.beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public Object getBean(String beanName) {

        //只有bean都注册完，才有getBean
        return doGetBean(beanName);
    }

    private Object doGetBean(String beanName) {
        Object bean = singletonObjects.get(beanName);
        if (bean != null) return bean;
        //需要根据 beanDefinition 创建bean
        AnnotatedGenericBeanDefinition abd = (AnnotatedGenericBeanDefinition)beanDefinitionMap.get(beanName);
        Object object = createBean(beanName, abd);
        if (abd.getScope().equals("singleton")) {
            singletonObjects.put(beanName, object);
        }
        return object;

    }

    private Object createBean(String beanName, AnnotatedGenericBeanDefinition abd) {
        try {
            return abd.getClazz().getConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     */
    public void doScan() {
        for (String beanName : beanDefinitionMap.keySet()) {
            AnnotatedGenericBeanDefinition bd = (AnnotatedGenericBeanDefinition) beanDefinitionMap.get(beanName);
            if (bd.getClazz().isAnnotationPresent(ComponentScan.class)) {
                ComponentScan componentScan = (ComponentScan) bd.getClazz().getAnnotation(ComponentScan.class);
                String basePackage = componentScan.value();//my.self.test.bean
                URL resource = this.getClass().getClassLoader()
                        .getResource(basePackage.replace(".", "/"));
                File file = new File(resource.getFile());
                if (file.isDirectory()) {
                    for (File f : file.listFiles()) {
                        try {
                            Class<?> clazz = this.getClass().getClassLoader()
                                    .loadClass(basePackage.concat(".").concat(f.getName().split("\\.")[0]));
                            if (clazz.isAnnotationPresent(Service.class)) {
                                String name = ((Service) clazz.getAnnotation(Service.class)).value();
                                AnnotatedGenericBeanDefinition abd = new AnnotatedGenericBeanDefinition();
                                abd.setClazz(clazz);
                                if (clazz.isAnnotationPresent(Scope.class)) {
                                    abd.setScope(((Scope) clazz.getAnnotation(Scope.class)).value());
                                } else {
                                    abd.setScope("singleton");
                                }
                                beanDefinitionMap.put(name, abd);
                                beanDefinitionNames.add(name);
                            }


                        } catch (ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

            }
        }
        System.out.println(beanDefinitionNames);
    }

    public void preInstantiateSingletons() {
        //初始化用户定义的Bean，需要找到所有自定义的beanName
        List<String> beanNames = new ArrayList<>(beanDefinitionNames);
        for (String beanName : beanNames) {
            AnnotatedGenericBeanDefinition abd =
                    (AnnotatedGenericBeanDefinition) beanDefinitionMap.get(beanName);
            if (abd.getScope().equals("singleton")) {
                //创建单例对象，保存到单例缓存中
                getBean(beanName);
            }
        }
    }
}
