package Vistas;
import Codigo.*;
//a
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * VentanaAsientos es un JPanel que se instancia en el JFrame Ventana
 * que dependiendo de lo elegido anteriormente mostrará una cantidad
 * específica de asientos (algunos premium) para ser seleccionados
 * los cuales a la hora de ser seleccionados mostrarán por la terminal que fueron
 * seleccionados
 * @author Alan Yuren Ibacache Gonnelli
 * @author Juan Agustín Umaña Silva
 */
        public class VentanaAsientos extends JPanel{
            private ImageIcon icon = new ImageIcon ("src/main/resources/asientos.png");
            private ImageIcon icon2 = new ImageIcon ("src/main/resources/asientopremium.png");
            private static JButton[][] sillas;
            private Buses busSelec;
            int NumeroDeAsientos = 0;
            private String ruta;
            private String horario;
            public VentanaAsientos(int n, Buses b, String ruta, String horario) throws a {
                if(b==null){
                    throw new a();
                }
                this.horario = horario;
                this.ruta = ruta;
                this.NumeroDeAsientos = n;
                this.busSelec = cargar();
                int filas = busSelec.getFilas();

                int columnas = busSelec.getColumnas();

                sillas = new JButton[filas*2][columnas/2];

                setLayout(new GridLayout(filas*2,columnas/2));

                this.setBackground(new Color(0x083563));


                for (int i = 0; i < sillas.length; i++) {

                    for (int j = 0; j < sillas[i].length; j++) {

                        Image imagenOriginal = (i < filas / 2) ? icon.getImage() : icon2.getImage();

                        Image imagenEscalada = imagenOriginal.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

                        ImageIcon iconEscalado = new ImageIcon(imagenEscalada);

                        sillas[i][j] = new JButton(iconEscalado);

                        EstilosListener(sillas[i][j],busSelec.getIterator(),i,j);

                        VentanaAsientos.this.add(sillas[i][j]);
                    }
                }

            }

            public void setBusSelec(Buses busSelec) {
                this.busSelec = busSelec;
            }
            public void EstilosListener(JButton btn, MatrixIterator iterator,int filas, int columnas){
                if(iterator.getElement(filas,columnas) == 1){
                    btn.setBackground(new Color(0x830808));
                }

                btn.setBackground(new Color(0xEEA31D));
                btn.setForeground(new Color(0,0,0));
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        /*iterator.setElementAt(1,filas,columnas);
                        btn.setBackground(new Color(0x830808));*/
                        if (iterator.getElement(filas, columnas) == 1) {
                            // El asiento está ocupado, realiza alguna acción o notifica al usuario.
                            System.out.println("El asiento está ocupado.");
                        } else {
                            // El asiento está libre, puedes marcarlo como ocupado y cambiar el estilo.
                            iterator.setElementAt(1, filas, columnas);
                            btn.setBackground(new Color(0x830808));
                        }
                    }
                });
            }
            public Buses cargar(){
                String rutaCarpeta = "src/main/datos";
                File carpeta = new File(rutaCarpeta);
                String archivo = ruta +"-"+ horario +"-"+ NumeroDeAsientos + ".dat";
                return Buses.CargarBus(carpeta.getPath() + "/" + archivo);
            }
            public void guardar(){
                String rutaCarpeta = "src/main/datos";
                File carpeta = new File(rutaCarpeta);
                String archivo = ruta +"-"+ horario +"-"+ NumeroDeAsientos + ".dat";
                Buses.GuardarBus(busSelec,carpeta.getPath() + "/" +archivo);
            }
        }
