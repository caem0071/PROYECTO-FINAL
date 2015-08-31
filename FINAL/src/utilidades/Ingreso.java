/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilidades;

import java.util.Scanner;
/**
 * @category ESPOL
 * @version 8.0
 * @author Villacis, Marmolejo, Espinosa.
 */
public class Ingreso {
    
    private static Scanner sc;
	private static Scanner sc2;

	public static int leerNumero(String mensaje){
        System.out.print(mensaje);
        sc = new Scanner(System.in);
        int numero = sc.nextInt();
        return numero;
    }
    
    public static String leerTexto(String mensaje){
        System.out.print(mensaje);
        sc2 = new Scanner(System.in);
        String texto = sc2.nextLine();
        return texto;
    }
    
}
