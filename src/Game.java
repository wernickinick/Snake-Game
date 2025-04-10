import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.ArrayList;
import javax.swing.*;

public class Game extends JPanel{

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

    //Food
    Tile food;

    Game(int GameBoardWidth, int GameBoardHeight)
    {
        this.GameBoardWidth = GameBoardWidth;
        this.GameBoardHeight = GameBoardHeight;
        setPreferredSize(new Dimension(this.GameBoardWidth,this.GameBoardHeight));
        setBackground(Color.BLACK);

        Snakehead = new Tile(5,5);

        food = new Tile(10,10);

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
        g.fillRect(food.x * TileSize, food.y * TileSize, TileSize,TileSize); //Left off here!!!
    }



}
