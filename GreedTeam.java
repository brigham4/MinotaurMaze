import java.util.*;

public class GreedTeam implements PlayerTeam{
    public boolean isTeamOne;
    public List<Robot> chooseTeam(boolean teamOne, GameState state){
        this.isTeamOne = teamOne;
        //making list to hold teams
        List<Robots> theTeam = new List<Robots>();
        //Now I am making 1 core bot to fill it and comment out other bots we want
        CoreBot bot1 = new CoreBot();
        CoreBot bot2 = new CoreBot();
        CoreBot bot3 = new CoreBot();
        CoreBot bot4 = new CoreBot();
        //WolfBot bot2 = new WolfBot();
        //SkunkBot bot3 = new SkunkBot();
        //RabbitBot bot4 = new RabbitBot();
        //BatBot bot5 = new BatBot();

        //now add robots to list
        theTeam.add(bot1);
        theTeam.add(bot2);
        theTeam.add(bot3);
        theTeam.add(bot4);
        return theTeam;
    }
    public List<Command> requestCommands(List<Location> information, List<Robot> robotsAwaitingCommand, GameState state){
        this.robotsAwaitingCommand = theTeam; 
        //all of our robots are awaiting commands


    }
}