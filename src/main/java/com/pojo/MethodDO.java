package com.pojo;

import org.springframework.stereotype.Component;

/**
 * @author lingfeng
 * @create 2022/3/25 21:13
 */
@Component
public class MethodDO {

    /**
     * 计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）
     * @param str
     * @return
     */
    public static int getStrLength(String str){
        String[] s = str.split(MethodConstant.space);
        String s1 = s[s.length-1];
        return s1.length();
    }

    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     * @param nums
     * @param target
     * @return
     */
    public static int [] getFirstAndLast(int [] nums,int target){

        int [] result = {-1,-1};

        for (int i = 0; i < nums.length; i++) {
            if (target==nums[i]){
                result[0]=i;
                break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (target==nums[i]){
                result[1]=i;
            }
        }
        return result;
    }
}
