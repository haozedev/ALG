package com.util;

import com.pojo.MethodDO;
import org.springframework.util.StringUtils;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName GetMethod
 * @Description TODO
 * @Author ty-ChaiHaoZe
 * @Date 2022/7/30
 * @Version TODO
 * @History TODO
 **/
public class GetMethod {
    public static void main(String[] args) {
//        String jarFilePath = "D:\\IdeaProjects\\ALG\\src\\main\\java\\com\\alg";
//
//        System.out.println("当前jar包路径: " + jarFilePath);
//        if (!new File(jarFilePath).exists()) {
//            System.out.println("文件路径不正确: " + jarFilePath);
//        }


//        Map<String,Object> map = new HashMap<>();
//        map.put("1",MethodDO.class);
//        Object o = map.get("1");
//        Method[] declaredMethods1 = o.getClass().getDeclaredMethods();

        Method[] declaredMethods = MethodDO.class.getDeclaredMethods();

        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.toString().startsWith("public")) {
                System.out.println(declaredMethod);
                String[] split = declaredMethod.toString().split(".");
                if (split.length>3) {
                    for (String s : split) {
                        System.out.println(s);
                    }
                }
            }
        }
    }
}
