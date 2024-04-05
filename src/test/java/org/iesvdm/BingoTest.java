package org.iesvdm;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
//import org.junit.jupiter.api.Timeout;
//import java.util.concurrent.TimeUnit;
//import java.util.Arrays;

public class BingoTest {

    @Test
    void testRellenarNumerosCarton_1_TamayoHabitual(){

        //  WHEN

        // Creación de array según la forma de crearlo original
        // (la usada en el programa objeto de la prueba)
        int[] col0 = new int[3];
        int[] col1 = new int[3];
        int[] col2 = new int[3];
        int[] col3 = new int[3];
        int[] col4 = new int[3];
        int[] col5 = new int[3];
        int[] col6 = new int[3];
        int[] col7 = new int[3];
        int[] col8 = new int[3];

        int[][] cartonHabitual = {col0, col1, col2, col3, col4, col5, col6, col7, col8};

//        // Forma de crearlo más eficiente
//        int[][] cartonHabitual = new int[9][3];

        // DO

        // Llamada al método en cuestión
        Bingo.rellenarNumerosCarton(cartonHabitual);

        // THEN

        System.out.println("\n---------- TEST ´´testRellenarNumerosCarton_1_TamayoHabitual`` ----------\n");

        // Recorrido del cartón y
        // Comprobación de que todos los valores son los adecuados

        for(int j=0; j<cartonHabitual[0].length; j++){
            for (int[] fila : cartonHabitual) {
                System.out.print(fila[j] + " ");
            }
            System.out.println();
        }

        int numAnterior = 0;
        for(int i=0; i<cartonHabitual.length; i++){
            for(int j=0; j<cartonHabitual[0].length; j++){
                // Comprobación de que los números de la fila están ordenados ascendentemente
                // y que no se repiten
                assertThat(cartonHabitual[i][j]).isGreaterThan(numAnterior);

                // Comprobación de que todos los números de cada fila están dentro de su decena
                assertThat(cartonHabitual[i][j]).isBetween(i*10,i*10+9);

                // Actualización del ´´numAnterior``
                numAnterior = cartonHabitual[i][j];
            }
        }


    }

    @Test
    void testRellenarNumerosCarton_2_1_TamayoMenorAlHabitual(){

        //  WHEN

        // Establecimiento del tamaño del cartón
        int cantFilasMenor = 7;
        int cantColumnasMenor = 2;

        // Establecimiento del cartón
        int[][] cartonMenor = new int[cantFilasMenor][cantColumnasMenor];

        // DO

        // Llamada al método en cuestión
        Bingo.rellenarNumerosCarton(cartonMenor);

        // THEN

        System.out.println("\n---------- TEST ´´testRellenarNumerosCarton_2_1_TamayoMenorAlHabitual`` ----------\n");

        // Recorrido del cartón y
        // Comprobación de que todos los valores son los adecuados

        for(int j=0; j<cartonMenor[0].length; j++){
            for (int[] fila : cartonMenor) {
                System.out.print(fila[j] + " ");
            }
            System.out.println();
        }

        int numAnterior = 0;
        for(int i=0; i<cartonMenor.length; i++){
            for(int j=0; j<cartonMenor[0].length; j++){
                // Comprobación de que los números de la fila están ordenados ascendentemente
                // y que no se repiten
                assertThat(cartonMenor[i][j]).isGreaterThan(numAnterior);

                // Comprobación de que todos los números de cada fila están dentro de su decena
                assertThat(cartonMenor[i][j]).isBetween(i*10,i*10+9);

                // Actualización del ´´numAnterior``
                numAnterior = cartonMenor[i][j];
            }
        }

    }

//    @Test
//    void testRellenarNumerosCarton_2_2_TamayoMayorAlHabitual(){
//
//        //  WHEN
//
//        // Establecimiento del tamaño del cartón
//        int cantFilasMayor = 4;
//        int cantColumnasMayor = 13;
//
//        // Establecimiento del cartón
//        int[][] cartonMayor = new int[cantFilasMayor][cantColumnasMayor];
//
//        // DO
//
//        // Llamada al método en cuestión
//        Bingo.rellenarNumerosCarton(cartonMayor);
//
//        // THEN
//
//        System.out.println("\n---------- TEST ´´testRellenarNumerosCarton_2_2_TamayoMayorAlHabitual`` ----------\n");
//
//        // Recorrido del cartón y
//        // Comprobación de que todos los valores son los adecuados
//
//        System.out.println("\nCartón Mayor:\n");
//
//        for(int j=0; j<cartonMayor[0].length; j++){
//            for (int[] fila : cartonMayor) {
//                System.out.print(fila[j] + " ");
//            }
//            System.out.println();
//        }
//
//        int numAnterior = 0;
//        for(int i=0; i<cartonMayor.length; i++){
//            for(int j=0; j<cartonMayor[0].length; j++){
//                // Comprobación de que los números de la fila están ordenados ascendentemente
//                // y que no se repiten
//                assertThat(cartonMayor[i][j]).isGreaterThan(numAnterior);
//
//                // Comprobación de que todos los números de cada fila están dentro de su decena
//                assertThat(cartonMayor[i][j]).isBetween(i*10,i*10+9);
//
//                // Actualización del ´´numAnterior``
//                numAnterior = cartonMayor[i][j];
//            }
//        }
//
//    }

