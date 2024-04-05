package org.iesvdm;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class UtilesArraysTest {

    @Test
    void testLimpiar(){

        // WHEN
        int[] arrayNumerosCeros = new int[5];
        int[] arrayNumerosCualesquiera = {1,7,2,9,34,-21,5690,-564,0};

        // DO
        arrayNumerosCeros = UtilesArrays.limpiar();
        arrayNumerosCualesquiera = UtilesArrays.limpiar();

        // THEN
        assertThat(arrayNumerosCeros).hasSize(0);
        assertThat(arrayNumerosCualesquiera).hasSize(0);

    }

    @Test
    void testRellenarConParamArrayUniDeIntEInt_1_1_ComprobarTamanyoCorrecto(){

        // WHEN
        int tamanyoOriginal = 5;
        int[] arrayNumeros = new int[tamanyoOriginal];

        int tamanyoNuevo = 10;

        // DO
        arrayNumeros = UtilesArrays.rellenar(arrayNumeros,tamanyoNuevo);

        // THEN
        assertThat(arrayNumeros).hasSize(tamanyoNuevo);

    }

    @Test
    void testRellenarConParamArrayUniDeIntEInt_1_2_ComprobarTodosNumerosCeros(){

        // WHEN
        int[] arrayNumeros = new int[5];

        // DO
        arrayNumeros = UtilesArrays.rellenar(arrayNumeros,10);

        // THEN

        // Recorrido del array modificado y
        // Comprobación de que todos sus elementos son 0
        for(int i=0; i<arrayNumeros.length; i++){
            assertThat(arrayNumeros[i]).isEqualTo(0);
        }

    }

    @Test
    void testRellenarConParamArrayUniDeIntEIntEInt_1_1_ComprobarTamanyoCorrecto(){

        // WHEN
        int[] arrayNumeros = {1,7,2,9,34,-21,5690,-564,0};

        // DO & THEN

        // Inserción 10 veces de números aleatorios y
        // Comprobación que el método en cuestión funciona correctamente
        int cantComprob = 10;

        for(int h=0; h<cantComprob; h++){
            int tamanyoNuevo = (int)(Math.random()*100+1);
            int numNuevo = (int)(Math.random()*2001-1000);

            // Llamada al método en cuestión
            arrayNumeros = UtilesArrays.rellenar(arrayNumeros,tamanyoNuevo,numNuevo);

            // Comprobación de que el array modificado tiene el tamanyo correcto
            assertThat(arrayNumeros).hasSize(tamanyoNuevo);
        }

    }

    @Test
    void testRellenarConParamArrayUniDeIntEIntEInt_1_2_ComprobarTodosNumerosIntroducido(){

        // WHEN
        int[] arrayNumeros = {1,7,2,9,34,-21,5690,-564,0};

        // DO & THEN

        // Inserción 10 veces de números aleatorios y
        // Comprobación que el método en cuestión funciona correctamente
        int cantComprob = 10;

        for(int h=0; h<cantComprob; h++){
            int tamanyoNuevo = (int)(Math.random()*100+1);
            int numNuevo = (int)(Math.random()*2001-1000);

            // Llamada al método en cuestión
            arrayNumeros = UtilesArrays.rellenar(arrayNumeros,tamanyoNuevo,numNuevo);

            // Recorrido del array modificado y
            // Comprobación de que todos sus elementos son el numNuevo
            for(int i=0; i<arrayNumeros.length; i++){
                assertThat(arrayNumeros[i]).isEqualTo(numNuevo);
            }
        }

    }

    @Test
    void testInsertarAlFinal_1_1_ComprobarTamanyoAumentadoEn1(){

        // WHEN
        int[] arrayNumeros = new int[0];

        // DO & THEN

        // Inserción 10 veces de números aleatorios y
        // Comprobación que el método en cuestión funciona correctamente
        int cantComprob = 10;
        int tamanyoAnterior = arrayNumeros.length;

        for(int h=0; h<cantComprob; h++){
            int numNuevo = (int)(Math.random()*2001-1000);

            // Llamada al método en cuestión
            arrayNumeros = UtilesArrays.insertarAlFinal(arrayNumeros,numNuevo);

            // Comprobación de que el tamaño nuevo es 1 más que el tamaño anterior
            assertThat(arrayNumeros).hasSize(tamanyoAnterior+1);

            // Actualización del tamanyoAnterior
            tamanyoAnterior = arrayNumeros.length;
        }

    }

    @Test
    void testInsertarAlFinal_1_2_ComprobarNumInsertadoCorrectamente(){

        // WHEN
        int[] arrayNumeros = new int[0];

        // DO & THEN

        // Inserción 10 veces de números aleatorios y
        // Comprobación que el método en cuestión funciona correctamente
        int cantComprob = 10;

        for(int h=0; h<cantComprob; h++){
            int numNuevo = (int)(Math.random()*2001-1000);

            // Llamada al método en cuestión
            arrayNumeros = UtilesArrays.insertarAlFinal(arrayNumeros,numNuevo);

            // Comprobación de que el tamaño nuevo es 1 más que el tamaño anterior
            assertThat(arrayNumeros[arrayNumeros.length-1]).isEqualTo(numNuevo);
        }

    }

    @Test
    void testInsertarAlPrincipio_1_1_ComprobarTamanyoAumentadoEn1(){

        // WHEN
        int[] arrayNumeros = new int[0];

        // DO & THEN

        // Inserción 10 veces de números aleatorios y
        // Comprobación que el método en cuestión funciona correctamente
        int cantComprob = 10;
        int tamanyoAnterior = arrayNumeros.length;

        for(int h=0; h<cantComprob; h++){
            int numNuevo = (int)(Math.random()*2001-1000);

            // Llamada al método en cuestión
            arrayNumeros = UtilesArrays.insertarAlPrincipio(arrayNumeros,numNuevo);

            // Comprobación de que el tamaño nuevo es 1 más que el tamaño anterior
            assertThat(arrayNumeros).hasSize(tamanyoAnterior+1);

            // Actualización del tamanyoAnterior
            tamanyoAnterior = arrayNumeros.length;
        }

    }

    @Test
    void testInsertarAlPrincipio_1_2_ComprobarNumInsertadoCorrectamente(){

        // WHEN
        int[] arrayNumeros = new int[0];

        // DO & THEN

        // Inserción 10 veces de números aleatorios y
        // Comprobación que el método en cuestión funciona correctamente
        int cantComprob = 10;

        for(int h=0; h<cantComprob; h++){
            int numNuevo = (int)(Math.random()*2001-1000);

            // Llamada al método en cuestión
            arrayNumeros = UtilesArrays.insertarAlPrincipio(arrayNumeros,numNuevo);

            // Comprobación de que el tamaño nuevo es 1 más que el tamaño anterior
            assertThat(arrayNumeros[0]).isEqualTo(numNuevo);
        }

    }

    @Test
    void testInsertarEnPosicion(){

        // WHEN
        int[] arrayNumeros = new int[0];

        // DO & THEN

        // Inserción 10 veces de números aleatorios y
        // Comprobación que el método en cuestión funciona correctamente
        int cantComprob = 10;

        for(int h=0; h<cantComprob; h++){
            int tamAleatorio = (int)(Math.random()*100+1);
            int numNuevo = (int)(Math.random()*2001-1000);

            arrayNumeros = new int[tamAleatorio];

            int posAleatoriaDentroLimites = (int)(Math.random()*1+arrayNumeros.length-1);

            // Llamada al método en cuestión
            arrayNumeros = UtilesArrays.insertarEnPosicion(arrayNumeros,numNuevo,posAleatoriaDentroLimites);

            // Comprobación de que el tamaño nuevo es 1 más que el tamaño anterior
            assertThat(arrayNumeros[posAleatoriaDentroLimites]).isEqualTo(numNuevo);
        }

    }

    @Test
    void testInsertarOrdenado(){

        // WHEN

        int[] arrayNumeros = {1,9,12,47,-32,-47,201,-96,471,52,-35,0,74,0,65};

        // Ordenación del array para realizarle la inserción y que se pueda obtener lo esperado
        Arrays.sort(arrayNumeros);

        int numAleatInsertado = (int)(Math.random()*201-100);

        // DO

        arrayNumeros = UtilesArrays.insertarOrdenado(arrayNumeros,numAleatInsertado);

        // THEN

        // Comprobación de que el arrayNum sigue ordenado después de haberle sido insertado
        // el numAleatInsertado
        int numAnterior = 0;

        for(int i=0; i<arrayNumeros.length; i++){
            if(i == 0){
                numAnterior = arrayNumeros[i];
            } else{
                assertThat(arrayNumeros[i]).isGreaterThanOrEqualTo(numAnterior);

                // Actualización del numAnterior
                numAnterior = arrayNumeros[i];
            }
        }

    }

}
