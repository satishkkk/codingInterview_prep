package com.interviewBitScaler.Lecture5_BinarySearch;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class Test implements I,I1 {
//    public static void main(String[] args) {
//        Hashtable t = new Hashtable();
//        t.put(null,1);
//        Set s = t.keySet();
//        Iterator iter = s.iterator();
//        while( iter.hasNext()){
//            System.out.println( iter.next());
//        }
//    }

//
//    public static void main(String[] args) {
//        Set s = new HashSet();
//        s.add(null);
//        s.add(5);
//        Iterator iter = s.iterator();
//        while( iter.hasNext()){
//            System.out.println( iter.next());
//        }
//    }

//    void check() throws A{
//        System.out.println("check");
//    }
//    public static void main(String[] args) {
//        Test t = new Test();
//        try {
//            t.check();
//        } catch (A a) {
//            a.printStackTrace();
//        }
//    }

//    public static void main(String[] args) {
//        try{
//            return 1;
//        }catch (Exception e){
//            return 2;
//        }finally{
//            return 3;
//        }
//    }
public static void main(String[] args) {
    I1 i1 = new Test();
    i1.show();
}

    @Override
    public void show() {
        System.out.println("show");
    }
}

interface I{
    void show();
}
interface I1{
    void show();
}

//class A extends Exception{
//    A(){
//        super("custom exc");
//    }
//}