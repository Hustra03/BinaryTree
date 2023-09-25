public class App {
    public static void main(String[] args) throws Exception {
        BinaryTreeTest();
    }

    public static void BinaryTreeTest() {
        BinaryTree tree = new BinaryTree();

        tree.add(0, 1);

        tree.add(2, 1);
        tree.add(10, 13);
        tree.add2(1, 1);
        tree.add2(6, 23);
        tree.add(4, 1);

        tree.getRoot().print();

        for (int i = 0; i <= 10; i++) {
            System.out.println("Value of Key " + i + " in tree 1 :" + tree.lookUp(i));
            System.out.println("");
        }
    }
}
