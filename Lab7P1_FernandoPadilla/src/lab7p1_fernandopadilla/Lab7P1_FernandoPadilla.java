package lab7p1_fernandopadilla;

import javax.swing.JOptionPane;
import java.util.*;

public class Lab7P1_FernandoPadilla {

    static Scanner read = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        int opcion = 0;
        do {
            System.out.println("1.Promedios");
            System.out.println("2.De landscape a portrait");
            System.out.println("3.Higher order contains");
            System.out.println("4.Salida");
            System.out.println("Ingrese el programa a ejecutar: ");
            opcion = read.nextInt();
            switch (opcion) {
                case 1:
                    int fila,
                     columna;
                    System.out.println("Ingrese las filas: ");
                    fila = read.nextInt();
                    System.out.println("Ingrese las columnas: ");
                    columna = read.nextInt();
                    int[][] matriz = new int[fila][columna];
                    matriz = llenado(fila, columna);
                    imprimir(matriz);
                    System.out.println("Calcular promedio de : \n"+ "1.Filas \n" + "2.Columnas");
                    int promedio = read.nextInt();
                    if (promedio == 1) {
                        System.out.println("El promedio es: ");
                        imprimir_arreglo(promedio_fila(matriz,fila,columna));
                    }
                    else if (promedio == 2) {
                        JOptionPane.showMessageDialog(null,"El promedio es: \n" + imprimir_j_array(promedio_columna(matriz,columna,fila)));
                    } else {
                        System.out.println("Opcion no valida");
                    }
                    break;

                case 2:
                    System.out.println("Ingrese las filas: ");
                    fila = read.nextInt();
                    System.out.println("Ingrese las columnas: ");
                    columna = read.nextInt();
                    int[][] matriz1 = new int[fila][columna];
                    matriz1 = llenado2(fila, columna);
                    System.out.println("La rotacion de 90 grados a la derecha de");
                    imprimir(matriz1);
                    System.out.println("\n \n es");
                    imprimirp(portrait(matriz1,fila,columna));
                    JOptionPane.showMessageDialog(null, "La rotacion de 90 grados a la derecha de" + "\n" + imprimir_j(matriz1)+"\n \n"+imprimir_jp(portrait(matriz1,fila,columna)) );
                    break;

                case 3:
                    System.out.println("Ingrese las filas: ");
                    fila = read.nextInt();
                    System.out.println("Ingrese las columnas: ");
                    columna = read.nextInt();
                    int size = 0;
                    while (size == 0 || size>columna){
                        System.out.println("Ingrese el tamaño del arreglo");
                        size = read.nextInt();
                    }
                    int[][] matriz2 = new int[fila][columna];
                    matriz2 = llenado2(fila, columna);
                    imprimir(matriz2);
                    containsHO(matriz2,size);
                    break;

                case 4:
                    opcion = 4;
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (opcion != 4);
    }

    public static void imprimir_arreglo(double[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println("");
    }
    
    public static void imprimir_arregloi(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println("");
    }

    public static String imprimir_j(int matriz[][]) {
        String matri = "";
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matri += "[" + matriz[i][j] + "]";
            }
            matri += "\n";
        }
        return matri;
    }

    public static String imprimir_j_array(double[] array) {
        String arr = "";
        for (int i = 0; i < array.length; i++) {
            arr += ("[" + array[i] + "]");
        }
        return arr;
    }
    
    public static String imprimir_j_array2(int[] array) {
        String arr = "";
        for (int i = 0; i < array.length; i++) {
            arr += ("[" + array[i] + "]");
        }
        return arr;
    }

    public static int[][] llenado(int fila, int columna) {
        int[][] temp = new int[fila][columna];
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                temp[i][j] = random.nextInt(100);
            }//Maneja las columnas
        }//Maneja las filas
        return temp;
    }
    
    public static int[][] llenado2(int fila, int columna) {
        int[][] temp = new int[fila][columna];
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                temp[i][j] = random.nextInt(10);
            }//Maneja las columnas
        }//Maneja las filas
        return temp;
    }

    public static void imprimir(int[][] enteros) {
        for (int i = 0; i < enteros.length; i++) {
            for (int j = 0; j < enteros[i].length; j++) {
                System.out.print(enteros[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void imprimirp(int[][] enteros) {
        for (int i = 0; i < enteros.length; i++) {
            for (int j = enteros[i].length-1; j >= 0; j--) {
                System.out.print(enteros[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static String imprimir_jp(int matriz[][]) {
        String matri = "";
        for (int i = 0; i < matriz.length; i++) {
            for (int j = matriz[i].length-1; j >= 0; j--) {
                matri += "[" + matriz[i][j] + "]";
            }
            matri += "\n";
        }
        return matri;
    }

    public static double [] promedio_fila(int[][] matriz, int fila,int columna) {
        double[] promedio = new double [fila];
        int acum = 0;
        int [] temp = new int[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                acum += matriz[i][j];
            }//aqui termina el for interno 
            temp[i] = acum;
            acum = 0;
        }
        for (int i = 0; i < fila; i++) {
            promedio[i] =(double) temp[i] / columna;
        }
        return promedio;
    }
    
    public static double [] promedio_columna(int[][] matriz, int columna, int fila) {
        double[] promedio = new double [columna];
        int acum = 0;
        int [] temp = new int[matriz[0].length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                acum += matriz[i][j];
            }//aqui termina el for interno 
            temp[i] = acum;
            acum = 0;
        }
        for (int i = 0; i < columna; i++) {
            promedio[i] =(double) temp[i] / fila;
        }
        return promedio;
    }
    
    public static void containsHO(int[][]matriz,int size){
        boolean tof = false;
        int cont = 0;
        int [] array = new int [size];
        int elemento = 0;
        for (int i = 0; i < size; i++) {
            System.out.println("Matriz generada \n");
            imprimir(matriz);
            System.out.println();
            imprimir_arregloi(array);
            System.out.println();
            System.out.println("Ingrese el elemento["+(i+1)+"]");
            elemento = read.nextInt();
            array[i] = elemento;
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if(cont < array.length && matriz[i][j] == array[cont]){
                    cont++;
                }else{
                    cont = 0;
                }
            }
        }
        if(cont == size){
            tof = true;
        }
        if (tof) {
            JOptionPane.showMessageDialog(null, "El arreglo \n" + imprimir_j_array2(array)+ "\n" + "Esta contenido en la matriz");
        } else {
            JOptionPane.showMessageDialog(null, "El arreglo \n" + imprimir_j_array2(array)+ "\n" + "NO esta contenido en la matriz");
        }
    }
    
    public static int[][] portrait (int[][] matriz,int fila,int columna){
        int[][]matriz2 = new int [columna][fila];
        for (int i =0 ; i < matriz.length; i++) {
            for (int j = matriz[i].length-1 ; j >= 0 ; j--) {
                matriz2[j][i] = matriz[i][j];
            }
        }
        return matriz2;
    }
}
