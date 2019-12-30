package o.series;
/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */

/**
 * @Author luckylau
 * @Date 2019/12/30
 */
public class RandomListNodeClone {
    public RandomListNode clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode currentNode = pHead;
        while (currentNode != null) {
            RandomListNode next = currentNode.next;
            RandomListNode newRandomListNode = new RandomListNode(currentNode.label);
            currentNode.next = newRandomListNode;
            newRandomListNode.next = next;
            currentNode = next;
        }
        currentNode = pHead;
        while (currentNode != null) {
            RandomListNode random = currentNode.random;
            if (random != null) {
                currentNode.next.random = random.next;
            } else {
                currentNode.next.random = null;
            }
            currentNode = currentNode.next.next;
        }
        currentNode = pHead;
        RandomListNode cloneHead = pHead.next;
        while (currentNode != null) {
            RandomListNode cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next == null ? null : cloneNode.next.next;
            currentNode = currentNode.next;
        }
        return cloneHead;
    }

    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
