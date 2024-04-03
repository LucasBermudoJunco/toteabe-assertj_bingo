package org.iesvdm;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.Timeout;
//import java.util.concurrent.TimeUnit;
//import java.util.Arrays;

public class BingoTest {

    /**
     * Test que introduce un array bidimensional de 3x9 y coloca blancos (con valor -1)
     * en dicho array
     */
    @Test
    void testPonerBlancos_1_CartonConTamanyoHabitual(){
        // WHEN

        // Creación del array bidimensional

        // Forma de crearlo original (la usada en el programa objeto de la prueba)
        int[] col0 = new int[3];
        int[] col1 = new int[3];
        int[] col2 = new int[3];
        int[] col3 = new int[3];
        int[] col4 = new int[3];
        int[] col5 = new int[3];
        int[] col6 = new int[3];
        int[] col7 = new int[3];
        int[] col8 = new int[3];

        int[][] carton = {col0, col1, col2, col3, col4, col5, col6, col7, col8};

//        // Forma de crearlo más eficiente
//        int[][] carton = new int[9][3];

        // DO
        Bingo.ponerBlancos(carton);

        // THEN

        // Impresión por pantalla del contenido del cartón
        // para comprobar visualmente que funciona correctamente

        // Forma de imprimirlo horizontal (en formato de los cartones de bingo)
        for(int j=0; j<carton[0].length; j++){
            for (int[] fila : carton) {
                System.out.print((fila[j] == 0 ? " 0" : fila[j]) + " ");
            }
            System.out.println();
        }

//        // Forma de imprimirlo más rápida (pero en vertical en vez de
//        // como son los cartones de bingo, que son en horizontal)
//        for(int[] col: carton){
//            System.out.println(Arrays.toString(col));
//        }

        // Tests
        int contBlancos = 0;
        for(int[] col: carton){
            int contCol = 0;
            for(int celda: col){
                if(celda == -1){
                    contCol++;
                    contBlancos++;
                }
            }
            // Comprobación de que no hay más de 2 casillas en blanco por cada columna
            assertThat(contCol).isLessThan(3);
        }
        // Comprobación de que hay 12 casillas en blanco en total en el cartón
        assertThat(contBlancos).isEqualTo(12);
    }

    /**
     * Demostración complementaria en forma de test de que el método ponerBlancos
     * no está diseñado para manejar arrays bidimensionales de tamaños menores a 3x9
     */
    @Test
    void testPonerBlancos_2_1_CartonConTamanyoMenorAlHabitual(){

        // WHEN
        int[][] cartonTamMenor1 = new int[8][2];
        int[][] cartonTamMenor2 = new int[8][2];
        int[][] cartonTamMenor3 = new int[8][2];

        // DO & THEN

        // Comprobación de que el método lanza una Excepción de cualquier tipo
        // cuando se le introduce un array de menor tamaño menor que el tamaño para el cual
        // está preparado

        // Usando el static Assertions de assertj
        assertThatThrownBy(() -> Bingo.ponerBlancos(cartonTamMenor1));

        // Comprobación de que la excepción que el método lanza es una
        // ArrayIndexOutOfBoundsException
        // cuando se le introduce un array de menor tamaño que el tamaño para el cual
        // está preparado

        // Usando el Assertions de junit
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> Bingo.ponerBlancos(cartonTamMenor2));

        boolean seProdujoArrayIndexOutOfBoundsException = false;

        try{
            Bingo.ponerBlancos(cartonTamMenor3);

            System.out.println("No se ha producido ninguna excepción");
        } catch(ArrayIndexOutOfBoundsException excep){
            seProdujoArrayIndexOutOfBoundsException = true;

            System.out.println("Se ha producido una ArrayIndexOutOfBoundsException");
        } catch(Exception excep){
            System.out.println("Se ha producido una excepción distinta a la " +
                    "ArrayIndexOutOfBoundsException");
        }

        assertThat(seProdujoArrayIndexOutOfBoundsException).isTrue();

    }

    /*
     * Test ´´testPonerBlancos_2_2_CartonConTamanyoMayorAlHabitual()`` no terminado
     * de implementar, por no ser el objeto principal del testeo, pero dejado empezado
     */
//    /**
//     * Demostración complementaria en forma de test de que el método ponerBlancos
//     * no está diseñado para manejar arrays bidimensionales de tamaños mayores a 3x9
//     * (ESTE TEST DEBE FALLAR (por lo que, para poder ejecutar la clase entera de los tests,
//     * habrá que convertir en comentario este test o, si no, el resultado de la prueba
//     * de esta clase no será oficialmente completamente exitosa))
//     *
//     */
//    @Test
//    // Establecimiento de un tiempo máximo de 15 segundos para que el test ejecute sus métodos
//    // para así comprobar si se queda colgado demasiado tiempo
//    @Timeout(value = 5, unit = TimeUnit.SECONDS)
//    void testPonerBlancos_2_2_CartonConTamanyoMayorAlHabitual(){
//
//        // WHEN
//        int[][] cartonTamMayor = new int[15][5];
//
//        // DO & THEN
//
//        // Llamamiento al método que sabemos que se va a quedar colgado demasiado tiempo
//        Bingo.ponerBlancos(cartonTamMayor);
//
//    }

}