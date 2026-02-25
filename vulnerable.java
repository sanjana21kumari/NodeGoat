public class VulnerableExample {

    public static void main(String[] args) {

        String username = args.length > 0 ? args[0] : "guest";

        System.out.println("Hello, " + username);

        // Example vulnerable code (Command Injection risk)
        try {
            Runtime.getRuntime().exec("echo Welcome " + username);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getUserInput(String input) {
        return input;
    }
}
