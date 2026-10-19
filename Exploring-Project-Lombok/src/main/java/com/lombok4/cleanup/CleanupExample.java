package com.lombok4.cleanup;

import lombok.Cleanup;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Component
public class CleanupExample {
    // Reference Link: https://www.javaguides.net/2019/03/project-lombok-automatic-resource-management-using-cleanup.html

    public void example() throws IOException {
        // The sample.txt file is in src/main/resources, so it's read from the classpath.
        // This works no matter which directory the application is started from.
        @Cleanup
        InputStream in = CleanupExample.class.getResourceAsStream("/sample.txt");
        if (in == null) {
            throw new FileNotFoundException("sample.txt not found on the classpath");
        }

        @Cleanup
        BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));

        String currentLine;

        while ((currentLine = br.readLine()) != null) {
            System.out.println(currentLine);
        }
    }
}
