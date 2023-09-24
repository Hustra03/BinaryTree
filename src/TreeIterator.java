import java.util.Stack;
import java.util.Iterator;

public class TreeIterator implements Iterator<Integer> {
    private BinaryNode next;
    private Stack<BinaryNode> stack;

    public TreeIterator() {

    }

    @Override
    public boolean hasNext() {

        return false;
    }

    @Override
    public Integer next() {

        Integer Integer = next.getValue();
        this.next = stack.pop();
        while (true) {

            if (next.getLeftBinaryNode() != null) {
                stack.push(next);
                next = next.getLeftBinaryNode();
                continue;

            } else {
                if (next.getRightBinaryNode() != null) {
                    stack.push(next);
                    next = next.getRightBinaryNode();
                    continue;
                } else {
                    break;
                }
            }
        }

        return Integer;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
