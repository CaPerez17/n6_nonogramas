package uniandes.cupi2.nonogramas.interfaz;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.*;


import uniandes.cupi2.nonogramas.mundo.CampoJuego;
/**
 * Created by DGromov on 2016-05-03.
 */
public class InterfazNonogramas extends JFrame {

    private static final int ANCHO = 800;

    private static final int ALTO = 450;

    private CampoJuego campoJuego;

    private PanelImagenArriba panelImagenArriba;

    private PanelImagenDerecha panelImagenDerecha;

    private PanelImagenIzquierda panelImagenIzquierda;

    private PanelBotonesAbajo panelBotonesAbajo;

    private PanelTablero panelTablero;

    private PanelBotones panelBotones;
    private File ultimo = null;

    public InterfazNonogramas() {
        campoJuego = new CampoJuego();
        setTitle("nonogramas");
        setLayout(new BorderLayout());
        setSize(ANCHO + 50, ALTO + 250);
        setResizable(true);
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );

        JPanel pcentro = new JPanel(new BorderLayout());

        panelTablero = new PanelTablero(this);

        //Inicialización de los botones
        panelBotonesAbajo = new PanelBotonesAbajo( this );

        panelBotones = new PanelBotones( this );


        // Creación de los paneles aquí
        panelImagenArriba = new PanelImagenArriba( );
        add(panelImagenArriba, BorderLayout.NORTH);
        panelImagenDerecha = new PanelImagenDerecha();
        add(panelImagenDerecha, BorderLayout.EAST);
        panelImagenIzquierda = new PanelImagenIzquierda();
        add(panelImagenIzquierda, BorderLayout.WEST);
        add(panelBotonesAbajo, BorderLayout.SOUTH);

        pcentro.add(panelTablero);
        pcentro.add(panelBotones, BorderLayout.SOUTH);


        add(pcentro, BorderLayout.CENTER);


        // centrar la ventana
        setLocationRelativeTo( null );

        // Inicializa el mundo
    }

    public void reqFuncOpcion1( )
    {
        String resultado = campoJuego.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método para la extensión 2
     */
    public void reqFuncOpcion2( )
    {
        String resultado = campoJuego.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    public static void main( String[] pArgs){
        InterfazNonogramas interfaz = new InterfazNonogramas();
        interfaz.setVisible( true );
    }

    public void jugar(int i, int j) {
        campoJuego.darCasilla(i,j).cambiarMarcado();
        if(campoJuego.ganador()){
            JOptionPane.showMessageDialog( this, "Haz encontrado la respuesta correcta: \n" + campoJuego.darNombre(), "Respuesta: \n" + campoJuego.darNombre(), JOptionPane.INFORMATION_MESSAGE );
        }


    }

    public boolean juegovacio(){
        return (campoJuego.darjuegovacio());
    }

    public void correctasporfilas() {
        if (juegovacio()){
            JOptionPane.showMessageDialog( this, "No hay ningún juego en curso.", "Respuesta", JOptionPane.INFORMATION_MESSAGE );
        }
        else {
            String resultado = "";
            int[] filascorrectas = campoJuego.darCasillasCorrectaporFila();
            for (int i = 0; i < 5; i++){
                resultado = resultado + "Fila" + (i+ 1)+ ":" + " " + filascorrectas[i] + " casillas correctas\n";
            }
            JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );

        }
    }

    public void correctasporcolumnas() {
        if (juegovacio()){
            JOptionPane.showMessageDialog( this, "No hay ningún juego en curso.", "Respuesta", JOptionPane.INFORMATION_MESSAGE );
        }
        else {
            String resultado = "";
            int[] columnascorrectas = campoJuego.darCasillasCorrectaporColumna();
            for (int i = 0; i < 5; i++){
                resultado = resultado + "Columna" + (i+1)+ ":" + "" + columnascorrectas[i] + " casillas correctas\n";
            }
            JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );

        }
    }

    public void reiniciar() {
        if (juegovacio()){
            JOptionPane.showMessageDialog( this, "No hay ningún juego en curso.", "Respuesta", JOptionPane.INFORMATION_MESSAGE );
        }
        else {
            panelTablero.reiniciar();
            try {
                campoJuego = new CampoJuego(ultimo);
            }catch(Exception e){JOptionPane.showMessageDialog(this, "El archivo no tiene el formato esperado", "Error", JOptionPane.ERROR_MESSAGE);}
        }
    }

    public void cargar() {
        JFileChooser fc = new JFileChooser("./data");
        fc.setDialogTitle("Seleccionar Archivo");
        int resultado = fc.showOpenDialog( this );
        if (resultado == JFileChooser.APPROVE_OPTION )
        {
            File archivoNonograma = fc.getSelectedFile();
            try{
                campoJuego = new CampoJuego(archivoNonograma);
                panelTablero.actualizar(campoJuego);
                ultimo = archivoNonograma;
            }catch (Exception e){
                campoJuego = null;
                JOptionPane.showMessageDialog(this, "El archivo no tiene el formato esperado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (resultado == JFileChooser.CANCEL_OPTION){
            JOptionPane.showMessageDialog(this, "Debe seleccionar un archivo de configuración para poder jugar.", "Empezar a jugar", JOptionPane.OK_OPTION);
            cargar();
        }

    }

    public CampoJuego darcampojuego() {
        return campoJuego;
    }
}
