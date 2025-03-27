
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import java.util.Collections;
import java.util.Comparator;



public class Student {
    private String nume;
    private String prenume;
    private String grupa;
    private List<Integer> note;

    // Constructorul clasei Student
    public Student(String nume, String prenume, String grupa) {
        this.nume = nume;
        this.prenume = prenume;
        this.grupa = grupa;
        this.note = new ArrayList<>();
    }

    // Metodele pentru a obține informațiile despre student
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

    // Adăugăm o notă în lista de note
    public void adaugaNota(int nota) {
        note.add(nota);
    }

    // Calculăm media notelor
    public float getMedie() {
        int suma = 0;
        for (int nota : note) {
            suma += nota;
        }
        return suma / (float) note.size();
    }

    // Verificăm dacă studentul este integralist (fără note sub 5)
    public boolean esteIntegralist() {
        for (int nota : note) {
            if (nota < 5) {
                return false;
            }
        }
        return true;
    }

    // Metoda pentru a număra restanțele (note sub 5)
    public int getNumarRestante() {
        int numarRestante = 0;
        for (int nota : note) {
            if (nota < 5) {
                numarRestante++;
            }
        }
        return numarRestante;
    }

    // Metodele equals() și hashCode() pentru Map
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return nume.equals(student.nume) && prenume.equals(student.prenume) && grupa.equals(student.grupa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, prenume, grupa);
    }

    // Suprascriem metoda toString() pentru a afisa detalii student
    @Override
    public String toString() {
        return String.format("%s %s (%s)", nume, prenume, grupa);
    }
}
