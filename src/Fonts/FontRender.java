package Fonts;

import java.awt.*;
import java.io.*;

public class FontRender {

    public static Font getProgressStyle() {
        try {
            InputStream myStream = new BufferedInputStream(new FileInputStream("Fonts/Progress.ttf"));
            Font fontHelsky = Font.createFont(Font.TRUETYPE_FONT, myStream);
            return fontHelsky.deriveFont(Font.PLAIN, 80);
        } catch (Exception e) {
            System.err.println(e);
            return new Font(Font.DIALOG, Font.BOLD, 50);
        }
    }

    public static Font getNewsPaperStyle() {
        try {
            Font font =  Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/NewsPaper.ttf"));
            return font.deriveFont(Font.PLAIN, 80);
        } catch (Exception e) {
            System.err.println(e);
            return new Font(Font.DIALOG, Font.BOLD, 20);
        }
    }

    public static Font getNewsPaperStyle2() {
        try {
            Font font =  Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/NewsPaper.ttf"));
            return font.deriveFont(Font.PLAIN, 30);
        } catch (Exception e) {
            System.err.println(e);
            return new Font(Font.DIALOG, Font.BOLD, 20);
        }
    }

    public static Font getRemachineStyle() {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/Remachine.ttf"));
            return font.deriveFont(Font.PLAIN, 30);
        } catch (Exception e) {
            System.err.println(e);
            return new Font(Font.DIALOG, Font.BOLD, 20);
        }
    }

    public static Font getHelskyStyle() {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/Helsky.ttf"));
            return font.deriveFont(Font.PLAIN, 80);
        } catch (Exception e) {
            System.err.println(e);
            return new Font(Font.DIALOG, Font.BOLD, 20);
        }
    }

    public static Font getHelskyStyle2() {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/Helsky.ttf"));
            return font.deriveFont(Font.PLAIN, 45);
        } catch (Exception e) {
            System.err.println(e);
            return new Font(Font.DIALOG, Font.BOLD, 20);
        }
    }
}
