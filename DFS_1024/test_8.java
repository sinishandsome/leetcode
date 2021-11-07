import java.util.HashMap;
import java.util.Map;

/**
 * @author chenxin
 * @create 2021-10-24 10:41
 */
public class test_8 {
    public static void main(String[] args) {

    }
}

class Solution60 {
    public int myAtoi(String s) {
        Solve solve = new Solve();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            solve.get(s.charAt(i));
        }
        return (int)(solve.ans * solve.sign);
    }
}

class Solve {
    long ans = 0;
    int sign = 1;
    String state = "start";

    Map<String, String[]> table = new HashMap<String, String[]>(){
        {
            put("start", new String[]{"start", "sign", "in_number", "end"});
            put("sign", new String[]{"end", "end", "in_number", "end"});
            put("in_number", new String[]{"end", "end", "in_number", "end"});
            put("end", new String[]{"end", "end", "end", "end"});
        }
    };

    public void get(char c) {
        state = table.get(state)[getCol(c)];
        if ("in_number".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if ("sign".equals(state)) {
            sign = c == '+' ? 1 : -1;
        }
    }

    public int getCol(char c) {
        if (c == (' ')) {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }
}
