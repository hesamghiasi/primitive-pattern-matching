package org.example;

public class InstanceOf {
    public static void main(String[] args) {
        Object obj = "Hello, World!";
        //old way
        if (obj instanceof String) {
            String str = (String) obj; // Explicit cast required
            System.out.println("Traditional: " + str.toUpperCase());
        }
        // Pattern Matching (Java 16+)
        if (obj instanceof String str) { // Pattern matching with variable binding
            System.out.println("Pattern Matching: " + str.toUpperCase());
        }
    }
}
