import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class Player
{
    private String name;
    private int highScore;
    int highscore;
    private int rNum;
    Scanner n;
    Scanner s;
    Scanner s2;
    PrintWriter pN;
    PrintWriter pSA;
    PrintWriter pSA2;
    PrintWriter pSO;
    Player(String nam, int hS)
    {
        name = nam;
        highscore = hS;
    }
    public String getName()
    {
        return name;
    }

    public void addHS(int hs)
    {
        highscore = highscore+hs;
    }

    public int getHS()
    {
        return highscore;
    }

   /* public void setHighScore(int hS){
        this.getHighScore();
        if(hS > highScore){
            ArrayList<Integer> tempSFile = new ArrayList<Integer>();
            while(s2.hasNextInt()){
                tempSFile.add(s2.nextInt());
            }
            tempSFile.remove(rNum-1);
            tempSFile.add(rNum-1,hS);
            try {
                pSO = new PrintWriter(new FileWriter("scoreList", false));
            }catch (Exception e){}
            pSO.close();
            for(int i = 0; i < tempSFile.size(); i++){
                pSA2.println(tempSFile.get(i));
            }
            pSA2.close();
        }
    }*/

}