package com.PatkarSir_core.serializationAndCloning.ObjectGraph;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LearningSerialization1 {
    public static void main(String[] args) throws Exception {

        FileOutputStream fos = new FileOutputStream("D:\\output.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        C12 obj12 = new C12(99, 88);
        C11 obj11 = new C11(10, 20, obj12);
        System.out.println(obj11);
        oos.writeObject(obj12);
        System.out.println("successfully written the object in the file");
        System.out.println("attempting the deserialize the object....");
        FileInputStream fis = new FileInputStream("D:\\output.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        C11 obj3 = (C11) ois.readObject();
        System.out.println("reading compelete .. ");
        System.out.println("printing the deserialized object");
        System.out.println(obj3);
    }
}
