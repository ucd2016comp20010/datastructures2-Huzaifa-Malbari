package project20280.tree;

import project20280.interfaces.Position;
import project20280.interfaces.List;
import project20280.list.SinglyLinkedList;

import java.util.ArrayList;
import java.util.Arrays;
// import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import javax.management.RuntimeErrorException;

/**
 * Concrete implementation of a binary tree using a node-based, linked
 * structure.
 */
public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

    static java.util.Random rnd = new java.util.Random();
    /**
     * The root of the binary tree
     */
    protected Node<E> root = null; // root of the tree

    // LinkedBinaryTree instance variables
    /**
     * The number of nodes in the binary tree
     */
    private int size = 0; // number of nodes in the tree

    /**
     * Constructs an empty binary tree.
     */
    public LinkedBinaryTree() {
    } // constructs an empty binary tree

    // constructor

    public static LinkedBinaryTree<Integer> makeRandom(int n) {
        LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>();
        bt.root = randomTree(null, 1, n);
        return bt;
    }

    // nonpublic utility

    public static <T extends Integer> Node<T> randomTree(Node<T> parent, Integer first, Integer last) {
        if (first > last) return null;
        else {
            Integer treeSize = last - first + 1;
            Integer leftCount = rnd.nextInt(treeSize);
            Integer rightCount = treeSize - leftCount - 1;
            Node<T> root = new Node<T>((T) ((Integer) (first + leftCount)), parent, null, null);
            root.setLeft(randomTree(root, first, first + leftCount - 1));
            root.setRight(randomTree(root, first + leftCount + 1, last));
            return root;
        }
    }

    // accessor methods (not already implemented in AbstractBinaryTree)

    public static void main(String [] args) {
//        LinkedBinaryTree<String> bt = new LinkedBinaryTree<>();
//        String[] arr = { "A", "B", "C", "D", "E", null, "F", null, null, "G", "H", null, null, null, null };
//        bt.createLevelOrder(arr);
//        System.out.println(bt.toBinaryTreeString());
//
//        Integer [] inorder= {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
//        Integer [] preorder= {18, 2, 1, 14, 13, 12, 4, 3, 9, 6, 5, 8, 7, 10, 11, 15, 16, 17, 28, 23, 19, 22, 20, 21, 24, 27, 26, 25, 29, 30};
//
//        LinkedBinaryTree <Integer> bt1 = new LinkedBinaryTree <>();
//        bt1.construct(inorder , preorder);
//        System.out.println(bt1.toBinaryTreeString ());
//        bt1.printLeaves();

        Integer[] arr = new Integer[] {1,
                2,3,
                4,5,6,7,
                8,9,10,11,12, 13, 14, 15,
                16,17 ,18,19,20,21,22,23 ,24,25,26,27,28,29,30,31,
                null ,null ,null ,35};

        LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>();
        bt.createLevelOrder(arr);

        bt.heightFunctionCalls = 0;
        System.out.println("Height is " + bt.height());
        System.out.println("Height function calls: " + bt.heightFunctionCalls);
        System.out.println(bt.toBinaryTreeString());
    }


    /**
     * Factory function to create a new node storing element e.
     */
    protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
        return new Node<E>(e, parent, left, right);
    }

    /**
     * Verifies that a Position belongs to the appropriate class, and is not one
     * that has been previously removed. Note that our current implementation does
     * not actually verify that the position belongs to this particular list
     * instance.
     *
     * @param p a Position (that should belong to this tree)
     * @return the underlying Node instance for the position
     * @throws IllegalArgumentException if an invalid position is detected
     */
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) throw new IllegalArgumentException("Not valid position type");
        Node<E> node = (Node<E>) p; // safe cast
        if (node.getParent() == node) // our convention for defunct node
            throw new IllegalArgumentException("p is no longer in the tree");
        return node;
    }

    /**
     * Returns the number of nodes in the tree.
     *
     * @return number of nodes in the tree
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns the root Position of the tree (or null if tree is empty).
     *
     * @return root Position of the tree (or null if tree is empty)
     */
    @Override
    public Position<E> root() {
        return root;
    }

    // update methods supported by this class

    /**
     * Returns the Position of p's parent (or null if p is root).
     *
     * @param p A valid Position within the tree
     * @return Position of p's parent (or null if p is root)
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     */
    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        return ((Node<E>) p).getParent();
    }

    /**
     * Returns the Position of p's left child (or null if no child exists).
     *
     * @param p A valid Position within the tree
     * @return the Position of the left child (or null if no child exists)
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     */
    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        return ((Node<E>) p).getLeft();
    }

    /**
     * Returns the Position of p's right child (or null if no child exists).
     *
     * @param p A valid Position within the tree
     * @return the Position of the right child (or null if no child exists)
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     */
    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        return ((Node<E>) p).getRight();
    }

    /**
     * Places element e at the root of an empty tree and returns its new Position.
     *
     * @param e the new element
     * @return the Position of the new element
     * @throws IllegalStateException if the tree is not empty
     */
    public Position<E> addRoot(E e) throws IllegalStateException {
        // TODO
        if (root != null) {
            throw new IllegalStateException("Tree is not empty");
        }

        root = createNode(e, null, null, null);
        size++;
        return root;
    }

    public void insert(E e) {
        // TODO

    }

    // recursively add Nodes to binary tree in proper position
    private Node<E> addRecursive(Node<E> p, E e) {
        // TODO
        return null;
    }

    /**
     * Creates a new left child of Position p storing element e and returns its
     * Position.
     *
     * @param p the Position to the left of which the new element is inserted
     * @param e the new element
     * @return the Position of the new element
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     * @throws IllegalArgumentException if p already has a left child
     */
    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
        // TODO
        validate(p);
        Node<E> pnode = (Node<E>) p;
        if (pnode.getLeft() != null){
            throw new IllegalArgumentException("p already has left child");
        }

        pnode.setLeft(createNode(e, pnode, null, null));
        size++;
        return pnode.getLeft();
    }

    /**
     * Creates a new right child of Position p storing element e and returns its
     * Position.
     *
     * @param p the Position to the right of which the new element is inserted
     * @param e the new element
     * @return the Position of the new element
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     * @throws IllegalArgumentException if p already has a right child
     */
    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
        // TODO
        validate(p);
        Node<E> pnode = (Node<E>) p;
        if (pnode.getRight() != null){
            throw new IllegalArgumentException("p already has right child");
        }

        pnode.setRight(createNode(e, pnode, null, null));
        size++;
        return pnode.getRight();
    }

    /**
     * Replaces the element at Position p with element e and returns the replaced
     * element.
     *
     * @param p the relevant Position
     * @param e the new element
     * @return the replaced element
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     */
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        // TODO
        validate(p);
        E removed = p.getElement();
        Node<E> node = (Node<E>) p;
        node.setElement(e);
        return removed;
    }

    /**
     * Attaches trees t1 and t2, respectively, as the left and right subtree of the
     * leaf Position p. As a side effect, t1 and t2 are set to empty trees.
     *
     * @param p  a leaf of the tree
     * @param t1 an independent tree whose structure becomes the left child of p
     * @param t2 an independent tree whose structure becomes the right child of p
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     * @throws IllegalArgumentException if p is not a leaf
     */
    public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException {
        // TODO
    }

    /**
     * Removes the node at Position p and replaces it with its child, if any.
     *
     * @param p the relevant Position
     * @return element that was removed
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     * @throws IllegalArgumentException if p has two children.
     */
    public E remove(Position<E> p) throws IllegalArgumentException {
        // TODO
        validate(p);
        Node<E> pnode = (Node<E>) p;
        if ((pnode.getLeft() != null) && (pnode.getRight() != null)) {
            throw new IllegalArgumentException("p has 2 children");
        }

        Node<E> parent = (pnode.getParent() == null) ? root : pnode.getParent();

        if (parent.getLeft() == pnode) {
            if (pnode.getLeft() != null) {
                parent.setLeft(pnode.getLeft());
            }else if (pnode.getRight() != null) {
                parent.setLeft(pnode.getRight());
            }

        }else {
            if (pnode.getLeft() != null) {
                parent.setRight(pnode.getLeft());
            }else if (pnode.getRight() != null) {
                parent.setRight(pnode.getRight());
            }
            
        }
        size--;
        return pnode.getElement();
    }

    public String toString() {
        return positions().toString();
    }

    public void createLevelOrder(ArrayList<E> l) {
        // TODO
        createLevelOrder( (E[]) l.toArray());
    }

    private Node<E> createLevelOrderHelper(java.util.ArrayList<E> l, Node<E> p, int i) {
        // TODO
        return createLevelOrderHelper( (E[]) l.toArray(), root, 0);
    }

    public void createLevelOrder(E[] arr) {
        root = createLevelOrderHelper(arr, root, 0);
    }

    private Node<E> createLevelOrderHelper(E[] arr, Node<E> p, int i) {
        // TODO
        if (i < arr.length) {
            Node<E> n = createNode(arr[i], p, null, null);
            n.setLeft(createLevelOrderHelper(arr, n, 2*i + 1));
            n.setRight(createLevelOrderHelper(arr, n, 2*i + 2));
            return n;
        }
        return null;
    }

    public void construct(E[] inorder, E[] preorder) {
        root = constructHelper(inorder, preorder, 0,0, inorder.length - 1);
    }

    private Node<E> constructHelper(E[] inorder, E[] preorder, int s, int i, int e) {

        int rootidx = s;
        while ((rootidx < e) && !(inorder[rootidx].equals(preorder[i])) ) {
            rootidx++;
        }

        //leaf node
        if ((rootidx == s) && (rootidx == e)) {
            return createNode(preorder[i], null, null, null);
        }

        Node<E> thisRoot = createNode(preorder[i], null, null, null);
        if ((rootidx > s) && (i + 1 < preorder.length)) {
            Node<E> left = constructHelper(inorder, preorder, s, i + 1, rootidx - 1);
            left.setParent(thisRoot);
            thisRoot.setLeft(left);
        }

        if (rootidx < e) {
            Node<E> right = constructHelper(inorder, preorder, rootidx + 1, i + rootidx - s + 1, e);
            right.setParent(thisRoot);
            thisRoot.setRight(right);
        }
//        if (rootidx < e) {
//            int rightRoot = i;
//            while ((rightRoot < preorder.length) && (preorder[rightRoot] != inorder[rootidx + 1])) {
//                rightRoot++;
//            }
//            Node<E> right = constructHelper(inorder, preorder, rootidx + 1, rightRoot, e);
//            right.setParent(thisRoot);
//            thisRoot.setRight(right);
//        }


        return thisRoot;
    }

    public void printLeaves() {
        SinglyLinkedList<E> snapshot = new SinglyLinkedList<E>();
        printLeavesHelper(root, snapshot);
        System.out.println(snapshot);
    }

    private void printLeavesHelper(Node<E> node, List<E> snapshot) {
        if (numChildren(node) == 0) {
            snapshot.addLast(node.getElement());
            return;
        }
        if (node.getLeft() != null) {
            printLeavesHelper(node.getLeft(), snapshot);
        }
        if (node.getRight() != null) {
            printLeavesHelper(node.getRight(), snapshot);
        }
        return;
    }

    public String toBinaryTreeString() {
        BinaryTreePrinter<E> btp = new BinaryTreePrinter<>(this);
        return btp.print();
    }

    /**
     * Nested static class for a binary tree node.
     */
    public static class Node<E> implements Position<E> {
        private E element;
        private Node<E> left, right, parent;

        public Node(E e, Node<E> p, Node<E> l, Node<E> r) {
            element = e;
            left = l;
            right = r;
            parent = p;
        }

        // accessor
        public E getElement() {
            return element;
        }

        // modifiers
        public void setElement(E e) {
            element = e;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> n) {
            left = n;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> n) {
            right = n;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> n) {
            parent = n;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (element == null) {
                sb.append("\u29B0");
            } else {
                sb.append(element);
            }
            return sb.toString();
        }
    }
}
