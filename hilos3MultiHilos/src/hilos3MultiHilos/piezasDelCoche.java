package hilos3MultiHilos;



import java.io.IOException;

import javax.swing.JTextPane;

public class piezasDelCoche extends multiHilosMain implements Runnable{
	String pieza;
	String resultado;
	int cantidad;
	

	@Override
	public void run() {
		 
		for(int i=1; i<=this.cantidad; i++) {
			resultado=this.pieza+i+" ";
			try {
				inicio.jTextArea(resultado);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				Thread.sleep(1850);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}		
	}
	
	
	public piezasDelCoche(String pieza, int cantidad) {
		super();
		this.pieza = pieza;
		this.cantidad = cantidad;
	}


	public String getPieza() {
		return pieza;
	}
	
	


	public void setPieza(String pieza) {
		this.pieza = pieza;
	}



}