    /**
     * Test que introduce un array bidimensional de 3x9 y coloca blancos (con valor -1)
     * en dicho array
     */
    @Test
    void testPonerBlancos_1_CartonConTamanyoHabitual(){
        // WHEN

        // Creación del array bidimensional

        // Creación de array según la forma de crearlo original
        // (la usada en el programa objeto de la prueba)
        int[] col0 = new int[3];
        int[] col1 = new int[3];
        int[] col2 = new int[3];
        int[] col3 = new int[3];
        int[] col4 = new int[3];
        int[] col5 = new int[3];
        int[] col6 = new int[3];
        int[] col7 = new int[3];
        int[] col8 = new int[3];

        int[][] cartonHabitual = {col0, col1, col2, col3, col4, col5, col6, col7, col8};

//        // Forma de crearlo más eficiente
//        int[][] cartonHabitual = new int[9][3];

        // DO
        Bingo.ponerBlancos(cartonHabitual);

        // THEN

        System.out.println("\n---------- TEST ´´testPonerBlancos_1_CartonConTamanyoHabitual`` ----------\n");

        // Impresión por pantalla del contenido del cartón
        // para comprobar visualmente que funciona correctamente

        // Forma de imprimirlo horizontal (en formato de los cartones de bingo)
        for(int j=0; j<cartonHabitual[0].length; j++){
            for (int[] fila : cartonHabitual) {
                System.out.print((fila[j] == 0 ? " 0" : fila[j]) + " ");
            }
            System.out.println();
        }

//        // Forma de imprimirlo más rápida (pero en vertical en vez de
//        // como son los cartones de bingo, que son en horizontal)
//        for(int[] col: cartonHabitual){
//            System.out.println(Arrays.toString(col));
//        }

        // Tests

        // Tests de:
        //      · que cada columna tenga como mucho 2 blancos
        //      · que en total haya 12 blancos en el cartón
        int contBlancos = 0;
        for(int[] col: cartonHabitual){
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

        // Test de:
        //      · que cada fila tenga 4 blancos
        for(int j=0; j<cartonHabitual[0].length; j++){
            int contFil = 0;
            for(int i=0; i<cartonHabitual.length; i++){
                if(cartonHabitual[i][j] == -1){
                    contFil++;
                }
            }
            // Comprobación de que haya 4 blancos por cada fila
            assertThat(contFil).isEqualTo(4);
        }

    }

    /**
     * Demostración complementaria en forma de test de que el método ponerBlancos
     * no está diseñado para manejar arrays bidimensionales de tamaños menores a 3x9
     */
    @Test
    void testPonerBlancos_2_1_CartonConTamanyoMenorAlHabitual(){

        // WHEN
        int[][] cartonMenor1 = new int[2][2];
        int[][] cartonMenor2 = new int[2][2];
        int[][] cartonMenor3 = new int[2][2];

        // DO & THEN

        System.out.println("\n---------- TEST ´´testPonerBlancos_2_1_CartonConTamanyoMenorAlHabitual`` ----------\n");

        // Comprobación de que el método lanza una Excepción de cualquier tipo
        // cuando se le introduce un array de menor tamaño menor que el tamaño para el cual
        // está preparado

        // Usando el static Assertions de assertj
        assertThatThrownBy(() -> Bingo.ponerBlancos(cartonMenor1));

        // Comprobación de que la excepción que el método lanza es una
        // ArrayIndexOutOfBoundsException
        // cuando se le introduce un array de menor tamaño que el tamaño para el cual
        // está preparado

        // Usando el Assertions de junit
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> Bingo.ponerBlancos(cartonMenor2));

        // Método alternativo sin Assertions para obtener más detalles sobre el lanzamiento de la posible excepción
        boolean seProdujoArrayIndexOutOfBoundsException = false;

        try{
            Bingo.ponerBlancos(cartonMenor3);

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

//    /*
//     * Test ´´testPonerBlancos_2_2_CartonConTamanyoMayorAlHabitual()`` no terminado
//     * de implementar, por no ser el objeto principal del testeo, pero dejado empezado
//     */
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
//        int[][] cartonMayor = new int[15][5];
//
//        // DO & THEN
//
//        System.out.println("\nTEST ´´testPonerBlancos_2_2_CartonConTamanyoMayorAlHabitual``:\n");
//
//        // Llamamiento al método que sabemos que se va a quedar colgado demasiado tiempo
//        Bingo.ponerBlancos(cartonMayor);
//
//    }

    @Test
    void testBuscarFila_1_FuncCorrecto(){

        // WHEN

        // Creación de array según la forma de crearlo original
        // (la usada en el programa objeto de la prueba)

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

        // Asignación de números aleatorios al cartón (entre ellos el -1
        // para poder observar el método en cuestión)
        for(int i=0; i<carton.length; i++){
            for(int j=0; j<carton[0].length; j++){
                // Obtención de un número aleatorio entre el -1 y el 2 (ambos incluidos)
                // e Inserción del número en el cartón
                int numAleatInsertar = ((int)(Math.random()*4))-1;

                carton[i][j] = numAleatInsertar;
            }
        }

        // DO & THEN

        System.out.println("\n---------- TEST ´´testBuscarFila_1_FuncCorrecto`` ----------\n");

        // Impresión por pantalla del contenido del cartón
        // para comprobar visualmente que funciona correctamente

        // Forma de imprimirlo horizontal (en formato de los cartones de bingo)
        for(int j=0; j<carton[0].length; j++){
            for (int i=0; i<carton.length; i++) {
                System.out.print(carton[i][j] != -1 ?
                        "  " + carton[i][j] : " " + carton[i][j]);
            }
            System.out.println();
        }

        // Recorrido del cartón y
        // Ejecución del test en cuestión para cada elemento
        for(int i=0; i<carton.length; i++){
            for (int j=0; j<carton[0].length; j++) {
                if(carton[i][j] == -1){
                    // En este método hay que invertir el orden de los índices porque los usa invertidos
                    assertThat(Bingo.buscarFila(carton,j,i)).isTrue();
                } else{
                    // En este método hay que invertir el orden de los índices porque los usa invertidos
                    assertThat(Bingo.buscarFila(carton,j,i)).isFalse();
                }
            }

        }

    }

    @Test
    void testBuscarFila_2_FuncIncorrectoParaFueraDeLimites(){

        // WHEN

        // Creación de array según la forma de crearlo original
        // (la usada en el programa objeto de la prueba)

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

        // DO & THEN

        // Prueba de que se produce una ArrayIndexOutOfBoundsException
        // cuando se introduce una fila y/o columna fuera del rango


        // Fila fuera y Columna dentro
        int filFueraLimite;
        int colDentroLimite;

        // Obtención de números al azar fuera o dentro de los límites del cartón
        // dependiendo del caso concreto

        // Fila
        do{
            filFueraLimite = (int)(Math.random()*20-7);
        } while(filFueraLimite>=0 && filFueraLimite<carton.length);

        // Columna
        do{
            colDentroLimite = (int)(Math.random()*20)-7;
        } while(colDentroLimite<0 || colDentroLimite>=carton[0].length);

        int finalFilFueraLimite = filFueraLimite;
        int finalColDentroLimite = colDentroLimite;
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () ->
            Bingo.buscarFila(carton, finalFilFueraLimite, finalColDentroLimite));


        // Fila dentro y Columna fuera
        int filDentroLimite=0;
        int colFueraLimite=0;

        // Obtención de números al azar fuera o dentro de los límites del cartón
        // dependiendo del caso concreto

        // Fila
        do{
            filDentroLimite = (int)(Math.random()*20)-7;
        } while(filDentroLimite<0 || filDentroLimite>=carton.length);

        // Columna
        do{
            colFueraLimite = (int)(Math.random()*20)-7;
        } while(colFueraLimite>=0 && colFueraLimite<carton[0].length);

        int finalFilFueraLimite1 = filFueraLimite;
        int finalColFueraLimite = colFueraLimite;
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                Bingo.buscarFila(carton, finalFilFueraLimite1, finalColFueraLimite));


        // Fila y Columna ambas fuera

        // Obtención de números al azar fuera o dentro de los límites del cartón
        // dependiendo del caso concreto

        // Fila
        do{
            filFueraLimite = (int)(Math.random()*20)-7;
        } while(filFueraLimite>=0 && filFueraLimite<carton.length);

        // Columna
        do{
            colFueraLimite = (int)(Math.random()*20)-7;
        } while(colFueraLimite>=0 && colFueraLimite<carton[0].length);

        int finalFilFueraLimite2 = filFueraLimite;
        int finalColFueraLimite1 = colFueraLimite;
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                Bingo.buscarFila(carton, finalFilFueraLimite2, finalColFueraLimite1));

    }

    @Test
    void testBuscarColumna(){

        // WHEN

        // Creación de array según la forma de crearlo original
        // (la usada en el programa objeto de la prueba)

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

        // Asignación de números aleatorios al cartón (entre ellos el -1
        // para poder observar el método en cuestión)
        for(int i=0; i<carton.length; i++){
            for(int j=0; j<carton[0].length; j++){
                // Obtención de un número aleatorio entre el -1 y el 2 (ambos incluidos)
                // e Inserción del número en el cartón
                int numAleatInsertar = ((int)(Math.random()*4))-1;

                carton[i][j] = numAleatInsertar;
            }
        }

        // DO & THEN

        System.out.println("\n---------- TEST ´´`` ----------\n");

        // Impresión por pantalla del contenido del cartón
        // para comprobar visualmente que funciona correctamente

        // Forma de imprimirlo horizontal (en formato de los cartones de bingo)
        for(int j=0; j<carton[0].length; j++){
            for (int i=0; i<carton.length; i++) {
                System.out.print(carton[i][j] != -1 ?
                        "  " + carton[i][j] : " " + carton[i][j]);
            }
            System.out.println();
        }

        // Recorrido del cartón y
        // Ejecución del test en cuestión para cada fila
        // (que en el formato del cartón, corresponde a cada columna)
        for(int i=0; i<carton.length; i++){
            int contBlancos = 0;

            // Recorrido de la columna entera y
            // Suma en 1 al ´´contBlancos``
            // cada vez que encuentre un blanco (con valor -1)
            for (int j=0; j<carton[0].length; j++) {
                if(carton[i][j] == -1){
                    contBlancos++;
                }
            }

            // Comprobación de que el método en cuestión devuelve false
            // si la columna del cartón tiene menos de 2 blancos
            // y devuelve true si ya tiene 2
            if(contBlancos < 2){
                assertThat(Bingo.buscarColumna(carton,i)).isFalse();
            } else{
                assertThat(Bingo.buscarColumna(carton,i)).isTrue();
            }

        }

    }

    @Test
    void testBuscarValorRepetido(){

        // WHEN

        // Creación de 2 arrays unidimensionales con 30 posiciones

        int[] arrayBolasSacadas = new int[30];
        int[] arrayNumerosParaBuscar = new int[30];

        // Asignación de números aleatorios al cartón entre el 1 y el 100 (ambos incluidos)
        for(int i=0; i<arrayBolasSacadas.length; i++){
            arrayBolasSacadas[i] = (int)(Math.random()*100+1);
        }

        // Asignación de números aleatorios al cartón entre el 1 y el 100 (ambos incluidos)
        for(int i=0; i<arrayNumerosParaBuscar.length; i++){
            arrayNumerosParaBuscar[i] = (int)(Math.random()*100+1);
        }

        // DO & THEN

        System.out.println("\n---------- TEST ´´`` ----------\n");

        // Impresión por pantalla del contenido de los arrays aleatorios
        System.out.println("arrayBolasSacadas:\n" + Arrays.toString(arrayBolasSacadas));
        System.out.println("\narrayNumerosParaBuscar:\n" + Arrays.toString(arrayBolasSacadas));

        // Búsqueda de todos los elementos del ´´arrayNumerosParaBuscar``
        // dentro del ´´arrayBolasSacadas`` y ejecución del método en cuestión
        // para cada elemento
        for(int i=0; i<arrayNumerosParaBuscar.length; i++){
            boolean estaEnLasBolasSacadas = false;

            for(int j=0; j<arrayBolasSacadas.length && !estaEnLasBolasSacadas;j++){
                if(arrayNumerosParaBuscar[i] == arrayBolasSacadas[j]){
                    estaEnLasBolasSacadas = true;
                }
            }

            if(estaEnLasBolasSacadas){
                assertThat(Bingo.buscarValorRepetido(arrayBolasSacadas,arrayNumerosParaBuscar[i])).isTrue();
            } else{
                assertThat(Bingo.buscarValorRepetido(arrayBolasSacadas,arrayNumerosParaBuscar[i])).isFalse();
            }
        }

    }

