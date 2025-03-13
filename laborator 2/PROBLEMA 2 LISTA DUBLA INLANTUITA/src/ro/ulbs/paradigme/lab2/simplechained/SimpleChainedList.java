package ro.ulbs.paradigme.lab2.simplechained;

import ro.ulbs.paradigme.lab2.api.MyList;
import ro.ulbs.paradigme.lab2.api.Node;

public class SimpleChainedList implements MyList {
    private SimpleChainedNode head;

    @Override
    public void addValue(int value) {
        if (head == null) {
            head = new SimpleChainedNode(value);
            return;
        }
        SimpleChainedNode temp = head;
        while (temp.getNextNode() != null) {
            temp = temp.getNextNode();
        }
        temp.setNextNode(new SimpleChainedNode(value));
    }

    @Override
    public Node getNodeByValue(int value) {
        SimpleChainedNode temp = head;
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
            return;
        }
        SimpleChainedNode temp = head;
        while (temp.getNextNode() != null && temp.getNextNode().getValue() != value) {
            temp = temp.getNextNode();
        }
        if (temp.getNextNode() != null) {
            temp.setNextNode(temp.getNextNode().getNextNode());
        }
    }

    @Override
    public void listNodes() {
        SimpleChainedNode temp = head;
        while (temp != null) {
            System.out.print(temp.getValue() + " -> ");
            temp = temp.getNextNode();
        }
        System.out.println("null");
    }

    @Override
    public boolean isSorted() {
        SimpleChainedNode temp = head;
        while (temp != null && temp.getNextNode() != null) {
            if (temp.getValue() > temp.getNextNode().getValue()) {
                return false;
            }
            temp = temp.getNextNode();
        }
        return true;
    }
}
