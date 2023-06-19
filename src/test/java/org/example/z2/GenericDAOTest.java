package org.example.z2;

import org.example.z2.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GenericDAOTest {

    @Mock
    Transaction transaction;
    @Mock
    TransactionService transactionService;
    @Mock
    DbLogger dbLogger;
    @Mock
    Session session;
    @InjectMocks
    GenericDAO genericDAO;
    @Captor
    private ArgumentCaptor<Exception> argumentCaptor;

    @Test
    void throwExceptionWhenSessionCannotBeOpened() {
        doThrow(SessionOpenException.class).when(session).open();
        assertThrows(SessionOpenException.class, () ->
                genericDAO.save(session));
    }

    @Test
    void throwExceptionWhenTransactionCannotBeCommitted() {
        doThrow(CommitException.class).when(transaction).commitTransaction();
        when(transactionService.createTransaction()).thenReturn(transaction);

        genericDAO.save(new Session());
        verify(dbLogger).log(argumentCaptor.capture());

        assertEquals(argumentCaptor.getValue().getClass(), CommitException.class);
    }

    @Test
    void shouldSaveWhenSessionCanBeOpenedAndTransactionCanBeCommitted() {
        when(transactionService.createTransaction()).thenReturn(transaction);

        genericDAO.save(new Session());
    }

}