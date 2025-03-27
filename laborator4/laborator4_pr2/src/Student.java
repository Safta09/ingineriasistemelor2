import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Student {
    private String nume;
    private String prenume;
    private String grupa;
    private List<Integer> note;

    // Constructor pentru a crea un student
    public Student(String nume, String prenume, String grupa) {
        this.nume = nume;
        this.prenume = prenume;
        this.grupa = grupa;
        this.note = new ArrayList<>();
        // Generăm 5 note aleatorii între 4 și 10
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            note.add(4 + rand.nextInt(7)); // note între 4 și 10
        }
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getGrupa() {
        return grupa;
    }

    public List<Integer> getNote() {
        return note;
    }

    // Calculăm media notelor
    public double getMedie() {
        int sum = 0;
        for (int nota : note) {
            sum += nota;
        }
        return sum / 5.0;
    }

    // Determinăm numărul de restanțe (note < 5)
    public int getNumarRestante() {
        int restanțe = 0;
        for (int nota : note) {
            if (nota < 5) {
                restanțe++;
            }
        }
        return restanțe;
    }


    // Determinăm dacă este integralist (fără restanțe)
    public boolean esteIntegralist() {
        return getNumarRestante() == 0;
    }

    @Override
    public String toString() {
        return nume + " " + prenume + " - Grupa: " + grupa + " - Note: " + note + " - Medie: " + getMedie();
    }
}
