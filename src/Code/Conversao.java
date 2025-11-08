package Code;

import java.util.Stack;

public class Conversao {
    public static void main(String[] args) {

        imprimeResultado(2);
        imprimeResultado(4);
        imprimeResultado(10);
        imprimeResultado(25);
        imprimeResultado(10035);
        imprimeResultadoQualquerBase(90, 16);
        imprimeResultadoQualquerBase(100, 17);

    }

    public static void imprimeResultado(int numero) {
        System.out.println(numero + " em binario: " + decimalBinario(numero));
    }

    public static void imprimeResultadoQualquerBase(int numero, int base) {
        System.out.println(numero + " na base " + base + ": " + decimalQualquerBase(numero, base));
    }

    public static String decimalBinario(int numero) {

        Stack<Integer> stack = new Stack<>();
        String numBinario = "";
        int resto;

        while (numero > 0) {
            resto = numero % 2;
            stack.push(resto);
            numero /= 2;
        }

        while (!stack.isEmpty()) {
            numBinario += stack.pop();
        }

        return numBinario;
    }

    public static String decimalQualquerBase(int numero, int base) {

        if (base > 16) {
            System.out.println("Sua base deve ser menor que 16");
        }

        Stack<Integer> stack = new Stack<>();
        String numBase = "";
        int resto;
        String bases = "0123456789ABCDEF";
        while (numero > 0) {
            resto = numero % base;
            stack.push(resto);
            numero /= base;
        }

        while (!stack.isEmpty()) {
            numBase += bases.charAt(stack.pop());
        }

        return numBase;
    }

}
