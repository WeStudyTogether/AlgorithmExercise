package com.fhlxc.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
* @author Xingchao Long
* @date 2020年3月25日 下午2:56:28
* @classname SimplifyPath
* @description 
* 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
* 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
* 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
* 示例 1：
* 输入："/home/"
* 输出："/home"
* 解释：注意，最后一个目录名后面没有斜杠。
* 示例 2：
* 输入："/../"
* 输出："/"
* 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
* 示例 3：
* 输入："/home//foo/"
* 输出："/home/foo"
* 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
* 示例 4：
* 输入："/a/./b/../../c/"
* 输出："/c"
* 示例 5：
* 输入："/a/../../b/../c//.//"
* 输出："/c"
* 示例 6：
* 输入："/a//b////c/d//././/.."
* 输出："/a/b/c"
*/

public class SimplifyPath {

    public String simplifyPath(String path) {
        StringTokenizer stringTokenizer = new StringTokenizer(path, "/");
        List<String> list = new ArrayList<String>();
        while (stringTokenizer.hasMoreElements()) {
            list.add(stringTokenizer.nextToken());
        }
        String s = "";
        for (int i = 0; i < list.size(); i++) {
            s = list.get(i);
            switch (s) {
            case ".":
                list.remove(i);
                i -= 1;
                break;
            case "..":
                if (i > 0) {
                    list.remove(i - 1);
                    list.remove(i - 1);
                    i -= 2;
                } else {
                    list.remove(i);
                    i -= 1;
                }
                break;
            default:
                break;
            }
        }
        s = "/";
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            s = s + list.get(i) + "/";
        }
        if (n > 0) {
            s = s + list.get(n - 1);
        }
        return s;
    }
    
    public static void main(String[] args) throws IOException {
        System.out.println(new SimplifyPath().simplifyPath(new BufferedReader(new InputStreamReader(System.in)).readLine()));
    }

}
