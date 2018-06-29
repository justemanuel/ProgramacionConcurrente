package model;

import java.util.*;

import org.apache.commons.lang3.ArrayUtils;


public class Simulador {
	private int cpuTime;
	private List<Proceso> lstProcesos = new ArrayList<Proceso>();
	int candidatos[] = new int[8];
	Proceso aux;
	
	public Simulador(int cpuTime) {
		this.cpuTime = cpuTime;
	}
	
	public void agregarProceso(int ioBlocking) {
		int id = this.generarIdProceso();
		Proceso proceso = new Proceso(id, ioBlocking);
		lstProcesos.add(proceso);
		candidatos[id] = id;
	}
	
	public void sorteo() {		
		int runTime = 0;
		while(runTime < cpuTime && candidatos.length != 0) {
			int sorteado = (int) (Math.random()* (candidatos.length)); //devuelve posicion del array
			System.out.println("posicion sorteada: "+sorteado);
			if(this.traerProceso(candidatos[sorteado]).actualizar(cpuTime)) {
				System.out.println("\nactualizo posicion: "+sorteado+"\n");
				candidatos = this.actualizarCandidatos(sorteado);
			}
			runTime++;
		}
		cpuTime = runTime;
		//this.resultados();
	}
	
	private int[] actualizarCandidatos(int sorteado) {
		
		candidatos = ArrayUtils.removeElement(candidatos, candidatos[sorteado]);
		
		return candidatos;
	}
	
	private Proceso traerProceso(int id) {//recibis la posicion del proceso en la lista
		return lstProcesos.get(id);
	}
	
	private int generarIdProceso() {
		if(lstProcesos.isEmpty()) {
			return 0;
		}else {
			return lstProcesos.get(lstProcesos.size()-1).getIdProceso()+1;
		}
	}
	
	public double getCpuTime() {
		return cpuTime;
	}

	public void setCpuTime(int cpuTime) {
		this.cpuTime = cpuTime;
	}

	public List<Proceso> getLstProcesos() {
		return lstProcesos;
	}

	public void setLstProcesos(List<Proceso> lstProcesos) {
		this.lstProcesos = lstProcesos;
	}

	public int[] getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(int[] candidatos) {
		this.candidatos = candidatos;
	}
	
	
}
