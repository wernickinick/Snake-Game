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
        //Menu menu = new Menu();
        Frame.add(game);
        Frame.pack();
        game.requestFocus();
        Frame.setVisible(true);

        JPanel MainMenu = new JPanel();
        MainMenu.setBounds(0, 0, 600, 600);
        MainMenu.setLayout(null);
        MainMenu.setBackground(new Color(236,204,162));
        MainMenu.setFocusable(true);
        MainMenu.setVisible(true);
        Frame.add(MainMenu);

        JButton start = new JButton("Start");
        start.setBounds(200,200,200,50);
        MainMenu.add(start);

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenu.setVisible(false);
                System.out.println("Menu Gone");
//                Frame.remove(game);
                Frame.add(game);
//                game.repaint();
//                game.revalidate();
                game.setVisible(true);
            }
        });

        if (game.GameLoop != null)
        {
            MainMenu.setVisible(true);
            game.setVisible(false);
            System.out.println("Svxcvxcvuccess");
        }

        game.setGameoverListener(() -> {
            SwingUtilities.invokeLater(() -> {
                MainMenu.setVisible(true);
                game.setVisible(false);
                System.out.println(" Menu shown again");
//                Frame.remove(game);
                //new Game(Width,Height);
//                Frame.add(new Game(Width,Height));
            });
        });

    }
}
