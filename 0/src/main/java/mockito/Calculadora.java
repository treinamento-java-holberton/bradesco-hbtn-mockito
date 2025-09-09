package mockito;

public class Calculadora {
    private final ServicoMatematico calc;

    public Calculadora(ServicoMatematico calc) {
        this.calc = calc;
    }

    public int somar(int a, int b) {
        return calc.somar(a, b);
    }
}