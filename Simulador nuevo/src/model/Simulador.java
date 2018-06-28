package model;

import java.util.*;

public class Simulador {
	private int cpuTime;
	private List<Proceso> lstProcesos = new ArrayList<Proceso>();
	//private List<Integer> lstCandidatos = new ArrayList<Integer>();
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
		while(runTime < cpuTime || candidatos.length == 0) {
			int sorteado = (int) Math.random()*(candidatos.length-1);
			if(this.traerProceso(candidatos[sorteado]).actualizar(cpuTime)) {
				candidatos = this.actualizarCandidatos(sorteado);
			}
			
			runTime++;
		}
		cpuTime = runTime;
		//this.resultados();
	}
	
	private int[] actualizarCandidatos(int sorteado) {
		int[] nuevo = new int[candidatos.length-1];
		for (int i = 0; i < candidatos.length; i++) {
			if(candidatos[i] != sorteado) {
				nuevo[i] = candidatos[i];
			}else {
				nuevo[i] = candidatos[i+1];
			}
		}
		return nuevo;
	}
	
	
	private Proceso traerProceso(int id) {
		int i = 0;
		boolean encontrado = false;
		Proceso aux = null;
		while(i < lstProcesos.size() && !encontrado) {
			if(lstProcesos.get(i).getIdProceso() == id) {
				encontrado = true;
				aux = lstProcesos.get(i);
			}
			i++;
		}
		return aux;
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
