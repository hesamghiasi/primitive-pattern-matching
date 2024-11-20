package org.example;

public record SwitchExample(double value) {

    static Object obj = new SwitchExample(123.45);

    public static void main(String[] args) {
        oldApproach();
        newApproach();
    }

    public static void oldApproach() {
        // Old "switch" case with manual checks
        if (obj instanceof SwitchExample) {
            SwitchExample measurement = (SwitchExample) obj; // Manual cast required
            double value = measurement.value();
            int intValue = (int) value; // Manual cast, potentially lossy
            System.out.println("oldApproach : Measurement value as int: " + intValue);
        } else {
            System.out.println("oldApproach : Not a Measurement object.");
        }
    }

    public static void newApproach() {
        switch (obj) { // no need for instanceof
            case SwitchExample(int intValue) -> // Pattern matches safely-convertible values
                    System.out.println("newApproach : Measurement value as int: " + intValue);
            case SwitchExample(double value) -> // Handles non-convertible values
                    System.out.println("newApproach : Measurement value as double: " + value);
            default -> System.out.println("newApproach : Not a Measurement object.");
        }
    }

    public void sample(Object value) {
//             Before pattern matching
//             if (value instanceof Integer) {
//                Integer i = (Integer) value; // Manual cast needed
//                System.out.println("It's an Integer: " + i);
//            }
        switch (value) {

            // Pattern matching with primitive types
            case int i -> System.out.println("Value is : " + i);

            // Pattern matching with reference types
            case Double d -> System.out.println("Double value: " + d);
            case String s -> System.out.println("String value: " + s);
            case Float f -> System.out.println("Float value: " + f);
            default -> throw new IllegalStateException("Unexpected value: " + value);
        }
    }
}
