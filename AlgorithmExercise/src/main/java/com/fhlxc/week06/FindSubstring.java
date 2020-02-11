package com.fhlxc.week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
* @author Xingchao Long
* @date 2020年2月11日 上午11:11:20
* @ClassName FindSubstring
* @Description
* 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
* 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
* 输入：
*   s = "barfoothefoobarman",
*   words = ["foo","bar"]
* 输出：[0,9]
* 解释：
* 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
* 输出的顺序不重要, [9,0] 也是有效答案。
*/

public class FindSubstring {
    
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        String ww = "";
        int length = 0;
        int l = 0;
        
        if (s.length() == 0 || words.length == 0) {
            return result;
        }
        
        length = words.length * words[0].length();
        
        for (String w: words) {
            ww += w + " ";
        }
        
        int x = s.length() - length;
        l = words[0].length();
        
        for (int i = 0; i <= x; i++) {
            String t = s.substring(i, i + length);
            StringBuilder tmp = new StringBuilder(ww);
            
            for (int j = 0; j < length; j += l) {
                int k = tmp.indexOf(t.substring(j, j + l));
                if (k == -1) {
                    break;
                }
                tmp.delete(k, k + l);
            }
            
            if (tmp.toString().trim().length() == 0) {
                result.add(i);
            }
        }
        return result;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String[] words = reader.readLine().split(" ");
        
        FindSubstring findSubstring = new FindSubstring();
        
        System.out.println(findSubstring.findSubstring(s, words));
    }

}
