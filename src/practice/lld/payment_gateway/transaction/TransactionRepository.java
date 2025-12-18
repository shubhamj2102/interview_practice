package practice.lld.payment_gateway.transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TransactionRepository {

    private final List<Transaction> transactionList;

    public TransactionRepository() {
        this.transactionList = new ArrayList<>();
    }

    public void save(Transaction transaction){
        transactionList.add(transaction);
    }

    public Transaction findById(UUID transactionId){
        return transactionList.stream().filter(txn -> transactionId.equals(txn.getTransactionId())).findFirst().orElseThrow();
    }
}
