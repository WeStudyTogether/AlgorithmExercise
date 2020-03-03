package com.fhlxc.week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
* @author Xingchao Long
* @date 2020年3月3日 上午10:17:04
* @ClassName GroupAnagrams
* @Description 
* 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
* 示例:
* 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
* 输出:
* [
*   ["ate","eat","tea"],
*   ["nat","tan"],
*   ["bat"]
* ]
*/

public class GroupAnagrams {

    public class Str {
        String str;
        String order;
        
        private void convert() {
            StringBuilder ss = new StringBuilder();
            char[] s = str.toCharArray();
            for (char c: s) {
                if (ss.length() != 0) {
                    for (int i = 0; i < ss.length(); i++) {
                        if (c < ss.charAt(i)) {
                            ss.insert(i, c);
                            break;
                        }
                        if (i == ss.length() - 1) {
                            ss.append(c);
                            break;
                        }
                    }
                } else {
                    ss.insert(0, c);
                }
            }
            order = ss.toString();
        }
        
        public Str(String str) {
            this.str = str;
            convert();
        }
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        List<Str> ss = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        for (String s: strs) {
            Str t = new Str(s);
            ss.add(t);
        }
        for (Str s: ss) {
            boolean find = false;
            for (List<String> r: result) {
                if (r.get(0).equals(s.order)) {
                    r.add(s.str);
                    find = true;
                    break;
                }
            }
            if (!find) {
                List<String> tmp = new ArrayList<>();
                tmp.add(s.order);
                tmp.add(s.str);
                result.add(tmp);
            }
        }
        for (List<String> r: result) {
            r.remove(0);
        }
        return result;
    }
    
    public static void main(String[] args) throws IOException {
        String[] strs = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
        System.out.println(new GroupAnagrams().groupAnagrams(strs));
    }

}
