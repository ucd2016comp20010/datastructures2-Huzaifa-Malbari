package project20280.hashtable;

import project20280.interfaces.Entry;
import project20280.priorityqueue.HeapPriorityQueue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountingWords {
    public static void main(String []args) throws FileNotFoundException {
        File f = new File("src/project20280/hashtable/sample_text.txt"); // check the path to the file
        ChainHashMap<String, Integer> counter = new ChainHashMap<String,
                Integer>();

        // use a Scanner to read words from the file
        Scanner scanner = new Scanner(f);
        while(scanner.hasNext()) { // read the file word at a time
            String word = scanner.next();
            System.out.println("word:" + word);

            // if word is not in the hashmap, add it with count=1
            // otherwise, find the entry for this word and increment by 1
            Integer count = counter.get(word);
            if (count == null) {
                counter.put(word, 1);
            }else {
                counter.put(word, count + 1);
            }
        }

        // sort the key, values...
        // Can you sort the Entries by the value?
        Integer[] keys = new Integer[counter.size()];
        String[] values = new String[counter.size()];

        int index = 0;
        for (Entry e : counter.entrySet() ) {
            keys[index] = ((Integer) e.getValue()) * -1;
            values[index] = (String) e.getKey();
            index++;
        }
        HeapPriorityQueue<Integer, String> heap = new HeapPriorityQueue<>(keys, values);

        for (int i = 0; i < 10 && !heap.isEmpty(); i++) {
            System.out.println("Popular " + i + ": " + heap.removeMin().getValue());
        }
    }
}
