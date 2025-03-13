package ro.ulbs.paradigme.lab2.doublechained;

import ro.ulbs.paradigme.lab2.api.MyList;
import ro.ulbs.paradigme.lab2.api.Node;

public class DoubleChainedList implements MyList {
    private DoubleChainedNode head;

    @Override
    public void addValue(int value) {
        DoubleChainedNode newNode = new DoubleChainedNode(value);
        if (head == null) {
            head = newNode;
            return;
        }
        DoubleChainedNode temp = head;
        while (temp.getNextNode() != null) {
            temp = temp.getNextNode();
        }
        temp.setNextNode(newNode);
        newNode.setPrevNode(temp);
    }

    @Override
    public Node getNodeByValue(int value) {
        DoubleChainedNode temp = head;
        while (temp != null) {
            if (temp.getValue() == value) {
                return temp;
            }
            temp = temp.getNextNode();
        }
        return null;
    }

    @Override
    public void removeNodeByValue(int value) {
        if (head == null) return;

        if (head.getValue() == value) {
            head = head.getNextNode();
            if (head != null) {
                head.setPrevNode(null);
            }
            return;
        }

        DoubleChainedNode temp = head;
        while (temp != null && temp.getValue() != value) {
            temp = temp.getNextNode();
        }

        if (temp == null) return;

        if (temp.getNextNode() != null) {
            temp.getNextNode().setPrevNode(temp.getPrevNode());
        }

        if (temp.getPrevNode() != null) {
            temp.getPrevNode().setNextNode(temp.getNextNode());
        }
    }

    @Override
    public void listNodes() {
        DoubleChainedNode temp = head;
        while (temp != null) {
            System.out.print(temp.getValue() + " <-> ");
            temp = temp.getNextNode();
        }
        System.out.println("null");
    }

    @Override
    public boolean isSorted() {
        DoubleChainedNode temp = head;
        while (temp != null && temp.getNextNode() != null) {
            if (temp.getValue() > temp.getNextNode().getValue()) {
                return false;
            }
            temp = temp.getNextNode();
        }
        return true;
    }
}
