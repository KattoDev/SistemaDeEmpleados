/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assets.Fonts;

import java.awt.Font;
import java.io.InputStream;

/**
 *
 * @author alexi
 */
public class Fonts {
    private Font font = null;
    public String BungeeRegular = "Bungee-Regular.ttf";
   
    /* Font.PLAIN = 0 , Font.BOLD = 1 , Font.ITALIC = 2
     * tamanio = float
     */
     
    public Font CustomFont( String fontName, int style, float size)
    {
         try {
            //Se carga la fuente
            InputStream is =  getClass().getResourceAsStream(fontName);
            font = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (Exception ex) {
            //Si existe un error se carga fuente por defecto ARIAL
            System.err.println(fontName + " No se cargo la fuente");
            font = new Font("Arial", Font.PLAIN, 14);            
        }
        Font tfont = font.deriveFont(style, size);
        return tfont;
    }
}
    


    