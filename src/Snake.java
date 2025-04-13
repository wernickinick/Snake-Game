import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        Menu menu = new Menu();
        Frame.add(game);
        Frame.pack();
        game.requestFocus();
        Frame.setVisible(true);

        JFrame MainMenu = new JFrame("MENU");
        MainMenu.setBounds(0, 0, 600, 600);
        MainMenu.setLayout(null);
        MainMenu.setLocationRelativeTo(null);
        MainMenu.setFocusable(true);
        MainMenu.setVisible(true);

        JButton start = new JButton("Start");
        start.setBounds(200,200,200,50);
        MainMenu.add(start);

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame.setVisible(true);
                MainMenu.setVisible(false);
            }
        });


//        if(!game.GameOver)
//        {
//            Frame.setVisible(false);
//        }

        if(!game.GameOver)
        {
            MainMenu.setVisible(true);
            Frame.setVisible(false);
            System.out.println("Svxcvxcvuccess");
        }
        else if (game.GameOver){
            MainMenu.setVisible(true);
            Frame.setVisible(false);
            System.out.println("Success");
        }


    }
}
