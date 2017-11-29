import java.util.Random;

public class WolfBot implements Robot{
    GreedTeam myTeam = new GreedTeam();
    public ModelType getModel(){
        //this sets the type of WolfBot to be WolfBot
        ModelType wolf = ModelType.WolfBot;
        return wolf;
    }
    public int getID(){
        //Here I will set the ID number to be a random number. I am doing this because I 
        //want to minimize the chances of it being the same ID number that another team gave
        Random rand = new Random();
        int  n = rand.nextInt(2000);
        return n;
    }
    public boolean isTeamOne(){
        //need to pull our boolean the GreedTeam class
        return myTeam.isTeamOne;
    }
    /*public DirType Move(){
        Random randmove = new Random();
        int k = randmove.nextInt(4);
        DirType dir = null;
        if(k == 0){
            dir = DirType.North;
        }
        if(k == 1){
            dir = DirType.East;
        }
        if(k == 2){
            dir = DirType.South;
        }
        if(k == 3){
            dir = DirType.West;
        }
        return dir;
    }
    */
}