package com.cc.SS;

import com.sun.javafx.css.CalculatedValue;

/**
 * @ClassName TestCalculateEcpression
 * @Description TODO
 * @Author Administrator
 * @Date 2021/6/26 14:27
 */
public class TestCalculateEcpression {
    public static void main(String[] args) {
        String expression="4+3+(6-10+2*3)*4";
        double result=Calculated(expression);
        System.out.println(result);

    }

    private static double Calculated(String expression) {
        //存储操作符
        MyArrayStack operatorStack = new MyArrayStack();
        //存储操作数
        MyArrayStack operaandStack = new MyArrayStack();

        for (int i=0;i<expression.length();i++){
            char cc = expression.charAt(i);
            //如果cc是数字
            if (Character.isDigit(cc)){
                //取出操作数
                StringBuilder sb = new StringBuilder();
                //只要是数字就是操作数的一部分
                while (Character.isDigit(cc)){
                    sb.append(cc);
                    i++;
                    if (i>=expression.length()){
                        break;
                    }
                    cc=expression.charAt(i);
                }
                //操作数入栈
                operaandStack.push(sb.toString());
                //修正i变量的值
                i--;
//                System.out.println(sb);
            }else {  //如果是操作符
                //1.如果栈为空，直接把操作符入栈
                if (operatorStack.isEmpty()){
                    operatorStack.push(cc);
                    continue;
                }
                //2.如果栈不为空
                while (!operatorStack.isEmpty()){
                    char op1 = (char) operatorStack.peek();
                    if (compareOperator(op1,cc)<0){
                        operatorStack.push(cc);
                        break;
                    }else if (compareOperator(op1,cc)==0){
                        operatorStack.pop();
                        break;

                    }else {

                        //取出两个操作符
                        double num1 = Double.parseDouble(operaandStack.pop().toString());
                        double num2 = Double.parseDouble(operaandStack.pop().toString());
                        //取出栈顶运算符
                        char operator= (char) operaandStack.pop();
                        //计算num2 op num1
                        double result=compute(operator,num2,num1);
                        //把结果存储到操作数栈中
                        operaandStack.push(result);
                        //如果当前操作符栈为空，新的操作符入栈
                        if (operatorStack.isEmpty()){
                            operatorStack.push(cc);
                            break;
                        }

                    }

                }

            }
        }


        return 0;
    }

    private static double compute(char operator, double num1, double num2) {
        switch (operator){
            case '+':
                return num1+num2;
            case '-':
                return num1-num2;
            case '*':
                return num1*num2;
            case '/':
                return num1-num2;

        }
        return 0;
    }

    //判断两个运算符的优先级
    private static int compareOperator(char op1, char op2) {
        if (op1=='+'||op1=='-'){
            if (op2=='*'||op2=='/'||op2=='('){
                return -1;
            }
        }
        if (op1=='*'||op1=='/'){
            if (op2=='('){
                return -1;
            }
        }
        if (op1=='('){
            if (op2==')'){
                return 0;
            }else {
                return -1;
            }
        }

        return 1;
    }

}
