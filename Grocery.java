import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Grocery extends JFrame
{
    CommonGraphics cg = new CommonGraphics();
    Color wall  = new Color(240, 248, 252);
    Color ground = new Color(181, 169, 121);
    Color wood1 = new Color (156, 124, 70);
    Color wood2 = new Color (133, 102, 50);
    Color wood3 = new Color (99, 72, 26);
    JButton co;
    JButton red;
    JButton local;
    JButton veg;
    JPanel p;
    boolean cont;
    Font text = new Font("SansSerif",Font.PLAIN,17);

    Player newUser;

   Grocery(Player player)
   {
       this.newUser = player;
       setSize(700, 600);
       p = new JPanel(null);
       p.repaint();
       setResizable (false);
       setBounds (0,0,700,600);
       setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

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

       red = new JButton("Red Meat");
       co.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e)
           {
            //adds 0 points to childs high score
           }
       });
       local = new JButton("Local Meat");
       co.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               newUser.addHS(2);//adds 2 points to childs high score
           }
       });
       veg = new JButton("Veggie Burger");
       co.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               newUser.addHS(4);//adds 4 points to childs high score
           }
       });

       p = new JPanel(null);

       p.add(co);
       co.setBounds(575,530,100,25);

       p.add(red);
       red.setBounds(295,390,100,25);
       p.add(local);
       local.setBounds(295,430,100,25);
       p.add(veg);
       veg.setBounds(295,470,120,25);

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
            setBackground(wall);
            g2.setColor(ground);
            g2.fillRect(0, 375, 700, 225);

            g2.setColor(new Color(189, 211, 219));
            g2.fillRect(0, 230, 700, 145); //fridge area
            g2.setColor(new Color(141, 159, 166));
            g2.drawLine(0, 260, 700, 260);
            g2.drawLine(0, 290, 700, 290);
            g2.drawLine(0, 320, 700, 320);
            g2.drawLine(0, 350, 700, 350);

            g.setColor(new Color(29, 145, 191));  //things on shlef
            for (int i = 0; i < 15; i++)
                g2.fillRoundRect(30 + i * 50, 240, 15, 20, 2, 2);
            for (int i = 0; i < 15; i++)
                g2.fillRoundRect(30 + i * 50, 270, 15, 20, 2, 2);
            for (int i = 0; i < 15; i++)
                g2.fillRoundRect(30 + i * 50, 300, 15, 20, 2, 2);
            for (int i = 0; i < 15; i++)
                g2.fillRoundRect(30 + i * 50, 330, 15, 20, 2, 2);


            g2.setColor(wood1);
            cg.fillTriangle(360, 400, 360, 225, 600, 425, g);   //shelf
            cg.fillTriangle(360, 225, 600, 425, 600, 200, g);

            g2.setColor(wood3);   // cubby hole
            cg.fillTriangle(380, 250, 580, 230, 580, 300, g);  //top
            cg.fillTriangle(380, 250, 380, 300, 580, 300, g);
            cg.fillTriangle(380, 326, 380, 375, 580, 390, g);  //bottom
            cg.fillTriangle(380, 326, 580, 390, 580, 328, g);

            g2.setColor(wood2);
            g2.fillRect(600, 200, 50, 225);   //shelf side

            g2.setColor(wood3);
            g2.fillRect(110, 410, 140, 80);   //back box
            cg.fillTriangle(60, 430, 110, 410, 110, 490, g);//left side box

            g2.setColor(Color.ORANGE);  //oranges
            g2.fillOval(124, 415, 30, 30);
            g2.fillOval(100, 402, 30, 30);
            g2.fillOval(85, 410, 30, 30);
            g2.fillOval(150, 405, 30, 30);
            g2.fillOval(190, 408, 30, 30);
            g2.fillOval(210, 406, 30, 30);
            g2.fillOval(170, 410, 30, 30);

            g2.setColor(wood2);
            cg.fillTriangle(200, 510, 250, 490, 250, 410, g);  //right side box
            cg.fillTriangle(200, 510, 250, 410, 200, 430, g);
            g2.setColor(wood1);
            g2.fillRect(60, 430, 140, 80); //front box

            cg.person(450, 350, g);

            g.setColor(Color.WHITE);
            BasicStroke bbs = new BasicStroke(5);
            g2.setStroke(bbs);
            int xx[] = {340, 340, 550, 550, 490, 480, 470,370};
            int yy[] = {290, 230, 230, 290, 290, 320, 290, 290};
            g.fillPolygon(xx, yy, 7);
            g2.setColor(Color.BLACK);
            g2.drawPolygon(xx, yy, 7);
            g2.setFont(text);
            g2.drawString("Which meat is the",355,255);
            g2.drawString("most eco friendly?",355,275);
        }
        else
        {
            Backyard b = new Backyard(newUser);
            red.setVisible(false);
            local.setVisible(false);
            veg.setVisible(false);
            b.paint(g2);
            b.setVisible(true);
            b.repaint();
            b.revalidate();

        }
    }
}