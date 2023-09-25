import java.util.Stack;
import java.util.Iterator;

public class TreeIterator implements Iterator<Integer> {
    private BinaryNode next;
    private Stack<BinaryNode> stack;

    public TreeIterator() {
        while (next.getLeftBinaryNode() != null) {
            stack.push(next);
            next = next.getLeftBinaryNode();
        }
    }

    @Override
    public boolean hasNext() {
        if (next != null) {
            return true;
        }
        return false;
    }

    @Override
    public Integer next() {// Not done

        if (stack.empty() != false) {

            BinaryNode newNext = stack.pop();
            if (newNext.getRightBinaryNode() != null) {
                stack.push(newNext);
                newNext = newNext.getRightBinaryNode();
                while (newNext.getLeftBinaryNode() != null) {
                    stack.push(newNext.getLeftBinaryNode());
                    newNext = newNext.getLeftBinaryNode();
                }
                next = newNext;
            }
            Integer Integer = next.getValue();

            return Integer;
        }
        this.next = null;
        return null;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
