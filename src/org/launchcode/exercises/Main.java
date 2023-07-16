package org.launchcode.exercises;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        // Test out your Divide() function!
        Divide(10, 2);

        HashMap<String, String> studentFiles = new HashMap<>();
        studentFiles.put("Carl", "Program.java");
        studentFiles.put("Brad", "");
        studentFiles.put("Elizabeth", "MyCode.java");
        studentFiles.put("Stefanie", "CoolProgram.java");

        // Test out your CheckFileExtension() function!
        for (Map.Entry<String, String> entry : studentFiles.entrySet()) {
            String student = entry.getKey();
            String fileName = entry.getValue();
            try {
                int points = CheckFileExtension(fileName);
                System.out.println(student + ": " + points + " points");
            } catch (InvalidFileException ex) {
                System.out.println(student + ": " + ex.getMessage());
            }
        }
    }

    public static void Divide(int x, int y) {
        try {
            int result = x / y;
            System.out.println("Result: " + result);
        } catch (ArithmeticException ex) {
            System.out.println("Error: Division by zero not allowed.");
            System.out.println(ex.getMessage());
        }
    }

    public static int CheckFileExtension(String fileName) throws InvalidFileException {
        if (fileName == null || fileName.isEmpty()) {
            throw new InvalidFileException("Invalid file name: file name cannot be null or empty.");
        }

        if (fileName.endsWith(".java")) {
            return 1;
        } else {
            return 0;
        }
    }

}

class InvalidFileException extends Exception {
    public InvalidFileException(String message) {
        super(message);
    }
}
