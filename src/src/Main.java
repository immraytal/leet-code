/**
 * Реализовать структуру, поддерживающую следующие операции:
 *
 * put(key, value)
 * get(key)
 * remove(key)
 * isAllUnique() - возвращает true, если никакие два ключа не имеют два одинаковых значения
 *
 *
 * const map = new MapWithAllUnique();
 * map.isAllUnique() => true
 * map.put("a",1);
 * map.isAllUnique() => true
 * map.put("b",2);
 * map.isAllUnique() => true
 * map.put("c",1);
 * map.isAllUnique() => false
 * map.put("a",3);
 * map.isAllUnique() => true
 *
 * 2 3
 * 1 2
 *
 * 1 2
 * 1 1
 *
 *
 * Даны два отсортированных массива.
 *
 * Вывести все элементы первого массива, которые не встречаются во втором.
 *
 * filter([1, 2, 3], [2, 3, 4]) => [1]
 * filter([1, 2, 3], [1, 2, 2, 4]) => [1]
 * filter([1, 2, 3], [2, 3, 4]) => [1]
 * filter([10, 20, 30], [19, 20, 21]) => [10, 30]
 * filter([1, 2, 3, 4], [30, 31, 32, 33]) => [1, 2, 3, 4]
 * filter([1, 2, 2, 3], [1, 2, 4]) => [3]
 * filter([], []) => []
 * filter([1, 2, 3], []) => [1, 2, 3]
 * filter([], [1, 2, 3]) => []
 * */
import java.util.*;
import java.lang.*;


public class Main {
    public static void main(String[] args) {
        Main.filter(new int[]{10, 20, 30}, new int[]{19, 20, 21});
        System.out.println("=========");
        Main.filter(new int[]{1, 2, 3, 4}, new int[]{30, 31, 32, 33});
        System.out.println("=========");
        Main.filter(new int[]{1, 2, 2, 3}, new int[]{1, 2, 4});
        System.out.println("=========");
        Main.filter(new int[]{}, new int[]{});
        System.out.println("=========");
        Main.filter(new int[]{1, 2, 3}, new int[]{});
        System.out.println("=========");
        Main.filter(new int[]{}, new int[]{1, 2, 3});

    }
    public static void filter(int[] arr1, int[] arr2) {

        int i = 0;
        int j = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                System.out.println(arr1[i]);
                i++;
            } else {
                j++;
            }
        }


        int pointerArr2 = 0;
        for (int num : arr1) {
            int currentArr2 = arr2[pointerArr2];
            if (num < currentArr2) {
                System.out.println(num);
            } else {
                if (num == currentArr2) {
                    continue;
                }
                while (currentArr2 < num && pointerArr2 < arr2.length - 1) {
                    pointerArr2++;
                    currentArr2 = arr2[pointerArr2];
                }
                if (num < currentArr2) {
                    System.out.println(num);
                }
            }
        }
    }
}



class Test
{
    public static void main(String args[])
    {
        MapWithAllUnique<String, Integer> map = new MapWithAllUnique<>();
        map.put("qwe", 1);
        map.put("qwew", 1);
        map.put("qwef", 2);
        System.out.println(map.isAllUnique());
        map.remove("qwe");
        System.out.println(map.isAllUnique());
    }
}

class MapWithAllUnique<K, V> {

    Map<K, V> map = new HashMap<>();
    Map<V, Integer> mapValues = new HashMap<>();

    public V put(K key, V value) {
        map.put(key, value);
        if (mapValues.containsKey(value)) {
            mapValues.put(value, mapValues.get(value) + 1);
        } else {
            mapValues.put(value, 0);
        }
        return value;
    }

    public V get(K key) {
        return map.get(key);
    }

    public V remove(K key) {
        V value = map.remove(key);
        if (value != null) {
            if (mapValues.get(value) > 1) {
                mapValues.put(value, mapValues.get(value) - 1);
            } else {
                mapValues.remove(value);
            }
            return value;
        } else {
            return null;
        }
    }

    public boolean isAllUnique() {
        System.out.println(map.size());
        System.out.println(mapValues.size());
        return map.size() == mapValues.size();
    }
}