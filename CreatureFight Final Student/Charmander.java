import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;

/**
 * Write a description of class Charmander here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Charmander extends Creature
{
    /**
     * Constructor for objects of class Charmander
     * 
     * @param w is a reference to the world that Charmander gets added to
     * @return An object of type Charmander
     */
    public Charmander(World w)
    {
        super(700, 1, "Fire");
        setImage("Charmander.png");
        getImage().scale(150, 100);
        w.addObject( getHealthBar() , 300, w.getHeight() - 50 );
    }

    /**
     * Act - do whatever the Charmander wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        CreatureWorld playerWorld = (CreatureWorld)getWorld();

        if( getHealthBar().getCurrent() <= 0 )
        {
            getWorld().showText("Charmander has fainted...", getWorld().getWidth()/2, getWorld().getHeight()/2 + 26);
            Greenfoot.delay(30);

            //TODO (68): If the current health of the health bar of the new one creature at index 1 in player world is greater than 0...
            if(playerWorld.getNewOneCreature(1).getHealthBar().getCurrent() > 0)
            {
                //TODO (69): Call the switchCreature method using a value of 1 as the parameter
                switchCreature(1);
                //TODO (70): Set the turn number in player world to 1
                playerWorld.setTurnNumber(1);
                //TODO (71): Clear the text (using an empty String, "") at the location that it stated Charmander had fainted
                getWorld().showText("", getWorld().getWidth()/2, getWorld().getHeight()/2 + 26);
                //TODO (72): Remove this object from the world
                getWorld().removeObject(this);
            }
            //TODO (73): Otherwise, if the current health of the health bar of the new one creature at index 2 in player world is greater than 0...
            else if(playerWorld.getNewOneCreature(2).getHealthBar().getCurrent() > 0)
            {
                //TODO (69): Call the switchCreature method using a value of 1 as the parameter
                switchCreature(2);
                //TODO (70): Set the turn number in player world to 1
                playerWorld.setTurnNumber(1);
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
        Creature enemy = playerWorld.getPlayerTwo();
        String enemyType = enemy.getType();

        //TODO (39): Make a call to the attackAnimation method
        attackAnimation();

        if( idx == 0 )
        {
            enemy.getHealthBar().add( -25 );
        }
        else
        {
            //TODO (40): If the enemy type equals (ignoring case) Water...
            if(enemyType.equalsIgnoreCase("water"))
            {
                //TODO (41): The enemy only receives half damage of the normal attack (70 points). DON'T DO THE MATH! Just type the mathematical expression you would use
                enemy.getHealthBar().add(-(70/2));
                /**
                 * TODO (42): Show text that states the attack was not very effective at a x location of half the width of the world 
                 *          and a y location of half the height of the world plus 26 pixels
                 */
                playerWorld.showText("attack was not very effective", playerWorld.getWidth()/2, (playerWorld.getHeight()/2) + 26);
                //TODO (43): Delay the scenario by 30 pixels
                Greenfoot.delay(30);
            }
            else
            {
                //TODO (44): Otherwise...

                //TODO (45): Take the line from below that takes away 70 points of health and place it inside this else

                enemy.getHealthBar().add( -70 );
            }
        }

        playerWorld.setTurnNumber(2);
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
            setLocation(getX() + 1, getY() - 2);
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
        Creature switchCreature = playerWorld.getNewOneCreature(idx);
        if(switchCreature.getHealthBar().getCurrent() <= 0)
        {
            JOptionPane.showMessageDialog( null, "Creature you have chosen has fainted and you must select a different option");
        }
        else
        {
            while(getX() > 0)
            {
                setLocation(getX() - 5, getY());
                Greenfoot.delay(2);
            }
            getImage().setTransparency(0);
            getHealthBar().getImage().setTransparency(0);
            if(idx == 1)
            {
                playerWorld.changePlayerOne("Golem");
            }
            else
            {
                playerWorld.changePlayerOne("Ivysaur");
            }
            switchCreature.switchedIn();
            playerWorld.setTurnNumber(2);
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
        getImage().setTransparency(255);
        getHealthBar().getImage().setTransparency(255);
        while(getX() < getImage().getWidth()/2)
        {
            setLocation(getX() + 5, getY());
            Greenfoot.delay(2);
        }
    }
}
