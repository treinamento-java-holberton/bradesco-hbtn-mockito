package mockito;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;


public class CalculadoraTest {

    ServicoMatematico servicoMatematico = mock(ServicoMatematico.class);

    Calculadora calculadora = new Calculadora(servicoMatematico);

    @Test
    void test_soma() {
        when(servicoMatematico.somar(2, 3)).thenReturn(5);

        int resultado = calculadora.somar(2, 3);
        assertEquals(5, resultado);
        verify(servicoMatematico).somar(2, 3);
        verifyNoMoreInteractions(servicoMatematico);
    }

}