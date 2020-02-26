package com.fhlxc.week01;

/**
* @author Xingchao Long
* @date 2020/55/10 18:55:47
* @ClassName AddTwoNumbersTest
* @Description 
*/

public class AddTwoNumbersTest {
    
    public static int addThreeNumbers(int n1, int n2, int n3) {
        if (n3 < 0) {
            n1 = -n1;
        }
        return n1 + n2 + n3;
    }
    
    public static void main(String[] args) {
        System.out.println(addThreeNumbers(1, 3, 1));
        System.out.println(addThreeNumbers(0, 3, -1));
        System.out.println(addThreeNumbers(1, 3, -1));
    }
    
}
