import javax.swing.*;
import java.awt.*;

public class Snake {
    public static void main(String [ ] args)
    {
        int Width = 600;
        int Height = Width;

        JFrame Frame = new JFrame("Snake");
        Frame.setBounds(0,0,Width,Height);
        Frame.setLocationRelativeTo(null);
        Frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Frame.setResizable(false);

        Game game = new Game(Width,Height);
        Frame.add(game);
        Frame.pack();
        game.requestFocus();
        Frame.setVisible(true);

    }
}
