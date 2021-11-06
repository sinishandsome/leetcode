import javax.swing.undo.CannotUndoException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenxin
 * @create 2021-10-30 9:45
 */
public class re_146 {
    public static void main(String[] args) {

    }
}

class LRUCache_146 {

    private int capacity;
    private int size;
    private DoubleLink head,tail;
    private Map<Integer, DoubleLink> cache = new HashMap<>();

    //新建双向链表
    class DoubleLink {
        private DoubleLink pre;
        private DoubleLink next;
        private int key;
        private int value;

        public DoubleLink() {
        }

        public DoubleLink(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    public LRUCache_146(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DoubleLink();
        tail = new DoubleLink();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DoubleLink node = cache.get(key);
        if (node == null) {
            return -1;
        } else {
            moveToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        DoubleLink node = cache.get(key);
        if (node == null) {
            DoubleLink newNode = new DoubleLink(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > capacity) {
                DoubleLink remove = removeTail();
                cache.remove(remove.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private DoubleLink removeTail() {
        DoubleLink res = tail.pre;
        removeNode(res);
        return res;
    }

    private void addToHead(DoubleLink node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(DoubleLink node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    private void moveToHead(DoubleLink node) {
        removeNode(node);
        addToHead(node);
    }


}
