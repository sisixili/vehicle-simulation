import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Pedestrian Class
 * 
 * Moves mindlessly up the road, reacting to cars
 * that hit it, ambulances that heal it, and potentially
 * buses that pick it up.
 * 
 * @author Jordan Cohen
 * 
 */
public abstract class Pedestrian extends Actor
{
    // Instance variables
    private int myWidth;
    protected boolean isDead = false;
    private int startSpeed = 1;
    protected int speed; 
    // Constructor
    public Pedestrian()
    {
        // figure out own width (related to checking if at world's edge)
        GreenfootImage g = this.getImage();
        myWidth = g.getWidth();
        // Set initial speed
        speed = startSpeed;
    }
    //Walk pattern for all Pedestrians. It rotates the actor to face upwards, moves it, and then reset 
    //rotation back to 0. Makes actor appear as if it is moving up while facing right. 
    protected void walk(int rotation, int speed) 
    {                     
        if (isDead == false) 
        {
            // move upwards   
            setRotation(rotation);
            move(speed);
            setRotation(0); 
            // check if I'm at the edge of the world,
            // and if so, remove myself
            if (atWorldEdge())
                getWorld().removeObject(this);  
        }
    }    

    /**
     * Method causes this Pedestrian to stop moving
     * and appear to fall over
     */
    //Bulldozer and class call this class to knock over all pedestrians 
    //and DrunkPedestrians respectively. 
    public void knockMeOver ()
    {
        speed = 0; 
        setRotation(90);
        isDead = true;
    }
    /**
     * Method causes this pedestrian to "heal" - regain
     * upright position and start moving again
     */
    //Ambulance calls this to heal pedestrians.
    public void healMe ()
    {
        speed = startSpeed;
        setRotation(0); 
        isDead = false;
    }   
    /**
     * Method causes the pedestrian to get picked up
     * by the bus - not yet implemented
     */
    //Bus calls this to pick up DrunkPedestrians
    public void pickMeUp()
    {
        if (isDead == false) 
            getWorld().removeObject(this);       
    }  
    public boolean getIsDead()
    {
        return isDead;
    }
    public void setIsDead(boolean b)
    {
        isDead = b;
    }  
    /**
     * Handy method that checks if this object is at the edge
     * of the World
     * 
     * @return boolean  true if at or past the edge of the World, otherwise false
     */
    protected boolean atWorldEdge()
    {
        if (getX() < -(myWidth / 2) || getX() > getWorld().getWidth() + (myWidth / 2))
            return true;
        else if (getY() < -(myWidth / 2) || getY () > getWorld().getHeight() + (myWidth / 2))
            return true;
        else
            return false;
    }
}
