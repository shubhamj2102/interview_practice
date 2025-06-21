package practice.multithreading.odd_even;

public class PrintNumbers {

    public int limit;
    public int currNum;

    public PrintNumbers(int limit) {
       this.limit=limit;
       this.currNum=1;
    }

    public synchronized void printEven(){
        while(currNum<=limit){
            if(currNum%2==0){
                System.out.println(currNum);
                currNum++;
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
        //notifyAll();
    }

    public synchronized void printOdd(){
        while(currNum<=limit){
            if(currNum%2!=0){
                System.out.println(currNum);
                currNum++;
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

        //notifyAll();
    }
}
