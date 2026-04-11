package project20280.tree;

import project20280.interfaces.Entry;
import project20280.interfaces.Position;

import java.util.Comparator;

/**
 * An implementation of a sorted map using an AVL tree.
 */

public class AVLTreeMap<K, V> extends TreeMap<K, V> {

    /**
     * Constructs an empty map using the natural ordering of keys.
     */
    public AVLTreeMap() {
        super();
    }

    /**
     * Constructs an empty map using the given comparator to order keys.
     *
     * @param comp comparator defining the order of keys in the map
     */
    public AVLTreeMap(Comparator<K> comp) {
        super(comp);
    }

    /**
     * Returns the height of the given tree position.
     */
    protected int height(Position<Entry<K, V>> p) {
        // TODO
        BalanceableBinaryTree.BSTNode node = (BalanceableBinaryTree.BSTNode) p;
        return node.getAux();
    }

    /**
     * Recomputes the height of the given position based on its children's heights.
     */
    protected void recomputeHeight(Position<Entry<K, V>> p) {
        // TODO
        int maxHeight = 0;
        if (isExternal(p)) {
            ((BalanceableBinaryTree.BSTNode<Entry<K,V>>) p).setAux(0);
            return;
        }
        for (Position child : tree.children(p)) {
            maxHeight = Math.max(maxHeight, height(child));
        }
        ((BalanceableBinaryTree.BSTNode<Entry<K,V>>) p).setAux(maxHeight + 1);
    }

    /**
     * Returns whether a position has balance factor between -1 and 1 inclusive.
     */
    protected boolean isBalanced(Position<Entry<K, V>> p) {
        // TODO
        if (isExternal(p)) {
            return true;
        }

        if (tree.numChildren(p) == 1) {
            return height(tree.children(p).iterator().next()) <= 1;
        }

        return Math.abs(height(left(p)) - height(right(p))) <= 1;
    }

    /**
     * Returns a child of p with height no smaller than that of the other child.
     */
    protected Position<Entry<K, V>> tallerChild(Position<Entry<K, V>> p) {
        // TODO
        BalanceableBinaryTree.BSTNode<Entry<K, V>> node = (BalanceableBinaryTree.BSTNode<Entry<K,V>>) p;

        if (isExternal(p)) {
            return null;
        }

        if (tree.numChildren(p) == 1) {
            return tree.children(p).iterator().next();
        }

        return (height(left(p)) >= height(right(p))) ? left(p) : right(p);
    }

    /**
     * Utility used to rebalance after an insert or removal operation. This
     * traverses the path upward from p, performing a trinode restructuring when
     * imbalance is found, continuing until balance is restored.
     */
    protected void rebalance(Position<Entry<K, V>> p) {
        // TODO
        int oldHeight, newHeight;
        do {
            oldHeight = height(p); // not yet recalculated if internal
            if (!isBalanced(p)) { // imbalance detected
                // perform trinode restructuring, setting p to resulting root,
                // and recompute new local heights after the restructuring
                p = restructure(tallerChild(tallerChild(p)));
                recomputeHeight(tree.left(p));
                recomputeHeight(tree.right(p));
            }
            recomputeHeight(p);
            newHeight = height(p);
            p = tree.parent(p);
        } while (oldHeight != newHeight && p != null);
    }

    /**
     * Overrides the TreeMap rebalancing hook that is called after an insertion.
     */
    @Override
    protected void rebalanceInsert(Position<Entry<K, V>> p) {
        rebalance(p);
    }

    /**
     * Overrides the TreeMap rebalancing hook that is called after a deletion.
     */
    @Override
    protected void rebalanceDelete(Position<Entry<K, V>> p) {
        // TODO
        rebalance(p);
    }

    /**
     * Ensure that current tree structure is valid AVL (for debug use only).
     */
    private boolean sanityCheck() {
        for (Position<Entry<K, V>> p : tree.positions()) {
            if (isInternal(p)) {
                if (p.getElement() == null)
                    System.out.println("VIOLATION: Internal node has null entry");
                else if (height(p) != 1 + Math.max(height(left(p)), height(right(p)))) {
                    System.out.println("VIOLATION: AVL unbalanced node with key " + p.getElement().getKey());
                    dump();
                    return false;
                }
            }
        }
        return true;
    }

    public String toBinaryTreeString() {
        BinaryTreePrinter<Entry<K, V>> btp = new BinaryTreePrinter<>(this.tree);
        return btp.print();
    }

    public static void main(String[] args) {
        AVLTreeMap avl = new AVLTreeMap<>();

        Integer[] arr = new Integer[]{5, 3, 10, 2, 4, 7, 11, 1, 6, 9, 12, 8};

        for (Integer i : arr) {
            if (i != null) avl.put(i, i);
            System.out.println("root " + avl.root());
        }
        System.out.println(avl.toBinaryTreeString());

        avl.remove(5);
        System.out.println(avl.toBinaryTreeString());

        AVLTreeMap map = new AVLTreeMap();
        for (int i = 1; i < 100; i++) {
            map.put(i, i);
        }

        System.out.println(map.toBinaryTreeString());

    }
}
