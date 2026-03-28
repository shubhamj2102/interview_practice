package practice.serialization;

import java.io.*;

public class Serializer {

    private static final String FILE_PATH = "/Users/shubhamjain/documents/user_serialize1";

    public void serialize(User obj) throws IOException {
        File file=new File(FILE_PATH);
        FileOutputStream fileOutputStream=new FileOutputStream(file);
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(obj);
    }

    public User deserialize() throws IOException, ClassNotFoundException {
        File file=new File(FILE_PATH);
        FileInputStream fileInputStream=new FileInputStream(file);
        ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
        return (User) objectInputStream.readObject();
    }

}
