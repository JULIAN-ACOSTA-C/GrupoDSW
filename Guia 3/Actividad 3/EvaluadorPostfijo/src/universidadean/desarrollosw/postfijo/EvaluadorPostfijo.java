/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnologías de la Información y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Evaluador de Expresiones Postfijas
 * Fecha: Febrero 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package universidadean.desarrollosw.postfijo;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Esta clase representa una clase que evalúa expresiones en notación polaca o
 * postfija. Por ejemplo: 4 5 +
 */
public class EvaluadorPostfijo {

    /**
     * Realiza la evaluación de la expresión postfijo utilizando una pila
     * @param expresion una lista de elementos con números u operadores
     * @return el resultado de la evaluación de la expresión.
     */
    static int evaluarPostFija(List<String> expresion) {
        Stack<Integer> pila = new Stack<>();
        //Transforma lista en array
        int resultado;
        int num1;
        int num2;
        for (String s : expresion) {
            switch (s) {
                case "+" -> {
                    num1 = pila.peek();
                    pila.pop();
                    num2 = pila.peek();
                    pila.pop();
                    resultado = num2 + num1;
                    pila.push(resultado);
                }
                case "-" -> {
                    num1 = pila.peek();
                    pila.pop();
                    num2 = pila.peek();
                    pila.pop();
                    resultado = num2 - num1;
                    pila.push(resultado);
                }
                case "*" -> {
                    num1 = pila.peek();
                    pila.pop();
                    num2 = pila.peek();
                    pila.pop();
                    resultado = num2 * num1;
                    pila.push(resultado);
                }
                case "/" -> {
                    num1 = pila.peek();
                    pila.pop();
                    num2 = pila.peek();
                    pila.pop();
                    resultado = num2 / num1;
                    pila.push(resultado);
                }
                case "%" -> {
                    num1 = pila.peek();
                    pila.pop();
                    num2 = pila.peek();
                    pila.pop();
                    resultado = num2 % num1;
                    pila.push(resultado);
                }
                case "^" -> {
                    num1 = pila.peek();
                    pila.pop();
                    num2 = pila.peek();
                    pila.pop();
                    resultado = (int) Math.pow(num2,num1);
                    pila.push(resultado);
                }
                default -> pila.push(Integer.valueOf(s));
            }
        }

        return pila.peek();
        // TODO: Realiza la evaluación de la expresión en formato postfijo
    }

    /**
     * Programa principal
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("> ");
        String linea = teclado.nextLine();

        try {
            List<String> expresion = Token.dividir(linea);
            System.out.println(evaluarPostFija(expresion));
        }
        catch (Exception e) {
            System.err.printf("Error grave en la expresión: %s", e.getMessage());
        }

    }
}
