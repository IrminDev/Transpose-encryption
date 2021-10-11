package transposicion;

import java.util.Scanner;

public class Transposicion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cadena;
        int codigoo[] = new int[5];
        int opc = 0;
        while(opc != 3){
            //Se piden la opción a realizar
            System.out.println("\nIntroduce el número de tu opción");
            System.out.println("1. Cifrar");
            System.out.println("2. Descifrar");
            System.out.println("3. Salir");
            opc = sc.nextInt();
            sc.nextLine();
            if(opc == 1){
                //Se recopilan los datos con los que se trabajarán
                System.out.println("Introduce la frase a cifrar");
                cadena = sc.nextLine();
                System.out.println("Introduce un codigo de 5 numeros del 0 al 4 sin que se repitan (uno por uno)");
                codigoo[0] = sc.nextInt();
                codigoo[1] = sc.nextInt();
                codigoo[2] = sc.nextInt();
                codigoo[3] = sc.nextInt();
                codigoo[4] = sc.nextInt();
                
                //Se determina el número de filas con las que trabajará el arreglo de dos dimensiones
                int largo = cadena.length();
                if(largo%5 > 0){
                    largo = largo/5 + 1;
                }
                else{
                    largo = largo/5;
                }
                
                //Se asignan las letras de la frase a una arreglo de caracteres
                char transposicion[][] = new char[largo][5];
                int indice = 0;
                for(int i =0; i<largo; i++){
                    for(int j=0; j<5; j++){
                        //Comprueba si no se ha excedido los carácteres que tiene la frase
                        if(indice < cadena.length()){
                            transposicion[i][j] = cadena.charAt(indice);
                            indice++;
                        }
                        else{
                            //Si es así los sustituye por espacios a los lugares restante del arreglo
                            transposicion[i][j] = (char)(' ');
                        }
                    }
                }
                
                //Se crea la frase resultante
                String nueva = "";
                for(int i=0; i<5; i++){
                    for(int j=0; j<largo; j++){
                        //Agrega las letras a la cadena de acuerdo a la clave que se proporcionó
                        nueva += transposicion[j][codigoo[i]];
                    }
                }
                
                System.out.println("La frase cifrada es: \n" + nueva);
            }
            else{
                if(opc == 2){
                    //Recopila los datos con los que se trabajará
                    System.out.println("Introduce la frase a descifrar");
                    cadena = sc.nextLine();
                    System.out.println("Introduce el codigo con el que fue cifrado (coloca numero por numero)");
                    codigoo[0] = sc.nextInt();
                    codigoo[1] = sc.nextInt();
                    codigoo[2] = sc.nextInt();
                    codigoo[3] = sc.nextInt();
                    codigoo[4] = sc.nextInt();
                    int largo = cadena.length();
                    
                    //Determina el alrgo que deberá tener en fila el arreglo de dos dimensiones
                    if(largo%5 > 0){
                        largo = largo/5 + 1;
                    }
                    else{
                        largo = largo/5;
                    }
                    
                    //Arreglo que tendrá a la frase desordenada
                    char transposicion[][] = new char[largo][5];
                    //Arreglo que tendrá a la frase ordenada
                    char transposicionuevo[][] = new char[largo][5];
                    
                    //mete la frase desordenada en el primer arreglo
                    int indice = 0;
                    for(int i =0; i<largo; i++){
                        for(int j=0; j<5; j++){
                            if(indice < cadena.length()){
                                transposicion[i][j] = cadena.charAt(indice);
                                indice++;
                            }
                            else{
                                transposicion[i][j] = (char)(' ');
                            }
                        }
                    }
                    
                    //Auxiliares para colocar cada una de las letras en orden
                    int indicex, indicey;
                    indicex = 0;
                    indicey = 0;
                    
                    //Se ordenan en el segundo arreglo
                    for(int i=0; i<5; i++){
                        for(int j=0; j<largo; j++){
                            transposicionuevo[j][codigoo[i]] = transposicion[indicey][indicex];
                            if(indicex == 4){
                                indicex = 0;
                                indicey++;
                            }
                            else{
                                indicex++;
                            }
                        }
                    }
                    
                    //Crea la frase que fue almacenada en orden del segundo arreglo
                    String nueva = "";
                    for(int i=0; i<largo; i++){
                        for(int j=0; j<5; j++){
                            nueva += transposicionuevo[i][j];
                        }
                    }
                    System.out.println("La frase descifrada es: \n" + nueva);
                }
            }
        }
    }
}
