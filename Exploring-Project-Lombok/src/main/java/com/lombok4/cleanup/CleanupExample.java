package com.lombok4.cleanup;

import lombok.Cleanup;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
public class CleanupExample {
    // Reference Link: https://www.javaguides.net/2019/03/project-lombok-automatic-resource-management-using-cleanup.html

    public void example() throws IOException {
        @Cleanup
        FileReader fr = new FileReader("sample.txt");
        // The sample.txt file is in the project root folder.

        @Cleanup
        BufferedReader br = new BufferedReader(fr);

        String currentLine;

        while ((currentLine = br.readLine()) != null) {
            System.out.println(currentLine);
        }
    }
}
