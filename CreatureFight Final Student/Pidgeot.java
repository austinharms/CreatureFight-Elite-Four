import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;

/**
 * TODO (153): Copy all code below public class Lapras and paste it below.
 *          You will make a few changes to the code to make it appropriate for
 *          Lapras. These are listed in order from top to bottom:
 *              - Change the constructor to say Pidgeot instead of Lapras
 *              - Pidgeot has 800 points of health
 *              - Pidgeot's type is Flying
 *              - Show text that Pidgeot has fainted when its health bar's value is 
 *                less than or equal to 0
 *                  - When Pidgeot faints, the second thing you should be checking is if getNewTwoCreature 
 *                    at 1 still has health
 *                      - You should be switching to Creature at index 1 if this is the case
 *              - Lapras's second attack...
 *                  - if used against a grass type...
 *                      - Should do two times 55 points of damage (DON'T DO THE MATH! Write the math expression)
 *                      - Should display that the attack is super effective at a location of
 *                        half the width of the world and half the height of the world plus 26
 *                  - otherwise, if used against a rock type...
 *                      - Should do half of 55 points of damage (DON'T DO THE MATH!)
 *                      - Should display that the attack is not very effective at a location of
 *                        half the width of the world and half the height of the world plus 26
 *                  - Delete the next otherwise if
 *                  - otherwise...
 *                      - Should do 55 points of damage
 *              - In switchCreature...
 *                      - In the else condition...
 *                          - Change player two to Lapras
 *              
 */
public class Pidgeot extends Creature
{
     /**
     * Constructor for objects of class Pidgeot
     * 
     * @param w is a reference to the world that Pidgeot gets added to
     * @return An object of type Pidgeot
     */
    public Pidgeot(World w)
    {
        super(800, 2, "Flying");
        setImage("Pidgeot.png");
        getImage().scale(150, 100);
        w.addObject( getHealthBar() , 100, 25 );
        getHealthBar().getImage().setTransparency(0);
    }

    /**
     * Act - do whatever the Pikachu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        CreatureWorld playerWorld = (CreatureWorld)getWorld();

        if( getHealthBar().getCurrent() <= 0 )
        {
            getWorld().showText("Pidgeot has fainted...", getWorld().getWidth()/2, getWorld().getHeight()/2 + 26);
            Greenfoot.delay(30);

            //TODO (142): If the current health of the health bar of the new two creature at index 1 in player world is greater than 0...

            //TODO (143): Call the switchCreature method using a value of 1 as the parameter

            //TODO (144): Set the turn number in player world to 2

            //TODO (145): Clear the text (using an empty String, "") at the location that it stated Pikachu had fainted

            //TODO (146): Remove this object from the world

            //TODO (147): Otherwise, if the current health of the health bar of the new two creature at index 2 in player world is greater than 0...

            //TODO (148): Call the switchCreature method using a value of 2 as the parameter

            //TODO (149): Set the turn number in player world to 2

            //TODO (150): Clear the text (using an empty String, "") at the location that it stated Pikachu had fainted

            //TODO (151): Remove this object from the world
            if(playerWorld.getNewTwoCreature(1).getHealthBar().getCurrent() > 0)
            {
                //TODO (69): Call the switchCreature method using a value of 1 as the parameter
                switchCreature(1);
                //TODO (70): Set the turn number in player world to 1
                playerWorld.setTurnNumber(2);
                //TODO (71): Clear the text (using an empty String, "") at the location that it stated Charmander had fainted
                getWorld().showText("", getWorld().getWidth()/2, getWorld().getHeight()/2 + 26);
                //TODO (72): Remove this object from the world
                getWorld().removeObject(this);
            }
            //TODO (73): Otherwise, if the current health of the health bar of the new one creature at index 2 in player world is greater than 0...
            else if(playerWorld.getNewTwoCreature(2).getHealthBar().getCurrent() > 0)
            {
                //TODO (69): Call the switchCreature method using a value of 1 as the parameter
                switchCreature(2);
                //TODO (70): Set the turn number in player world to 1
                playerWorld.setTurnNumber(2);
                //TODO (71): Clear the text (using an empty String, "") at the location that it stated Charmander had fainted
                getWorld().showText("", getWorld().getWidth()/2, getWorld().getHeight()/2 + 26);
                //TODO (72): Remove this object from the world
                getWorld().removeObject(this);
            }
        }

    } 

    /**
     * attack takes away health from the enemy Creature using one of
     * two predefined attacks
     * 
     * @param idx is the index of the attack option selected
     * @return Nothing is returned
     */
    public void attack(int idx)
    {
        CreatureWorld playerWorld = (CreatureWorld)getWorld();
        Creature enemy = playerWorld.getPlayerOne();
        String enemyType = enemy.getType();

        //TODO (109): Make a call to the attackAnimation method
        attackAnimation();

        if( idx == 0 )
        {
            enemy.getHealthBar().add( -30 );
        }
        else
        {
            //TODO (110): If the enemy type equals (ignoring case) Rock...
            if(enemyType.equalsIgnoreCase("grass"))
            {
                //TODO (111): The enemy receives zero damage
                enemy.getHealthBar().add( -(55*2) );

                /**
                 * TODO (112): Show text that states the attack has no effect at a x location of half the width of the world 
                 *          and a y location of half the height of the world plus 26 pixels
                 */
                playerWorld.showText("attack was very effective", playerWorld.getWidth()/2, (playerWorld.getHeight()/2) + 26);

                //TODO (113): Delay the scenario by 30 pixels
                Greenfoot.delay(30);
            }
            //TODO (114): If the enemy type equals (ignoring case) Grass...
            else if(enemyType.equalsIgnoreCase("rock"))
            {
                enemy.getHealthBar().add( -(55/2) );

                /**
                 * TODO (112): Show text that states the attack has no effect at a x location of half the width of the world 
                 *          and a y location of half the height of the world plus 26 pixels
                 */
                playerWorld.showText("attack was not very effective", playerWorld.getWidth()/2, (playerWorld.getHeight()/2) + 26);

                //TODO (113): Delay the scenario by 30 pixels
                Greenfoot.delay(30);
            }
            else
            {
                //TODO (118): Otherwise...

                //TODO (119): Take the line from below that takes away 65 points of health and place it inside this else

                enemy.getHealthBar().add( -55 );
            }
        }

        playerWorld.setTurnNumber(1);
    }

