package project20280.priorityqueue;

import utils.Timer;
import utils.Util;

import java.util.Random;
import java.util.stream.IntStream;

public class SortTimings {

    public static void main(String [] args) {
        Random rnd = new Random();
        rnd.setSeed(1024);
        int n_min = 1000, n_max = 1000000, n_samples = 80;
        double alpha = ( (Math.log(n_max) / Math.log(n_min)) - 1) / (n_samples-1);
        for(int i = 0; i < n_samples; ++i) {
            int n = (int) Math.pow(n_min, (1 + i * alpha));
            Integer[] arr = IntStream.rangeClosed(1, n).boxed().toArray(Integer[]::new);
            Runnable worker = () -> {
                Util.shuffle(arr);
                HeapPriorityQueue<Integer, Integer> pq = new HeapPriorityQueue<>(arr, arr);
                for(int k = 0; k < arr.length; ++k) {
                    arr[k] = pq.removeMin().getKey();
                }
            };

            Runnable heapsort = () -> {
                HeapPriorityQueue pq = new HeapPriorityQueue(arr, arr);
                pq.heapsort();
            };

//            double result = Timer.measure(worker);
//            System.out.println(i + "\t" + n + "\t" + result + "\t" );
            double result = Timer.measure(heapsort);
            System.out.println(i + "\t" + n + "\t" + result + "\t" );
        }
    }

//    public static void main() {
//
////        Integer[] arr = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
////        Util.shuffle(arr);
////        System.out.println(printArr(arr));
//
//        Integer[] ten = new Integer[] {1,2,3,4,5,6,7,8,9,10};
//        Util.shuffle(ten);
//        HeapPriorityQueue pq = new HeapPriorityQueue(ten, ten);
//        pq.heapsort();
//        System.out.println(pq);
//
//    }

    static <T extends Object> String  printArr(T [] a) {

        StringBuilder sb = new StringBuilder();
        sb.append('[');

        for (T o : a) {
            sb.append(o.toString() + ", ");
        }

        sb.setLength(sb.length() - 2);
        sb.append(']');
        return sb.toString();
    }
}
