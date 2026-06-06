package rules;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SecurityRules {
    private static final Pattern HARDCODED_PASSWORD_PATTERN = Pattern.compile("(?i)(password|pwd|pass)\\s*=\\s*[\"'][^\"']+[\"']");
    
    public static boolean checkPlaintextPassword(String sourceCode) {
        Matcher matcher = HARDCODED_PASSWORD_PATTERN.matcher(sourceCode);
        return matcher.find();
    }
}
