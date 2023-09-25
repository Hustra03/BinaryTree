public class App {
    public static void main(String[] args) throws Exception {
        BinaryTreeTest();
    }

    public static void BinaryTreeTest() {
        BinaryTree tree = new BinaryTree();

        tree.add(0, 0);

        tree.add(2, 2);
        tree.add(10, 10);
        tree.add(1, 1);
        tree.add(6, 6);
        tree.add(4, 4);

        tree.getRoot().print();

        for (int i = 0; i <= 10; i++) {
            System.out.println("Value of Key " + i + " in tree 1 :" + tree.lookUp(i));
            System.out.println("");
        }
        for (int i : tree) {
            System.out.println(i);
        }
    }
}
