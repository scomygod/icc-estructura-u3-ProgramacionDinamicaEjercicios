package Ejercicio;

import java.util.ArrayList;
import java.util.List;
/*
 * Implementa un método para devolver todos los subconjuntos de un arreglo de enteros
 * 
 * Se puede sin recursividad
 * Ejemplo:
 *  Input: [1,2,3]
 *
 *  Output:
 *    [
 *      [1,2,3],
 *      [1,2],
 *      [1,3],
 *      [2,3],
 *      [1],
 *      [2],
 *      [3],
 *      []
 *    ]
 * 
 * El  metodo me debe devolver una lista de listas de enteros. 
 * Se puede usar varios metodos 
 * 
 * Escoja la mejor estructura de datos para que sea mas eficiente
 */

public class EjercicioUno {
    public List<List<Integer>> subsets(List<Integer> set){
        List <List<Integer>> subsets = new ArrayList<List<Integer>>();
        subsets.add(new ArrayList<Integer>());

        for (Integer element : set){
            addSetByElement (element, subsets);
        }
        return subsets;
    }

    private void addSetByElement(Integer element, List<List<Integer>> subsets) {

        int currentSize = subsets.size();
        for (int i = 0; i < currentSize; i++){
            List<Integer> newSubset = new ArrayList<Integer>(subsets.get(i));
            newSubset.add(element);
            subsets.add(newSubset);
        }
    }

    

    // public List<List<Integer>> subsets(List<Integer> set) {
    //     List<List<Integer>> result = new ArrayList<>();
    //     int n = set.size(); // Número de elementos del conjunto
    //     int totalSubsets = 1 << n; // Número total de subconjuntos 2^n
        
    //     // Genera todos los subconjuntos
    //     for (int i = 0; i < totalSubsets; i++) {
    //         List<Integer> subset = new ArrayList<>(); // Lista para subconjunto actual
    //         // Iterar sobre cada bit
    //         for (int j = 0; j < n; j++) {
    //             // Si la posición j es '1'
    //             if ((i & (1 << j)) != 0) {
    //                 subset.add(set.get(j)); // Añade el elemento al subconjunto
    //             }
    //         }
    //         result.add(subset); // Añade el subset al result
    //     }
    //     return result;
    // }
    
}