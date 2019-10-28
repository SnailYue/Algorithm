package com.snail.highqualitycode;

public class PowerWithUnsignedExponend {

    /**
     * 题目：数值的整数次方
     * 解题思路：使用数的未操作代替除操作，提高代码的执行效率
     * 一个数右移一位，相当于/2操作，但是效率远高于/ 2
     *
     * @param base
     * @param exponend
     * @return
     */
    public static double powerWithUnsignedExponend(double base, int exponend) {
        if (exponend == 0) {
            return 1;
        }
        if (exponend == 1) {
            return base;
        }
        double result = powerWithUnsignedExponend(base, exponend >> 1);
        result *= result;
        if ((exponend & 0x01) == 0x01) {
            result *= base;
        }
        return result;
    }

    public static void testInstance() {
        System.out.println("result = " + (int) powerWithUnsignedExponend(2, 5));
    }
}
