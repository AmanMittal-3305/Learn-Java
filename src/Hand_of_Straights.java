import java.util.*;
public class Hand_of_Straights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        Arrays.sort(hand);
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int card : hand) {
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }

        for (int card : hand) {
            int freq = countMap.getOrDefault(card, 0);
            if (freq > 0) {
                for (int i = 0; i < groupSize; i++) {
                    int currentCard = card + i;
                    int currentCount = countMap.getOrDefault(currentCard, 0);
                    if (currentCount == 0) return false;
                    countMap.put(currentCard, currentCount - 1);
                }
            }
        }

        return true;
    }
}
