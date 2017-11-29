import java.util.*;

public class GreedTeam implements PlayerTeam{
    public boolean isTeamOne;
    public List<Robot> chooseTeam(boolean teamOne, GameState state){
        this.isTeamOne = teamOne;
        //making list to hold teams
        List<Robot> theTeam = new ArrayList<Robot>();
        //Now I am making all of the bots for our team 
        CoreBot bot1 = new CoreBot();
        //CoreBot bot2 = new CoreBot();
        //CoreBot bot3 = new CoreBot();
        //CoreBot bot4 = new CoreBot();
        WolfBot bot2 = new WolfBot();
        SkunkBot bot3 = new SkunkBot();
        RabbitBot bot4 = new RabbitBot();
        //BatBot bot5 = new BatBot();

        //now add robots to list
        theTeam.add(bot1);
        theTeam.add(bot2);
        theTeam.add(bot3);
        theTeam.add(bot4);
        return theTeam;
    }
    public boolean CoinPickUp(Location loc, Robot rob){
        //this function will return a boolean as to whether the robot can pick up a 
        //coin or not.
        if(loc.getCoins() ==  null || loc.getCoins().isEmpty()){
            return false;
        }
        else{
            if(Collections.disjoint(PossibleCoins(rob), loc.getCoins())){    
                //no overlap
                return false;
            }
            else{
                return true;
            }
        }
    }

    public List<CoinType> PossibleCoins(Robot rob){
        //go through all robots and create a list of coins they can pick up, return the list
        List<CoinType> coinsCanPickup = new ArrayList<CoinType>();
        if(rob.getModel() == ModelType.WolfBot || rob.getModel() == ModelType.SkunkBot){
            coinsCanPickup.add(CoinType.Silver);
            coinsCanPickup.add(CoinType.Bronze);
        }
        if(rob.getModel() == ModelType.RabbitBot){
            coinsCanPickup.add(CoinType.Silver);
            coinsCanPickup.add(CoinType.Bronze);
            coinsCanPickup.add(CoinType.Gold);
        }
        if(rob.getModel() == ModelType.CoreBot){
            coinsCanPickup.add(CoinType.Silver);
            coinsCanPickup.add(CoinType.Bronze);
            coinsCanPickup.add(CoinType.Gold);
            coinsCanPickup.add(CoinType.Diamond);
        }
        return coinsCanPickup;
    }

    public Location roboLocation(List<Location> information, Robot rob){
        Location aLocation = null;
        for(Location loc : information){
            List<? extends Robot> bots = loc.getRobots();
            if(bots == null || bots.isEmpty()){
                continue;
                //start for loop again for next location
            }
            else{
                for(Robot robo : bots){
                    if(robo.getID() == rob.getID()){
                        aLocation = loc;
                    }
                }
            }
        }
        return aLocation;
    }

    public List<Command> requestCommands(List<Location> information, List<Robot> robotsAwaitingCommand, GameState state){
        /*this.robotsAwaitingCommand = theTeam; 
        Location location1 = information.get(0);
        Location location2 = information.get(1);
        Location location3 = information.get(2);
        Location location4 = information.get(3);
        */

        //information.get() is returning a random location that the team can see.
        //information is filled with locations that are scanned by the team so getting the
        //first four things gets us locations that some bots cannot even move to
        //this does not give us the location of a robot

        //commenting this out
        /*if (!location1.getCoins().isEmpty()){
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
        */
        
        //This is the movement template from Lepinski's TestTeam.java file
        
        List<Command> cmds = new ArrayList<Command>();
        for(Robot r: robotsAwaitingCommand){
            Random rand = new Random();
            int num = rand.nextInt(4);
            DirType dir = null;
            Location robotLocation = roboLocation(information, r);

            if(CoinPickUp(robotLocation, r) == true){
                cmds.add(new CommandCoin(r));
            }
            else{

                //this will tell robots to move randomly
                switch(num){
                case 0: dir = DirType.North;
                break;
                case 1: dir = DirType.South;
                break;
                case 2: dir = DirType.East;
                break;
                case 3: dir = DirType.West;
                break;
                }
                cmds.add(new CommandMove(r, dir));
            }
        }
        return cmds;
    }
}