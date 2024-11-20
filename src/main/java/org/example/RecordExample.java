package org.example;

public record RecordExample(double value) {

    static Object measurement = new RecordExample(123.45);

    public static void main(String[] args) {
        oldApproach();
        newApproach();
    }

    public static void oldApproach() {
        //old way
        if (measurement instanceof RecordExample(double value)) {
            int intValue = (int) value; // Potentially lossy cast
            System.out.println("oldApproach : Value as int: " + intValue);
        } else {
            System.out.println("Not a Measurement object.");
        }
    }

    public static void newApproach() {
        if (measurement instanceof RecordExample(int intValue)) { // Automatic safe narrowing
            System.out.println("newApproach : Value as int: " + intValue);
        } else {
            System.out.println("newApproach : Not a Measurement object or incompatible value.");
        }
    }
}
