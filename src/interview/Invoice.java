package interview;

public class Invoice {

    public int amount;
    public String name;
    public String date;

    public int getAmount(){
        return amount;
    }
    public void setAmount(int amount){
        amount=amount+6;
        this.amount=amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printDetails() {
        System.out.println("pretty girl= " + name);
        System.out.println("pretty girl has spent="+amount);
    }
}