    /**
     * Method attackAnimation is the animation the creature dose when it attacks
     *
     * @param nothing there are no parameters
     * @return nothing is returned
     */
    private void attackAnimation()
    {
        int originalX = getX();
        int originalY = getY();
        for(int i = 0; i < 15; i++)
        {
            setLocation(getX() - 1, getY() + 2);
            Greenfoot.delay(1);
        }
        setLocation(originalX, originalY);
    }

    /**
     * Method switchCreature switchs the the curent creature to the new selected creature and playes the proper animations
     *
     * @param idx A parameter useed to get the creature you are switching to
     * @return nothing is returned
     */
    public void switchCreature(int idx)
    {
        CreatureWorld playerWorld = (CreatureWorld)getWorld();
        Creature switchCreature = playerWorld.getNewTwoCreature(idx);
        if(switchCreature.getHealthBar().getCurrent() <= 0)
        {
            JOptionPane.showMessageDialog( null, "Creature you have chosen has fainted and you must select a different option");
        }
        else
        {
            while(getX() < playerWorld.getWidth() - 1)
            {
                setLocation(getX() + 5, getY());
                Greenfoot.delay(2);
            }
            getImage().setTransparency(0);
            getHealthBar().getImage().setTransparency(0);
            if(idx == 0)
            {
                playerWorld.changePlayerTwo("Pikachu");
            }
            else
            {
                playerWorld.changePlayerTwo("Lapras");
            }
            switchCreature.switchedIn();
            playerWorld.setTurnNumber(1);
        }
    }

    /**
     * Method switchedIn dose the animation for when the creature is switched
     *
     *@param nothing there are no parameters
     *@return nothing is returned
     */
    public void switchedIn()
    {
        this.getImage().setTransparency(255);
        this.getHealthBar().getImage().setTransparency(255);
        while(getX() > getWorld().getWidth() - (getImage().getWidth()/2))
        {
            setLocation(getX() - 5, getY());
            Greenfoot.delay(2);
        }
    }
}
