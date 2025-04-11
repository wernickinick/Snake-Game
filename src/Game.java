import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.ArrayList;
import javax.swing.*;

public class Game extends JPanel implements ActionListener, KeyListener{

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
    ArrayList<Tile> SnakeBody;

    //Food
    Tile Food;
    Random random;

    //Game Logic
    Timer GameLoop;
    int VelocityX;
    int VelocityY;

    Game(int GameBoardWidth, int GameBoardHeight)
    {
        this.GameBoardWidth = GameBoardWidth;
        this.GameBoardHeight = GameBoardHeight;
        setPreferredSize(new Dimension(this.GameBoardWidth,this.GameBoardHeight));
        setBackground(Color.BLACK);
        addKeyListener(this);
        setFocusable(true);

        Snakehead = new Tile(5,5);
        SnakeBody = new ArrayList<Tile>();

        Food = new Tile(10,10);
        random = new Random();
        PlaceFood();

        VelocityX = 0;
        VelocityY = 0;

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
        //Snake head
        g.setColor(Color.green);
        g.fillRect(Snakehead.x * TileSize, Snakehead.y * TileSize, TileSize, TileSize);

        //Food
        g.setColor(Color.red);
        g.fillRect(Food.x * TileSize, Food.y * TileSize, TileSize,TileSize);

        //Snake Body
        for(int i = 0; i < SnakeBody.size(); i++)
        {
            Tile SnakePart = SnakeBody.get(i);
            g.setColor(Color.green);
            g.fillRect(SnakePart.x * TileSize, SnakePart.y * TileSize,TileSize,TileSize);
        }
    }

    public Boolean Collision(Tile tile1, Tile tile2)
    {
        return tile1.x == tile2.x && tile1.y == tile2.y;
    }


    public void PlaceFood()
    {
        Food.x = random.nextInt(GameBoardWidth/TileSize);
        Food.y = random.nextInt(GameBoardHeight/TileSize);
    }

    public void move()
    {
        //Eat Food
        if(Collision(Snakehead,Food))
        {
            SnakeBody.add(new Tile(Food.x,Food.y));
            PlaceFood();
        }

        //Snake Body
        for(int i = SnakeBody.size()-1; i >= 0; i--)
        {
            Tile SnakePart = SnakeBody.get(i);
            if (i == 0)
            {
                SnakePart.x = Snakehead.x;
                SnakePart.y = Snakehead.y;
            }
            else {
                Tile PrevSnakePart = SnakeBody.get(i - 1);
                SnakePart.x = PrevSnakePart.x;
                SnakePart.y = PrevSnakePart.y;
            }
        }

        //Snake Head
        Snakehead.x += VelocityX;
        Snakehead.y += VelocityY;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP && VelocityY != 1)
        {
            VelocityX =  0;
            VelocityY = -1;
        }
        else  if (e.getKeyCode() == KeyEvent.VK_DOWN && VelocityY != -1)
        {
            VelocityX = 0;
            VelocityY = 1;
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT && VelocityX != 1)
        {
            VelocityX = -1;
            VelocityY = 0;
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT && VelocityX != -1)
        {
            VelocityX = 1;
            VelocityY = 0;
        }

    }
    //Dont Need these down here!!!!!! just there for the Implementation
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
