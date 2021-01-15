package com.coding.strings.RP;

public class LearningPrimitiveTypes {

    public static void main(String[] args) {

        System.out.println("Primitives Types in Java");
        System.out.println("\nRange of a Byte: " +
                Byte.MIN_VALUE + " to " +
                Byte.MAX_VALUE
        );
        System.out.println("Size of a Byte: " + Byte.SIZE+" bit");
        System.out.println("Byte is of " + Byte.BYTES + " byte");

        System.out.println("\nRange of a Integer: " +
                Integer.MIN_VALUE + " to " +
                Integer.MAX_VALUE
        );
        System.out.println("Size of a Integer: " + Integer.SIZE+" bits");
        System.out.println("Integer is of " + Integer.BYTES + " bytes");

        System.out.println("\nRange of a Float: " +
                Float.MIN_VALUE + " to " +
                Float.MAX_VALUE
        );
        System.out.println("Size of a Float: " + Float.SIZE+" bits");
        System.out.println("Float is of " + Float.BYTES + " bytes");

        System.out.println("\nRange of a Long: " +
                Long.MIN_VALUE + " to " +
                Long.MAX_VALUE
        );
        System.out.println("Size of a Long: " + Long.SIZE+" bits");
        System.out.println("Long is of " + Long.BYTES + " bytes");

        System.out.println("\nRange of a Double: " +
                Double.MIN_VALUE + " to " +
                Double.MAX_VALUE
        );
        System.out.println("Size of a Double: " + Double.SIZE+" bits");
        System.out.println("Double is of " + Double.BYTES + " bytes");

        System.out.println("\nRange of a Short: " +
                Short.MIN_VALUE + " to " +
                Short.MAX_VALUE
        );
        System.out.println("Size of a Short: " + Short.SIZE+" bits");
        System.out.println("Short is of " + Short.BYTES + " bytes");

        System.out.println("\nRange of a Character: " +
                (int) Character.MIN_VALUE + " to " +
                (int) Character.MAX_VALUE
        );
        System.out.println("Size of a Character: "+
                Character.SIZE+" bits"
        );
        System.out.println("Character is of " +
                Character.BYTES + " bytes"
        );

    }
}

