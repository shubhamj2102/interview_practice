package practice.design_patterns;

import java.io.Serial;
import java.io.Serializable;

public class SingletonClass implements Serializable {

    private static SingletonClass object;
    private SingletonClass() {

    }

    public static SingletonClass getObject(){
        if(object==null){
            synchronized (SingletonClass.class){
                if(object==null){
                   object=new SingletonClass();
                }
            }
        }
        return object;
    }

    @Serial
    protected Object readResolve(){
        return object;
    }
}
