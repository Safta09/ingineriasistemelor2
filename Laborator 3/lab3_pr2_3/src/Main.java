public class Main {
    public static void main(String[] args) {
        // Accesăm metoda getInstance de câteva ori
        PasswordMaker p1 = PasswordMaker.getInstance("John");
        PasswordMaker p2 = PasswordMaker.getInstance("Jane");

        // Verificăm numărul de accesări
        System.out.println("getInstance was called " + PasswordMaker.getAccessCount() + " times.");

        // Generăm parole
        System.out.println("Password 1: " + p1.getPassword());
        System.out.println("Password 2: " + p2.getPassword());
    }
}
