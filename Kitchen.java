import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kitchen extends JFrame
{
    Color bg =  new Color(201,182,212);
    Color floor = new Color(140, 123, 113);
    Color table = new Color(122, 80, 80);
    Color sBottle = new Color(217, 186, 134);
    Color pBottle = new Color(145, 204, 204);
    Color rBottle = new Color(33, 93, 22);
    Font text = new Font("SansSerif",Font.PLAIN,17);
    Font title = new Font("Serif",Font.PLAIN,40);
    JButton co;
    JButton s;
    JButton w;
    JButton r;
   boolean cont = false;
   boolean choice;
    JPanel p;
    Player newUser;
    CommonGraphics c = new CommonGraphics();

    Kitchen(Player player)
    {
        this.newUser = player;
        setSize(700, 600);
        p = new JPanel(null);
        p.repaint();
        setResizable (false);
        setBounds (0,0,700,600);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        //ActionListenter is for the continue button which the player presses to move onto the next scene
        co = new JButton("Continue");
        co.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                cont=true;
                repaint();
                co.setVisible(false);
            }
        });

        s = new JButton("Glass bottle");
        s.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                newUser.addHS(4); //adds 4 to high score
            }
        });
        w = new JButton("Plastic Bottle");
        w.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                 //adds 0 to high score
            }
        });
        r = new JButton ("Metal Bottle");
        r.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                newUser.addHS(2); //adds 2 to high score
            }
        });

        p = new JPanel(null);

        p.add(co);
        co.setBounds(575,530,100,25);

        p.add(s);
        s.setBounds(170,470,110,25);
        p.add(w);
        w.setBounds(305,470,120,25);
        p.add(r);
        r.setBounds(450,470,110,25);


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
            setBackground(bg);

            g.setColor(floor);
            g.fillRect(0, 300, 700, 300);//floor

            c.person(580, 340, g);

            //table
            g.setColor(table);
            int xTable[] = {200, 450, 530, 280};
            int yTable[] = {360, 360, 320, 320};
            g.fillPolygon(xTable, yTable, 4);//table
            int xSTable[] = {450, 450, 530, 530};
            int ySTable[] = {360, 370, 330, 320};
            g.fillPolygon(xSTable, ySTable, 4);//table sides
            g2.setStroke(new BasicStroke(10));
            g.drawLine(205, 365, 445, 365);
            g.drawLine(450, 365, 450, 445);//table legs
            g.drawLine(200, 365, 200, 445);
            g.drawLine(530, 325, 530, 405);
            g.drawLine(280, 325, 280, 405);
            //windows
            c.window(80, 60, 200, 140, g);
            //bottles
            g.setColor(sBottle);
            g.drawRect(320, 337, 8, 20);//starbucks bottle
            g.setColor(pBottle);
            g.drawRect(350, 337, 8, 20); //plastic bottle
            g.setColor(rBottle);
            g.drawRect(380, 337, 8, 20);//reusable bottle
            //*bottles fix later*

            //speech bubble
            g2.setColor(Color.WHITE);
            BasicStroke bbs = new BasicStroke(5);
            g2.setStroke(bbs);
            int xx[] = {460, 460, 670, 670, 610, 600, 590,490};
            int yy[] = {280, 220, 220, 280, 280, 310, 280, 280};
            g2.fillPolygon(xx, yy, 7);
            g2.setColor(Color.BLACK);
            g2.drawPolygon(xx, yy, 7);
            g2.setFont(text);
            g2.drawString("Which water bottle is",475,245);
            g2.drawString("the most eco friendly?",475,265);

        }
        else
        {
            //when continue button is pressed, it moves on to the next screen
            Outside o= new Outside(newUser);
            o.setVisible (true);
            o.repaint();
            o.paint(g2);

        }

    }
}
