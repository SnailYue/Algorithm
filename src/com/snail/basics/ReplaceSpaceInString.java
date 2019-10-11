package com.snail.basics;

public class ReplaceSpaceInString {

    /**
     * 题目：将字符串中的空格替换成%20
     * <p>
     * 解题思路：先查找出字符串中的空格的个数，然后新建一个符合替换后字符串长度的字符数组。
     * 从后向前进行替换。
     *
     * @param data
     * @param length
     * @return
     */

    public static String replaceString(char[] data, int length) {
        int newLangth = length;
        /**
         * 查找空格的个数
         */
        for (int i = 0; i < length; i++) {
            if (Character.isSpaceChar(data[i])) {
                newLangth += 2;
            }
        }
        char[] newData = new char[newLangth];

        for (int i = 0; i < length; i++) {
            newData[i] = data[i];
        }

        for (int indexOfOld = length - 1, indexOfNew = newLangth - 1;
             indexOfOld >= 0 && indexOfOld != indexOfNew; indexOfOld--, indexOfNew--) {
            if (Character.isSpaceChar(newData[indexOfOld])) {
                newData[indexOfNew--] = '0';
                newData[indexOfNew--] = '2';
                newData[indexOfNew] = '%';
            } else {
                newData[indexOfNew] = newData[indexOfOld];
            }
        }
        return String.valueOf(newData);
    }

    public static void testInstance() {
        String test = "We Are Happy";
        char[] charTest = test.toCharArray();
        System.out.println(replaceString(charTest, charTest.length));
    }

}
