package l.series;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author luckylau
 * @Date 2020/1/17
 */
public class LadderLength {
    public static void main(String[] args) {
        LadderLength ladderLength = new LadderLength();
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(ladderLength.ladderLength("hit", "cog", wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) {
            return 0;
        }
        wordList.add(beginWord);
        int len = wordList.size();
        int end = 0;
        while (end < len) {
            if (endWord.equals(wordList.get(end))) {
                break;
            }
            end++;
        }
        if (end == len) {
            return 0;
        }
        ArrayList<Integer>[] relation = new ArrayList[len + 1];
        for (int i = 0; i < len; i++) {
            relation[i] = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                if (isConnected(wordList.get(i), wordList.get(j))) {
                    relation[i].add(j);
                }
            }
        }
        return getShortPath(relation, len - 1, end);

    }

    private int getShortPath(ArrayList<Integer>[] relation, int start, int end) {
        boolean[] mark = new boolean[relation.length];
        mark[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int path = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            path++;
            while (size > 0) {
                int cur = queue.poll();
                for (int next : relation[cur]) {
                    if (next == end) {
                        return path;
                    }
                    if (!mark[next]) {
                        queue.add(next);
                        mark[next] = true;
                    }

                }
                size--;
            }
        }
        return 0;
    }

    private boolean isConnected(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        int diff = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }
}
