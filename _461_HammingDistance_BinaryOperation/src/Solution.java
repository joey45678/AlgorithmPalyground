
/*
https://www.cnblogs.com/findbetterme/p/10787118.html
位运算
偶数，二进制末尾为0
奇数，二进制末尾为1

&
|
^
~
<<
>>
>>>
 */

public class Solution {
    public static int hammingDistance(int x, int y) {
        int xor = x ^ y;

        int distance = 0;
        while (xor != 0) {
//            xor的二进制的末尾和1运算
            if ((xor & 1) == 1)
                distance += 1;
            xor = xor >> 1;
        }
        return distance;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1,4));
    }
}
