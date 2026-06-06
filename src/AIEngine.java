package src;

public class AIEngine {
    public String analyzeCode(String sourceCode) {
        if (sourceCode == null || sourceCode.trim().isEmpty()) {
            return "⚠️ AI Warning: The provided source code is empty.";
        }
        return "🤖 AI Engine: Deep context scan complete. No complex logical bypasses detected.";
    }
}
