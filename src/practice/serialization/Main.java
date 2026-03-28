package practice.serialization;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user=new User();
        user.setName("Radhika");
        user.setEmail("radhika@gmail.com");
        Serializer serializer=new Serializer();
        serializer.serialize(user);

        User deserializeObj= serializer.deserialize();

        System.out.println(deserializeObj.getName());
        System.out.println(deserializeObj.getEmail());

    }
}
