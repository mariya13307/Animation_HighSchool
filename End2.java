import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class End2 extends JFrame
{

    Color sky =  new Color(137, 160, 196, 255);
    Font title = new Font("Serif",Font.PLAIN,40);
    Font text = new Font("Serif",Font.PLAIN,25);
    JButton c;
    boolean cont;
    JPanel p;
    File hs = new File("/Users/mariyamaksymenko/IdeaProjects/random/src/hs");
    File file = new File("Usernames");
    ArrayList <Player> highScores = new ArrayList <Player>();
    End2()
    {
        setSize(700, 600);
        p = new JPanel(null);
        p = new JPanel(null);
        p.repaint();
        setResizable (false);
        setBounds (0,0,700,600);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

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

        p.add(c);
        c.setBounds(575,530,100,25);

        this.add (p);
        p.repaint();
        setResizable (false);
        setBounds (0,0,700,600);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        if(!cont)
        {
            try
            {
                BufferedReader br = new BufferedReader(new FileReader("hs"));
                BufferedReader b = new BufferedReader(new FileReader("Usernames"));
                while (br.ready() && b.ready())
                {
                    String nameLine = b.readLine();
                    String scoreLine = br.readLine();
                    highScores.add(new Player(nameLine, Integer.parseInt(scoreLine)));
                }
            }
            catch (Exception e)
            {
                System.out.println("Open");
            }

            g2.setColor(sky);
            g2.fillRect(0, 0, 700, 600);
            g2.setFont(title);
            g2.setColor(Color.BLACK);
            g2.drawString("Leaderboard",220,100);
            g2.setFont(text);
            sort(highScores);
            for (int i = 0; i < Math.min(highScores.size(), 10); i++)
            {
                g2.drawString((i + 1) + ". " + highScores.get(i).getName() + "                " + highScores.get(i).getHS(), 200, 200 + (i * 40));
            }
        }
        else
        {
            MainMenu m = new MainMenu();
            m.setVisible(true);
            m.repaint();
        }

    }
    public void sort(ArrayList<Player> arr)
    {
        int numOfActions = arr.size();
        while (numOfActions > 1)
        {
            for (int i = 0; i < numOfActions - 1; i++)
            {
                if (arr.get(i).getHS() < arr.get(i + 1).getHS())
                {
                    Collections.swap(arr, i, i + 1);
                }
            }
            numOfActions--;  // Decrease the range for the next pass
        }

        try
        {
            FileWriter writer = new FileWriter(hs);
            for(int i=0;i<highScores.size();i++)
            {
                writer.write(highScores.get(i).getHS() + System.lineSeparator());
            }
        }
        catch (Exception e) {}

    }

    public static void main (String[] args)
    {
        try {
            UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName());
        } catch (Throwable e) {
            e.printStackTrace();
        }
        Player newP = null;
        End2 m = new End2();
        m.setVisible (true);
        m.repaint();
    }

}