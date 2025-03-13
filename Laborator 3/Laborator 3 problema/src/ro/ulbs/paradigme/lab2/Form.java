package ro.ulbs.paradigme.lab2;

// Clasa de bază Form
public class Form {
    private String color;
    private static int counter = 0; // Contor static

    public Form() {
        this.color = "white";
        counter++; // Incrementare la crearea unei noi instante
    }

    public Form(String color) {
        this.color = color;
        counter++; // Incrementare la crearea unei noi instante
    }

    public float getArea() {
        return 0;
    }

    public static int getCounter() { // Getter pentru contor
        return counter;
    }

    @Override
    public String toString() {
        return "This form has the color " + color;
    }
}
