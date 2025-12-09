
package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Twosums {
 
    //Para este approach, recorremos con 2 fors anidados, uno siempre que parte 1 dígito adelante, y comparamos el primero con el resto 
    // el segundo con los de adelante y así sucesivamente hasta que encontramos 2 numeros que sumen el target, la complejidad es O (n^2)

    int [] resultado;

    public int [] twoSum (int [] nums, int target){

        int [] resultado;

        for (int i = 0 ; i < nums.length ; i++){
            for (int j = i+1 ; i< nums.length ; i++){
                if (nums [i] + nums [j] == target){
                    resultado = new int [] {i,j};
                    return resultado;
                }
            }
        }
        return nums;
    }

    //Para optimizarlo usamos HashMaps O(n), sin embargo ocupa más espacio, la llave sera el complemento de cada número de nums (donde nos encontramos en el recorrido del for ) y 
    // el valor el índice de ese número al cual se le calculó su complemento 
    
   public int [] twoSum2 (int [] nums, int target){

    Map < Integer, Integer > complementos = new HashMap<>();

    for (int i = 0; i < nums.length; i++){
        //¿nums[i] está guardado como llave (complemento de algún numero) en el mapa?
        //Es una pregunta porque el get devuelve el valor si la llave existe, sino no 
        Integer indiceDelComplemento = complementos.get (nums[i]);
        //Si existe obtenemos nuestro resultado, el cual es, donde nos encontramos y el indice del complemento en el hashmap 
        //nos preguntamos ¿el mapa tenía un valor para esta llave?
        if (indiceDelComplemento != null){
            return new int [] {i, indiceDelComplemento}; 
        }
        //Sino existe lo agregamos, (complemento) que utilizariamos después  e indice 
        complementos.put(target - nums [i], i );
        
    }
    return nums; 
   }

   

}
