package org.example.z2;

public class GenericDAO {
    DbLogger dbLogger;
    TransactionService transactionService;

    public GenericDAO(DbLogger dbLogger, TransactionService transactionService) {
        this.dbLogger = dbLogger;
        this.transactionService = transactionService;
    }

    void save(Session session) throws SessionOpenException {
        session.open();
        Transaction transaction = transactionService.createTransaction();
        transaction.start();
        transaction.perform();
        try {
            transaction.commitTransaction();
        } catch (CommitException e) {
            dbLogger.log(e);
            transaction.rollback();
        }
        transaction.end();
        session.close();
    }


}
