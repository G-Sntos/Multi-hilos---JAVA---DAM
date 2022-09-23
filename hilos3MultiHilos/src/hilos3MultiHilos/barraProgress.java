package hilos3MultiHilos;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class barraProgress extends JFrame implements Runnable{
	public static JProgressBar progressBar = new JProgressBar();
 
	public barraProgress() {
			 this.setSize(300,150);
			 this.setTitle("MultiHilos");
			 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 this.setResizable(false);
			 progressBar.setValue(0);
			 progressBar.setStringPainted(true);
			 this.add(progressBar);
			 this.setVisible(true); 
			
 	}
 


@Override
public void run() {
	//Rellenar la barra cuando lo llaman con Thread.start()
	int i = 0;
    try {
        while (i <= 100) {
        	progressBar.setValue(i + 5);
            Thread.sleep(1000);
            i += 5;
        }
    }
    catch (Exception e) {
    }
}


}


