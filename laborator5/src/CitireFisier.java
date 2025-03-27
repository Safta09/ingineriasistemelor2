import java.io.*;

public class CitireFisier {
    public static void main(String[] args) {
        String inputFile = "in.txt";  // Fișierul de intrare
        String outputFile = "out.txt"; // Fișierul de ieșire

        // Citirea fișierului, procesarea și salvarea în out.txt
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            StringBuilder allText = new StringBuilder();
            String line;

            // Citirea întregului fișier
            while ((line = reader.readLine()) != null) {
                allText.append(line).append(" "); // Împărțim textul pe linii și adăugăm un spațiu între ele
            }

            // Împărțirea textului în propoziții pe baza punctului
            String[] sentences = allText.toString().split("(?<=\\.)"); // Împărțim la fiecare punct, păstrând punctul

            // Scrierea fiecărei propoziții pe o linie separată
            for (String sentence : sentences) {
                writer.write(sentence.trim());  // Îndepărtăm spațiile suplimentare
                writer.newLine();  // Adăugăm un newline după fiecare propoziție
            }

            System.out.println("Modificările au fost salvate în 'out.txt'.");

        } catch (IOException e) {
            System.out.println("Eroare la citirea sau scrierea fișierului: " + e.getMessage());
        }
    }
}
