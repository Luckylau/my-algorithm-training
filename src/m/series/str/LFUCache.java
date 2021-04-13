package m.series.str;

import java.util.HashMap;
import java.util.Map;

/**
 * LFU缓存
 *
 * @Author luckylau
 * @Date 2021/4/13
 */
public class LFUCache {

    Map<Integer, Node> cache;
    Map<Integer, DoubleLinkedList> freMap;
    int size;
    int capacity;
    int min;

    public LFUCache(int capacity) {
        cache = new HashMap<>();
        freMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        freInc(node);
        return node.value;
    }

    private void freInc(Node node) {
        int freq = node.freq;
        DoubleLinkedList linkedList = freMap.get(freq);
        linkedList.removeNode(node);
        if (freq == min && linkedList.head.post == linkedList.tail) {
            min = freq + 1;
        }

        node.freq++;
        linkedList = freMap.get(freq + 1);
        if (linkedList == null) {
            linkedList = new DoubleLinkedList();
            freMap.put(freq + 1, linkedList);
        }
        linkedList.addNode(node);
    }


    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            freInc(node);
        } else {
            if (size == capacity) {
                DoubleLinkedList minDoubleLinkedList = freMap.get(min);
                cache.remove(minDoubleLinkedList.tail.pre.key);
                minDoubleLinkedList.removeNode(minDoubleLinkedList.tail.pre);
                size--;
            }
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            cache.put(key, newNode);
            DoubleLinkedList linkedList = freMap.get(1);
            if (linkedList == null) {
                linkedList = new DoubleLinkedList();
                freMap.put(1, linkedList);
            }
            linkedList.addNode(newNode);
            size++;
            min = 1;
        }
    }

    class Node {
        int key;
        int value;
        int freq = 1;
        Node pre;
        Node post;
    }

    class DoubleLinkedList {
        Node head;
        Node tail;

        public DoubleLinkedList() {
            head = new Node();
            tail = new Node();
            head.post = tail;
            tail.pre = head;
        }

        public void addNode(Node node) {
            node.post = head.post;
            head.post.pre = node;
            node.pre = head;
            head.post = node;
        }

        public void removeNode(Node node) {
            node.pre.post = node.post;
            node.post.pre = node.pre;
        }
    }
}
