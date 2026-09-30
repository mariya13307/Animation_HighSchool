import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Instructions extends JFrame
{
    JPanel p;
    JButton c;
    boolean cont;
    Font title = new Font("Serif",Font.PLAIN,40);
    Font text = new Font("Serif",Font.PLAIN,20);
    Color blue =  new Color(137, 160, 196);
    Player newUser;
    Instructions()
    {
        setSize(700, 600);
        p = new JPanel(null);
        p.repaint();
        setBackground(blue);
        setResizable (false);
        setBounds (0,0,700,600);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        //ActionListenter is for the continue button which the player presses to move onto the next scene
        c = new JButton("Back");
        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                cont = true;
                repaint();
                c.setVisible(false);
            }
        });
        p = new JPanel(null);

        p.add(c);
        c.setBounds(575,530,100,25);

        this.add (p);
        p.repaint();
        //c.setVisible(true);
        setResizable (false);
        setBounds (0,0,700,600);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        if(!cont)
        {
            g2.setColor(Color.BLACK);
            g2.setFont(title);
            g2.drawString("How to Play",230,100);
            g2.setFont(text);
            g2.drawString("In each scene you will be presented with a options.",130,200);
            g2.drawString("They will vary in eco-friendliness, some will be very good",100,250);
            g2.drawString("for the environment while some won't.", 170,300);
            g2.drawString("Your job is to click on the most eco-friendly option,",130,350);
            g2.drawString("the more eco-friendly the option you choose the more points you score.",60,400);
            g2.drawString("After the game your score will be placed in a leaderboard",100,450);
            g2.drawString("Good Luck!",280,500);
        }
        else
        {
            MainMenu m = new MainMenu();
            m.setVisible(true);
            m.repaint();
            m.revalidate();
        }
    }
}
