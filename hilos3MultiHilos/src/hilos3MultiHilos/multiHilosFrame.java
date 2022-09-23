package hilos3MultiHilos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.JTextComponent;

public class multiHilosFrame extends JFrame {
	JMenu menu;
	JMenuBar menuBar;
	JMenuItem menuItem1,menuItem2;
	JButton mostrarCoche= new JButton();
	JButton salirPrograma= new JButton();
	public JTextArea montajeYPieza = new JTextArea();
	private int cantidad;
	private boolean error;
	
	

	public multiHilosFrame() {
				//Base frame del menu
				this.setLayout(new FlowLayout(FlowLayout.CENTER,20,20)); 
				this.setSize(500, 350);
				this.setTitle("MultiHilos");
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.setResizable(false);
				this.getContentPane().setBackground(new Color(249, 112, 104));
				//montar buttones
				mostrarCoche.setFocusable(false);
				mostrarCoche.setText("Mostrar Coches");
				mostrarCoche.setPreferredSize(new Dimension(200,50));
				
				salirPrograma.setFocusable(false);
				salirPrograma.setText("Salir");
				salirPrograma.setPreferredSize(new Dimension(200,50));
				
				//fin montar buttones
				
				//Menu
				menuBar = new JMenuBar();// iniciar barra de menu
				menu = new JMenu("Informacion");
				menuItem2 = new JMenuItem("INFO");
				menu.add(menuItem2);
				menuBar.add(menu);//añadir menu al la barra
				//fin Menu
				//TextArea
				montajeYPieza.setPreferredSize(new Dimension(450,200));
				//Acciones 
				mostrarCoche.addActionListener(e->{
					try {
						cantidad=Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad","Multi-Hilos 3", JOptionPane.INFORMATION_MESSAGE));
						if(cantidad > 0) {
							setError(false);	
						}else {
							JOptionPane.showMessageDialog(null, "Error debe ser un numero mas que 0","Multi-Hilos Error",JOptionPane.WARNING_MESSAGE);
						}
						
					} catch (Exception xx) {
						JOptionPane.showMessageDialog(null, "Error debe ser un numero","Multi-Hilos Error",JOptionPane.WARNING_MESSAGE);
						setError(true);
					}
					if(!isError()) {
						//si el numero de cantidad es más que 0, inicia los 3 hilos
						///////////////////////////////
						//reloj digital inicio
						hilosRelojDigital reloj = new hilosRelojDigital();
						Thread relojThread = new Thread(reloj);
						relojThread.start();
						//reloj digital fin
						///////////////////////////////
						 
						//montaje de coche inicio
						montajeCoche montaje = new montajeCoche(getCantidad());
						piezasDelCoche motor = new piezasDelCoche("motor",getCantidad());
						piezasDelCoche lunas = new piezasDelCoche("lunas",getCantidad());
						piezasDelCoche ruedas = new piezasDelCoche("ruedas",getCantidad());
						piezasDelCoche electricidad = new piezasDelCoche("electricidad",getCantidad());
						piezasDelCoche accesorios = new piezasDelCoche("accesorios",getCantidad());
						//
						Thread xx = new Thread(montaje);
						Thread p1 = new Thread(motor);
						Thread p2= new Thread(lunas);
						Thread p3= new Thread(ruedas);
						Thread p4= new Thread(electricidad);
						Thread p5= new Thread(accesorios);
						//
						xx.start();
						p1.start();
						p2.start();
						p3.start();
						p4.start();
						p5.start();
						
						
						//montaje de coche fin
						///////////////////////////////
						//barra de progresso inicio
						 barraProgress barraProgress = new barraProgress();
						 Thread barraThreads = new Thread(barraProgress);
						 barraThreads.start();
						
						//barra de progresso fin
					}
					
				});
				salirPrograma.addActionListener(e->{
					System.exit(0);
				});
				//Añadir el button al JFrame
				this.add(mostrarCoche);
				this.add(salirPrograma);
				this.add(montajeYPieza);
				//Para que sea visible el JFrame
				this.setVisible(true);
		}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public void jTextArea(String resultado) throws IOException {
		montajeYPieza.append(resultado);
	}
	
	
}
