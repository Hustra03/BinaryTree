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

        tree.add(12, 12);
        tree.add(13, 13);
        tree.add(5, 5);

        tree.getRoot().print();

        for (int i = 0; i <= 10; i++) {
            System.out.println("Value of Key " + i + " in tree 1 :" + tree.lookUp(i));
            System.out.println("");
        }
        for (int i : tree) {
            System.out.println(i);
        }
        TreeIterator iter =  tree.iterator();
        Integer one = iter.next();
        Integer two = iter.next();
        Integer three = iter.next();
    
        System.out.println("one: " + one + " two: " + two + " three: " + three);
        tree.add(4, 13);//Changes in the tree will affect the iterator, depending on where in the tree the value is located
        one = iter.next();
        two = iter.next();
        three = iter.next();
        System.out.println("one: " + one + " two: " + two + " three: " + three);


    }
}
