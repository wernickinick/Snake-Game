import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.ArrayList;
import javax.swing.*;

public class Game extends JPanel implements ActionListener{

    private class Tile
    {
        int x;
        int y;

        Tile(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    int GameBoardWidth;
    int GameBoardHeight;
    int TileSize = 25;

    //Snake
    Tile Snakehead;
    Random random;

    //Food
    Tile Food;

    //Game Logic
    Timer GameLoop;

    Game(int GameBoardWidth, int GameBoardHeight)
    {
        this.GameBoardWidth = GameBoardWidth;
        this.GameBoardHeight = GameBoardHeight;
        setPreferredSize(new Dimension(this.GameBoardWidth,this.GameBoardHeight));
        setBackground(Color.BLACK);

        Snakehead = new Tile(5,5);

        Food = new Tile(10,10);
        random = new Random();
        PlaceFood();

        GameLoop = new Timer(100, this);
        GameLoop.start();

    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        draw(g);
    }

    //Snake
    public void draw(Graphics g)
    {
        //Snake
        g.setColor(Color.green);
        g.fillRect(Snakehead.x * TileSize, Snakehead.y * TileSize, TileSize, TileSize);

        //Food
        g.setColor(Color.red);
        g.fillRect(Food.x * TileSize, Food.y * TileSize, TileSize,TileSize);
    }
    public void PlaceFood()
    {
        Food.x = random.nextInt(GameBoardWidth/TileSize);
        Food.y = random.nextInt(GameBoardHeight/TileSize);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();

    }


}
