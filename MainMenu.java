import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.*;
import java.io.*;

public class MainMenu extends JFrame
{
    Font title = new Font("Serif",Font.PLAIN,32);
    Font text = new Font("SansSerif",Font.PLAIN,20);
    Font f = new Font("Serif", Font. PLAIN, 52);
    Color blue =  new Color(137, 160, 196);
    Color yellow = new Color(237, 186, 57);
    Color green = new Color(106, 153, 84);
    JButton b;
    JButton r;
    JButton q;
    JButton co;
    JTextField u;
    JPanel p;
    JFrame jf;
    boolean newGame = false;
    boolean instructions = false;
    boolean leaderboard = false;
    boolean user1 = false;
    boolean gw;
    String user;
    BufferedReader reader;
    File file = new File("Usernames");

    MainMenu()
    {
        setSize(700, 600);
        setBackground(green);
        setResizable (false);
        setBounds (0,0,700,600);
        jf = new JFrame();

        p = new JPanel(null);

        jf.add(p);

        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        addWindowListener(new WindowAdapter()
      {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
          }
        );


        b = new JButton("Start New Game");
        b.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                newGame = true;
                b.setVisible(false);
                r.setVisible(false);
                q.setVisible(false);
                repaint();
                jf.setVisible(true);

                u = new JTextField();
                u.isFocusable();
                co = new JButton("Press After You Enter Your Username");
                co.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        while(true)
                        {

                            co.setVisible(true);
                            u.setVisible(true);
                            u.requestFocusInWindow();
                            user = u.getText();
                            boolean userExists = false;

                            //checks if the username already exists
                            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                                String line;
                                while ((line = reader.readLine()) != null) {
                                    if (line.equals(user)) {
                                        userExists = true;
                                        break;
                                    }
                                }
                            } catch (IOException ep) {
                                ep.printStackTrace();
                            }

                            //if username exists makes user re-enter a username
                            if (userExists)
                            {gw = true;
                                repaint();
                                co.setVisible(true);
                                u.setVisible(true);
                                u.requestFocusInWindow();
                                u.setText("");
                                break;
                            }
                            //if the username is unique, it reads it into the file
                            else
                            {
                                user1 = true;
                                repaint();
                                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true)))
                                {
                                    writer.write(user);
                                    writer.newLine();
                                    repaint();
                                } catch (IOException o) {
                                    System.out.print("File not found");
                                }
                                break;
                            }
                        }
                    }
                });
                p.add(u);
                p.add(co);
                u.setBounds(70,120,560,100);
                u.setVisible(true);
                co.setBounds(150,300,400,50);
                co.setVisible(true);
                repaint();
                revalidate();

            }
        });

        r = new JButton("How To Play");
        r.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                instructions = true;
                repaint();
                b.setVisible(false);
                r.setVisible(false);
                q.setVisible(false);
            }
        });
        q = new JButton("Leaderboard");
        q.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                leaderboard = true;
                repaint();
                b.setVisible(false);
                r.setVisible(false);
                q.setVisible(false);
            }
        });

        p.add(b);
        b.setBounds(190,180,300,70);

        p.add(r);
        r.setBounds(190, 300, 300, 70);

        p.add(q);
        q.setBounds(190, 420, 300, 70);




        this.add (p);
        jf.setVisible(true);
        p.repaint();
        setResizable (false);
        setBounds (0,0,700,600);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    }


    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

       if(newGame)
       {
           //when the New Game button is pressed, this screen is displayed
           g2.setColor(blue);
           g2.fillRect(0,0,700,600);
           g2.setColor(Color.BLACK);
           g2.setFont(text);
           g2.drawString("Enter your username: ",50,100);
           u.repaint();
           u.revalidate();
           co.repaint();
           co.revalidate();
           if(gw)
           {
               g2.setColor(Color.BLACK);
               g2.setFont(text);
               g2.drawString("This username already exists, please enter another one",70,280);
               gw = false;
           }

           else if (user1)
           {
               //when username is checked to be unique, it moves onto the next screen
               Player newUser = new Player(user,0);
               Bedroom b = new Bedroom(newUser);
               b.setVisible (true);
               b.repaint();
           }
       }
       else if(instructions)
       {
           //when Instructions button is pressed  the instructions screen is shown
          Instructions i = new Instructions();
           i.setVisible (true);
           i.repaint();

       }
       else if(leaderboard)
       {
           //when the Leaderboard button is pressed the leaderboard is shown
           End2 e = new End2();
           e.setVisible(true);
           e.repaint();
       }
       else
       {
           //sky
           g2.setColor(blue);
           g2.fillRect(0,0,700,410);
           g2.setColor(yellow);
           g2.fillOval(-40,-20,120,120);
           //title
           g2.setColor(Color.WHITE);
           g2.setFont(f); // Set the font to f
           g2.drawString("Climate Change", 175, 120);
       }

    }

    public static void main (String[] args)
    {
        MainMenu m = new MainMenu ();
        m.setVisible (true);
        m.repaint();

    }

}