package me.seanxiao.interview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

class Pair {
    String word;
    int count;

    public Pair(String word, int count) {
        this.word = word;
        this.count = count;
    }

}

class PairComparator implements Comparator<Pair> {

    @Override
    public int compare(Pair o1, Pair o2) {
        if (o1.count != o2.count) {
            return Integer.compare(o1.count, o2.count);
        }
        else {
            return o2.word.compareTo(o1.word);
        }
    }
}


public class FrequentTerms {

    private static PriorityQueue<Pair> heap;

    private static int count;

    private static int size;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        count = Integer.parseInt(sc.nextLine());
        Map<String, Integer> wordCount = new HashMap<String, Integer>();
        for (int i = 0; i < count; i++) {
            String word = sc.nextLine().trim();
            if (!wordCount.containsKey(word)) {
                wordCount.put(word, 0);
            }
            wordCount.put(word, wordCount.get(word) + 1);
        }
        size = Integer.parseInt(sc.nextLine());
        heap = new PriorityQueue<Pair>(size, new PairComparator());
        for (String word : wordCount.keySet()) {
            Pair newPair = new Pair(word, wordCount.get(word));
            PairComparator comparator = new PairComparator();
            if (heap.size() < size) {
                heap.offer(newPair);
            }
            else {
                if (comparator.compare(newPair, heap.peek()) > 0) {
                    heap.poll();
                    heap.offer(newPair);
                }
            }
        }
        List<String> results = new ArrayList<>();
        while (!heap.isEmpty()) {
            results.add(0, heap.poll().word);
        }
        for (String result : results) {
            System.out.println(result);
        }
        sc.close();
    }
}
