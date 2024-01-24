package com.tec;



/**
 * @author lingfeng
 * @create 2022/4/24 13:51
 */
public class ridZero {
    public static void main(String[] args) {
//        JsonStringA jsonStringA = new JsonStringA();
//        String str = "啊啊啊"+" ";
//        String res = padRight(str,500," ");
//        jsonStringA.setAaa(str);
//        jsonStringA.setBbb(res);
//        System.out.println(res);
//        System.out.println(res.length());
//        System.out.println(JSON.toJSONString(jsonStringA));


//        System.out.println(padLeft("aaa",10,"6"));

        String str1 = "aaaaabbb";

        System.out.println(str1.substring(0,6));

//        String str = "汉字";
//        try {
//            byte[] bytes = str.getBytes("utf-8");
//            System.out.println(bytes.length);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

    }

    private static String padRight(String str, int i, String s) {
        StringBuilder sb = new StringBuilder(str);

        while (sb.toString().length()<i){
            sb.append(s);
        }
        return sb.toString();
    }

    private static String padLeft(String str, int i, String s) {
        String s1 = str;
        while (s1.length()<i){
            s1=s+s1;
        }
        return s1;
    }

}
