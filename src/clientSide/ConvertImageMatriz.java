/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientSide;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;



/**
 *
 * @author Gustavo
 */
public class ConvertImageMatriz{

    public static Integer[][] lerArq(File file){
        
        Integer[][] matriz = null;
 
        try {
            Scanner scanner = new Scanner(file);
            String linha;
            int valor;
            int largura;
            int altura;
            
            linha = scanner.nextLine(); //tipo do formato
            linha = scanner.nextLine(); //comment
            largura = scanner.nextInt();
            altura = scanner.nextInt();
            
            scanner.nextInt();
            
            matriz = new Integer[largura][altura];
            
            for(int y=0;y<altura;y++){
                for(int x=0; x<largura;x++){
                    valor = scanner.nextInt();
                    matriz[x][y] = valor;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado");
        }
        return matriz;
    }
    public static void salvarArq (Integer[][] matriz,String nomeArq){
        try {
            
                FileWriter arq = new FileWriter(nomeArq + ".pgm");
                int largura = matriz[0].length;
                int altura = matriz.length;
                PrintWriter gravarArq = new PrintWriter(arq);
                gravarArq.printf("P2\n");
                gravarArq.printf("#Resultado Operação\n");
                gravarArq.printf( largura + " " + altura +"\n");
                gravarArq.printf("255\n");
                
                for(int y=0;y<altura;y++){
                  for(int x=0; x<largura;x++){
                       gravarArq.printf("%d\n",matriz[x][y]);
                    }
                }
                arq.close();
                System.out.println("Imagem Salva");
            } catch (IOException ex) {
                System.out.println("Arquivo não Criado");
       
            }
        
    }
    
    
}
