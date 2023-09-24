public class BinaryTree {
    BinaryNode root;

    public BinaryTree() {
        this.root = null;
    }

    public void add(Integer key, Integer value) { // Non recursive add method

        BinaryNode currentPosition = root;
        while (true) {
            if (currentPosition == null) {
                currentPosition = new BinaryNode(key, value);
            } else {
                if (currentPosition.getKey() == key) {
                    currentPosition.setValue(value);
                    return;
                } else {
                    if (currentPosition.getKey() < key) {
                        currentPosition = currentPosition.getLeftBinaryNode();
                    } else {
                        currentPosition = currentPosition.getLeftBinaryNode();
                    }

                }
            }
        }
    }

    public void add2(Integer key, Integer value) { // Recursive add method
        addRecursive(key, value, this.root);
    }

    public void addRecursive(Integer key, Integer value, BinaryNode currentPosition) {
        if (currentPosition == null) {
            currentPosition = new BinaryNode(key, value);
        } else {
            if (currentPosition.getKey() == key) {
                currentPosition.setValue(value);
                return;
            } else {
                if (currentPosition.getKey() < key) {
                    addRecursive(key, value, currentPosition.getLeftBinaryNode());
                } else {
                    addRecursive(key, value, currentPosition.getRightBinaryNode());
                }

            }
        }
    }

    public Integer lookUp(Integer key) { // Non recursive look up
        BinaryNode currentPosition = root;
        while (currentPosition != null) {
            if (currentPosition.getKey() == key) {
                return currentPosition.getValue();
            } else {
                if (currentPosition.getKey() < key) {
                    currentPosition = currentPosition.getLeftBinaryNode();
                } else {
                    currentPosition = currentPosition.getLeftBinaryNode();
                }
            }
        }

        return null;
    }

    public Integer lookUp2(Integer key) { // Recursive look up
        return recursiveLookUp(key, root);
    }

    public Integer recursiveLookUp(Integer key, BinaryNode currentPosition) {

        if (currentPosition != null) {
            if (currentPosition.getKey() == key) {
                return currentPosition.getValue();
            } else {
                if (currentPosition.getKey() < key) {
                    recursiveLookUp(key, currentPosition.getLeftBinaryNode());
                } else {
                    recursiveLookUp(key, currentPosition.getRightBinaryNode());
                }

            }
        }
        return null;

    }
}
