/**
 * @author chenxin
 * @create 2021-10-18 8:43
 */
public class test_415 {
    public static void main(String[] args) {

    }
}

class Solution41 {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        int p1 = num1.length() - 1, p2 = num2.length() - 1;
        StringBuilder res = new StringBuilder();
        while (p1 >= 0 || p2 >= 0) {
            int n1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
            int n2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
            int temp = n1 + n2 + carry;
            carry = temp / 10;
            res.append(temp % 10);
            p1--;
            p2--;
        }
        if (carry == 1) {
            res.append(1);
        }
        return res.reverse().toString();
    }
}
