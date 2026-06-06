package tests;

public class VulnerableCode {
    public void login() {
        String password = "superSecretPassword123";
        System.out.println("Login attempt with password: " + password);
    }
}
