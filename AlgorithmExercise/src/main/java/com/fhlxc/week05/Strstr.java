package com.fhlxc.week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020年2月9日 下午4:46:56
* @ClassName Strstr
* @Description
* 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
*/

public class Strstr {

    public static int strStr(String haystack, String needle) {
        int result = -1;
        if (needle == "") {
            return 0;
        }
        char[] haystacks = haystack.toCharArray();
        char[] needles = needle.toCharArray();
        int l = haystacks.length - needles.length;
        boolean find = true;
        for (int i = 0; i <= l; i++) {
            find = true;
            for (int j = 0; j < needles.length; j++) {
                if (j + i >= haystacks.length) {
                    find = false;
                    break;
                }
                if (haystacks[i + j] != needles[j]) {
                    find = false;
                    break;
                }
            }
            if (find) {
                result = i;
                break;
            }
        }
        return result;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String haystack = reader.readLine();
        String needle = reader.readLine();
        System.out.println(strStr(haystack, needle));
    }

}
