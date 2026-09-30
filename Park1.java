import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Park1 extends JFrame
{
    CommonGraphics cg = new CommonGraphics();
    Color sky =  new Color(137, 160, 196, 255);
    Color grass = new Color (79, 134, 8);
    Color path = new Color (183, 153, 96);
    Font text = new Font("SansSerif",Font.PLAIN,17);
    Player newUser;
    JButton c;
    JButton t;
    JButton w;
    JButton b;
    JPanel p;
    boolean cont;

    Park1(Player newUser)
    {
        this.newUser=newUser;

        c = new JButton("Continue");
        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                cont = true;
                repaint();
                c.setVisible(false);
            }
        });
        t = new JButton("Throw it on the ground");
        t.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //adds no points to childs highscore
            }
        });
        w = new JButton("Wait for a trash can");
        w.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                newUser.addHS(4);//adds 4 points to childs high score
            }
        });
        b = new JButton("Bury it");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                newUser.addHS(2);
                //adds 2 points to childs high score
            }
        });

        p = new JPanel(null);

        p.add(c);
        c.setBounds(575,530,100,25);

        p.add(t);
        t.setBounds(100,380,170,25);
        p.add(w);
        w.setBounds(290,380,160,25);
        p.add(b);
        b.setBounds(225,420,100,25);

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
            setBackground(sky);
            g2.setColor(sky);
            g2.fillRect(0, 0, 700, 600);
            g2.setColor(grass);
            g2.fillRect(0, 350, 700, 250);//grass

            cg.tree(160, 240, 0.8, 't', g);//tress, background
            cg.tree(50, 160, 1.4, g);
            cg.tree(280, 200, 1.2, g);
            cg.tree(620, 220, 1, 't', g);

            g2.setColor(path);
            g2.fillRect(0, 400, 700, 80);//path

            cg.tree(590, 520, 1.2, g);
            cg.person(460, 260, g);

            g2.setColor(Color.GRAY);
            cg.fillTriangle(440, 360, 480, 380, 450, 386, g);//garbage

            //speech bubble
            BasicStroke bs2 = new BasicStroke(5);
            g2.setStroke(bs2);
            g2.setColor(Color.WHITE);
            int xx[] = {190, 190, 390, 390, 440};
            int yy[] = {300, 200, 200, 270, 300};
            g2.fillPolygon(xx, yy, 5);
            g2.setColor(Color.BLACK);
            g2.drawPolygon(xx, yy, 5);
            g2.setFont(text);
            g2.drawString("That chocolate bar", 200, 225);
            g2.drawString("was so good!", 200, 245);
            g2.drawString("What should I do", 200, 265);
            g2.drawString("with the wrapper?", 200, 285);
        }
        else
        {
            //when continue button is pressed, it moves onto the next scene
            Grocery gr = new Grocery(newUser);
            t.setVisible(false);
            c.setVisible(false);
            w.setVisible(false);
            gr.paint(g);
            gr.setVisible(true);
            gr.repaint();
        }

    }
    public void paintMain(){//acts like static main method, the method that will be called in the driver class
        Park1 s = new Park1(newUser);
        JFrame f = new JFrame();
        f.add(s);
        f.setSize(700,600);
        f.setVisible(true);
    }
}