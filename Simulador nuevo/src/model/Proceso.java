package model;

public class Proceso {
	private int idProceso;
	private int ioBlockling;
	private int cpuCompleted;
	private int cpuBlocked;
	
	public Proceso(int idProceso, int ioBlocking) {
		this.idProceso = idProceso;
		this.ioBlockling = ioBlocking;
		this.cpuCompleted = 0;
		this.cpuBlocked = 0;
	}
	
	
	public boolean actualizar(int cpuTime) {
		boolean terminado = false;
		this.cpuCompleted = this.cpuCompleted + this.ioBlockling;
		if(this.cpuCompleted > cpuTime) {
			this.cpuCompleted = cpuTime;
			terminado = true;
		}
		this.cpuBlocked = this.cpuBlocked + 1;
		return terminado;
	}
	
	public int getIdProceso() {
		return idProceso;
	}

	public void setIdProceso(int idProceso) {
		this.idProceso = idProceso;
	}

	public int getIoBlockling() {
		return ioBlockling;
	}

	public void setIoBlockling(int ioBlockling) {
		this.ioBlockling = ioBlockling;
	}

	public int getCpuCompleted() {
		return cpuCompleted;
	}

	public void setCpuCompleted(int cpuCompleted) {
		this.cpuCompleted = cpuCompleted;
	}

	public int getCpuBlocked() {
		return cpuBlocked;
	}

	public void setCpuBlocked(int cpuBlocked) {
		this.cpuBlocked = cpuBlocked;
	}


	@Override
	public String toString() {
		return "Proceso [idProceso=" + idProceso + ", ioBlockling=" + ioBlockling + ", cpuCompleted=" + cpuCompleted
				+ ", cpuBlocked=" + cpuBlocked + "]";
	}

	
}
