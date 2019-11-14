/**
 * EjerciciosPOJO.java
 */
package com.hbt.semillero.pojo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Juan Camilo
 * @version 
 */
public class EjerciciosPOJO {

	public boolean primos(int numero) {
		int contador = 2;
		boolean primo=true;
		while ((primo) && (contador!=numero)){
			if (numero % contador == 0)
			{
				primo = false;
			    contador++;
			}
			else
			{
				primo = true;
			}
		}
		return primo;
	}
	
	public boolean fecha(int nacimiento, int numeroAños) {
		LocalDate fechaActual = LocalDate.now();
		int añoActual = fechaActual.getYear();
		int diferecia = añoActual - numeroAños ;
		if (diferecia == nacimiento) {
			return true;
		}
		else {
			return false;
		}
	}
	public List<Integer> lista= new ArrayList<>();
	public void ingresarValores(int numero) {
		this.lista.add(numero);
	}
	
	public List<Integer> ordenar() {
        Integer [] ordenada = new Integer[lista.size()];
		ordenada = this.lista.toArray(ordenada);
		Arrays.sort(ordenada);
		lista = Arrays.asList(ordenada);
		return lista;
	}
	public Map<String, Integer> map=new HashMap<>();

	public void tenis(String federer, Integer pF, String thiem, Integer pT) {
		map.put(federer, pF);
		map.put(thiem, pT);
	}
	
	public Integer[] cambio(Integer dinero) {
		Integer M_1000 = dinero/1000;
		Integer saldo = dinero%1000;
		Integer M_500 = saldo/500;
		saldo = saldo%500;
		Integer M_200 = saldo/200;
		saldo = saldo%200;
		Integer M_100 = saldo/100;
		saldo = saldo%100;
		Integer M_50 = saldo/50;
		saldo = saldo%50;
		
		Integer[] monedas = new Integer[] {M_1000,M_500,M_100,M_200,M_100,M_50};
		return monedas;
	}
	
	public void ohNo() throws Exception {
		throw new Exception();
	}
	
	
	public Boolean secuencia(Integer num) {
		Integer[] patron = new Integer[] {23,33,25,80,36,num};
		Integer digitos = 5;
		for (int i = 0; i < patron.length; i++) {
	        Integer resultado = 0;
			while(patron[i] > 0) {
	            resultado += patron[i] % 10;
	            patron[i] = patron[i] / 10;
	        }
			if (patron[i] != digitos) {
				return false;
			}
			digitos++;
		}
		
		return true;
	}
}
