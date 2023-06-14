/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package br.unipar.recursividadeex2;

import java.util.Scanner;

/**
 *
 * @author leona
 */
public class RecursividadeEx2 { 
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("insira um numero");
        
        int num = scanner.nextInt();
        scanner.close();

        int fatorial = (int) calculoDeFatorial(num);
        System.out.println("fatorial de " + num + " é: " + fatorial);
    }

    public static long calculoDeFatorial(int numF) {
        if (numF == 0 || numF == 1) {
            return 1;
            
        } else {
            return 
            numF *  calculoDeFatorial(numF - 1);
        }
    }
     }