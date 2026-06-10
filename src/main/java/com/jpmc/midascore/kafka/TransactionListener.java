package com.jpmc.midascore.kafka;

import com.jpmc.midascore.foundation.Transaction;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionListener {

    private final List<Transaction> receivedTransactions = new ArrayList<>();

    @KafkaListener(
            topics = "${general.kafka-topic}",
            groupId = "midas-core-group"
    )
    public void listen(Transaction transaction) {
        if (receivedTransactions.size() < 4) {
            receivedTransactions.add(transaction);
        }
    }

    public List<Transaction> getReceivedTransactions() {
        return receivedTransactions;
    }
}