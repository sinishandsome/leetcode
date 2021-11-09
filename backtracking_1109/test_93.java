import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author chenxin
 * @create 2021-11-09 20:16
 */
public class test_93 {
    public static void main(String[] args) {

    }
}

class Solution_80 {
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        if (len > 12 || len < 4) {
            return res;
        }
        Deque<String> path = new ArrayDeque<>(4);
        dfs(s, len, 0, 4, path, res);
        return res;
    }

    private void dfs(String s, int len, int begin, int reside, Deque<String> path, List<String> res) {
        if (begin == len) {
            if (reside == 0) {
                res.add(String.join(".", path));
            }
            return;
        }
        for (int i = begin; i < begin + 3; i++) {
            if (i >= len) {
                break;
            }
            if (reside * 3 < len - i) {
                continue;
            }
            if (judgeIpSegment(s, begin, i)) {
                String current = s.substring(begin, i + 1);
                path.addLast(current);
                dfs(s, len, i + 1, reside - 1, path, res);
                path.removeLast();
            }
        }
    }

    private boolean judgeIpSegment(String s, int begin, int end) {
        int len = end - begin + 1;
        if (len > 1 && s.charAt(begin) == '0') {
            return false;
        }
        int res = 0;
        while (begin <= end) {
            res = res * 10 + s.charAt(begin) - '0';
            begin++;
        }
        return res >= 0 && res <= 255;
    }
}
