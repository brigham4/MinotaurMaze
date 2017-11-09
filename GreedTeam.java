import java.util.*;

public class GreedTeam implements PlayerTeam{
    public boolean isTeamOne;
    public List<Robot> chooseTeam(boolean teamOne, GameState state){
        this.isTeamOne = teamOne;
        //making list to hold teams
        List<Robots> theTeam = new List<Robots>();
        //Now I am making 1 core bot to fill it and comment out other bots we want
        CoreBot bot1 = new CoreBot();
        //WolfBot bot 2 = new WolfBot();
        //SkunkBot bot 3 = new SkunkBot();
        //RabbitBot bot 4 = new RabbitBot();
        //BatBot bot 5 = new BatBot();

        //now add robots to list
        theTeam.add(bot1);
        return theTeam;
    }
    public List<Command> requestCommands(List<Location> information, List<Robot> robotsAwaitingCommand, GameState state){
        //this needs to be made
    }
}