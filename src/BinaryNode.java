public class BinaryNode {

    public Integer key;
    public Integer value;
    public BinaryNode left, right;

    public BinaryNode(Integer key, Integer value) {
        this.key = key;
        this.value = value;
        this.left = this.right = null;
    }

    public Integer getKey() {
        return this.key;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public BinaryNode getRightBinaryNode() {
        return this.right;
    }

    public void setRightBinaryNode(BinaryNode newRightNode) {
        this.right = newRightNode;
    }

    public BinaryNode getLeftBinaryNode() {
        return this.left;
    }

    public void setLeftBinaryNode(BinaryNode newLeftNode) {
        this.left = newLeftNode;
    }

    public void print() {
        if (left != null)
            left.print();
        System.out.println(" key: " + key + "\tvalue: " + value);
        if (right != null)
            right.print();
    }
}
