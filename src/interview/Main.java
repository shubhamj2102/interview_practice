package interview;

public class Main  {
    public static void main(String[] args) {

        // How to create object;
        // syntex
        // class_Name obj_name=new class_name();

        Invoice antimaInvoice=new Invoice();

        antimaInvoice.setAmount(1000);
        antimaInvoice.setName("Antima");

        Invoice shubhamInvoice=new Invoice();
        shubhamInvoice.setAmount(200);
        shubhamInvoice.setName("kukkuda");

        Invoice madhuInvoice=new Invoice();
        madhuInvoice.setAmount(300);
        madhuInvoice.setName("cd");

        antimaInvoice.printDetails();
        shubhamInvoice.printDetails();
        madhuInvoice.printDetails();

    }
}
