package org.example.exercicio04;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerServiceTest {
    private final CustomerService customerService = new CustomerService();

    @Test
    void testCadastrarCliente_IdadeValida() {
        Customer clienteValido = new Customer(1, "João Silva", "joao.silva@example.com", 18, true);
        assertTrue(customerService.registerCustomer(clienteValido));
    }

    @Test
    void testCadastrarCliente_IdadeInvalida() {
        Customer muitoJovem = new Customer(2, "Jovem Demais", "jovem.demais@example.com", 17, true);
        Customer muitoIdoso = new Customer(3, "Idoso Demais", "idoso.demais@example.com", 100, true);

        assertFalse(customerService.registerCustomer(muitoJovem));
        assertFalse(customerService.registerCustomer(muitoIdoso));
    }

    @Test
    void testAtualizarCliente_Ativo() {
        Customer clienteAtivo = new Customer(4, "Maria Souza", "maria.souza@example.com", 25, true);
        assertTrue(customerService.updateCustomer(clienteAtivo, "Maria Santos", "maria.santos@example.com", 30));
    }

    @Test
    void testAtualizarCliente_Inativo() {
        Customer clienteInativo = new Customer(5, "Carlos Mendes", "carlos.mendes@example.com", 40, false);
        assertFalse(customerService.updateCustomer(clienteInativo, "Carlos Lima", "carlos.lima@example.com", 35));
    }

    @Test
    void testExcluirCliente_Ativo() {
        Customer clienteAtivo = new Customer(6, "Ana Pereira", "ana.pereira@example.com", 30, true);
        assertTrue(customerService.deleteCustomer(clienteAtivo));
    }

    @Test
    void testExcluirCliente_Inativo() {
        Customer clienteInativo = new Customer(7, "Fernando Rocha", "fernando.rocha@example.com", 50, false);
        assertFalse(customerService.deleteCustomer(clienteInativo));
    }

    @Test
    void testCadastrarCliente_EmailValido() {
        Customer clienteEmailValido = new Customer(8, "Pedro Alves", "pedro.alves@example.com", 30, true);
        assertTrue(customerService.registerCustomer(clienteEmailValido));
    }

    @Test
    void testCadastrarCliente_EmailInvalido() {
        Customer semArroba = new Customer(9, "Lucas Oliveira", "lucasoliveira.com", 30, true);
        Customer semDominio = new Customer(10, "Carla Lima", "carla@com", 30, true);

        assertFalse(customerService.registerCustomer(semArroba));
        assertFalse(customerService.registerCustomer(semDominio));
    }

    @Test
    void testCadastrarCliente_Completo() {
        Customer clienteCompleto = new Customer(11, "Beatriz Nunes", "beatriz.nunes@example.com", 25, true);
        assertTrue(customerService.registerCustomer(clienteCompleto));
    }
}
