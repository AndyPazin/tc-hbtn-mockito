package mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import mockito.Calculadora;
import mockito.ServicoMatematico;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {

    @Test
    public void testSomar() {
        // Criando um mock do ServicoMatematico
        ServicoMatematico servicoMock = Mockito.mock(ServicoMatematico.class);

        // Definindo comportamento esperado do mock
        Mockito.when(servicoMock.somar(2, 3)).thenReturn(5);

        // Criando a Calculadora com o mock
        Calculadora calculadora = new Calculadora(servicoMock);

        // Executando o teste
        int resultado = calculadora.somar(2, 3);

        // Verificando se o resultado está correto
        assertEquals(5, resultado);

        // Verificando se o método somar foi chamado corretamente
        Mockito.verify(servicoMock).somar(2, 3);
    }
}