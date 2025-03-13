// ro.ulbs.paradigme.lab2.application.Application.java
package ro.ulbs.paradigme.lab2.application;

import ro.ulbs.paradigme.lab2.simplechained.SimpleChainedList;

public class Application {
    public static void main(String[] args) {
        SimpleChainedList simpleList = new SimpleChainedList();
        for (int i = 1; i <= 10; i++) {
            simpleList.addValue(i);
        }

        simpleList.removeNodeByValue(4);
        simpleList.removeNodeByValue(6);
        simpleList.removeNodeByValue(8);
        simpleList.removeNodeByValue(10);

        System.out.print("Lista simplu inlantuita: ");
        simpleList.listNodes();
        System.out.println("Suma valorilor: " + simpleList.sumValues());
        System.out.println("Lista sortata: " + simpleList.isSorted());
    }
}
