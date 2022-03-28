package com.alg;

import com.pojo.MethodDO;

/**
 * @author lingfeng
 * @create 2022/3/28 21:25
 */
public class SearchInsertTest {

    public static void main(String[] args) {
        int [] nums = {1,3,5,6};
        int target = 7;

        int i = MethodDO.searchInsert(nums, target);
        System.out.println(i);
    }
}
