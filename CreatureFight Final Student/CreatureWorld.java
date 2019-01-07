/**
 * Name: Austin
 * Techer Name: Mr Hardman
 * Class: ptec software development
 * Date: 12/10/2018
 * 
 * Knowledge & Understanding:    18/20
 *    Percent Grade for
 *    how well student 
 *    followed standards:      90%
 *
 *    Missing comment block for changePlayerOne
 *    Watch for indentation issues (Golem, Ivysaur)
 *
 * Problem-Solving:              18.5/20
 *    Percent Grade for 
 *    completion of 
 *    assignment requirements: 92.5%
 *
 *    List of incorrect TODOs: 
 *        TODO 155
 *        TODO 176
 *        TODO 179
 *        Ivysaur's switchCreature method calls and related if statements are incorrect
 *        Pidgeot's switchCreature method calls and related if statements are incorrect
 * 
 */

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
import java.util.List;

/**
 * MyWorld is the world that the 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CreatureWorld extends World
{
    //TODO (5): Change the data type of these two variables from Creature to String
    private String playerOneCreature;
    private String playerTwoCreature;

    private int turnNumber;

    private Menu oneFightMenu;
    private Menu oneSwitchMenu;
    private Menu twoFightMenu;
    private Menu twoSwitchMenu;

    private boolean playerOneMenusAdded;
    private boolean playerTwoMenusAdded;

    private String playerOneName = "1";
    private String playerTwoName = "2";

    //TODO (80): Declare two Creature instance arrays, one for the collection of playerOneCreatures and one for the collection of playerTwoCreatures
    private Creature[] playerOneCreatures;// = {new Charmander(this), new Golem(this), new Ivysaur(this)};
    private Creature[] playerTwoCreatures;// = {new Pikachu(this), new Lapras(this), new Pidgeot(this)};
   

    /**
     * Default constructor for objects of class CreatureWorld that sets the valuse for the the player one and two
     * creatures, runs the prepare creature method and than starts the game
     * 
     * @param There are no parameters
     * @return an object of class CreatureWorld
     */
    public CreatureWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(400, 400, 1);

        //TODO (6): Change these two variables to store the names of the playerOne and playerTwo Creatures, Charmander and Pikachu respectively
        playerOneCreature = "Charmander";
        playerTwoCreature = "Pikachu";

        /**
         * TODO (81): Initialize the playerOneCreatures array to a new Creature array that stores a 
         *          new Charmander object, a new Golem object, and a new Ivysaur object
         */
        
        playerOneCreatures = new Creature[3];
        playerOneCreatures[0] = new Charmander(this);
        playerOneCreatures[1] = new Golem(this);
        playerOneCreatures[2] = new Ivysaur(this);
        
        //playerOneCreatures = {new Ivysaur(this), new Golem(this), new Charmander(this)};
        
        /**
         * TODO (154): Initialize the playerTwoCreatures array to a new Creature array that stores a 
         *          new Pikachu object, a new Lapras object, and a new Pidgeot object
         */
        
        playerTwoCreatures = new Creature[3];
        playerTwoCreatures[0] = new Pikachu(this);
        playerTwoCreatures[1] = new Lapras(this);
        playerTwoCreatures[2] = new Pidgeot(this);
        
        prepareCreatures();

        turnNumber = 0;

        playerOneMenusAdded = false;
        playerTwoMenusAdded = false;
        
        //Greenfoot.start();
    }

    /**
     * act will complete actions that the CreatureWorld object should
     * accomplish while the scenario is running
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void act()
    {
        List allObjects = getObjects(null);

        //TODO (7): Declare two local boolean variables called playerOneLose and playerTwoLose that are both initialized to true
        boolean playerOneLose = true;
        boolean playerTwoLose = true;

        if( turnNumber == 0 )
        {
            playerOneName = JOptionPane.showInputDialog( "Please enter your name, Player One:", null );
            playerTwoName = JOptionPane.showInputDialog( "Please enter your name, Player Two:", null );
            turnNumber = 1;
        }
        else if( turnNumber == 1 )
        {
            showText( "Your turn, " + playerOneName, getWidth()/2, getHeight()/2 );
            showText( "", getWidth()/2, getHeight()/2 + 26 );
        }
        else
        {
            showText( "Your turn, " + playerTwoName, getWidth()/2, getHeight()/2 );
            showText( "", getWidth()/2, getHeight()/2 + 26 );
        }
        
        
        
        
        
        
        if( playerOneMenusAdded == false )
        {
            //TODO (95): If playerOneCreature equals (ignoring case) "Charmander"...

            //TODO (96): Place the oneFightMenu and oneSwitchMenu initializations for Charmander inside this if statement

            //TODO (97): Otherwise, if playerOneCreature equals (ignoring case) "Golem"...
            //TODO (98): Set oneFightMenu to a new Fight menu that has options for Tackle and Earthquake
                
            //TODO (99): Set oneSwitchMenu to a new Switch menu that has options to change to Charmander or Ivysaur

            //TODO (100): Otherwise...
            //TODO (101): Set oneFightMenu to a new Fight menu that has options for Tackle and Razor Leaf
                
            //TODO (102): Set oneSwitchMenu to a new Switch menu that has options to change to Charmander or Golem
            if(playerOneCreature.equalsIgnoreCase("Charmander"))
            {
                oneFightMenu = new Menu(" Fight ", " Scratch \n Flamethrower ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());
                oneSwitchMenu = new Menu(" Switch ", " Golem \n Ivysaur ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());
            }
            else if(playerOneCreature.equalsIgnoreCase("Golem"))
            {
                oneFightMenu = new Menu(" Fight ", " Tackle \n Earthquake ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());
                oneSwitchMenu = new Menu(" Switch ", " Charmander \n Ivysaur ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());
            }
            else
            {
                oneFightMenu = new Menu(" Fight ", " Tackle \n Razor Leaf ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());
                oneSwitchMenu = new Menu(" Switch ", " Charmander \n Golem ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());
            }

            addObject(oneFightMenu, 173, getHeight() - 100 );
            addObject(oneSwitchMenu, 241, getHeight() - 100);

            playerOneMenusAdded = true;
        }

        if( playerTwoMenusAdded == false )
        {
            //TODO (168): If playerTwoCreature equals (ignoring case) "Pikachu"...
            if(playerTwoCreature.equalsIgnoreCase("Pikachu"))
            {
                //TODO (169): Place the twoFightMenu and twoSwitchMenu initializations for Pikachu inside this if statement
                twoFightMenu = new Menu(" Fight ", " Tackle \n Thunderbolt ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());
                twoSwitchMenu = new Menu(" Switch ", " Lapras \n Pidgeot ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());
            }
            else if(playerTwoCreature.equalsIgnoreCase("Lapras"))
            {
                //TODO (169): Place the twoFightMenu and twoSwitchMenu initializations for Pikachu inside this if statement
                twoFightMenu = new Menu(" Fight ", " Tackle \n Hydro Pump ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());
                twoSwitchMenu = new Menu(" Switch ", " Pikachu \n Pidgeot ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());
            }
            else
            {
                //TODO (169): Place the twoFightMenu and twoSwitchMenu initializations for Pikachu inside this if statement
                twoFightMenu = new Menu(" Fight ", " Tackle \n Wing Attack ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());
                twoSwitchMenu = new Menu(" Switch ", " Pikachu \n Lapras ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());
            }
            //TODO (170): Otherwise, if playerTwoCreature equals (ignoring case) "Lapras"...

            //TODO (171): Set twoFightMenu to a new Fight menu that has options for Tackle and Hydro Pump

            //TODO (172): Set twoSwitchMenu to a new Switch menu that has options to change to Pikachu or Pidgeot
            
            //TODO (173): Otherwise...

            //TODO (174): Set twoFightMenu to a new Fight menu that has options for Tackle and Wing Attack

            //TODO (175): Set twoSwitchMenu to a new Switch menu that has options to change to Pikachu or Golem
            addObject(twoFightMenu, 131, 75);
            addObject(twoSwitchMenu, 199, 75);

            playerTwoMenusAdded = true;
        }
        //TODO (176): Declare a for loop that runs while playerOneLose is true AND index is less than the length of the playerOneCreatures array
        //What if the length of the array changed?
        for(int i = 0; playerOneLose == true && i < playerOneCreatures.length; i++)
        {
            //TODO (177): If the player one creature at the current index of the array's current health is greater than 0...
            if(playerOneCreatures[i].getHealthBar().getCurrent() > 0)
            {
                //TODO (178): Set playerOneLose to false
                playerOneLose = false;
            }
        }

        //TODO (179): Declare a for loop that runs while playerTwoLose is true AND index is less than the length of the playerTwoCreatures array

        //TODO (180): If the player two creature at the current index of the array's current health is greater than 0...

        //TODO (181): Set playerTwoLose to false
        for(int j = 0; j < playerTwoCreatures.length && playerTwoLose == true; j++)
        {
            //TODO (177): If the player one creature at the current index of the array's current health is greater than 0...
            if(playerTwoCreatures[j].getHealthBar().getCurrent() > 0)
            {
                //TODO (178): Set playerOneLose to false
                playerTwoLose = false;
            }
        }

        //TODO (8): Change the condition of this if statement to check if playerOneLose is false

        //TODO (182): Change the condition of this if statement to check if playerOneLose is true
        if(playerOneLose == true)
        {
            removeObjects(allObjects);
            showText(playerTwoName + " wins!!", getWidth()/2, getHeight()/2);
            Greenfoot.stop();
        }

        //TODO (9): Change the condition of this if statement to check if playerTwoLose is false
        //TODO (183): Change the condition of this if statement to check if playerTwoLose is true
        if(playerTwoLose == true)
        {
            removeObjects(allObjects);
            showText(playerOneName + " wins!!", getWidth()/2, getHeight()/2);
            Greenfoot.stop();
        } 
        
        
    }

    /**
     * prepareCreatures adds the creatures for both players to the world
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void prepareCreatures()
    {
        //TODO (10): Delete the next two lines inside the prepareCreatures method

        //TODO (82): Declare a loop that will allow you to access every element of the playerOneCreatures array
        for(int i = 0; i < playerOneCreatures.length; i++)
        {
            //TODO (83): If the loop index is 0...
            if(i == 0)
            {
                /**
                 * TODO (84): Add the object stored at the current index of the playerOneCreatures array
                 *          at an x location of playerOneCreatures[i].getImage().getWidth()/2 and
                 *          a y location of getHeight() - playerOneCreatures[i].getImage().getHeight()/2
                 */
                addObject(playerOneCreatures[i], playerOneCreatures[i].getImage().getWidth()/2, getHeight() - playerOneCreatures[i].getImage().getHeight()/2);
            }
            //TODO (85): Otherwise...
            else
            {
                //TODO (86): Set the transparency of the image of the Creature that is stored at the current index of the playerOneCreatures array to 0
                playerOneCreatures[i].getImage().setTransparency(0);

                /**
                 * TODO (87): Add the object stored at the current index of the playerOneCreatures array
                 *          at an x location of 0 and a y location of
                 *          getHeight() - playerOneCreatures[i].getImage().getHeight()/2
                 */
                addObject(playerOneCreatures[i], 0, getHeight() - playerOneCreatures[i].getImage().getHeight()/2);

            }
        }
        //TODO (155): Declare a loop that will allow you to access every element of the playerTwoCreatures array
        //This should technically use playerTwoCreatures.length
        for(int j = 0; j < playerTwoCreatures.length; j++)
        {
            //TODO (156): If the loop index is 0...
            if( j == 0)
            {
                /**
                 * TODO (157): Add the object stored at the current index of the playerTwoCreatures array
                 *          at an x location of getWidth() - playerTwoCreatures[j].getImage().getWidth()/2
                 *          and a y location of playerTwoCreatures[j].getImage().getHeight()/2
                 */
                addObject(playerTwoCreatures[j], getWidth() - playerTwoCreatures[j].getImage().getWidth()/2, playerTwoCreatures[j].getImage().getHeight()/2);
            }
            else
            {
                //TODO (158): Otherwise...

                //TODO (159): Set the transparency of the image of the Creature that is stored at the current index of the playerTwoCreatures array to 0
                playerTwoCreatures[j].getImage().setTransparency(0);

                /**
                 * TODO (160): Add the object stored at the current index of the playerTwoCreatures array
                 *          at an x location of the width of the world and a y location of playerTwoCreatures[j].getImage().getHeight()/2
                 */
                addObject(playerTwoCreatures[j], getWidth(), playerTwoCreatures[j].getImage().getHeight()/2);
            }
        }
    }

    /**
     * getPlayerOne returns player one's current creature for
     * use in other parts of the code or for the user's information
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public Creature getPlayerOne()
    {
        //TODO (11): Declare a local Creature variable called currentPlayerOne initialized to null
        Creature currentPlayerOne = null;

        //TODO (88): If playerOneCreature equals (ignoring case) Charmander...

        if(playerOneCreature.equalsIgnoreCase("Charmander"))
        {
            //TODO (89): Initialize currentPlayerOne to the first element of the playerOneCreatures array
            currentPlayerOne = playerOneCreatures[0];
        }
        else if(playerOneCreature.equalsIgnoreCase("Golem"))
        {
            //TODO (89): Initialize currentPlayerOne to the first element of the playerOneCreatures array
            currentPlayerOne = playerOneCreatures[1];
        }
        else
        {
            //TODO (89): Initialize currentPlayerOne to the first element of the playerOneCreatures array
            currentPlayerOne = playerOneCreatures[2];
        }

        //TODO (90): If playerOneCreature equals (ignoring case) Golem...

        //TODO (91): Initialize currentPlayerOne to the second element of the playerOneCreatures array

        //TODO (92): Otherwise...

        //TODO (93): Initialize currentPlayerOne to the third element of the playerOneCreatures array

        
        //TODO (12): Change this to return the current player one
        return currentPlayerOne;
    }

    /**
     * getPlayerTwo returns player two's current creature for
     * use in other parts of the code or for the user's information
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public Creature getPlayerTwo()
    {
        //TODO (13): Declare a local Creature variable called currentPlayerTwo initialized to null
        Creature currentPlayerTwo = null;

        //TODO (161): If playerTwoCreature equals (ignoring case) Pikachu...

        //TODO (162): Initialize currentPlayerTwo to the first element of the playerTwoCreatures array

        //TODO (163): If playerTwoCreature equals (ignoring case) Lapras...

        //TODO (164): Initialize currentPlayerTwo to the second element of the playerTwoCreatures array

        //TODO (165): Otherwise...

        //TODO (166): Initialize currentPlayerTwo to the third element of the playerTwoCreatures array
        if(playerTwoCreature.equalsIgnoreCase("Pikachu"))
        {
            //TODO (89): Initialize currentPlayerOne to the first element of the playerOneCreatures array
            currentPlayerTwo = playerTwoCreatures[0];
        }
        else if(playerTwoCreature.equalsIgnoreCase("Lapras"))
        {
            //TODO (89): Initialize currentPlayerOne to the first element of the playerOneCreatures array
            currentPlayerTwo = playerTwoCreatures[1];
        }
        else
        {
            //TODO (89): Initialize currentPlayerOne to the first element of the playerOneCreatures array
            currentPlayerTwo = playerTwoCreatures[2];
        }

        //TODO (14): Change this to return the current player two
        return currentPlayerTwo;
    }

    /**
     * getTurnNumber returns a number that represents which player's
     * turn it is (either player 1 or player 2)
     * 
     * @param There are no parameters
     * @return An integer that represents which player's turn it is
     */
    public int getTurnNumber()
    {
        return turnNumber;
    }

    /**
     * setTurnNumber changes the turn number to the appropriate
     * number for which player's turn it is
     * 
     * @param turn is the number that represents which player's turn it is
     * @return Nothing is returned
     */
    public void setTurnNumber( int turn )
    {
        turnNumber = turn;
    }

    /**
     * Method changePlayerOne changes the player one creature with the string creature parameter
     *
     * @param creature A parameter use to set the new player one creature
     * @return nothing is returned
     */
    public void changePlayerOne(String creature)
    {
        playerOneCreature = creature; 
        removeObject(oneSwitchMenu);
        removeObject(oneFightMenu);
        playerOneMenusAdded = false;
    }

    
    /**
     * Method changePlayerTwo changes the player two creature with the string creature parameter
     *
     * @param creature A parameter use to set the new player two creature
     * @return nothing is returned
     */
    public void changePlayerTwo(String creature)
    {
        playerTwoCreature = creature; 
        removeObject(twoSwitchMenu);
        removeObject(twoFightMenu);
        playerTwoMenusAdded = false;
    }

    
    /**
     * Method getNewOneCreature returns the player on creature at the index parameter
     *
     * @param index A parameter used to get the right creature from the arary
     * @return The return value is the specified creature a the index
     */
    public Creature getNewOneCreature(int index)
    {
        return playerOneCreatures[index];
    }

    /**
     * Method getNewTwoCreature returns the player on creature at the index parameter
     *
     * @param index A parameter used to get the right creature from the arary
     * @return The return value is the specified creature a the index
     */
    public Creature getNewTwoCreature(int index)
    {
        return playerTwoCreatures[index];
    }

}
