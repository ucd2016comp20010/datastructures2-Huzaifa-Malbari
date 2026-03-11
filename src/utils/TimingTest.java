package utils;

import java.util.Random;

public class TimingTest {
    public static void main(String[] args) {
        int n_min = 100, n_max = 100000, n_samples = 50;
        // we want to even divide the range on a log scale
        // n_min^{1+alpha*0}, ..., n_min^{1+alpha*i}, ..., n_min^{1 + alpha(n-1)} = n_max
        // alpha = (log(n_max)/log(n_min) - 1) / (n_samples - 1)
        double alpha = ((Math.log(n_max) / Math.log(n_min)) - 1) / (n_samples - 1);
        for (int i = 0; i < n_samples; ++i) {
            int n = (int) Math.pow(n_min, (1 + i * alpha));
            Runnable worker = () -> {
                int[] arr = new Random().ints(n).toArray();
                BubbleSort.sort(arr);
            };
            double result = Timer.measure(worker);
            System.out.println(i + "\t" + n + "\t" + result);
        }
    }
//    public static void main() {
//        int[] arr = new Random().ints(10).toArray();
////        arr = new int[] {4, 2, 8, 9, 10, 1, 3, 7, 5, 6};
//        BubbleSort.sort(arr);
//
//        StringBuilder line = new StringBuilder();
//        line.append("[");
//        for (int i : arr) {
//            line.append(i + ", ");
//        }
//
//        line = line.delete(line.length() - 2, line.length());
//        line.append("]");
//        System.out.println(line);
//
//    }
}

class BubbleSort {

    public static void sort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
           for (int j = 0; j < arr.length - i - 1; j++) {
               if (arr[j] > arr[j + 1]) {
                   int temp = arr[j];
                   arr[j] = arr[j + 1];
                   arr[j + 1] = temp;
               }
           }
        }

    }
}