package leetcode.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution950 {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = deck.length - 1; i >= 0; i--) {
            queue.offer(deck[i]);
            if (i == 0) {
                break;
            }
            queue.offer(queue.poll());
        }
        for (int i = deck.length - 1; i >= 0; i--) {
            deck[i] = queue.poll();
        }
        return deck;
    }
}
