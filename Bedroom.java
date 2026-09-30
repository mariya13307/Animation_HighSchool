import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bedroom extends JFrame
{
    Color wall = new Color(201, 182, 212);
    Color floor = new Color(92, 65, 41);
    Color sky =  new Color(137, 160, 196);
    Color bed = new Color(207, 182, 138);
    Color rug = new Color(43, 44, 130);
    Color rugB = new Color(27, 28, 82);
    Color pillow = new Color(223, 247, 247);
    Font text = new Font("SansSerif",Font.PLAIN,17);
    JButton c;
    JPanel p;
    boolean cont;
    Player newUser;


    Bedroom(Player player)
    {
        this.newUser = player;
        setSize(700, 600);
        p = new JPanel(null);
        p.repaint();
        setBackground(wall);
        setResizable (false);
        setBounds (0,0,700,600);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        //ActionListenter is for the continue button which the player presses to move onto the next scene
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
            g2.setColor(wall);
            g2.fillRect(0,0,700,600);
            g2.setColor(floor);
            g2.fillRect(0, 400, 700, 600);
            //window
            BasicStroke s = new BasicStroke(5);
            g2.setStroke(s);
            g2.setColor(sky);
            g2.fillRect(240, 90, 230, 225);
            g2.setColor(floor);
            g2.drawRect(240, 90, 230, 225);
            g2.drawLine(240, 203, 470, 203);
            g2.drawLine(355, 90, 355, 315);

            //carpet
            g2.setColor(rug);
            int XP[] = {52, 142, 542, 452};
            int YP[] = {560, 450, 450, 560};
            g2.fillPolygon(XP, YP, 4);
            BasicStroke bs = new BasicStroke(15);
            g2.setStroke(bs);
            g2.setColor(rugB);
            g2.drawPolygon(XP, YP, 4);

            //bed
            g2.setColor(bed);
            //headboard
            BasicStroke bbs = new BasicStroke(5);
            g2.setStroke(bbs);
            g2.drawLine(132, 510, 132, 455);
            int x[] = {130, 200, 200, 130};
            int y[] = {475, 395, 340, 420};
            g2.fillPolygon(x, y, 4);
            //sheets
            g2.setColor(sky);
            int xP[] = {132, 202, 512, 442};
            int yP[] = {470, 390, 390, 470};
            g2.fillPolygon(xP, yP, 4);
            g2.fillRect(132, 470, 310, 30);
            //pillow
            g2.setColor(pillow);
            int xPP[] = {160, 200, 190, 150};
            int yPP[] = {465, 415, 370, 420};
            g2.fillPolygon(xPP, yPP, 4);
            //backboard
            g2.setColor(bed);
            g2.drawLine(444, 510, 444, 470);
            g2.drawLine(508, 390, 508, 430);
            int xPo[] = {442, 510, 510, 442};
            int yPo[] = {450, 370, 405, 485};
            g2.fillPolygon(xPo, yPo, 4);

            CommonGraphics c = new CommonGraphics();
            c.person(250, 350, g2);
            //speech bubble
            g2.setColor(Color.WHITE);
            int xx[] = {315, 365, 365, 565, 565};
            int yy[] = {380, 360, 280, 280, 380};
            g2.fillPolygon(xx, yy, 5);
            g2.setColor(Color.BLACK);
            g2.drawPolygon(xx, yy, 5);
            g2.setFont(text);
            g2.drawString("What a nice morning!", 375, 305);
            g2.drawString("I can't wait to have my", 375, 330);
            g2.drawString("delicious breakfast!", 375, 355);
        }
        else
        {
            //when continue button is pressed, it moves on to the next screen
            Kitchen k = new Kitchen(newUser);
            k.setVisible (true);
            k.repaint();
            k.paint(g2);
        }

    }

}
