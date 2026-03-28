package practice.cutom_annotation.email;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class Validator {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    public static void validate(Object obj) throws IllegalAccessException {
       var declaredFields= obj.getClass().getDeclaredFields();

       for(Field field: declaredFields){
           if(field.isAnnotationPresent(Email.class)){
               field.setAccessible(true);
               var value=field.get(obj);
              var fieldAnnotation= field.getAnnotation(Email.class);

              if(value==null || !EMAIL_PATTERN.matcher(value.toString()).matches()){
                  throw new RuntimeException(
                          field.getName() + ": " + fieldAnnotation.message());
              }
           }
       }
    }
}
