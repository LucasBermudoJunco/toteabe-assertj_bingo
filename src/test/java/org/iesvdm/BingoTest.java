package org.iesvdm;


import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BingoTest {

    @Test
    void test1(){
        int numero = 1;
        boolean valor = true;

        assertThat(numero == 1).isTrue();
        assertThat(valor).isTrue();
    }

    @Test
    void testPonerBlancos(){
        // WHEN

        // Forma de crearlo original
        int[] col0 = new int[3];
        int[] col1 = new int[3];
        int[] col2 = new int[3];
        int[] col3 = new int[3];
        int[] col4 = new int[3];
        int[] col5 = new int[3];
        int[] col6 = new int[3];
        int[] col7 = new int[3];
        int[] col8 = new int[3];

        int[][] cartonOriginal = {col0, col1, col2, col3, col4, col5, col6, col7, col8};

        // Forma de crearlo más eficiente
        int[][] cartonNoOriginal = new int[9][3];

        // DO
        Bingo.ponerBlancos(cartonOriginal);

//        for(int[] col: cartonOriginal){
//            System.out.println(Arrays.toString(col));
//        }

        // Impresión por pantalla del contenido del cartón
        for(int j=0; j<cartonOriginal[0].length; j++){
            for(int i=0; i<cartonOriginal.length; i++){
                System.out.println((cartonOriginal[i][j] == 0 ? "0" : cartonOriginal[i][j]) + " ");
            }
            System.out.println();
        }

        // THEN
        int contBlancos = 0;
        for(int[] col: cartonOriginal){
            int contCol = 0;
            for(int celda: col){
                if(celda == -1){
                    contCol++;
                } else if(celda == 0){
                    contBlancos++;
                }
            }

            assertThat(contCol).isLessThan(3);
            assertThat(contBlancos == 12).isTrue();
        }
    }

}