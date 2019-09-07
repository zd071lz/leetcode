package leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution638 {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int num =price.size();
        String key = getKey(needs);
        Integer keyMinPay = map.get(key);
        if (keyMinPay != null) {
            return keyMinPay;
        }
        int minPay = 0;
        for (int i = 0; i < num; i++) {
            minPay += price.get(i) * needs.get(i);
        }
        List<Integer> tmp = new ArrayList<>(needs);
        for (int i = 0; i < special.size(); i++) {

            for (int j = 0; j < num; j++) {
                if(needs.get(j) < special.get(i).get(j)){
                    break;
                }else {
                    tmp.set(j, needs.get(j) - special.get(i).get(j));
                }
                if (j == num-1) {
                    minPay = Math.min(minPay, special.get(i).get(num)+shoppingOffers(price, special, tmp));
                }
            }

        }
        map.put(key, minPay);
        return minPay;
    }
    private Map<String, Integer> map = new HashMap<>();
    private String getKey(List<Integer> needs) {
        StringBuilder sb = new StringBuilder(needs.size());
        for (int i = 0; i < needs.size(); i++) {
            sb.append(needs.get(i));
        }
        return sb.toString();
    }
}
