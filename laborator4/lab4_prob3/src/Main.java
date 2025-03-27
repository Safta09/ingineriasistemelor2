import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Student, Integer> students = readInputFile("input.txt");

        // Afișăm studenții și numărul lor de apariții
        for (Map.Entry<Student, Integer> entry : students.entrySet()) {
            System.out.println(entry.getKey() + " - Apariții: " + entry.getValue());
        }
    }

    // Metoda care citește datele dintr-un fișier și le adaugă într-un Map
    public static Map<Student, Integer> readInputFile(String fileName) {
        Map<Student, Integer> students = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length < 3) {
                    System.out.println("Linie invalidă: " + line);
                    continue;
                }

                String nume = parts[0];
                String prenume = parts[1];
                String grupa = parts[2];

                Student student = new Student(nume, prenume, grupa);

                // Adăugăm notele
                for (int i = 3; i < parts.length; i++) {
                    try {
                        int nota = Integer.parseInt(parts[i]);
                        student.adaugaNota(nota);
                    } catch (NumberFormatException e) {
                        System.out.println("Eroare la conversia notei: " + parts[i]);
                    }
                }

                // Incrementăm aparițiile studentului în Map
                students.put(student, students.getOrDefault(student, 0) + 1);
            }
        } catch (IOException e) {
            System.out.println("Eroare la citirea fișierului: " + e.getMessage());
        }

        return students;
    }
}
