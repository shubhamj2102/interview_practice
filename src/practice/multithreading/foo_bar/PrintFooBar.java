package practice.multithreading.foo_bar;

public class PrintFooBar {

    private int count;
    private boolean fooTurn;
    private int counter;

    public PrintFooBar(int count) {
        this.count = count;
        this.counter=1;
        this.fooTurn=true;
    }

    public synchronized void printFoo(){

        while(counter<=count){
            if(fooTurn){
                System.out.println("foo");
                fooTurn=!fooTurn;
                counter++;
                notifyAll();
            }
            else{
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        notifyAll();
    }

    public synchronized void printBar(){
        while(counter<=count){
            if(!fooTurn){
                System.out.println("bar");
                fooTurn=!fooTurn;
                counter++;
                notifyAll();
            }
            else{
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        notifyAll();
    }
}
