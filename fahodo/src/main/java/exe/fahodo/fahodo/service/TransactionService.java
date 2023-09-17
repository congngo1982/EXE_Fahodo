package exe.fahodo.fahodo.service;

import exe.fahodo.fahodo.entity.Transaction;
import exe.fahodo.fahodo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService implements ITransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Override
    public List<Transaction> GetAllTransaction() {
        return transactionRepository.findAll();
    }
}
