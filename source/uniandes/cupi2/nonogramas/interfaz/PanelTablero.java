package uniandes.cupi2.nonogramas.interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.nonogramas.mundo.CampoJuego;
import uniandes.cupi2.nonogramas.mundo.Casilla;

/**
 * Created by DGromov on 2016-05-03.
 */
public class PanelTablero extends JPanel implements ActionListener {


    // Atributos
    /**
     * Es una referencia a la clase principal de la interfaz.
     */
    private InterfazNonogramas ventanaPrincipal;



    // Atributos de Interfaz

    /**
     * Botones de las casillas
     */
    private  JToggleButton[][] botonesCasillas;

    private int ancho;

    private int alto;
    ;

    public PanelTablero( InterfazNonogramas principal ){

        ventanaPrincipal = principal;
        setBorder(new TitledBorder("Tabla de Juego"));
        setLayout(new GridLayout(7, 7));
        botonesCasillas = new JToggleButton[7][7];

        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 7; j++) {
                botonesCasillas[i][j] = new JToggleButton();
                add(botonesCasillas[i][j]);
                botonesCasillas[i][j].setEnabled(false);
            }
        }
        if(!ventanaPrincipal.juegovacio()){
            inicializar(ventanaPrincipal.darcampojuego());
        }

    }

    public void inicializar(CampoJuego campoJuego) {

        int[][] pistasfilas = campoJuego.darPistasFilas();
        int[][] pistascolumnas = campoJuego.darPistasColumnas();
        for (int i = 0; i < 2; i++){
            for (int j = 2; j< 7; j++){
                JToggleButton boton = botonesCasillas[i][j];
                if ( pistascolumnas[j-2][i] != 0 ){
                    boton.setText(Integer.toString(pistascolumnas[j-2][i]));
                }
                boton.setEnabled(false);
            }
        }

        for (int i = 2; i < 7; i++){
            for (int j = 0; j < 2; j++){
                JToggleButton boton = botonesCasillas[i][j];
                if (pistasfilas[i-2][j] != 0){
                    boton.setText(Integer.toString(pistasfilas[i-2][j]));
                }
                boton.setEnabled(false);
            }
        }

    }

    public void actualizar( CampoJuego campoJuego){

        inicializar(campoJuego);

        


        // Realiza un ciclo que recorre cada una de las casillas, cambia su estado y repinta su estado.
        for (int i = 2; i < 7; i++){
            for (int j = 2; j < 7; j++){
                JToggleButton boton = botonesCasillas[i][j];
                boton.setText( "" );
                boton.setEnabled( true );
                botonesCasillas[ i ][ j ].addActionListener( this );
                botonesCasillas[ i ][ j ].setActionCommand( i + "," + j );
                boton.setIcon(new ImageIcon("./data/imagenes/casilla_blanco.jpg"));
                boton.setSelectedIcon(new ImageIcon("./data/imagenes/casilla_rellena.png"));
            }
        }

    }

    public void reiniciar(){
        for (int i = 2; i < 7; i++) {
            for (int j = 2; j < 7; j++) {
            if(botonesCasillas[i][j].isSelected()){
                    botonesCasillas[i][j].setSelected(false);
                }
            }
        }

    }

    public void actionPerformed( ActionEvent evento )
    {


        String comando = evento.getActionCommand( );

        String[] coordenada = comando.split( "," );
        int i = Integer.parseInt( coordenada[ 0 ] );
        int j = Integer.parseInt( coordenada[ 1 ] );
        ventanaPrincipal.jugar( i - 2 , j - 2 );

    }

}
