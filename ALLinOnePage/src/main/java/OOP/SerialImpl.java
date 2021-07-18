package OOP;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerialImpl {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        String filname = "emp.ser";
//        serialize(filname);
        deserialize(filname);
        
    }

    private static void deserialize(String filname) throws IOException, ClassNotFoundException {
        File file = new File(filname);
        FileInputStream inputStream = new FileInputStream(file);
        
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        
        SerialClass class1  = (SerialClass) objectInputStream.readObject();
        
        System.out.println(class1);
    }

    private static void serialize(String filname) throws IOException {
       
        File file = new File(filname);
        
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        
        SerialClass class1 = new SerialClass();
        class1.setFname("neeljain");
        class1.setName("neeljain");

        objectOutputStream.writeObject(class1);
        
        objectOutputStream.flush();
        objectOutputStream.close();
    }
}






















