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
        //this needs to be made
        Location location1 = information.get(0);
        Location location2 = information.get(1);
        Location location3 = information.get(2);
        Location location4 = information.get(3);
        if (!location1.getCoins().isEmpty()){
            CommandCoin command1 = new CommandCoin(robotsAwaitingCommand.get(0));
        } else {
            DirType dir1 = location1.getDirections.get(0);
            CommandMove(robotsAwaitingCommand.get(0), dir1);
        }

        if (!location2.getCoins().isEmpty()){
            CommandCoin command2 = new CommandCoin(robotsAwaitingCommand.get(1));
        } else {
            DirType dir2 = location2.getDirections.get(0);
            CommandMove(robotsAwaitingCommand.get(1), dir2);
        }

        if (!location3.getCoins().isEmpty()){
            CommandCoin command3 = new CommandCoin(robotsAwaitingCommand.get(2));
        } else {
            DirType dir3 = location3.getDirections.get(0);
            CommandMove(robotsAwaitingCommand.get(2), dir3);
        }

        if (!location4.getCoins().isEmpty()){
            CommandCoin command4 = new CommandCoin(robotsAwaitingCommand.get(3));
        } else {
            DirType dir4 = location4.getDirections.get(0);
            CommandMove(robotsAwaitingCommand.get(3), dir4);
        }


    }
}