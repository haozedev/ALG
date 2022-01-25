package com.dev;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author HaoZ
 * @ClassName
 * @description 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *              有效字符串需满足：
 *              左括号必须用相同类型的右括号闭合。
 *              左括号必须以正确的顺序闭合。
 *              注意空字符串可被认为是有效字符串。
 * @create 2022/1/25 14:33
 */
public class isValidBracket {
    public static void main(String[] args) {
        String str = "(){}[]";
//        System.out.println(str.length());
        boolean valid = isValid(str);
        System.out.println(valid);
    }

    public static boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            //碰到左括号，就把相应的右括号入栈
            if (ch == '(') {
                deque.push(')');
            }else if (ch == '{') {
                deque.push('}');
            }else if (ch == '[') {
                deque.push(']');
            } else if (deque.isEmpty() || deque.peek() != ch) {
                return false;
            }else {//如果是右括号判断是否和栈顶元素匹配
                deque.pop();
            }
        }
        //最后判断栈中元素是否匹配
        return deque.isEmpty();
    }
}
