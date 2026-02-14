package practice.java_17_feature.other;

public class Feature {


//    public void oldInstanceOfFeature(Object obj){
//        if (obj instanceof String) {
//            String s = (String) obj;
//            System.out.println(s.toLowerCase());
//        }
//    }
    public void newInstanceOfFeature(Object obj){
        if (obj instanceof String s) {
            System.out.println(s.toLowerCase()); // 's' is already cast
        }
    }

    public String switchFeature(Object obj){
        return switch (obj) {
            case Integer i -> "It's an int: " + i;
            case String s  -> "It's a string: " + s;
            case null      -> "It's null!";
            default        -> "Unknown type";
        };
    }

    public void recordFeature(){
        User user=new User("test name",20);

        user.age();
        user.name();

    }


}
