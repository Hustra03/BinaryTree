import java.util.Stack;
import java.util.Iterator;

public class TreeIterator implements Iterator<Integer> {
    private BinaryNode next;
    private Stack<BinaryNode> stack;

    public TreeIterator(BinaryNode root) {

        this.next = root;
        this.stack = new Stack<BinaryNode>();
        stack.push(next);
        while (next.getLeftBinaryNode() != null) {
            stack.push(next);
            next = next.getLeftBinaryNode();
        }
    }

    @Override
    public boolean hasNext() {
        if (stack.empty()) {
            return false;
        }
        return true;
    }

    @Override
    public Integer next() {// Not done

        if (stack.empty() == false) {
            next = stack.pop();
            Integer Integer = next.getValue();
            if (next.getRightBinaryNode() != null) {
                next = next.getRightBinaryNode();
                while (next.getLeftBinaryNode() != null) {
                    stack.push(next);
                    next = next.getLeftBinaryNode();
                }
            }
            return Integer;
        } else {
            return null;
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
