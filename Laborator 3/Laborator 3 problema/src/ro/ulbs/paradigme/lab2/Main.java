
// Clasa Main pentru testare
package ro.ulbs.paradigme.lab2;

public class Main {
    public static void main(String[] args) {
        Form form1 = new Form();
        Form form2 = new Form("red");
        Form form3 = new Form("blue");
        Form form4= new Form("white ");
        Form form5 = new Form("black ");
        Form form6= new Form("yellow");
        Form form7= new Form("yellow");

        System.out.println("Number of instances created: " + Form.getCounter());
    }
}
