package hilos3MultiHilos;

import java.io.IOException;

public class montajeCoche extends multiHilosMain implements Runnable {
	String resultado;
	int cantidad;
	public montajeCoche(int cantidad) {
		super();
		this.cantidad = cantidad;
	}
	@Override
	public void run() {
		for(int i=1; i<=cantidad; i++) {
			resultado="Montaje Coche "+i+"\n ";
			try {
				inicio.jTextArea(resultado);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}		
	}

}
