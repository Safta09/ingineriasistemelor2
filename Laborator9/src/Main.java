import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // Cerința 9.3.2
    //-------------------------------------------------------------
        List<Integer> originalList = Arrays.asList(9, 10, 3, 4, 7, 3, 4);

        List<Integer> distinctList = originalList.stream()
                .distinct()
                .collect(Collectors.toList());

        List<Integer> squaredList = distinctList.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());

        System.out.println("Lista 1 " + originalList);
        System.out.println("Lista cu elemente distincte: " + distinctList);
        System.out.println("Lista cu pătratele valorilor distincte: " + squaredList);


        // Cerința 9.3.3 – Lucru cu text
        //-----------------------------------------------------------
        String sentence = "Acesta este un program scris cu java 8 si expresii lambda";

        // a) Split în cuvinte și filtrare pe lungime >= 5
        List<String> words = Arrays.asList(sentence.split(" "));
        List<String> longWords = words.stream()
                .filter(word -> word.length() >= 5)
                .collect(Collectors.toList());

        System.out.println("\nCuvinte cu lungime >= 5: " + longWords);
        System.out.println("Număr de cuvinte: " + longWords.size());

        // b) Ordonăm lista
        List<String> sortedLongWords = longWords.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Lista ordonată: " + sortedLongWords);

        // c) Afișăm un cuvânt care începe cu 'p'
        Optional<String> wordStartingWithP = words.stream()
                .filter(w -> w.startsWith("p"))
                .findFirst();

        if (wordStartingWithP.isPresent()) {
            System.out.println("Un cuvânt care începe cu 'p': " + wordStartingWithP.get());
        } else {
            System.out.println("Nu există cuvinte care încep cu 'p'.");
        }


        // Codul original - opțional
        // ---------------------------------------------
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            numbers.add(random.nextInt(21) + 5);
        }

        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        int max = numbers.stream().mapToInt(Integer::intValue).max().orElse(0);
        int min = numbers.stream().mapToInt(Integer::intValue).min().orElse(0);

        System.out.println("\nLista generată aleator:");
        numbers.forEach(System.out::println);
        System.out.println("Maxim: " + max);
        System.out.println("Minim: " + min);
        System.out.println("Suma: " + sum);

        List<Integer> filteredList = numbers.stream()
                .filter(n -> n >= 10 && n <= 20)
                .collect(Collectors.toList());



        System.out.println("\nLista cu elemente în intervalul [10..20]:");
        filteredList.forEach(System.out::println);

        List<Double> doubleList = numbers.stream()
                .map(n -> (double) n)
                .collect(Collectors.toList());

        System.out.println("\nLista în format Double:");
        doubleList.forEach(System.out::println);

        boolean contains12 = numbers.stream().anyMatch(n -> n == 12);
        System.out.println("\nLista conține valoarea 12: " + contains12);
    }
}
