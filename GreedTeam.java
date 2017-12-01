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
        //This is the movement template from Professor Lepinski's TestTeam.java file
        List<Command> cmds = new ArrayList<Command>();
        for(Robot r: robotsAwaitingCommand){
            Random rand = new Random();
            int num = rand.nextInt(4);
            DirType dir = null;
            Location robotLocation = roboLocation(information, r);

            if(CoinPickUp(robotLocation, r) == true){
                //if the robot can pick up the coin, pick it up. Else, move somewhere else.
                cmds.add(new CommandCoin(r));
            }
            if(state.turns_remaining > 30){
                //we will scatter in the beginnning because it is hard to implement 
                //deterministic rules in  the beginning
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
            else{
                for(Robot r1: robotsAwaitingCommand){
                    //once we are done scattering, we now want to move in a deterministic way
                        int x_diff = (roboLocation(information, r).getX() - roboLocation(information, r1).getX());
                        int y_diff = (roboLocation(information, r).getY() - roboLocation(information, r1).getY());
                        if( -2 <= x_diff  || x_diff <= 2) {
                            //I am too close to a team member in X
                            if(r.getID() == r1.getID()){
                            }
                            if( -2 <= y_diff  || y_diff <= 2) {
                                //I am also too close to a team member in Y
                                //I have to be too close in both directions for there to be a problem
                                if(r.getID() == r1.getID()){
                                }
                                //If We have reached this point, we are both too close in X and 
                                //too close in Y, we must go away from our other bot.
                                else if(x_diff < 0 || y_diff < 0){
                                    System.out.println("I Moved in an X Way");
                                    //We should move west or North
                                    switch(num){
                                        case 0: dir = DirType.North;
                                        break;
                                        case 1: dir = DirType.North;
                                        break;
                                        case 2: dir = DirType.West;
                                        break;
                                        case 3: dir = DirType.West;
                                        break;
                                        }
                                    }
                                else{
                                    System.out.println("I Moved in an Y Way");
                                    switch(num){
                                        case 0: dir = DirType.South;
                                        break;
                                        case 1: dir = DirType.South;
                                        break;
                                        case 2: dir = DirType.East;
                                        break;
                                        case 3: dir = DirType.East;
                                        break;
                                        }
                                    }
                                }
                        }

                        
                        /*if( -2 <= x_diff  || x_diff <= 2) {
                            //I am too close to a team member in X
                            if(r.getID() == r1.getID()){
                            }
                            else if(x_diff < 0){
                                dir = DirType.West;
                                System.out.println("I moved in a special way: West");
                            }
                            else{
                                dir = DirType.East;
                                //System.out.println("I moved in a special way: East");
                            }
                        }
                        if( -2 <= y_diff  || y_diff <= 2) {
                            //I am too close to a team member in Y
                            if(r.getID() == r1.getID()){
                            }
                            else if(y_diff < 0){
                                dir = DirType.North;
                                //System.out.println("I moved in a special way: North");
                            }
                            else{
                                dir = DirType.South;
                                //System.out.println("I moved in a special way: South");
                            }
                        }
                        */
                        else{
                            switch(num){
                                //If the bot does not have a problem in X or Y then it should just move randomly
                                case 0: dir = DirType.North;
                                break;
                                case 1: dir = DirType.South;
                                break;
                                case 2: dir = DirType.East;
                                break;
                                case 3: dir = DirType.West;
                                break;
                                }
                        }
                    }
                    
                    cmds.add(new CommandMove(r, dir));
                }

            }
        return cmds;
    }
}
