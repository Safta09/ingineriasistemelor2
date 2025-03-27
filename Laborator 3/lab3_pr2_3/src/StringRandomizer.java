import java.util.Random;

public class StringRandomizer {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private Random random;

    // Constructorul clasei
    public StringRandomizer() {
        random = new Random();
    }

    // Metoda pentru a genera un string aleatoriu de o lungime specificată
    public String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(ALPHABET.length());
            sb.append(ALPHABET.charAt(index));
        }
        return sb.toString();
    }
}
