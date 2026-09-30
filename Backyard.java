import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Backyard extends JFrame
{

    CommonGraphics cg = new CommonGraphics();
    Color sky =  new Color(137, 160, 196);
    Color ground = new Color(93, 158, 65);
    Color dirt = new Color(61, 42, 32);
    Font text = new Font("SansSerif",Font.PLAIN,17);
    JFrame f = new JFrame();
    Player newUser;
    JButton co;
    Boolean cont = false;
    JPanel p;
    JButton gun;
    JButton ball;
    Backyard(Player player)
    {
        this.newUser=player;
        setSize(700, 600);
        p = new JPanel(null);
        p.repaint();
        setResizable (false);
        setBounds (0,0,700,600);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        co = new JButton("Continue");
        co.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cont = true;
                repaint();
                co.setVisible(false);
            }
        });

        gun = new JButton("Water Gun");
        gun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newUser.addHS(4);
               //adds 4 points to childs high score
            }
        });
        ball = new JButton("Water Balloons");
        ball.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newUser.addHS(2);//adds 2 points to childs high score
            }
        });

        p = new JPanel(null);

        p.add(co);
        co.setBounds(575,530,100,25);
        p.add(gun);
        gun.setBounds(225, 390, 100, 25);
        p.add(ball);
        ball.setBounds(225, 430, 120, 25);

        this.add (p);
        gun.setVisible(true);
        ball.setVisible(true);
        p.repaint();
        setResizable (false);
        setBounds (0,0,700,600);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        if (!cont)
        {
            setBackground(sky);
            g2.setColor(ground);
            g2.fillRect(0, 375, 700, 225);

            g2.setColor(new Color(245, 215, 66));
            g2.fillOval(500, 100, 100, 100);

            g2.setColor(dirt);    //garden
            cg.fillTriangle(400, 380, 550, 380, 575, 550, g);
            cg.fillTriangle(400, 380, 375, 550, 575, 550, g);

            cg.tree(100, 250, 0.8, g);
            cg.person(160, 350, g);
            cg.tree(-25, 510, 1.2, g);
            cg.tree(600, 215, 1, g);


            g2.setColor(Color.ORANGE);     //carrots
            g2.fillRoundRect(405, 385, 18, 14, 2, 2);
            g2.fillRoundRect(445, 385, 18, 14, 2, 2);
            g2.fillRoundRect(485, 385, 18, 14, 2, 2);
            g2.fillRoundRect(525, 385, 18, 14, 2, 2);

            g2.fillRoundRect(403, 425, 18, 14, 2, 2);
            g2.fillRoundRect(447, 425, 18, 14, 2, 2);
            g2.fillRoundRect(492, 425, 18, 14, 2, 2);
            g2.fillRoundRect(537, 425, 18, 14, 2, 2);

            g2.fillRoundRect(392, 475, 18, 14, 2, 2);
            g2.fillRoundRect(444, 475, 18, 14, 2, 2);
            g2.fillRoundRect(494, 475, 18, 14, 2, 2);
            g2.fillRoundRect(544, 475, 18, 14, 2, 2);

            g2.fillRoundRect(384, 525, 18, 14, 2, 2);
            g2.fillRoundRect(440, 525, 18, 14, 2, 2);
            g2.fillRoundRect(498, 525, 18, 14, 2, 2);
            g2.fillRoundRect(550, 525, 18, 14, 2, 2);

            //speech bubble
            g2.setColor(Color.WHITE);
            BasicStroke bbs = new BasicStroke(5);
            g2.setStroke(bbs);
            int xx[] = {225, 275, 275, 475, 475};
            int yy[] = {370, 350, 270, 270, 370};
            g2.fillPolygon(xx, yy, 5);
            g2.setColor(Color.BLACK);
            g2.drawPolygon(xx, yy, 5);
            g2.setFont(text);
            g2.drawString("Its such a hot day!", 285, 295);
            g2.drawString("Which game should I", 285, 320);
            g2.drawString("play to cool down?", 285, 345);
        }
        else
        {
            //when continue button is pressed, moved onto the next scene
            Home h= new Home(newUser);
            gun.setVisible(false);
            ball.setVisible(false);
            h.paint(g2);
            h.setVisible(true);
            h.repaint();
            h.revalidate();
        }
    }
}