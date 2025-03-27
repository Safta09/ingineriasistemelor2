import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Creăm o listă de studenți
        List<Student> studenti = new ArrayList<>();

        // Adăugăm studenți în listă
        studenti.add(new Student("Popescu", "Ion", "A1"));
        studenti.add(new Student("Ionescu", "Maria", "B2"));
        studenti.add(new Student("Vasile", "George", "A1"));
        studenti.add(new Student("Stoica", "Andrei", "B2"));
        studenti.add(new Student("Dobre", "Elena", "A1"));
        studenti.add(new Student("Mihai", "Cristian", "A1"));

        // Afișarea studenților în ordinea alfabetică, pe grupe
        System.out.println("Studenți ordonați alfabetically pe grupe:");
        studenti.stream()
                .sorted(Comparator.comparing(Student::getGrupa)
                        .thenComparing(Student::getNume)
                        .thenComparing(Student::getPrenume))
                .forEach(System.out::println);

        // b2) Afișarea studenților în ordinea descrescătoare a mediilor (pentru integraliști)
        System.out.println("\n Studenți ordonați descrescător după media notelor (pentru integraliști):");
        studenti.stream()
                .filter(Student::esteIntegralist)
                .sorted(Comparator.comparing(Student::getMedie).reversed())
                .forEach(System.out::println);

        // b3) Afișarea studenților în ordinea crescătoare a numărului de restanțe (pentru restanțieri)
        System.out.println("\n Studenți ordonați crescător după numărul de restanțe:");
        studenti.stream()
                .sorted(Comparator.comparingInt(Student::getNumarRestante))
                .forEach(System.out::println);
    }
}
