import java.util.jar.JarEntry;

/**
 * @author chenxin
 * @create 2021-11-06 13:33
 */
public class re_415 {
    public static void main(String[] args) {

    }
}

class Solution_415 {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int n = num1.length() - 1;
        int m = num2.length() - 1;
        int carry = 0;
        while (n >= 0 || m >= 0) {
            int n1 = n >= 0 ? num1.charAt(n) - '0' : 0;
            int n2 = m >= 0 ? num2.charAt(m) - '0' : 0;
            int temp = n1 + n2 + carry;
            carry = temp / 10;
            res.append(temp % 10);
            n--;
            m--;
        }
        if (carry == 1) {
            res.append(1);
        }
        return res.reverse().toString();
    }
}
