package com.coding.strings;

public class CodeSignalDataBrix {
    public static void main(String[] args) {
        String out = getOutput("WWDTDTDTWW");
        System.out.println(out);
    }
    
    static String getOutput(String s){
        StringBuilder out = new StringBuilder();
        StringBuilder sb = new StringBuilder(s);
        
        while(sb.length() !=0){
            if(sb.indexOf("W")!=-1){
                sb.replace(sb.indexOf("W"),sb.indexOf("W")+1,"");
                out.append("W");
            }
            if(sb.indexOf("D")!=-1){
                sb.replace(sb.indexOf("D"),sb.indexOf("D")+1,"");
                out.append("D");
            }
            if(sb.indexOf("T")!=-1){
                sb.replace(sb.indexOf("T"),sb.indexOf("T")+1,"");
                out.append("T");
            }
        }
        return out.toString();
    }
    
    
}
