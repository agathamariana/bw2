package br.com.task2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class App 
{

    public static void main( String[] args )
    {   	
    	String numero;
    	
    	Scanner ler = new Scanner(System.in);
    	System.out.printf("Informe o número:\n");
    	numero = ler.next();
    	String num = numero;
    	
    	double num_valida = Double.parseDouble(num);
    	
    	if ((num_valida > 0) && (num_valida < (Math.pow(10, 9)) && (num.charAt(0) != '0'))) {
    		
    		Boolean verifica;
    		List<String> combinacoes = new ArrayList<String>();
    		List<String> combinacoes_final = new ArrayList<String>();
    		List<Character> retira_repeticao = new ArrayList<Character>();
    		
    		geraNovoNumero(combinacoes, num, num.length(), "");	
    		
    		for (String num_final : combinacoes) {	
    			for (int i = 0; i < num_final.length(); i++) { 
    				retira_repeticao.add(num_final.charAt(i));
    	        } 
    			
    			Set<Character> set = new HashSet<>(retira_repeticao);
    			
    			if (set.size() == num.length()) {				
    				verifica = true;
    			} else {
    				verifica = false;
    				set.clear();
    				retira_repeticao.clear();
    				continue;
    			}
    			
    			if (verifica)
    				combinacoes_final.add(num_final);
    			
    			set.clear();
    			retira_repeticao.clear();
    		}
    		
    		System.out.println(combinacoes_final);
    	} else {
    		System.out.println("O número informado não é válido!");
    	}

    }
    
    public static void geraNovoNumero(List<String> combinacoes, String num, int tamanho, String num_atual) { 
        String num_corrente = num_atual; 

        for (int i = 0; i < num.length(); i++) { 
        	num_corrente += num.charAt(i); 
        	        	           	
        	if (num_corrente.charAt(0) != '0') {
        		if (num_corrente.length() == tamanho) {          			
                	combinacoes.add(num_corrente); 
                	num_corrente = num_atual;
                } else {                 	
                	geraNovoNumero(combinacoes, num, tamanho, num_corrente); 
                	num_corrente = num_atual; 
                } 
        	}

        } 
    } 
    
}
