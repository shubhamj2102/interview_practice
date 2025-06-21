package practice.multithreading.odd_even;

public class main {
    public static void main(String[] args) {

        PrintNumbers pn=new PrintNumbers(100);

        var evenTh=new Thread(pn::printEven);
        var oddTh=new Thread(pn::printOdd);
        evenTh.start();
        oddTh.start();
    }
}
