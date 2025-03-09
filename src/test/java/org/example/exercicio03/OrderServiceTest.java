package org.example.exercicio03;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


class OrderServiceTest {

    private OrderService orderService;

    @Mock
    private PaymentProcessor paymentProcessor;

    // Inicializando os Mocks para teste.
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        orderService = new OrderService(paymentProcessor);
    }

    @Test
    void testProcessOrder_PaymentApproved() {
        // Configurar o mock para retornar true (pagamento aprovado)
        when(paymentProcessor.processPayment(100.0)).thenReturn(true);

        // Chamar o método sob teste
        boolean result = orderService.processOrder(100.0);

        // Verificar se o resultado é o esperado
        assertTrue(result);

        // Verificar se o método do mock foi chamado corretamente
        verify(paymentProcessor).processPayment(100.0);
    }

    @Test
    void testProcessOrder_PaymentDeclined() {
        // Configurar o mock para retornar false (pagamento recusado)
        when(paymentProcessor.processPayment(50.0)).thenReturn(false);

        // sob teste
        boolean result = orderService.processOrder(50.0);

        // Verificar se o resultado é o esperado
        assertFalse(result);

        // Verificar se o método do mock foi chamado corretamente
        verify(paymentProcessor).processPayment(50.0);

    }

}