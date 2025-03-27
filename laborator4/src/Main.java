
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();

        // Inițializarea listelor
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        List<Integer> xPlusY = new ArrayList<>();
        Set<Integer> zSet = new TreeSet<>();
        List<Integer> xMinusY = new ArrayList<>();
        int p = 4;
        List<Integer> xPlusYLimitedByP = new ArrayList<>();

        // Generarea aleatorie a valorilor pentru listele x și y
        for (int i = 0; i < 5; i++) {
            x.add(rand.nextInt(11)); // [0..10]
        }
        for (int i = 0; i < 7; i++) {
            y.add(rand.nextInt(11)); // [0..10]
        }

        // Ordonarea listelor
        Collections.sort(x);
        Collections.sort(y);

        // a) xPlusY conține toate elementele din x și y
        xPlusY.addAll(x);
        xPlusY.addAll(y);
        Collections.sort(xPlusY);

        // b) zSet conține numai valorile comune din x și y, fără duplicate
        for (int num : x) {
            if (y.contains(num)) {
                zSet.add(num);
            }
        }

        // c) xMinusY conține valorile din x care nu sunt în y
        for (int num : x) {
            if (!y.contains(num)) {
                xMinusY.add(num);
            }
        }

        // d) xPlusYLimitedByP conține elementele din x și y care nu depășesc valoarea p
        for (int num : xPlusY) {
            if (num <= p) {
                xPlusYLimitedByP.add(num);
            }
        }

        // Afișarea rezultatelor
        System.out.println("Lista x: " + x);
        System.out.println("Lista y: " + y);
        System.out.println("Lista xPlusY: " + xPlusY);
        System.out.println("Set zSet (valori comune): " + zSet);
        System.out.println("Lista xMinusY: " + xMinusY);
        System.out.println("Lista xPlusYLimitedByP: " + xPlusYLimitedByP);
    }
}
