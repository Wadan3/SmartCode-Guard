package rules;

public class SecurityRules {
    public static boolean checkPlaintextPassword(String sourceCode) {
        return sourceCode.contains("System.out.println") && sourceCode.contains("password");
    }
}
