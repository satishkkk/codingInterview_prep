package com.company.linkedin.Intern;

public class StringReplacment {


    public static String replace (String orig, String find, String repl){
        if(find.isEmpty()){
            throw  new IllegalArgumentException("string to replace must not be empty");
        }

        if(find.equals(repl)) return orig;

        int found = orig.indexOf(find); // O(N)
        if(found <0) return orig; // didnt found base case

        return orig.substring(0,found) + repl + replace(orig.substring(found+find.length()),find,repl);
    }

    public static void main(String[] args) {
        StringBuilder out = new StringBuilder(replace("FOFOXFOFOX", "FOX", "X"));
        while(out.indexOf("FOX")>=0){
            out = new StringBuilder(replace(out.toString(), "FOX", "X"));
        }
        System.out.println(out.toString());
    }

}
