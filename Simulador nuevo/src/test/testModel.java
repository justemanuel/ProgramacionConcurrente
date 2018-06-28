package test;

import model.*;

public class testModel {
	public static void main(String[] args) {
		
		Simulador simulador = new Simulador(1500);
		
		simulador.agregarProceso(50);
		simulador.agregarProceso(1000);
		simulador.agregarProceso(850);
		simulador.agregarProceso(1500);
		simulador.agregarProceso(1400);
		simulador.agregarProceso(1200);
		simulador.agregarProceso(1300);
		simulador.agregarProceso(1000);
		
		for (int i = 0; i < simulador.getLstProcesos().size(); i++) {
			System.out.println(simulador.getLstProcesos().get(i));
			System.out.println();
		}
		
		for (int i = 0; i < simulador.getCandidatos().length; i++) {
			System.out.println(simulador.getCandidatos()[i]);
		}
		
		System.out.println("muestro resultados:");
		simulador.sorteo();
		
		
		for (int i = 0; i < simulador.getLstProcesos().size(); i++) {
			System.out.println(simulador.getLstProcesos().get(i));
			System.out.println();
		}

		
		
		
		
		
		
	}
}
