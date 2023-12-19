package Vistas;
import Codigo.BusA;
import Codigo.BusB;
import Codigo.BusC;
import Codigo.Buses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
            private JLabel labelSeleccionado;
            private VentanaBuses ventanaBuses;
            private Buses busSelec;
            private HashMap<JLabel, Buses> mapa;
            int NumeroDeAsientos = 0;
            public VentanaAsientos(int n,Buses b){
                this.NumeroDeAsientos = n;
                ventanaBuses = new VentanaBuses(DatosCompartidos.getRuta());
                ventanaBuses.setVisible(false);

                /*Buses busSeleccionado = ventanaBuses.getBusSeleccionado();
                if (busSeleccionado != null) {
                    busSlec(busSeleccionado);
                }*/

                int filas = b.getFilas();
                int columnas = b.getColumnas();
                sillas = new JButton[filas*2][columnas/2];
                setLayout(new GridLayout(filas*2,columnas/2));
                this.setBackground(new Color(0x083563));
                for (int i = 0; i < sillas.length; i++) {
                    for (int j = 0; j < sillas[i].length; j++) {
                        Image imagenOriginal = (i < filas / 2) ? icon.getImage() : icon2.getImage();
                        Image imagenEscalada = imagenOriginal.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                        ImageIcon iconEscalado = new ImageIcon(imagenEscalada);
                        sillas[i][j] = new JButton(iconEscalado);
                        Estilos(sillas[i][j]);
                        VentanaAsientos.this.add(sillas[i][j]);
                    }
                }
                /*for(int i=0; i<NumeroDeAsientos;i++) {
                    z=i;
                    Image imagenOriginal = (i < NumeroDeAsientos / 2) ? icon.getImage() : icon2.getImage();
                    Image imagenEscalada = imagenOriginal.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
                    ImageIcon iconEscalado = new ImageIcon(imagenEscalada);
                sillas[i]= new JButton(iconEscalado);
                    if(c.getPisos()==1 && c.getAsientos()==20) {
                        if (i < NumeroDeAsientos / 2) {
                        sillas[i].setBounds(500, i * 35, 30, 30);
                    } else {
                        sillas[i].setBounds(550, y * 35, 30, 30);
                        y++;
                    }
                    }
                    if(c.getPisos()==1 && c.getAsientos()==30) {
                        if (i < NumeroDeAsientos / 2) {
                            sillas[i].setBounds(500, i * 30, 25, 25);
                        } else {
                            sillas[i].setBounds(550, y * 30, 25, 25);
                            y++;
                        }
                    }
                    if(c.getPisos()==2){
                    if (i < NumeroDeAsientos / 4) {
                        sillas[i].setBounds(450, i * 25, 20, 20);
                    } else if(i < NumeroDeAsientos /2)  {
                        sillas[i].setBounds(40, y * 25, 20, 20);
                        y++;
                    }
                    else if(i < NumeroDeAsientos *3/4)  {
                        sillas[i].setBounds(80, w * 25, 20, 20);
                        w++;
                    }else{
                        sillas[i].setBounds(120, v * 25, 20, 20);
                        v++;
                        sillas[i].setBounds(500, y * 25, 20, 20);
                        y++;
                    }if(i < NumeroDeAsientos *3/4)  {
                        sillas[i].setBounds(550, w * 25, 20, 20);
                        w++;}
                    else   {
                        sillas[i].setBounds(600, v * 25, 20, 20);
                        v++;}
                    }
                    int finalZ = z;
                    if(i < NumeroDeAsientos /2) {
                    int finalI = i;
                    sillas[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(asientos[finalI]==0) {
                                System.out.print("acaba de comprar el asiento " + finalZ + " " );
                                asientos[finalI]=1;
                            }
                            else{
                                System.out.print("usted ya compró el asiento " + finalZ+ " " );
                            }
                        }
                    });
                    //tengo que cambiarle el tamaño a la imagen
                    this.add(sillas[i]);
                }else{
                    int finalI = i;
                    sillas[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (asientos[finalI] == 0) {
                                System.out.print("acaba de comprar el asiento (premium) " + finalZ+ " " );
                                asientos[finalI]=1;
                            }
                            else{
                                System.out.print("usted ya compró el asiento " + finalZ+ " " );
                            }
                        }
                    });
                    //tengo que cambiarle el tamaño a la imagen
                    this.add(sillas[i]);
                    }
                }*/
            }

            public void setBusSelec(Buses busSelec) {
                this.busSelec = busSelec;
            }

            public void setMapa(HashMap<JLabel, Buses> mapa) {
                this.mapa = mapa;
            }

            public void busSlec(Buses bus) {
                this.busSelec = bus;
                NumeroDeAsientos = busSelec.getAsientos();
                System.out.println(busSelec.getAsientos());
                sillas = new JButton[bus.getFilas()][bus.getColumnas()];
            }
            public void Estilos(JButton btn){
                btn.setBackground(new Color(0xEEA31D));
                btn.setForeground(new Color(0,0,0));
            }
        }
