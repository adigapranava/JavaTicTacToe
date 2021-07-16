package frontEnds;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import Fonts.FontRender;

public class frontEndUtil {
    int SIZE = 700;
    int BOARD_SIZE = 500;
    int CELL_SIZE = BOARD_SIZE/3;

    /* Color BACKGROUND_COLOR = new Color(0x1c1c1c);
    Color CELL_COLOR = new Color(0x2a2a2a);
    Color O_COLOR = new Color(0xed6364);
    Color X_COLOR = new Color(0x56b8fb);
    Color TEXT_COLOR = new Color(0x9e9e9e);
    Color TEXT_COLOR_LITE = new Color(0x3e3e3e);
    Color WINNING_PAIRS = new Color(0x63ed9c); */

    Color BACKGROUND_COLOR = new Color(0x1c1c1c);
    Color CELL_COLOR = new Color(0x2a2a2a);
    Color O_COLOR = new Color(0xeded63);
    Color X_COLOR = new Color(0x63ebed);
    Color TEXT_COLOR = new Color(0xefefef);
    Color TEXT_COLOR_LITE = new Color(0x3e3e3e);
    Color WINNING_PAIRS = new Color(0x63ed9c);

    Font fontHelsky = FontRender.getHelskyStyle();
    Font fontHelsky2 = FontRender.getHelskyStyle2();
    Font fontNewsPaper = FontRender.getNewsPaperStyle();
    Font fontNewsPaper2 = FontRender.getNewsPaperStyle2();
    Font fontReMachine = FontRender.getRemachineStyle();

    Border borderCell = BorderFactory.createLineBorder(BACKGROUND_COLOR, 3);
}
