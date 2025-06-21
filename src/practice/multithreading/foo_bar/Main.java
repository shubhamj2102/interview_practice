package practice.multithreading.foo_bar;

public class Main {
    public static void main(String[] args) {
        var printFooBar=new PrintFooBar(20);

        var fooThread=new Thread(printFooBar::printFoo);
        var barThread=new Thread(printFooBar::printBar);
        fooThread.start();
        barThread.start();
    }
}
