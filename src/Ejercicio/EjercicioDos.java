package Ejercicio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 * Dados n pares de paréntesis, implementa un algoritmo para generar todas las combinaciones
 * válidas de paréntesis.
 *
 * Ejemplo 1:
 *  Input:
 *    n: 1
 *  Output:
 *    ["()"]
 *
 * Ejemplo 2:
 *  Input:
 *    n: 3
 *  Output:
 *    ["((()))","(()())","(())()","()(())","()()()"]
 *
 * Ecoja la mejor estructura de datos para que sea mas eficiente
 * Se debe usar StringBuilder
 */
public class EjercicioDos {

    // Utilizamos HashMap para registrar las combinaciones generadas
    private Map<String, Boolean> map = new HashMap<>();

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisHelper(n, n, new StringBuilder(), result);
        return result;
    }

    private void generateParenthesisHelper(int open, int close, StringBuilder current, List<String> result) {
        // Caso base: si no hay paréntesis para agregar, añadir la combinación actual al result
        if (open == 0 && close == 0) {
            String combination = current.toString();
            // Verificamos si la combinación ya fue generada
            if (!map.containsKey(combination)) {
                map.put(combination, true);
                result.add(combination);
            }
            return;
        }

        // Si quedan paréntesis '(' disponibles, añadir uno y continuar
        if (open > 0) {
            current.append('(');
            generateParenthesisHelper(open - 1, close, current, result);
            // Volver al estado anterior eliminando el último paréntesis añadido
            current.deleteCharAt(current.length() - 1);
        }

        // Si quedan paréntesis ')' disponibles y hay más '(' que ')', añadir uno y continuar
        if (close > open) {
            current.append(')');
            generateParenthesisHelper(open, close - 1, current, result);
            // Volver al estado anterior eliminando el último paréntesis añadido
            current.deleteCharAt(current.length() - 1);
        }
    }
}