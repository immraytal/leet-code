import java.util.*;

public class Task347 {
    public int[] topKFrequent(int[] nums, int k) {

        // map hold the word: counts
        HashMap<Integer, Integer> map = new HashMap();

        // sort the map by frequency high->low order, sort words lexi order
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
                (a,b)->{
                    if(a.getValue() != b.getValue())
                        return a.getValue().compareTo(b.getValue());
                    return -a.getKey().compareTo(b.getKey());
                }
        );

        // fill the map
        for(Integer word: nums){
            map.merge(word, 1, Integer::sum);
        }

        // put into heap
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            heap.offer(entry);
            if(heap.size() > k)
                heap.poll();
        }

        int[] res = new int[k];
        int counter = 0;
        while(!heap.isEmpty()){
            Map.Entry<Integer, Integer> entry = heap.poll();
            res[counter++] = entry.getKey();
        }

        // check the order
        //Collections.reverse(ans);
        return res;
    }
}
