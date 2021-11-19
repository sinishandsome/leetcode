/**
 * @author chenxin
 * @create 2021-11-19 14:58
 */
public class test_165 {
    public static void main(String[] args) {

    }
}

class Solution95 {
    public int compareVersion(String version1, String version2) {
        int p1 = 0, p2 = 0;
        int s1 = version1.length(), s2 = version2.length();
        while (p1 < s1 || p2 < s2) {
            int num1 = 0, num2 = 0;
            while (p1 < s1 && version1.charAt(p1) != '.') {
                num1 = num1 * 10 + version1.charAt(p1++) - '0';
            }
            while (p2 < s2 && version2.charAt(p2) != '.') {
                num2 = num2 * 10 + version2.charAt(p2++) - '0';
            }
            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }
            p1++;
            p2++;
        }
        return 0;
    }
}
