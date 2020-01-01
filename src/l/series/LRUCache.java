package l.series;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author luckylau
 * @Date 2020/1/1
 */
public class LRUCache {
    private final int capacity;
    private DoubleLinkedNode head;
    private DoubleLinkedNode tail;
    private int count = 0;
    private Map<Integer, DoubleLinkedNode> cache = new HashMap<>(16);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DoubleLinkedNode();
        tail = new DoubleLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));


    }

    public int get(int key) {
        DoubleLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DoubleLinkedNode node = cache.get(key);
        if (node == null) {
            DoubleLinkedNode newNode = new DoubleLinkedNode();
            newNode.value = value;
            newNode.key = key;
            count++;
            if (count > capacity) {
                DoubleLinkedNode tailPre = removeNodeFromTail();
                cache.remove(tailPre.key);
                count--;
            }
            addNodeFromHead(newNode);
            cache.put(key, newNode);
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addNodeFromHead(DoubleLinkedNode node) {
        DoubleLinkedNode headNext = head.next;
        headNext.pre = node;
        node.next = headNext;
        node.pre = head;
        head.next = node;
    }

    private DoubleLinkedNode removeNodeFromTail() {
        DoubleLinkedNode tailPre = tail.pre;

        DoubleLinkedNode tailPrePre = tailPre.pre;
        tailPrePre.next = tail;
        tail.pre = tailPrePre;
        return tailPre;
    }

    private void moveToHead(DoubleLinkedNode node) {
        DoubleLinkedNode preNode = node.pre;
        DoubleLinkedNode nextNode = node.next;
        preNode.next = nextNode;
        nextNode.pre = preNode;


        DoubleLinkedNode nextHead = head.next;
        nextHead.pre = node;
        node.next = nextHead;
        head.next = node;
        node.pre = head;
    }

    private class DoubleLinkedNode {
        int value;
        int key;
        DoubleLinkedNode pre;
        DoubleLinkedNode next;

        public DoubleLinkedNode() {
        }
    }

}
