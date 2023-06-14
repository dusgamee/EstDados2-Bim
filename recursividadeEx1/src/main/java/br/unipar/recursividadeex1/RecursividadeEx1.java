package br.unipar.recursividadeex1;

public class RecursividadeEx1 {
 // c = começo   f = fim
    public static void main(String[] args) { 
        
        sequenciaNumeros(0, 50);
    }
    
    public static void sequenciaNumeros(int c, int f) {
        if (c <= f) {
            System.out.println(c);
            
            sequenciaNumeros(c + 1, f);
        }
    }
}