//    @Test
//    void testPintarCarton(){
//
//        // WHEN
//
//        int[][] carton;
//        int[] bolas;
//
//        // DO & THEN
//
//        int cantComprob = 10;
//
//        for(int h=0; h<cantComprob; h++){
//            // Creación del carton
//
//            carton = new int[(int)(Math.random()*30+1)][(int)(Math.random()*30+1)];
//
//            for(int i=0; i<carton.length; i++){
//                for(int j=0; j<carton[0].length; j++){
//                    carton[i][j] = (int)(Math.random()*201-100);
//                }
//            }
//
//            // Creación del array de las bolas
//            bolas = new int[(int)(Math.random()*30+1)];
//
//            for(int i=0; i<bolas.length; i++){
//                bolas[i] = (int)(Math.random()*21-10);
//            }
//
//            // Almacenamiento en una variable String el mismo ´´println`` que imprime el método en cuestión
//            int aciertos = 0;
//
//            String textoImpreso = "\n\n";
//
//            for (int i = 0; i < carton[0].length; i++) // Recorre las 3 filas que vamos a pintar
//            {
//                textoImpreso = "|  ";
//
//                for (int j = 0; j < carton.length; j++) // Pinta las 8 posiciones de cada fila
//                {
//
//                    boolean seTacha = Bingo.buscarValorRepetido(bolas, carton[j][i]);
//
//                    if(seTacha) // Si la bola ha salido pinto X, si no pinto la casilla original
//                    {
//                        textoImpreso = "X  |  ";
//
//                        aciertos++;
//                    }
//                    else
//                    {
//                        textoImpreso = carton[j][i] + "  |  ";
//                    }
//
//                }
//                textoImpreso = "\n";
//            }
//            textoImpreso = "\n\n";
//
//            // Llamada al método en cuestión
//            ByteArrayOutputStream contenido = new ByteArrayOutputStream();
//            System.setOut(new PrintStream(contenido));
//
//            Bingo.pintarCarton(carton, bolas);
//
//            // Comprobación de que el método de que el método en cuestión proporciona el resultado correcto
//            assertThat(textoImpreso).isEqualTo(contenido.toString().trim());
//        }
//
//    }

    @Test
    void testInsertarAlFinal_1_NumeroNuevoSeColocoAlFinal(){

        // WHEN

        // Creación de un array unidimensional vacío
        int[] arrayNumeros = new int[0];

        // DO & THEN

        // Inserciones de números aleatorios en el arrayNumeros durante 30 veces y
        // Comprobación de que cada número insertado se inserta al final del arrayNumeros
        int cantInserciones = 30;

        for(int i=0; i<cantInserciones; i++){
            int numInsertado = (int)(Math.random()*100+1);

            arrayNumeros = Bingo.insertarAlFinal(arrayNumeros,numInsertado);

            assertThat(arrayNumeros[arrayNumeros.length-1]).isEqualTo(numInsertado);
        }

    }

    @Test
    void testInsertarAlFinal_2_ArrayAmpliado1TamanyoMayorQueArrayOriginal(){

        // WHEN

        // Creación de un array unidimensional vacío
        int[] arrayNumeros = new int[0];

        // DO & THEN

        // Inserciones de números aleatorios en el arrayNumeros durante 30 veces y
        // Comprobación de que el nuevo array tiene 1 posición más que el array antes
        // de recibir la inserción
        int cantInserciones = 30;
        int tamanyoAnteriorArray = arrayNumeros.length;

        for(int i=0; i<cantInserciones; i++){
            int numInsertado = (int)(Math.random()*100+1);

            arrayNumeros = Bingo.insertarAlFinal(arrayNumeros,numInsertado);

            // Llamada al método en cuestión
            assertThat(arrayNumeros.length).isEqualTo(tamanyoAnteriorArray+1);

            // Actualización del ´´tamanyoAnteriorArray``
            tamanyoAnteriorArray = arrayNumeros.length;
        }

    }

    @Test
    void testOrdenar_1_ComprobacionNumeroPorNumero(){

        // WHEN

        // Creación de 1 arrays unidimensionales con 30 posiciones

        int[] arrayNumeros = new int[30];

        // DO & THEN

        // Establecimiento de los números aleatorios del arrayNumeros y
        // Comprobación de que el método en cuestión realiza la ordenación correctamente
        // durante 10 veces
        int cantComprob = 10;
        int numAnterior = 0;

        for(int h=0; h<cantComprob; h++) {
            // Asignación de números aleatorios al cartón entre el 1 y el 100 (ambos incluidos)
            for (int i = 0; i < arrayNumeros.length; i++) {
                arrayNumeros[i] = (int) (Math.random() * 100 + 1);
            }

            // Llamada al método en cuestión
            arrayNumeros = Bingo.ordenar(arrayNumeros);

            // Recorrido del arrayNumeros y
            // Comprobación de que el arrayNumeros está ordenado de menor a mayor
            for (int i = 0; i < arrayNumeros.length; i++) {
                if(i == 0){
                    numAnterior = arrayNumeros[i];
                } else{
                    // Comprobación
                    assertThat(arrayNumeros[i]).isGreaterThanOrEqualTo(numAnterior);

                    // Actualización de numAnterior
                    numAnterior = arrayNumeros[i];
                }
            }

        }

    }

    /**
     * Comprobación quizá redundante ya que lo que hace el método en cuestión
     * es precisamente llamar al Arrays.sort(), aunque el objeto de este test
     * es comprobar de que el método en cuestión recibe el array y llama correctamente
     * al método Arrays.sort()
     *
     */
    @Test
    void testOrdenar_2_ComprobacionConElMetodoSortDeArray(){

        // WHEN

        // Creación de 1 arrays unidimensionales con 30 posiciones

        int[] arrayNumeros = new int[30];

        // DO & THEN

        // Establecimiento de los números aleatorios del arrayNumeros y
        // Comprobación de que el método en cuestión realiza la ordenación correctamente
        // durante 10 veces
        int cantComprob = 10;

        for(int h=0; h<cantComprob; h++) {
            // Asignación de números aleatorios al cartón entre el 1 y el 100 (ambos incluidos)
            for (int i = 0; i < arrayNumeros.length; i++) {
                arrayNumeros[i] = (int) (Math.random() * 100 + 1);
            }

            // Copia del arrayNumeros para ordenarlos de distinto modo y
            // Comprobar que el resultado de la comprobación es el mismo
            int[] arrayCopia = arrayNumeros.clone();

            // Llamada al método en cuestión
            arrayNumeros = Bingo.ordenar(arrayNumeros);

            // Ordenación del arrayCopia mediante el método Arrays.sort()
            Arrays.sort(arrayCopia);

            // Comparación del método en cuestión con el método de ordenación establecido
            // para los arrays (el Arrays.sort())
            assertThat(arrayNumeros).isEqualTo(arrayCopia);

        }

    }

}