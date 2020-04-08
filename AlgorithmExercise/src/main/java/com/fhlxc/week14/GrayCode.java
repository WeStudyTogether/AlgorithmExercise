package com.fhlxc.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
* @author Xingchao Long
* @date 2020年4月8日 上午8:49:13
* @classname GrayCode
* @description 
* 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
* 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
* 示例 1:
* 输入: 2
* 输出: [0,1,3,2]
* 解释:
* 00 - 0
* 01 - 1
* 11 - 3
* 10 - 2
* 对于给定的 n，其格雷编码序列并不唯一。
* 例如，[0,2,3,1] 也是一个有效的格雷编码序列。
* 00 - 0
* 10 - 2
* 11 - 3
* 01 - 1
* 示例 2:
* 输入: 0
* 输出: [0]
* 解释: 我们定义格雷编码序列必须以 0 开头。
*      给定编码总位数为 n 的格雷编码序列，其长度为 2n。当 n = 0 时，长度为 20 = 1。
*      因此，当 n = 0 时，其格雷编码序列为 [0]。
*/

public class GrayCode {

    /**
     * 
     * @param n
     * @return
     * 基于数学方法计算的格雷码，B[i + 1] ^ B[i] = G[i]（首位保持不变）
     */
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        int count = 0;
        int total = (int) Math.pow(2, n);
        for (; count < total; count++) {
            result.add(count >> 1 ^ count);
        }
        return result;
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        System.out.println(new GrayCode().grayCode(Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine())));
    }

}
