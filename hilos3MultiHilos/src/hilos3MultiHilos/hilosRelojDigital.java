package hilos3MultiHilos;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class hilosRelojDigital extends JFrame implements Runnable {
	JTextArea fechaYHora = new JTextArea();
	 
	private boolean vivo = true;
	
	public hilosRelojDigital() {
		fechaYHora.setPreferredSize(new Dimension(200,50));
		 this.setSize(250,110);
		 this.setTitle("MultiHilos");
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setResizable(false);
		 this.add(fechaYHora);
		 this.setVisible(true);
	}

	@Override
	public void run() {
		while(vivo) {
	      try {
	    	  //Mientras esta abierto la applicacion se recoge la fecha/hora y reemplaza lo que esta en
	    	  //JTextArea. El Hilo duerme cada 1.1 seg.
	    	Date date = new java.util.Date();
	    	SimpleDateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");  
	    	String strDate = formatter.format(date); 
	    	fechaYHora.setText(strDate);
			Thread.sleep(1100);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	public void relojProgressar(SimpleDateFormat reloj) {
		
	}
}
