package practice.cutom_annotation.email;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        Request request=new Request();
        request.setEmail("abbbbbb@gmail.com");

        Validator.validate(request);
    }
}
