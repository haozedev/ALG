package com.tec;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author HaoZ
 * @ClassName
 * @description
 * @create 2022/2/9 19:08
 */
public class RegularExpression {

    public static void main(String[] args) {
        String newSql = "COMMENT ON TABLE agency_info IS 'xxx基本信息';";
        String tableComment = "COMMENT\\s+ON\\s+TABLE\\s+([a-z]|[A-Z]|_)+\\s+IS\\s+'([^']+)'" ;
        Pattern pattern = Pattern.compile(tableComment) ;
        Matcher matcher = pattern.matcher(newSql) ;
        while(matcher.find()){
            int count = matcher.groupCount() ;
            for (int i = 0; i <= count; i++) {
                String ret = matcher.group(i) ;
                System.out.println(ret);
            }

        }
    }
}
