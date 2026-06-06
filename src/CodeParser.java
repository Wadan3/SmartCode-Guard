package src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CodeParser {
    public String parseFile(String filePath) throws IOException {   
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
}
