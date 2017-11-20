import java.util.Random;

public class SkunkBot implements Robot{
    GreedTeam myTeam = new GreedTeam();
    public ModelType getModel(){
        //this sets the type of RabbitBot to be RabbitBot
        ModelType skunk = new ModelType();
        skunk = ModelType.SkunkBot;
        return skunk;
    }
    public int getID(){
        //Here I will set the ID number to be a random number. I am doing this because I 
        //want to minimize the chances of it being the same ID number that another team gave
        Random rand = new Random();
        int  n = rand.nextInt(4000);
        return n;
    }
    public boolean isTeamOne(){
        //need to pull our boolean the GreedTeam class
        return myTeam.isTeamOne;
    }
}