import java.awt.*;
public class CommonGraphics extends Canvas{
    public void fillTriangle(int x1, int y1, int x2, int y2, int x3, int y3, Graphics g){
        int xVal[] = {x1,x2,x3};
        int yVal[] = {y1,y2,y3};
        g.fillPolygon(xVal,yVal,3);
    }

    public void person(int x , int y, Graphics g){
        Color skin = new Color(190, 147, 87);
        Color hair = new Color(80, 42, 3);
        Color shirt = new Color(197, 172, 8);
        Color pants = new Color(21, 32, 80);
        int hairXBot[] = {x-12, x-5,x+45,x+50,x+47,x+47,x+39,x+31,x+23,x+15 ,x+7,x-5 ,x-3 };
        int hairYBot[] = {y+38,y+20,y+20,y+38,y+34,y+43,y+40,y+43,y+40,y+43,y+40,y+43,y+34};
        int hairXTop[] = {x-2 ,x+43,x+45,x+34,x+24,x+12,x-4};
        int hairYTop[] = {y+11,y+11,y+23,y+11,y+27,y+11,y+22};
        //bottom hair
        g.setColor(hair);
        g.fillPolygon(hairXBot,hairYBot,13);
        //head
        g.setColor(skin);
        g.fillOval(x,y,40,40);//head
        g.fillRect(x+16,y+36,8,10);//neck
        g.fillOval(x-8,y+18,12,12);//ears
        g.fillOval(x+36,y+18,12,12);
        g.setColor(Color.BLACK);
        g.fillOval(x+8,y+24,4,4);//eyes
        g.fillOval(x+28,y+24,4,4 );
        //top hair
        g.setColor(hair);
        g.fillArc(x-2,y-5,45,32,360,180);
        g.fillPolygon(hairXTop,hairYTop,7);
        //arms
        g.setColor(skin);
        g.fillRect(x-8,y+56,8,60);
        g.fillRect(x+40,y+56,8,60);
        //shirt
        g.setColor(shirt);
        g.fillRect(x,y+46,40,60);
        this.fillTriangle(x,y+46,x,y+66,x-10,y+56,g);
        this.fillTriangle(x+40,y+46,x+40,y+66,x+50,y+56,g);
        //pants
        g.setColor(pants);
        g.fillRect(x,y+106,40,20);
        g.fillRect(x,y+126,15,70);
        g.fillRect(x+25,y+126,15,70);
        g.setColor(Color.BLACK);
        g.fillOval(x-5,y+190,20,10);
        g.fillOval(x+25,y+190,20,10);
    }
    public void window(int x, int y, int width, int height, Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Color sky =  new Color(137, 160, 196, 255);
        Color wood = new Color(80, 40, 15);
        g.setColor(sky);
        g.fillRect(x, y, width, height);
        g.setColor(wood);
        g2.setStroke(new BasicStroke(10));
        g.drawRect(x, y, width, height);
        g.drawLine(x+width / 2, y, x+width / 2, y + height);
        g.drawLine(x, y+height / 2, x + width, y+height / 2);
    }
    public void tree(int x, int y,double l, Graphics g){
        Color bark = new Color(66, 36, 8);
        Color leaves = new Color(29, 114, 18);
        g.setColor(bark);
        g.fillRect(x+10,y,(int)(60*l),(int)(160*l));

        g.setColor(leaves);
        g.fillOval((int)(x-20*l),(int)(y-70*l),(int)(120*l),(int)(120*l));//main body of laves
        g.fillOval((int)(x-36*l),(int)(y-86*l),(int)(40*l),(int)(40*l));
        g.fillOval((int)(x-58*l),(int)(y-70*l),(int)(64*l),(int)(64*l));
        g.fillOval((int)(x-50*l),(int)(y-20*l),(int)(80*l),(int)(80*l));
        g.fillOval((int)(x-10*l),(int)(y-94*l),(int)(40*l),(int)(40*l));
        g.fillOval((int)(x+40*l),(int)(y-80*l),(int)(52*l),(int)(52*l));
        g.fillOval((int)(x+60*l),(int)(y-40*l),(int)(70*l),(int)(70*l));
        g.fillOval((int)(x+56*l),(int)(y+2*l),(int)(60*l),(int)(60*l));
        g.fillOval((int)(x+28*l),(int)(y-92*l),(int)(48*l),(int)(48*l));

    }
    public void tree(int x, int y,double l,char s, Graphics g){
        Color bark = new Color(52, 28, 6);
        Color leaves = new Color(17, 84, 10);
        g.setColor(bark);
        g.fillRect(x+10,y,(int)(60*l),(int)(160*l));

        g.setColor(leaves);
        g.fillOval((int)(x-20*l),(int)(y-70*l),(int)(120*l),(int)(120*l));//main body of laves
        g.fillOval((int)(x-36*l),(int)(y-86*l),(int)(40*l),(int)(40*l));
        g.fillOval((int)(x-58*l),(int)(y-70*l),(int)(64*l),(int)(64*l));
        g.fillOval((int)(x-50*l),(int)(y-20*l),(int)(80*l),(int)(80*l));
        g.fillOval((int)(x-10*l),(int)(y-94*l),(int)(40*l),(int)(40*l));
        g.fillOval((int)(x+40*l),(int)(y-80*l),(int)(52*l),(int)(52*l));
        g.fillOval((int)(x+60*l),(int)(y-40*l),(int)(70*l),(int)(70*l));
        g.fillOval((int)(x+56*l),(int)(y+2*l),(int)(60*l),(int)(60*l));
        g.fillOval((int)(x+28*l),(int)(y-92*l),(int)(48*l),(int)(48*l));

    }
}
