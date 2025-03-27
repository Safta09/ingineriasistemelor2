import java.util.Random; // Importul corect al clasei Random

public class PasswordMaker {
    private static PasswordMaker instance;
    private static final int MAGIC_NUMBER = 6; // Poate fi orice valoare între 5 și 10
    private final String magicString;
    private String name;
    private StringRandomizer stringRandomizer;

    // Contor static pentru a număra accesările la getInstance()
    private static int accessCount = 0;

    // Constructorul privat pentru a preveni instanțierea din afacerea clasei
    private PasswordMaker(String name) {
        this.name = name;
        this.stringRandomizer = new StringRandomizer();
        this.magicString = stringRandomizer.generateRandomString(20 + new Random().nextInt(11)); // Folosim Random aici
    }

    // Bloc static pentru inițializarea instanței
    static {
        instance = null;
    }

    // Metoda statică getInstance care va returna instanța unică
    public static PasswordMaker getInstance(String name) {
        accessCount++; // Incrementăm contorul de accesări
        if (instance == null) {
            instance = new PasswordMaker(name); // Creăm instanța doar dacă nu există deja
        }
        return instance;
    }

    // Metoda pentru a obține contorul de accesări
    public static int getAccessCount() {
        return accessCount;
    }

    // Metoda care generează și returnează parola
    public String getPassword() {
        String randomString = stringRandomizer.generateRandomString(MAGIC_NUMBER);
        StringBuilder magicSubString = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int index = new Random().nextInt(magicString.length());
            magicSubString.append(magicString.charAt(index));
        }
        String nameLength = String.valueOf(name.length());
        int randomNumber = new Random().nextInt(51);
        return randomString + magicSubString.toString() + nameLength + randomNumber;
    }
}
