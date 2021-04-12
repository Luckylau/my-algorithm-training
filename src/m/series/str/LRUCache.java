package m.series.str;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author luckylau
 * @Date 2021/4/12
 * LRU(最近最少使用)缓存机制
 */
public class LRUCache {
    private int count = 0;
    private Map<Integer, Node> cache = new HashMap<>();
    private Node head;
    private Node tail;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        } else {
            int value = node.var;
            moveHead(node);
            return value;
        }
    }

    private void moveHead(Node node) {
        Node next = node.next;
        Node pre = node.pre;
        pre.next = next;
        next.pre = pre;

        Node headNext = head.next;
        node.next = headNext;
        headNext.pre = node;
        head.next = node;
        node.pre = head;
    }

    private Node removeTailNode() {
        Node pre = tail.pre;
        Node prePre = pre.pre;
        prePre.next = tail;
        tail.pre = prePre;
        return pre;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            node = new Node();
            node.var = value;
            node.key = key;

            Node next = head.next;
            next.pre = node;
            node.next = next;
            head.next = node;
            node.pre = head;
            if (count == capacity) {
                Node tailPre = removeTailNode();
                cache.remove(tailPre.key);
            } else {
                count++;
            }
            cache.put(key, node);

        } else {
            node.var = value;
            moveHead(node);
        }
    }

    private static class Node {
        Node pre;
        Node next;
        int var;
        int key;
    }
}
