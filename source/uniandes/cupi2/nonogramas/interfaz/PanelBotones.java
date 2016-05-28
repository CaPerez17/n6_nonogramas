package uniandes.cupi2.nonogramas.interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * Created by DGromov on 2016-05-03.
 */
public class PanelBotones extends JPanel implements ActionListener {
    private static final String BOTON_CARGAR = "CARGAR";

    private static final String BOTON_REINICIAR = "REINICIAR";

    // Atributos

    private JButton botonCargar;

    private JButton botonReiniciar;

    private InterfazNonogramas ventanaPrincipal;

    public PanelBotones(InterfazNonogramas in){
        ventanaPrincipal = in;

        setBorder( new TitledBorder( "Nuevo Juego" ) );
        setLayout( new GridLayout( 1, 2 ) );

        botonCargar = new JButton("Cargar");
        botonCargar.setActionCommand(BOTON_CARGAR);
        botonCargar.addActionListener(this);
        add(botonCargar);

        botonReiniciar = new JButton("Reiniciar");
        botonReiniciar.setActionCommand(BOTON_REINICIAR);
        botonReiniciar.addActionListener(this);
        add(botonReiniciar);
    }

    // Métodos
    @Override
    public void actionPerformed(ActionEvent evento) {
        String comando = evento.getActionCommand();

        if (BOTON_CARGAR.equals( comando )){
            ventanaPrincipal.cargar();
        }
        if (BOTON_REINICIAR.equals( comando )){
            ventanaPrincipal.reiniciar();
        }
    }


}
