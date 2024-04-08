package org.iesvdm;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class UtilesArraysTest {

    @Test
    void testLimpiar(){

        // WHEN & DO & THEN

        // Comprobación 10 veces de que el método en cuestión funciona correctamente
        int cantComprob = 10;

        for(int h=0; h<cantComprob; h++){
            int tamAleatorio = (int)(Math.random()*30+1);

            int[] arrayNumerosCeros = new int[tamAleatorio+10];
            int[] arrayNumerosCualesquiera = new int[tamAleatorio];
            for(int i=0; i<arrayNumerosCualesquiera.length; i++){
                arrayNumerosCualesquiera[i] = (int)(Math.random()*201-100);
            }

            // Llamada al método en cuestión
            arrayNumerosCeros = UtilesArrays.limpiar();
            arrayNumerosCualesquiera = UtilesArrays.limpiar();

            // Comprobación de que ambos arrays están vacíos
            assertThat(arrayNumerosCeros).isEmpty();
            assertThat(arrayNumerosCualesquiera).isEmpty();
        }

    }

    @Test
    void testRellenarConParamArrayUniDeIntEInt_1_1_ComprobarTamanyoCorrecto(){

        // WHEN & DO & THEN
        int cantComprob = 10;

        for(int h=0; h<cantComprob; h++) {
            int tamanyoOriginal = (int)(Math.random()*31);
            int[] arrayNumeros = new int[tamanyoOriginal];

            int tamanyoNuevo = (int)(Math.random()*31);

            // Llamada al método en cuestión
            arrayNumeros = UtilesArrays.rellenar(arrayNumeros, tamanyoNuevo);

            // Comprobación de que el método devuelve un array con el tamaño correcto
            assertThat(arrayNumeros).hasSize(tamanyoNuevo);
        }

    }

    @Test
    void testRellenarConParamArrayUniDeIntEInt_1_2_ComprobarTodosNumerosCeros(){

        // WHEN & DO & THEN
        int cantComprob = 10;

        for(int h=0; h<cantComprob; h++) {
            int tamanyoOriginal = (int)(Math.random()*31);
            int[] arrayNumeros = new int[tamanyoOriginal];

            int tamanyoNuevo = (int)(Math.random()*31);

            // Llamada al método en cuestión
            arrayNumeros = UtilesArrays.rellenar(arrayNumeros, tamanyoNuevo);

            // Recorrido del array modificado y
            // Comprobación de que todos sus elementos son 0
            for(int i=0; i<arrayNumeros.length; i++){
                assertThat(arrayNumeros[i]).isEqualTo(0);
            }
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

            int posAleatoriaDentroLimites = (int)(Math.random()*arrayNumeros.length);

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

        // DO & THEN

        // Comprobación 10 veces de que el arrayNum sigue ordenado después de haberle sido insertado
        // el numAleatInsertado
        int cantComprob = 10;
        int numAnterior = 0;

        for(int h=0; h<cantComprob; h++) {
            int numAleatInsertado = (int)(Math.random()*201-100);

            arrayNumeros = UtilesArrays.insertarOrdenado(arrayNumeros,numAleatInsertado);

            for (int i = 0; i < arrayNumeros.length; i++) {
                if (i == 0) {
                    numAnterior = arrayNumeros[i];
                } else {
                    assertThat(arrayNumeros[i]).isGreaterThanOrEqualTo(numAnterior);

                    // Actualización del numAnterior
                    numAnterior = arrayNumeros[i];
                }
            }
        }

    }

    @Test
    void testEliminarUltimo_1_1_ComprobarTamayoDisminuido(){

        // WHEN

        int[] arrayNumerosConElementos = {1,9,12,47,-32,-47,201,-96,471,52,-35,0,74,0,65};
        int[] arrayNumerosConTamanyo0 = new int[0];

        // DO & THEN

        // Comprobación 10 veces de que el tamaño del arrayNumerosConElementos
        // se ha disminuido en 1 y que el tamaño del arrayNumerosConTamanyo0 sigue en 0
        // y que no se ha producido ninguna NegativeArraySizeException
        int cantComprob = 10;

        for(int h=0; h<cantComprob; h++){
            int tamanyoAnteriorlArrayNumerosConElementos = arrayNumerosConElementos.length;
            int tamanyoAnteriorArrayNumerosConTamanyo0 = arrayNumerosConTamanyo0.length;

            arrayNumerosConElementos = UtilesArrays.eliminarUltimo(arrayNumerosConElementos);
            arrayNumerosConTamanyo0 = UtilesArrays.eliminarUltimo(arrayNumerosConTamanyo0);

            assertThat(arrayNumerosConElementos).hasSize(tamanyoAnteriorlArrayNumerosConElementos-1);
            assertThat(arrayNumerosConTamanyo0).hasSize(tamanyoAnteriorArrayNumerosConTamanyo0);
        }

    }

    @Test
    void testEliminarUltimo_1_2_ComprobarRestoElementosIguales(){

        // WHEN

        int[] arrayNumeros = {1,9,12,47,-32,-47,201,-96,471,52,-35,0,74,0,65};

        // DO & THEN

        // Comprobación 10 veces de que al arrayNumerosConElementos le ha sido elminado el último elemento
        // y que el resto del array sigue igual
        int cantComprob = 10;

        for(int h=0; h<cantComprob; h++) {
            int[] arrayDisminuidoAqui;

            if(arrayNumeros.length > 0){
                arrayDisminuidoAqui = Arrays.copyOfRange(arrayNumeros,0,arrayNumeros.length-1);
            } else{
                arrayDisminuidoAqui = new int[0];
            }

            arrayNumeros = UtilesArrays.eliminarUltimo(arrayNumeros);

            assertThat(arrayNumeros).isEqualTo(arrayDisminuidoAqui);
        }

    }

    @Test
    void testEliminarPrimero_1_1_ComprobarTamayoDisminuido(){

        // WHEN

        int[] arrayNumerosConElementos = {1,9,12,47,-32,-47,201,-96,471,52,-35,0,74,0,65};
        int[] arrayNumerosConTamanyo0 = new int[0];

        // DO & THEN

        // Comprobación 10 veces de que el tamaño del arrayNumerosConElementos
        // se ha disminuido en 1 y que el tamaño del arrayNumerosConTamanyo0 sigue en 0
        // y que no se ha producido ninguna NegativeArraySizeException
        int cantComprob = 10;

        for(int h=0; h<cantComprob; h++){
            int tamanyoAnteriorlArrayNumerosConElementos = arrayNumerosConElementos.length;
            int tamanyoAnteriorArrayNumerosConTamanyo0 = arrayNumerosConTamanyo0.length;

            arrayNumerosConElementos = UtilesArrays.eliminarPrimero(arrayNumerosConElementos);
            arrayNumerosConTamanyo0 = UtilesArrays.eliminarPrimero(arrayNumerosConTamanyo0);

            assertThat(arrayNumerosConElementos).hasSize(tamanyoAnteriorlArrayNumerosConElementos-1);
            assertThat(arrayNumerosConTamanyo0).hasSize(tamanyoAnteriorArrayNumerosConTamanyo0);
        }

    }

    @Test
    void testEliminarPrimero_1_2_ComprobarRestoElementosIguales(){

        // WHEN

        int[] arrayNumeros = {1,9,12,47,-32,-47,201,-96,471,52,-35,0,74,0,65};

        // DO & THEN

        // Comprobación 10 veces de que al arrayNumerosConElementos le ha sido elminado el primer elemento
        // y que el resto del array sigue igual
        int cantComprob = 10;

        for(int h=0; h<cantComprob; h++) {
            int[] arrayDisminuidoAqui;

            if(arrayNumeros.length > 0){
                arrayDisminuidoAqui = Arrays.copyOfRange(arrayNumeros,1,arrayNumeros.length);
            } else{
                arrayDisminuidoAqui = new int[0];
            }

            arrayNumeros = UtilesArrays.eliminarPrimero(arrayNumeros);

            assertThat(arrayNumeros).isEqualTo(arrayDisminuidoAqui);
        }

    }

    @Test
    void testEliminarPosicion_1_1_ComprobarTamayoDisminuido(){

        // WHEN

        int[] arrayNumerosConElementos = {1,9,12,47,-32,-47,201,-96,471,52,-35,0,74,0,65};
        int[] arrayNumerosConTamanyo0 = new int[0];

        // DO & THEN

        // Comprobación 10 veces de que el tamaño del arrayNumerosConElementos
        // se ha disminuido en 1 y que el tamaño del arrayNumerosConTamanyo0 sigue en 0
        // y que no se ha producido ninguna NegativeArraySizeException
        int cantComprob = 10;

        for(int h=0; h<cantComprob; h++){
            int tamanyoAnteriorArrayNumerosConElementos = arrayNumerosConElementos.length;
            int tamanyoAnteriorArrayNumerosConTamanyo0 = arrayNumerosConTamanyo0.length;

            int posAleatoriaDentroLimitesOMayor = (int)(Math.random()*tamanyoAnteriorArrayNumerosConElementos*2);

            arrayNumerosConElementos = UtilesArrays.eliminarPosicion(arrayNumerosConElementos,posAleatoriaDentroLimitesOMayor);
            arrayNumerosConTamanyo0 = UtilesArrays.eliminarPosicion(arrayNumerosConTamanyo0,posAleatoriaDentroLimitesOMayor);

            // Comprobación de que el array solo se disminuye de posición si la posición que se quiere eliminar
            // es menor que la longitud del array de números
            if(posAleatoriaDentroLimitesOMayor<tamanyoAnteriorArrayNumerosConElementos) {
                assertThat(arrayNumerosConElementos).hasSize(tamanyoAnteriorArrayNumerosConElementos - 1);
            } else{
                assertThat(arrayNumerosConElementos).hasSize(tamanyoAnteriorArrayNumerosConElementos);
            }
            assertThat(arrayNumerosConTamanyo0).hasSize(tamanyoAnteriorArrayNumerosConTamanyo0);
        }

    }

    @Test
    void testEliminarPosicion_1_2_ComprobarRestoElementosIguales(){

        // WHEN

        int[] arrayNumeros = {1,9,12,47,-32,-47,201,-96,471,52,-35,0,74,0,65};

        // DO & THEN

        // Comprobación 10 veces de que al arrayNumerosConElementos le ha sido elminado el primer elemento
        // y que el resto del array sigue igual
        int cantComprob = 10;

        for(int h=0; h<cantComprob; h++) {
            int[] arrayDisminuidoAqui;

            if(arrayNumeros.length > 0){
                arrayDisminuidoAqui = Arrays.copyOfRange(arrayNumeros,1,arrayNumeros.length);
            } else{
                arrayDisminuidoAqui = new int[0];
            }

            arrayNumeros = UtilesArrays.eliminarPrimero(arrayNumeros);

            assertThat(arrayNumeros).isEqualTo(arrayDisminuidoAqui);
        }

    }

    @Test
    void testEliminarPosicion_2_ComprobarLanzamientoExcepcionConPosNegativa(){

        // WHEN

        final int[] arrayNumerosConElementos = {1, 9, 12, 47, -32, -47, 201, -96, 471, 52, -35, 0, 74, 0, 65};
        int[] arrayNumerosConTamanyo0 = new int[0];
        int[] arrayCopiaNumerosConTamanyo0 = arrayNumerosConTamanyo0.clone();

        // DO & THEN

        // Comprobación 10 veces de que el tamaño del arrayNumerosConElementos
        // se ha disminuido en 1 y que el tamaño del arrayNumerosConTamanyo0 sigue en 0
        // y que no se ha producido ninguna NegativeArraySizeException
        int cantComprob = 10;

        for(int h=0; h<cantComprob; h++){
            int posAleatoriaMenorQue0 = (int)(Math.random()*30-60);

            Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,() -> UtilesArrays.eliminarPosicion(arrayNumerosConElementos,posAleatoriaMenorQue0));
            assertThat(UtilesArrays.eliminarPosicion(arrayNumerosConTamanyo0,posAleatoriaMenorQue0)).isEqualTo(arrayCopiaNumerosConTamanyo0);
        }

    }

    @Test
    void testEliminar_1_1_ComprobarTamayoDisminuido(){

        // WHEN

        int[] arrayNumeros = {1,9,12,47,-32,-47,201,-96,471,52,-35,0,74,0,65};

        // DO & THEN

        // Comprobación 10 veces de que el tamaño del arrayNumerosConElementos
        // se ha disminuido en 1 y que el tamaño del arrayNumerosConTamanyo0 sigue en 0
        // y que no se ha producido ninguna NegativeArraySizeException
        int cantComprob = 10;

        for(int h=0; h<cantComprob; h++) {
            if(arrayNumeros.length>0){
                int numAleatorio = (int)(Math.random()*101-50);
                int tamanyoAnterior = arrayNumeros.length;

                int cantVecesPresente = 0;
                // Búsqueda de cuántas veces el numAleatorio está presente en el arrayNumeros
                for(int i=0; i<arrayNumeros.length; i++){
                    if(numAleatorio == arrayNumeros[i]){
                        cantVecesPresente++;
                    }
                }

                // Llamada al método en cuestión
                arrayNumeros = UtilesArrays.eliminar(arrayNumeros,numAleatorio);

                // Comprobación de que el tamaño nuevo corresponde al esperado
                assertThat(arrayNumeros).hasSize(tamanyoAnterior-cantVecesPresente);
            }
        }

    }

    @Test
    void testEliminar_1_2_ComprobarFuncionamientoCorrecto(){

        // WHEN

        int[] arrayNumeros = {1,9,12,47,-32,-47,6,-23,31,50,-35,0,14,0,-15};

        // DO & THEN

        // Comprobación 10 veces de que
        //      · al arrayNumerosConElementos le ha sido elminado el elemento deseado y que el resto del array
        //          sigue igual en caso de que el elemento deseado estuviese en el array
        //      · de que el array sigue igual en caso de que el elemento deseado no estuviese en el array
        int cantComprob = 10;

        for(int h=0; h<cantComprob; h++) {
            int numAleatorio = (int)(Math.random()*101-50);
            int[] arrayCopia = arrayNumeros.clone();

            // Llamada al método en cuestión
            arrayNumeros = UtilesArrays.eliminar(arrayNumeros,numAleatorio);

            // Comprobación de que el método ha funcionado correctamente

            // Comprobación de que el elemento se ha eliminado correctamente
            assertThat(numAleatorio).isNotIn(arrayNumeros);

            // Recorrido del array sin modificar y
            // Comprobación de que el resto de elementos siguen iguales
            int correctorIndice = 0;

            for(int i=0; i<arrayCopia.length; i++){
                if(arrayCopia[i] == numAleatorio){
                    correctorIndice++;
                }

                if(arrayCopia[i] != numAleatorio){
                    assertThat(arrayCopia[i]).isEqualTo(arrayNumeros[i-correctorIndice]);
                }
            }
        }

    }

    @Test
    void testOrdenar(){

        // WHEN & DO & THEN

        // Comprobación 10 veces de que el método funciona correctamente
        int cantComprob = 10;

        for(int h=0; h<cantComprob; h++) {
            // Creación de un array de números aleatorios
            int tamAleat = (int)(Math.random()*31);
            int[] arrayNumeros = new int[tamAleat];
            for(int i=0; i<arrayNumeros.length; i++){
                arrayNumeros[i] = (int)(Math.random()*2001-1000);
            }

            // Llamada al método en cuestión
            arrayNumeros = UtilesArrays.ordenar(arrayNumeros);

            // Comprobación de que el método ha funcionado correctamente
            boolean estaOrdenadoAsc = true;
            for(int i=0;i<arrayNumeros.length && estaOrdenadoAsc; i++){
                if(i>0){
                    if(arrayNumeros[i]<arrayNumeros[i-1]){
                        estaOrdenadoAsc = false;
                    }
                }
            }

            assertThat(estaOrdenadoAsc).isTrue();
        }

    }

    @Test
    void testDesordenar(){

        // WHEN & DO & THEN

        // Comprobación 1000 veces de que el método desordena un array
        // y visualización del porcentaje de veces que se ha desordenado
        // (ya que, según el código del método en cuestión, es posible que el array
        // siga quedando ordenado de la misma forma que estaba antes de aplicarle el método)
        int cantComprob = 1000;
        int vecesDesordenado = 0;

        for(int h=0; h<cantComprob; h++){
            // Creación de un array de longitud alteaoria entre 30 y 60 (ambos incluidos)
            int[] arrayNumeros = new int[(int)(Math.random()*31+30)];

            // Asignación al arrayNumeros de números aleatorios entre -200 y +200 (ambos incluidos)
            for(int i=0; i<arrayNumeros.length; i++){
                arrayNumeros[i] = (int)(Math.random()*401-200);
            }

            // Copia del arrayNumeros para compararlo con el arrayNumeros desordenado
            int[] arrayCopia = arrayNumeros.clone();

            // Llamada al método en cuestión
            UtilesArrays.desordenar(arrayNumeros);

            // Comprobación de que el arrayNumeros no coincida con su orden previo a la desordenación
            if(!Arrays.equals(arrayNumeros,arrayCopia)){
                vecesDesordenado++;
            }
        }

        // Comprobación de que el porcenaje de desordenación sea muy alto
        int porcentajeDesord = (vecesDesordenado/cantComprob) * 100;

        assertThat(porcentajeDesord).isGreaterThanOrEqualTo(95);
    }

    @Test
    void testInvertir(){

        // WHEN & DO & THEN

        // Comprobación 100 veces de que el método en cuestión invierte correctamente
        // un array de números aleatorios
        int cantComprob = 100;

        for(int h=0; h<cantComprob; h++){
            // Creación de un array de longitud alteaoria entre 30 y 60 (ambos incluidos)
            int[] arrayNumeros = new int[(int)(Math.random()*31+30)];

            // Asignación al arrayNumeros de números aleatorios entre -200 y +200 (ambos incluidos)
            for(int i=0; i<arrayNumeros.length; i++){
                arrayNumeros[i] = (int)(Math.random()*401-200);
            }

            // Copia del arrayNumeros para compararlo con el arrayNumeros invertido
            int[] arrayCopia = arrayNumeros.clone();

            // Llamada al método en cuestión
            arrayNumeros = UtilesArrays.invertir(arrayNumeros);


            // Comprobación de que el arrayNumeros sea el inverso a su orden previo a la desordenación
            for(int i=0; i<arrayNumeros.length; i++){
                assertThat(arrayNumeros[i]).isEqualTo(arrayCopia[arrayCopia.length-1-i]);
            }
        }

    }

//    @Test
//    void testImprimir(){
//
//        // WHEN & DO & THEN
//
//        // Comprobación 100 veces de que el método en cuestión funciona correctamente
//        int cantComprob = 1;
//
//        for(int h=0; h<cantComprob; h++){
//            // Creación de un array de longitud alteaoria entre 30 y 60 (ambos incluidos)
//            int[] arrayNumeros = new int[(int)(Math.random()*31+30)];
//
//            // Asignación al arrayNumeros de números aleatorios entre -200 y +200 (ambos incluidos)
//            for(int i=0; i<arrayNumeros.length; i++){
//                arrayNumeros[i] = (int)(Math.random()*401-200);
//            }
//
//            // Almacenamiento en un String del resultado de la impresión del método
//            String texto = "\t[";
//
//            for(int i=0; i<arrayNumeros.length; i++){
//                texto += arrayNumeros[i];
//
//                if(i<arrayNumeros.length-1){
//                    texto += ", ";
//                }
//            }
//
//            texto += "]";
//
//            // Llamada al método en cuestión y
//            // Comprobación de que el método funciona correctamente
//
//
//            // Redirección de la salida estándar a un ByteArrayOutputStream
//            ByteArrayOutputStream contenidoDelOutput = new ByteArrayOutputStream();
//            System.setOut(new PrintStream(contenidoDelOutput));
//
//            // Ejecutar el método que imprime en la consola
//            UtilesArrays.imprimir(arrayNumeros);
//
//            // Asegurarse de que la salida sea la esperada
//            assertThat(contenidoDelOutput).isEqualTo(texto);
//
//        }
//
//    }

    @Test
    void testEstaOrdenado(){

        // WHEN & DO & THEN

        // Comprobación 100 veces de que el método en cuestión funciona correctamente
        int cantComprob = 100;

        for(int h=0; h<cantComprob; h++){
            // Creación de un array de longitud alteaoria entre 30 y 60 (ambos incluidos)
            int[] arrayNumeros = new int[(int)(Math.random()*31+30)];

            // Asignación al arrayNumeros de números aleatorios entre -200 y +200 (ambos incluidos)
            for(int i=0; i<arrayNumeros.length; i++){
                arrayNumeros[i] = (int)(Math.random()*401-200);
            }

            // Averiguación de si el arrayNumeros ha sido creado de forma ordenada o no
            boolean estaOrdenado = true;
            for(int i=0; i<arrayNumeros.length-1 && estaOrdenado; i++){
                if(!(arrayNumeros[i] <= arrayNumeros[i+1])){
                    estaOrdenado = false;
                }
            }

            // Llamada al método en cuestión y
            // Comprobación de que el método funciona correctamente
            if(estaOrdenado){
                assertThat(UtilesArrays.estaOrdenado(arrayNumeros)).isTrue();
            } else{
                assertThat(UtilesArrays.estaOrdenado(arrayNumeros)).isFalse();

                // Ordenación del array
                Arrays.sort(arrayNumeros);

                // Llamada al método en cuestión
                assertThat(UtilesArrays.estaOrdenado(arrayNumeros)).isTrue();
            }
        }

    }

    @Test
    void testBuscar_1_1_NumerosPresentes(){

        // WHEN & DO & THEN

        // Comprobación 100 veces de que el método en cuestión funciona correctamente
        int cantComprob = 100;

        for(int h=0; h<cantComprob; h++){
            // Creación de un array de longitud aleatoria entre 30 y 60 (ambos incluidos)
            int[] arrayNumeros = new int[(int)(Math.random()*31+30)];

            // Asignación al arrayNumeros de números aleatorios entre -20 y +20 (ambos incluidos)
            for(int i=0; i<arrayNumeros.length; i++){
                arrayNumeros[i] = (int)(Math.random()*41-20);
            }

            // Recorrimiento del arrayNumeros para saber qué posición es la primera posición
            // en la que aparece cada número
            ArrayList<ArrayList<Integer>> numerosPresentesConSuIndice = new ArrayList<>();
            ArrayList<Integer> numerosPresentes = new ArrayList<Integer>();
            ArrayList<Integer> numeroEIndice = new ArrayList<Integer>();

            for(int i=0; i<arrayNumeros.length; i++){
                // Añadido a los numerosPresentes de los números de la lista
                // en caso de que sea la primera vez que salen
                // para saber si ha salido ya o no
                if(!numerosPresentes.contains(arrayNumeros[i])){
                    // añadido del nuevo número a los numerosPresentes
                    numerosPresentes.add(arrayNumeros[i]);

                    // Añadido del número y de su posición a los numeroEIndice
                    numeroEIndice.add(arrayNumeros[i]);
                    numeroEIndice.add(i);

                    // Añadido del número con su índice a los numerosPresentesConSuIndice
                    numerosPresentesConSuIndice.add(numeroEIndice);

                    // Limpieza de los numeroEIndice
                    numeroEIndice.clear();
                }

            }

            // Recorrimiento del arrayNumeros y
            // Comprobación de que el método en cuestión devuelve la posición de la primera ocurrencia
            // de cada número ó -1 en caso de que no esté
            for(int i=0; i<arrayNumeros.length; i++){
                // Recorrimiento de la lista de los números e índices
                Iterator<ArrayList<Integer>> iter1 = numerosPresentesConSuIndice.iterator();

                while(iter1.hasNext()){
                    ArrayList<Integer> sublista = iter1.next();

                    // Recorrimiento de la sublist de cada número e índice
                    Iterator<Integer> iter2 = sublista.iterator();

                    while(iter2.hasNext()){
                        Integer numeroActual = iter2.next();

                        // Comprobación de que el método en cuestión devuelve la primera posición
                        // en la que se encuentra el número en la lista, que coincide con la posición
                        // en la que se encuentra en la lista de numerosPresentesConSuIndice
                        if(arrayNumeros[i] == numeroActual) {
                            Integer indiceActual = iter2.next();

                            assertThat(UtilesArrays.buscar(arrayNumeros,arrayNumeros[i])).isEqualTo(indiceActual);
                        }
                    }
                }

            }
        }

    }

    @Test
    void testBuscar_1_2_NumerosNoPresentes(){

        // WHEN & DO & THEN

        // Comprobación 100 veces de que el método en cuestión funciona correctamente
        int cantComprob = 100;

        for(int h=0; h<cantComprob; h++){
            // Creación de un array de longitud aleatoria entre 30 y 60 (ambos incluidos)
            int[] arrayNumeros = new int[(int)(Math.random()*31+30)];

            // Asignación al arrayNumeros de números aleatorios entre -20 y +20 (ambos incluidos)
            for(int i=0; i<arrayNumeros.length; i++){
                arrayNumeros[i] = (int)(Math.random()*41-20);
            }

            // Creación de una lista de números para buscar dentro del arrayNumeros
            ArrayList<Integer> listaNumerosParaBuscar = new ArrayList<>();
            int longitudLista = 60;
            for(int f=0; f<longitudLista; f++){
                listaNumerosParaBuscar.add((int)(Math.random()*201-100));
            }

            // Recorrimiento de la listaNumerosParaBuscar
            Iterator<Integer> iteradorNumeros = listaNumerosParaBuscar.iterator();

            while(iteradorNumeros.hasNext()){
                Integer numeroActual = iteradorNumeros.next();

                // Búsqueda de cada número de la listaNumerosParaBuscar dentro del arrayNumeros
                boolean estaEnLaLista = false;

                for(int i=0; i<arrayNumeros.length && !estaEnLaLista; i++){
                    if(numeroActual == arrayNumeros[i]){
                        estaEnLaLista = true;
                    }
                }

                // Comprobación de que el método en cuestión devuelve -1 si el númeroActual
                // no se encuentra en el arrayNumeros
                if(!estaEnLaLista){
                    assertThat(UtilesArrays.buscar(arrayNumeros,numeroActual)).isEqualTo(-1);
                }
            }
        }

    }

    @Test
    void testPartirPor_1_ConPosicionesCorrectas(){

        // WHEN & DO & THEN

        int cantComprob = 10000;

        for(int h=0; h<cantComprob; h++){
            int[] arrayNumeros = new int[(int)(Math.random()*61+30)];
            for(int i=0; i<arrayNumeros.length; i++){
                arrayNumeros[i] = (int)(Math.random()*201-100);
            }

            int posInicialDentroLimites = (int)(Math.random()*arrayNumeros.length);
            int posCorteDentroLimites = (int)(Math.random()*arrayNumeros.length);

            if(posInicialDentroLimites<posCorteDentroLimites){
                // Creación aquí de un array desde el rango indicado
                int[] arrayPartido = Arrays.copyOfRange(arrayNumeros,posInicialDentroLimites,posCorteDentroLimites);

                // Llamada al método en cuestión
                arrayNumeros = UtilesArrays.partirPor(arrayNumeros,posInicialDentroLimites,posCorteDentroLimites);

                // Comprobación de que el array ha sido partido bien
                assertThat(arrayNumeros).isEqualTo(arrayPartido);
            } else{
                // Creación de un array copia igual que el original
                int[] arrayCopia = Arrays.copyOf(arrayNumeros,arrayNumeros.length);

                // Llamada al método en cuestión
                arrayNumeros = UtilesArrays.partirPor(arrayNumeros,posInicialDentroLimites,posCorteDentroLimites);

                // Comprobación de que el método en cuestión no modifica el array si se introducen
                // valores incorrectos
                assertThat(arrayNumeros).isEqualTo(arrayCopia);
            }

        }

    }

    @Test
    void testPartirPor_2_ConPosicionesIncorrectas(){

        // WHEN & DO & THEN

        int cantComprob = 1000;

        for(int h=0; h<cantComprob; h++){
            int[] arrayNumeros = new int[(int)(Math.random()*61+30)];
            for(int i=0; i<arrayNumeros.length; i++){
                arrayNumeros[i] = (int)(Math.random()*201-100);
            }

            int posInicialDentroOFueraLimites = (int)(Math.random()*arrayNumeros.length*2+(1-arrayNumeros.length));
            int posCorteDentroOFueraLimites = (int)(Math.random()*arrayNumeros.length*2+(1-arrayNumeros.length));

            // Comprobación de que el método en cuestión no modifica el array si se introducen
            // valores más grandes del tamaño del array
            if(posInicialDentroOFueraLimites >= arrayNumeros.length || posCorteDentroOFueraLimites >= arrayNumeros.length){
                // Creación de un array copia igual que el original
                int[] arrayCopia = Arrays.copyOf(arrayNumeros,arrayNumeros.length);

                // Llamada al método en cuestión
                arrayNumeros = UtilesArrays.partirPor(arrayNumeros,posInicialDentroOFueraLimites,posCorteDentroOFueraLimites);

                // Comprobación de que el método en cuestión no modifica el array si se introducen
                // valores más grandes del tamaño del array
                assertThat(arrayNumeros).isEqualTo(arrayCopia);
            }

        }

    }

    @Test
    void testSonIguales_1_FuncionamientoCorrecto(){

        // WHEN & DO & THEN

        int cantComprob = 1000;

        for(int h=0; h<cantComprob; h++){
            // Creación de varios arrays de números
            int[] arrayNumeros1 = new int[(int)(Math.random()*61+30)];
            for(int i=0; i<arrayNumeros1.length; i++){
                arrayNumeros1[i] = (int)(Math.random()*201-100);
            }

            int[] arrayNumeros2 = new int[(int)(Math.random()*61+30)];
            for(int i=0; i<arrayNumeros2.length; i++){
                arrayNumeros2[i] = (int)(Math.random()*201-100);
            }

            // Comprobación de si los arrays tienen el mismo tamaño
            if(arrayNumeros1.length == arrayNumeros2.length) {
                // Comprobación de si ambos arrays son iguales o no
                boolean sonIguales = true;
                for (int i = 0; i < arrayNumeros1.length && sonIguales; i++) {
                    if (arrayNumeros1[i] != arrayNumeros2[i]) {
                        sonIguales = false;
                    }
                }

                // Llamada al método en cuestión si los arrays tienen longitud distinta y
                // Comprobación de que el método en cuestión devuelve true
                if(!sonIguales){
                    assertThat(UtilesArrays.sonIguales(arrayNumeros1,arrayNumeros2)).isFalse();
                }
            } else{
                assertThat(UtilesArrays.sonIguales(arrayNumeros1, arrayNumeros2)).isFalse();
            }
        }

    }

    @Test
    void testSonIguales_2_FuncionamientoIncorrecto(){

        // WHEN & DO & THEN

        int cantComprob = 1000;

        for(int h=0; h<cantComprob; h++){
            // Creación de varios arrays de números
            int[] arrayNumeros1 = new int[(int)(Math.random()*61+30)];
            for(int i=0; i<arrayNumeros1.length; i++){
                arrayNumeros1[i] = (int)(Math.random()*201-100);
            }

            int[] arrayNumeros2 = new int[(int)(Math.random()*61+30)];
            for(int i=0; i<arrayNumeros2.length; i++){
                arrayNumeros2[i] = (int)(Math.random()*201-100);
            }

            int[] arrayCopiadel1 = arrayNumeros1.clone();

            if(arrayNumeros1.length == arrayNumeros2.length){
                // Comprobación de si ambos arrays son iguales o no
                boolean sonIguales = true;
                for (int i = 0; i < arrayNumeros1.length && sonIguales; i++) {
                    if (arrayNumeros1[i] != arrayNumeros2[i]) {
                        sonIguales = false;
                    }
                }

                // Llamada al método en cuestión si los arrays son iguales y
                // Comprobación de que el método no controla el lanzamiento
                // de ArrayIndexOutOfBoundsException cuando los arrays son iguales
                if(sonIguales){
                    Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                            () -> UtilesArrays.sonIguales(arrayNumeros1,arrayNumeros2));
                }
            }

            Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                    () -> UtilesArrays.sonIguales(arrayNumeros1,arrayCopiadel1));

        }

    }

    @Test
    void testElementosIguales_1_FuncionamientoCorrecto(){

        // WHEN & DO & THEN

        int cantComprob = 1000;

        for(int h=0; h<cantComprob; h++){
            // Creación de varios arrays de números
            int[] arrayNumeros1 = new int[(int)(Math.random()*61+30)];
            for(int i=0; i<arrayNumeros1.length; i++){
                arrayNumeros1[i] = (int)(Math.random()*201-100);
            }

            // arrayNumeros2 con el mismo tamaño que arrayNumeros1
            int[] arrayNumeros2 = new int[arrayNumeros1.length];
            for(int i=0; i<arrayNumeros2.length; i++){
                arrayNumeros2[i] = (int)(Math.random()*201-100);
            }

            int[] arrayCopiadel1 = arrayNumeros1.clone();

            for(int i=0; i<arrayNumeros1.length; i++){
                if(arrayNumeros1[i] == arrayNumeros2[i]){
                    assertThat(UtilesArrays.elementosIguales(arrayNumeros1,arrayNumeros2,i)).isTrue();
                    // Comprobación de que el método en cuestión devuelve false si se comparan 2 números distintos
                } else{
                    assertThat(UtilesArrays.elementosIguales(arrayNumeros1,arrayNumeros2,i)).isFalse();
                }

                // Comprobación de que el método en cuestión devuelve true si se comparan 2 números iguales
                assertThat(UtilesArrays.elementosIguales(arrayNumeros1,arrayCopiadel1,i)).isTrue();
            }

        }

    }

    @Test
    void testElementosIguales_2_FuncionamientoIncorrecto(){

        // WHEN & DO & THEN

        int cantComprob = 1000;

        for(int h=0; h<cantComprob; h++){
            // Creación de varios arrays de números
            int[] arrayNumeros1 = new int[(int)(Math.random()*61+30)];
            for(int i=0; i<arrayNumeros1.length; i++){
                arrayNumeros1[i] = (int)(Math.random()*201-100);
            }

            // arrayNumeros2 con el mismo tamaño que arrayNumeros1
            int[] arrayNumeros2 = new int[arrayNumeros1.length];
            for(int i=0; i<arrayNumeros2.length; i++){
                arrayNumeros2[i] = (int)(Math.random()*201-100);
            }

            int[] arrayCopiadel1 = arrayNumeros1.clone();

            int posFueraDeLimites = 0;

            do{
                posFueraDeLimites = (int)(Math.random()*201-100);
            } while(posFueraDeLimites >= 0 && posFueraDeLimites < arrayNumeros1.length);

            // Comprobación de que el método lanza excepciones siempre que se introduce un índice fuera
            // de límites
            int finalPosFueraDeLimites = posFueraDeLimites;
            Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                    ()-> UtilesArrays.elementosIguales(arrayNumeros1,arrayNumeros2, finalPosFueraDeLimites));

            Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                    ()-> UtilesArrays.elementosIguales(arrayNumeros1,arrayCopiadel1, finalPosFueraDeLimites));

        }

    }

    @Test
    void testConcatenarArrays(){

        // WHEN & DO & THEN

        int cantComprob = 1000;

        for(int h=0; h<cantComprob; h++){
            // Creación de varios arrays de números
            int[] arrayNumeros1 = new int[(int)(Math.random()*61+30)];
            for(int i=0; i<arrayNumeros1.length; i++){
                arrayNumeros1[i] = (int)(Math.random()*201-100);
            }

            int[] arrayNumeros2 = new int[(int)(Math.random()*61+30)];
            for(int i=0; i<arrayNumeros2.length; i++){
                arrayNumeros2[i] = (int)(Math.random()*201-100);
            }

            int[] arrayCopiadel1 = arrayNumeros1.clone();

            // Llamada al método en cuestión y
            // Comprobación de que funciona correctamente

            // Primera concatenación
            int[] arrayConcat = UtilesArrays.concatenarArrays(arrayNumeros1,arrayNumeros2);

            int indiceArrayConcat= 0;

            for(int i=0; i<arrayNumeros1.length; i++){
                assertThat(arrayConcat[indiceArrayConcat]).isEqualTo(arrayNumeros1[i]);

                indiceArrayConcat++;
            }

            for(int i=0; i<arrayNumeros2.length; i++){
                assertThat(arrayConcat[indiceArrayConcat]).isEqualTo(arrayNumeros2[i]);

                indiceArrayConcat++;
            }

            // Segunda concatenación
            int[] arrayConcatCopiaPrevia = arrayConcat.clone();

            arrayConcat = UtilesArrays.concatenarArrays(arrayConcat,arrayCopiadel1);

            indiceArrayConcat = 0;

            for(int i=0; i<arrayConcatCopiaPrevia.length; i++){
                assertThat(arrayConcat[indiceArrayConcat]).isEqualTo(arrayConcatCopiaPrevia[i]);

                indiceArrayConcat++;
            }

            for(int i=0; i<arrayCopiadel1.length; i++){
                assertThat(arrayConcat[indiceArrayConcat]).isEqualTo(arrayCopiadel1[i]);

                indiceArrayConcat++;
            }

        }

    }

}
