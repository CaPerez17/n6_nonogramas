package uniandes.cupi2.nonogramas.mundo;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * Clase que controla la matriz 5x5 del juego
 */
public class CampoJuego {

    // Constantes

    /**
     * Número de columnas en el juego
     */
    public static final int COLUMNAS = 5;

    /**
     * Número de filas en el juego
     */
    public static final int FILAS = 5   ;

    // Atributos
    /**
     * Nombre del juego
     */
    private String nombre;

    /**
     * Es el campo de Juego. <br>
     * Cada elemento de la matriz es una casilla
     */
    private Casilla[][] casillasCampoJuego;

    private int[][] pistasColumnas;

    private int[][] pistasFilas;

    private boolean juegovacio;


    // Constructores

    public CampoJuego() {
        juegovacio = true;
    }



    public CampoJuego (File arch ) throws Exception {

        Properties datos = cargarInfoJuego( arch );
        nombre = datos.getProperty("nonograma.nombreProblema");
        pistasColumnas = new int[5][5];
        pistasFilas = new int[5][5];
        parsearPistas( datos, pistasColumnas, pistasFilas );
        casillasCampoJuego = new Casilla[5][5];
        parsearCasillas( datos, casillasCampoJuego );
        juegovacio = false;

    }

    private void parsearCasillas(Properties datos, Casilla[][] casillasCampoJuego) {
        int[][] matrizdecasillas = new int[5][5];
        String strtableroFila = "nonograma.tableroFila";
        for (int i = 1; i < 6; i++){
            String contenido = datos.getProperty(strtableroFila + i);
            for (int j = 0; j < contenido.length(); j++) {
                matrizdecasillas[i-1][j] = Character.getNumericValue(contenido.charAt(j));
            }
        }
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                casillasCampoJuego[i][j] = new Casilla(i, j, matrizdecasillas[i][j] != 0);
            }
        }
    }

    private void parsearPistas(Properties datos, int[][] pistasC, int[][] pistasF) {
        for (int i = 1; i < 6; i++){
            String pistaarevisar = "nonograma.pistas";
            String[] contenido = datos.getProperty(pistaarevisar + "Columna" + i).split(";");
            String[] contenidoF = datos.getProperty(pistaarevisar + "Fila" + i).split(";");
            int[] intcontenido = new int[2];
            intcontenido[0] = Integer.parseInt(contenido[0]);
            intcontenido[1] = Integer.parseInt(contenido[1]);
            pistasC[i-1] = intcontenido;
            int[] intcontenidoF = new int[2];
            intcontenidoF[0] = Integer.parseInt(contenidoF[0]);
            intcontenidoF[1] = Integer.parseInt(contenidoF[1]);
            pistasF[i-1] = intcontenidoF;
        }

    }

    private Properties cargarInfoJuego( File arch ) throws Exception {
        Properties datos = new Properties( );
        FileInputStream in = new FileInputStream( arch );
        try
        {
            datos.load( in );
            in.close();
        } catch (Exception e) {
            throw new Exception( "Formato inválido" );
        }
        return datos;
    }

    public Casilla darCasilla(int fila, int columna){ return casillasCampoJuego[ fila ][ columna ];}

    public int[] darCasillasCorrectaporFila(){
        int[] casillasCorrectas = new int[5];
        for (int i = 0; i < 5; i++){
            int correctas = 0;
            for (int j = 0; j < 5 ; j++) {
                Casilla casillaarevisar = casillasCampoJuego[i][j];
                if (casillaarevisar.darMarcado() == casillaarevisar.darpFigura()){
                    correctas += 1;
                }
            }
            casillasCorrectas[i] = correctas;
        }
        return casillasCorrectas;
    }

    public int[] darCasillasCorrectaporColumna(){
        int[] casillasCorrectas = new int[5];
        for (int i = 0; i < 5; i++){
            int correctas = 0;
            for (int j = 0; j < 5 ; j++) {
                Casilla casillaarevisar = casillasCampoJuego[j][i];
                if (casillaarevisar.darMarcado() == casillaarevisar.darpFigura()){
                    correctas += 1;
                }
            }
            casillasCorrectas[i] = correctas;
        }
        return casillasCorrectas;
    }
    /**
     * Método 1 de extensión al ejemplo
     * @return respuesta
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método 2 de extensión al ejemplo
     * @return respuesta
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }


    public Casilla[][] darCasillas() {
        return casillasCampoJuego;
    }

    public boolean darjuegovacio() {
        return juegovacio;
    }

    public int[][] darPistasFilas(){ return pistasFilas; }

    public int[][] darPistasColumnas() { return pistasColumnas; }

    public boolean ganador() {
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                if(casillasCampoJuego[i][j].darMarcado() != casillasCampoJuego[i][j].darpFigura()){
                    return false;
                }
            }
        }
        return true;
    }

    public String darNombre() {
        return nombre;
    }
}
