package com.springTest;

import com.pojo.Person;

import java.beans.*;
import java.util.stream.Stream;

/**
 * @author haoze
 * @create 2025/5/20 9:26
 * @description
 */
public class BeanInfoDemo {
    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);
//        System.out.println(beanInfo.getBeanDescriptor());
        Stream.of(beanInfo.getPropertyDescriptors())
                .forEach(propertyDescriptor -> {
//                    System.out.println(propertyDescriptor);
//                    PropertyEditor propertyEditor =
//                            propertyDescriptor.createPropertyEditor(Person.class);
                    Class<?> propertyType = propertyDescriptor.getPropertyType();
                    String propertyName = propertyDescriptor.getName();
                    if ("age".equals(propertyName)){
                        propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
//                        propertyDescriptor.createPropertyEditor();
                        System.out.println(propertyDescriptor);
                    }

                });

    }
    static class StringToIntegerPropertyEditor extends PropertyEditorSupport{
        public void setAsText(String text) throws java.lang.IllegalArgumentException {
            Integer value = Integer.valueOf(text);
            setValue(value);
        }
    }
}
