public class BinaryTree implements Iterable<Integer> {
    BinaryNode root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryNode getRoot() {
        return this.root;
    }

    public TreeIterator iterator() {
        return new TreeIterator(this.root);
    }

    public void add(Integer key, Integer value) { // Non recursive add method

        BinaryNode currentPosition = root;

        if (root == null) {
            root = new BinaryNode(key, value);
            return;
        } else {
            while (true) {
                if (currentPosition.getKey() == key) {
                    currentPosition.setValue(value);
                    return;
                } else {
                    if (currentPosition.getKey() > key) {
                        if (currentPosition.getLeftBinaryNode() == null) {
                            currentPosition.setLeftBinaryNode(new BinaryNode(key, value));
                            return;
                        } else {
                            currentPosition = currentPosition.getLeftBinaryNode();
                        }

                    } else {
                        if (currentPosition.getRightBinaryNode() == null) {
                            currentPosition.setRightBinaryNode(new BinaryNode(key, value));
                            return;
                        } else {
                            currentPosition = currentPosition.getRightBinaryNode();
                        }
                    }

                }
            }
        }

    }

    public void add2(Integer key, Integer value) { // Recursive add method
        if (root == null) {
            root = new BinaryNode(key, value);
            return;
        }
        addRecursive(key, value, this.root);
    }

    private void addRecursive(Integer key, Integer value, BinaryNode currentPosition) {

        if (currentPosition.getKey() == key) {
            currentPosition.setValue(value);
            return;
        } else {
            if (currentPosition.getKey() > key) {
                if (currentPosition.getLeftBinaryNode() == null) {
                    currentPosition.setLeftBinaryNode(new BinaryNode(key, value));
                    return;
                } else {
                    addRecursive(key, value, currentPosition.getLeftBinaryNode());
                }

            } else {
                if (currentPosition.getRightBinaryNode() == null) {
                    currentPosition.setRightBinaryNode(new BinaryNode(key, value));
                    return;
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
                if (currentPosition.getKey() > key) {
                    currentPosition = currentPosition.getLeftBinaryNode();
                } else {
                    currentPosition = currentPosition.getRightBinaryNode();
                }
            }
        }

        return null;
    }

    public Integer lookUp2(Integer key) { // Recursive look up
        return recursiveLookUp(key, root);
    }

    private Integer recursiveLookUp(Integer key, BinaryNode currentPosition) {

        if (currentPosition != null) {
            if (currentPosition.getKey() == key) {
                return currentPosition.getValue();
            } else {
                if (currentPosition.getKey() > key) {
                    return recursiveLookUp(key, currentPosition.getLeftBinaryNode());
                } else {
                    return recursiveLookUp(key, currentPosition.getRightBinaryNode());
                }
            }
        }
        return null;

    }

}
