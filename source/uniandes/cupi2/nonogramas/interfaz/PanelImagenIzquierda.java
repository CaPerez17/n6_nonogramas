package uniandes.cupi2.nonogramas.interfaz;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * Created by DGromov on 2016-05-03.
 */
public class PanelImagenIzquierda extends JPanel {

    public PanelImagenIzquierda( ){
        JLabel imagen = new JLabel();
        ImageIcon icono = new ImageIcon("data/imagenes/izquierda.jpg");
        imagen = new JLabel( "" );
        imagen.setIcon( icono );
        add( imagen );
    }
}
