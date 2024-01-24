package com.tec;

import com.pojo.MonitorDo;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @ClassName NullTest
 * @Description TODO
 * @Author ty-ChaiHaoZe
 * @Date 2022/7/13
 * @Version TODO
 * @History TODO
 **/
public class NullTest {
    public static void main(String[] args) {
        MonitorDo monitorDo = new MonitorDo();

        List<String> telList = monitorDo.getTelList();
        System.out.println(ObjectUtils.isEmpty(telList));

    }
}
