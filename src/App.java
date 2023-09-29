import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
         BinaryTreeTest();
       // BinaryTreeLookUpBenchmark();
    }

    public static void BinaryTreeTest() {
        BinaryTree tree = new BinaryTree();

        tree.add(0, 0);

        tree.add(2, 2);
        tree.add(10, 10);
        tree.add(1, 1);
        tree.add(6, 6);
        tree.add(4, 4);

        tree.add(12, 12);
        tree.add(13, 13);
        tree.add(5, 5);

        for (int i : tree) {
            System.out.println(i);
        }

    }

    public static void BinaryTreeLookUpBenchmark() {

        Random rnd = new Random();
        int sizes[] = new int[] { 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192 ,8192*2};
        long minimumLookUp[] = new long[sizes.length];
        long minimumBinary[] = new long[sizes.length];
        for (int i = 0; i < minimumLookUp.length; i++) {
            minimumLookUp[i] = Long.MAX_VALUE;
            minimumBinary[i] = Long.MAX_VALUE;
        }
        int numberOfRuns = 25000;
        int numberOfAttempts = 1000;
        long t0;
        long t1;
        for (int h = 0; h < sizes.length; h++) {
            for (int x = 0; x < numberOfRuns; x++) {

                int[] array = sorted(sizes[h]);
                int[] key = keyArray(numberOfAttempts);

                t0 = System.nanoTime();
                for (int j = 0; j < numberOfAttempts; j++) {
                    binary_search_sorted(array, key[j]);
                }
                t1 = System.nanoTime() - t0;

                if (minimumBinary[h] > t1) {
                    minimumBinary[h] = t1;
                }

                BinaryTree tree = new BinaryTree();
                for (int j = 0; j < array.length; j++) {
                    int i = rnd.nextInt(array.length - 1);
                    tree.add2(array[i], array[i]);
                }

                t0 = System.nanoTime();

                for (int g = 0; g < numberOfAttempts; g++) {
                    tree.lookUp(key[g]);
                }

                t1 = System.nanoTime() - t0;

                if (minimumLookUp[h] > t1) {
                    minimumLookUp[h] = t1;
                }
            }

            System.out.println("Minimum time for look up size " + sizes[h] + " : " + minimumLookUp[h] + " ns");
            System.out.println("Minimum time for binary search " + sizes[h] + " : " + minimumBinary[h] + " ns");
            System.out.println("");
        }

    }

    private static int[] sorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;
        for (int i = 0; i < n; i++) {
            nxt += rnd.nextInt(10) + 1;
            array[i] = nxt;
        }
        return array;
    }

    public static boolean binary_search_sorted(int[] array, int key) {
        int minimumIndex = 0;
        int maximumIndex = array.length - 1;
        while (true) {
            // jump to the middle
            int middleIndex = (minimumIndex + maximumIndex) / 2;
            if (array[middleIndex] == key) {
                return true;
            }
            if (array[middleIndex] < key && middleIndex < maximumIndex) {
                // The index position holds something that is less than
                // what we're looking for, what is the first possible page?
                minimumIndex = middleIndex + 1;
                continue;
            }
            if (array[middleIndex] > key && middleIndex > minimumIndex) {
                // The index position holds something that is larger than
                // what we're looking for, what is the last possible page?
                maximumIndex = middleIndex - 1;
                continue;
            }
            // Why do we land here? What should we do?
            return false;
        }
    }

    public static int[] keyArray(int arraySize) {
        Random rnd = new Random();

        int[] key = new int[1000];

        for (int j = 0; j < key.length; j++) {
            key[j] = rnd.nextInt(10 * arraySize) + 1;
        }

        return key;

    }
}
