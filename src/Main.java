package src;

import rules.SecurityRules;
import java.nio.file.NoSuchFileException;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void main(String[] args) {
        System.out.println(ANSI_CYAN + "========================================" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "🛡️  SmartCode-Guard Vulnerability Scanner" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "========================================" + ANSI_RESET);

        String targetFilePath = (args.length > 0) ? args[0] : "tests/VulnerableCode.java";

        try {
            CodeParser parser = new CodeParser();
            AIEngine ai = new AIEngine();
            
            System.out.println("📂 Parsing target file: " + targetFilePath);
            String code = parser.parseFile(targetFilePath);
            
            System.out.println(ANSI_YELLOW + "\n🔍 Running Static Security Rules..." + ANSI_RESET);
            boolean hasPasswordBug = SecurityRules.checkPlaintextPassword(code);
            
            if (hasPasswordBug) {
                System.out.println(ANSI_RED + "❌ [CRITICAL ALERT]: Hardcoded plaintext password found in code!" + ANSI_RESET);
            } else {
                System.out.println(ANSI_GREEN + "✅ Static Rules Passed." + ANSI_RESET);
            }
            
            System.out.println(ANSI_CYAN + "\n🧠 Initializing AI Engine Analysis..." + ANSI_RESET);
            String aiAnalysisResult = ai.analyzeCode(code);
            System.out.println(ANSI_GREEN + aiAnalysisResult + ANSI_RESET);
            
            File reportDir = new File("reports");
            if (!reportDir.exists()) {
                reportDir.mkdir(); 
            }
            
            FileWriter fileWriter = new FileWriter("reports/report.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("=== SmartCode-Guard Security Audit ===");
            printWriter.println("Target File: " + targetFilePath);
            printWriter.println("Static Rule (Password): " + (hasPasswordBug ? "FAILED (Vulnerability Found)" : "PASSED"));
            printWriter.println("AI Engine Result: " + aiAnalysisResult);
            printWriter.close();
            
            System.out.println(ANSI_CYAN + "\n📄 Final report generated successfully at: reports/report.txt" + ANSI_RESET);

        } catch (NoSuchFileException e) {
            System.err.println(ANSI_RED + "❌ Error: File not found at path -> " + new File(targetFilePath).getAbsolutePath() + ANSI_RESET);
        } catch (Exception e) {
            System.err.println(ANSI_RED + "❌ An unexpected error occurred: " + e.getMessage() + ANSI_RESET);
        }
        System.out.println(ANSI_CYAN + "========================================" + ANSI_RESET);
    }
}
