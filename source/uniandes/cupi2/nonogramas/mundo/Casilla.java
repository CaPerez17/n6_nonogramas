package uniandes.cupi2.nonogramas.mundo;

/**
 * 
 * clase que representa una casilla del campo de juego.
 */
public class Casilla {

    // Constantes
    /**
     * Constante de la imagen que corresponde a las casillas no marcadas. 
     */
    public static final String NOMARCADA_IMAGEN = "./data/imagenes/casilla_blanco.jpg";

    /**
     * Constante de la imagen que corresponde a las casillas marcadas.
     */
    public static final String MARCADA_IMAGEN = "./data/imagenes/casilla_rellena.png";

    // Atributos

    /**
     * Posición horizontal de la casilla.
     */
    private int fila;

    /**
     * Posición vertical de la casilla.
     */
    private int columna;

    /**
     * Indica si la casilla hace parte de una figura de juego.
     */
    private boolean pFigura;

    /**
     * Indica si la casilla esta marcada por el usuario.
     */
    private boolean marcada;

    // Constructores

    /**
     * Construye una nueva casilla TODO DOCUMENTATION
     */
    public Casilla( int laFila, int laColumna ){
        fila = laFila;
        columna = laColumna;
        marcada = false;
    }

    /**
     * Construye una nueva casilla si existe que es parte de la pfigura
     */
    public Casilla( int laFila, int laColumna, boolean parteFigura){
        this(laFila,laColumna);
        this.pFigura = parteFigura;
    }

    // Métodos

    /**
     * Retorna si esta marcado o no marcado la casilla
     */
    public boolean darMarcado() { return marcada; }

    /**
     * Retorna si esta casilla hace parte de una figura
     */
    public boolean darpFigura() { return pFigura; }

    /**
     * Devuele el número fila de la casilla
     */
    public int darFila() { return fila; }

    /**
     * Devuelve el número de columna
     */
    public int darColumna() { return columna; }

    /**
     * Modifica el estado de Marcado
     */
    public void cambiarMarcado(){
        marcada = !marcada;
    }

    /**
     * Retorna la imagen que debe mostrarse según si esta marcada o no
     */
    public String darImagen( ){
        if (marcada){
            return MARCADA_IMAGEN;
        }
        else return NOMARCADA_IMAGEN;
    }


}
