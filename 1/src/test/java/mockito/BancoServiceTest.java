package mockito;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class BancoServiceTest {

    ContaRepository repository = mock(ContaRepository.class);

    BancoService bancoService = new BancoService(repository);


    @Test
    public void testConsultarSaldo() {
        // Criando mock do repositório


        // Criando conta simulada
        String numeroConta = "1234-5";
        double saldoConta = 1000;
        Conta conta = new Conta(numeroConta, saldoConta);


        // Definindo comportamento do mock
        when(repository.buscarConta(numeroConta)).thenReturn(conta);


        // Testando consulta de saldo
        double saldoRetornado = bancoService.consultarSaldo(numeroConta);

        // Verificando se o saldo está correto
        assertEquals(saldoConta, saldoRetornado);


        // Verificando se o método buscarConta foi chamado
        verify(repository).buscarConta(numeroConta);
        verifyNoMoreInteractions(repository);
    }


    @Test
    public void testDepositar() {
        // Criando conta simulada
        String numeroConta = "1234-5";
        double saldoConta = 1000;
        Conta conta = new Conta(numeroConta, saldoConta);


        // Definindo comportamento do mock
        when(repository.buscarConta(numeroConta)).thenReturn(conta);

        // Executando depósito
        bancoService.depositar(numeroConta, 500);


        // Verificando se o saldo foi atualizado
        double novoSaldo = saldoConta + 500;
        assertEquals(novoSaldo, conta.getSaldo());


        // Verificando se os métodos foram chamados corretamente
        verify(repository).buscarConta(numeroConta);
        verify(repository).salvar(conta);
        verifyNoMoreInteractions(repository);
    }
}