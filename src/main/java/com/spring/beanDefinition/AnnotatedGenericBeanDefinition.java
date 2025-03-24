package com.spring.beanDefinition;



/**
 * @author haoze
 * @create 2025/3/24 14:30
 * @description AnnotatedGenericBeanDefinition
 */
public class AnnotatedGenericBeanDefinition implements AnnotatedBeanDefinition {
    private Class clazz;
    private String scope;

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
