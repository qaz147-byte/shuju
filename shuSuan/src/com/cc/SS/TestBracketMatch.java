package com.cc.SS;

/**
 * @ClassName TestBracketMatch
 * @Description TODO
 * @Author Administrator
 * @Date 2021/6/26 13:44
 */
public class TestBracketMatch {
    public static void main(String[] args) {
        System.out.println(bracketMatch("([{}])"));
        System.out.println(bracketMatch("([{]})"));
        System.out.println(bracketMatch("([{}"));
    }

    public static boolean bracketMatch(String expression){
        //保存左括号
        MyArrayStack stack = new MyArrayStack();
        for (int i=0;i<expression.length();i++){
           //取出表达式的每个字符
            char cc = expression.charAt(i);
            switch (cc){
                case '(':
                case '[':
                case '{':
                    stack.push(cc);//java可以自动装箱与拆箱
                    break;
                case '}':
                    if (!stack.isEmpty()&&stack.pop().equals('{')){
                        break;
                    }else {
                        return false;
                    }
                case ']':
                    if (!stack.isEmpty()&&stack.pop().equals('[')){
                        break;
                    }else {
                        return false;
                    }
                case ')':
                    if (!stack.isEmpty()&&stack.pop().equals('(')){
                        break;
                    }else {
                        return false;
                    }
                    default:
                        break;
            }

        }

        //表达式遍历完后，如果栈是空的，表示括弧匹配
        if (stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
