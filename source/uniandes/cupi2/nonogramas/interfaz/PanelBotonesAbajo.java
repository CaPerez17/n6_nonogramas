package uniandes.cupi2.nonogramas.interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * Created by DGromov on 2016-05-03.
 */
public class PanelBotonesAbajo extends JPanel implements ActionListener {



    private static final String BOTON_CORRECTASPORFILAS = "Correctas por Filas";

    private static final String BOTON_CORRECTASPORCOLUMNAS = "Correctas por Columnas";

    private static final String OPCION_1 = "OPCION_1";

    private static final String OPCION_2 = "OPCION_2";

    // Atributos

    private InterfazNonogramas ventanaPrincipal;

    // Atributos de Interfaz

    private JButton botonCPorFilas;

    private JButton botonCPorColumnas;

    /**
     * Es el botón para realizar la opción 1
     */
    private JButton opcion1;

    /**
     * Es el botón para realizar la opción 2
     */
    private JButton opcion2;

    // Constructores

    public PanelBotonesAbajo(InterfazNonogramas in) {

        ventanaPrincipal = in;

        setBorder( new TitledBorder( "Opciones" ) );
        setLayout( new GridLayout( 1, 2 ) );


        botonCPorFilas = new JButton("Correctas por fila");
        botonCPorFilas.setActionCommand(BOTON_CORRECTASPORFILAS);
        botonCPorFilas.addActionListener(this);
        add(botonCPorFilas );

        botonCPorColumnas = new JButton("Correctas por columna");
        botonCPorColumnas.setActionCommand(BOTON_CORRECTASPORCOLUMNAS);
        botonCPorColumnas.addActionListener(this);
        add(botonCPorColumnas);

        // inicializa el boton de la opción 1
        opcion1 = new JButton("Opción 1");
        opcion1.setToolTipText("Opción 1");
        opcion1.setActionCommand(OPCION_1);
        opcion1.addActionListener(this);
        add(opcion1);

        // inicializa el boton de la opción 2
        opcion2 = new JButton("Opción 2");
        opcion2.setToolTipText("Opcion 2");
        opcion2.setActionCommand(OPCION_2);
        opcion2.addActionListener(this);
        add(opcion2);
    }

    // Métodos
    @Override
    public void actionPerformed(ActionEvent evento) {
        String comando = evento.getActionCommand();

        if( BOTON_CORRECTASPORFILAS.equals( comando ) ){
            ventanaPrincipal.correctasporfilas();
        }
        else if (BOTON_CORRECTASPORCOLUMNAS.equals( comando )){
            ventanaPrincipal.correctasporcolumnas();
        }
        else if( OPCION_1.equals( comando ) )
        {
            ventanaPrincipal.reqFuncOpcion1( );
        }
        else if( OPCION_2.equals( comando ) )
        {
            ventanaPrincipal.reqFuncOpcion2( );
        }
    }



}
