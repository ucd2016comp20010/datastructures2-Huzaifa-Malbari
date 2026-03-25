package utils;

public class Util {

    public static void shuffle(Integer [] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            int j = (int) (Math.random() * (arr.length - i)) + i;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

        }

    }
}
