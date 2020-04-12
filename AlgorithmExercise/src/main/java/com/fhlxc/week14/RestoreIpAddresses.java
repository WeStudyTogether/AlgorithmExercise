package com.fhlxc.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
* @author Xingchao Long
* @date 2020年4月12日 上午10:29:07
* @classname RestoreIpAddresses
* @description 
* 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
* 示例:
* 输入: "25525511135"
* 输出: ["255.255.11.135", "255.255.111.35"]
*/

public class RestoreIpAddresses {

    private List<String> result = new ArrayList<>();
    private long[] ip = {-1, -1, -1, -1};
    
    private void backtrace(char[] s, int i, int count) {
        if (count == 3) {
            if (i < s.length) {
                if (s[i] == '0' && s.length - i > 1) {
                    return;
                }
            }
            long n = 0;
            boolean exe = false;
            for (int k = 0; k < s.length - i; k++) {
                n = n * 10 + s[i + k] - '0';
                exe = true;
            }
            if (n > 255 || !exe) {
                return;
            }
            ip[count] = n;
            String string = "";
            for (int k = 0; k < 4; k++) {
                if (k != 3) {
                    string = string + ip[k] + ".";
                } else {
                    string = string + ip[k];
                }
            }
            result.add(string);
            return;
        }
        long n = 0;
        boolean exe = false;
        for (int k = i; k < i + 1 && k < s.length; k++) {
            n = n * 10 + s[k] - '0';
            exe = true;
        }
        if (n > 255 || !exe) {
            return;
        }
        ip[count] = n;
        backtrace(s, i + 1, count + 1);
        if (s[i] == '0') {
            return;
        }
        n = 0;
        exe = false;
        for (int k = i; k < i + 2 && k < s.length; k++) {
            n = n * 10 + s[k] - '0';
            exe = true;
        }
        if (n > 255 || !exe) {
            return;
        }
        ip[count] = n;
        backtrace(s, i + 2, count + 1);
        n = 0;
        exe = false;
        for (int k = i; k < i + 3 && k < s.length; k++) {
            n = n * 10 + s[k] - '0';
            exe = true;
        }
        if (n > 255 || !exe) {
            return;
        }
        ip[count] = n;
        backtrace(s, i + 3, count + 1);
    }
    
    public List<String> restoreIpAddresses(String s) {
        backtrace(s.toCharArray(), 0, 0);
        return result;
    }
    
    public static void main(String[] args) throws IOException {
        System.out.println(new RestoreIpAddresses().restoreIpAddresses(new BufferedReader(new InputStreamReader(System.in)).readLine()));
    }

}
