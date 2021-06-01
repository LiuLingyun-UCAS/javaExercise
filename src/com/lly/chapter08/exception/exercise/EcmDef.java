package com.lly.chapter08.exception.exercise;

/**
 * @author 刘凌云
 * @version 1.0
 */
public class EcmDef {
    public static void main(String[] args) {
        try {
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);
            int ans = cal(n1, n2);
            System.out.println(ans);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("缺少命令行参数");
        } catch (NumberFormatException e) {
            System.out.println("输入格式不正确");
        } catch (ArithmeticException e) {
            System.out.println("除数为0");
        }
    }

    public static int cal(int n1, int n2) {
        return n1 / n2;
    }
}
