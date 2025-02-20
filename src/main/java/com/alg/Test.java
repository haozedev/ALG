package com.alg;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.HashMap;

/**
 * @ClassName Test
 * @Author haoZe
 * @Date 2023/3/6
 **/
public class Test {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int search = search(arr, 7);
        System.out.println(search);

        HashMap hashMap = new HashMap();
        hashMap.put("a",1);
        Integer a = new Integer(2000);
        Integer b = new Integer(2000);
        System.out.println(a==b);
        Integer c = new Integer(100);
        Integer d = new Integer(100);
        System.out.println(c==d);
    }


    public static int search(int[] arr, int target) {
        int res = -1;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                res = mid;
                break;
            }
        }
        return res;

    }
}
