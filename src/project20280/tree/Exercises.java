package project20280.tree;

public class Exercises {
    public static void createRandomTrees() {
        for (int i = 50; i <= 5000; i += 50) {

            double height = 0;
            for (int j = 1; j < 100; j++) {
                LinkedBinaryTree bt = LinkedBinaryTree.makeRandom(i);
                height += bt.height();
            }
            height /= 100;
            System.out.println(i + "\t\t" + height);

        }
    }

    public static void main() {
        createRandomTrees();
    }
}
