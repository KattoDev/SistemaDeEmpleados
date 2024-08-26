/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assets.Fonts;

import java.awt.Font;
import java.io.InputStream;

/**
 * @author alexi
 */
public class Fonts {
  private Font font = null;

  // font list
  final String lilitaOne = "LilitaOne-Regular.ttf";
  final String Inter = "Inter_24pt-Regular.ttf";

  public String getLilitaOne() {
    return lilitaOne;
  }

  public String getInter() {
    return Inter;
  }

  /**
   * @param fontName The font name to set.
   * @param style
   *     <ul>
   *       <li>Font.PLAIN = 0
   *       <li>Font.BOLD = 1
   *       <li>Font.ITALIC = 2
   *     </ul>
   *
   * @param size The font size in px
   * @return The font created by the method.
   */
  public Font CustomFont(String fontName, int style, float size) {
    try {
      // Se carga la fuente
      InputStream is = getClass().getResourceAsStream(fontName);
      font = Font.createFont(Font.TRUETYPE_FONT, is);
    } catch (Exception ex) {
      // Si existe un error se carga fuente por defecto ARIAL
      System.err.println(fontName + " No se cargo la fuente");
      font = new Font("Arial", Font.PLAIN, 14);
    }
    Font tfont = font.deriveFont(style, size);
    return tfont;
  }
}
