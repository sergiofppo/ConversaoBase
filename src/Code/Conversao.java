package Code;

import java.util.Scanner;
import java.util.Stack;

public class Conversao {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("Digite um numero decimal para converter (ou 'sair' para terminar): ");
            String inputNumero = scan.next();

            if (inputNumero.equalsIgnoreCase("sair")) {
                break;
            }

            int numero;
            try {
                numero = Integer.parseInt(inputNumero);
            } catch (NumberFormatException e) {
                System.out.println("entrada invalida. Tente novamente.");
                continue;
            }

            System.out.println("Digite a base para a conversao: ");
            int base = scan.nextInt();

            imprimeResultadoQualquerBase(numero, base);
        }

        System.out.println("Programa terminado.");
        scan.close();

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
            System.out.println("Sua base tem que ser menor que 16");
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