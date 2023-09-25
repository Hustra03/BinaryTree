import java.util.Stack;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class TreeIterator implements Iterator<Integer> {
    private BinaryNode next;
    private Stack<BinaryNode> stack;

    public TreeIterator(BinaryNode root) {

        this.next = root;
        this.stack=new Stack<BinaryNode>();
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
            if (next.getRightBinaryNode() != null) {
                stack.push(next);
                next = next.getRightBinaryNode();
                while (next.getLeftBinaryNode() != null) {
                    stack.push(next.getLeftBinaryNode());
                    next = next.getLeftBinaryNode();
                }
            }
            Integer Integer = next.getValue();

            return Integer;
        }
        else
        {throw new NoSuchElementException();}
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
