public class App {
    public static void main(String[] args) throws Exception {
        BinaryTreeTest();
    }

    public static void BinaryTreeTest() {
        BinaryTree tree = new BinaryTree();
        tree.add(0, 1);
        tree.add(2, 1);
        tree.add(10, 13);

        tree.add(1, 1);
        tree.add(6, 23);

        tree.add(4, 1);

        tree.getRoot().print();
    }
}
