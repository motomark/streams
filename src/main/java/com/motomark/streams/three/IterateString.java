package com.motomark.streams.three;

public class IterateString {

    // Chapter 3 upto page 44.
    public void iterateString() {
        final String str = "w00t";
        str.chars().forEach(ch -> System.out.println(ch));
        System.out.println("Using method reference");
        str.chars().forEach(System.out::println);
        str.chars().forEach(IterateString::printChar);
        System.out.println("Using mapToObj");
        str.chars().mapToObj(ch -> Character.valueOf((char) ch)).forEach(System.out::println);
        System.out.println("Using filer on digit");
        str.chars().filter(ch -> Character.isDigit(ch)).forEach(ch -> printChar(ch));
        System.out.println("Using filer on digit with method references");
        str.chars().filter(Character::isDigit).forEach(IterateString::printChar);

    }

    // convenience to cast top a char. We can reference this method using method
    // reference approach. See page 25.
    private static void printChar(int aChar) {
        System.out.println((char) aChar);
    }

}
