package ro.ulbs.paradigme.lab2.doublechained;

import ro.ulbs.paradigme.lab2.api.Node;

public class DoubleChainedNode implements Node {
    private int value;
    private DoubleChainedNode next;
    private DoubleChainedNode prev;

    public DoubleChainedNode(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }

    public void setNextNode(DoubleChainedNode n) {
        this.next = n;
    }

    public DoubleChainedNode getNextNode() {
        return next;
    }

    public void setPrevNode(DoubleChainedNode p) {
        this.prev = p;
    }

    public DoubleChainedNode getPrevNode() {
        return prev;
    }
}
