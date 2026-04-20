package practice.multithreading.producer_consumer;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource=new SharedResource();

        Thread producer=new Thread(()-> {

            for(int i=1;i<55;i++){
                sharedResource.produce(i);
            }

        }
        );

        Thread consumer=new Thread(()->{
            for(int i=1;i<55;i++){
                sharedResource.consume();
            }
        });

        producer.start();
        consumer.start();

    }
}
