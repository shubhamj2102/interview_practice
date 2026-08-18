package practice.stream;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Solution sol=new Solution();
        var cls =Solution.class;
        var methods=cls.getDeclaredMethods();
        System.out.println("Enter method name");
        Scanner sc=new Scanner(System.in);
        String inputMethodName=sc.next();

        for(var method:methods){
            if (method.getParameterCount() == 0 && method.getReturnType() == void.class && inputMethodName.equals(method.getName())) {// ← this line is required for private methods
                System.out.println("Method name- "+method.getName());
                System.out.println("solution-");
                method.invoke(sol);   // use `null` if method is static, or an object if non-static
            }
        }
    }
}


