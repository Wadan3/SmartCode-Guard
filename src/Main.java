import src.CodeParser;
import src.AIEngine;
import rules.SecurityRules;

public class Main {
    public static void main(String[] args) {
        try {
            CodeParser parser = new CodeParser();
            AIEngine ai = new AIEngine();
            String code = parser.parseFile("tests/VulnerableCode.java");
            if (SecurityRules.checkPlaintextPassword(code)) {
                System.out.println("ALERT: Manual Rule Violation! Plaintext password found in code.");
            }
            System.out.println(ai.analyzeCode(code));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
