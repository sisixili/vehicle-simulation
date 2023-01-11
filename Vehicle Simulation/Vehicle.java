import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class Vehicle extends Actor
{   
    // Variables in abstract classes should be
    // implemented 
    protected int speed;
    /**
     * Abstract method declarations: 
     * This means that all Vehicles must have a
     * move() amd checkHitPedestrian() method with the same signature:
     * E.g: public void move ();
     * 
     * HINT:
     * However, in this current implementation, the drive()
     * method for all three subclasses is the same. Perhaps
     * one of these methods will change if you implement something
     * interesting that requires different drive methods. If not,
     * it would be more efficient to actually write the method
     * here, making it inherited by not abstract.
     */
    //All Vehicles must have this method. 
    public abstract void checkHitPedestrian();   
    // Remove me if I've gone fully off the edge
    protected void checkEdges(){
        if (getX() < -getImage().getWidth() || getX() > getWorld().getBackground().getWidth() + getImage().getWidth()){
            getWorld().removeObject(this);
        }
    }      
    /**
     * Method that deals with movement. Speed can be set by individual subclasses in their constructors
     */
    //Vehicle only moves if there is no Vehicle or no living TrafficLight in front. 
    protected void drive() 
    {       
        TrafficLight l = (TrafficLight)getOneObjectAtOffset((this.getImage().getWidth() / 2) + 2, 0, TrafficLight.class);
        Vehicle ahead = (Vehicle) getOneObjectAtOffset (speed + getImage().getWidth()/2, 0, Vehicle.class);
        if (ahead == null && (l == null || l.getIsDead() == true)) {      
            move(speed); 
        }
    }   
    //Bulldozer calls this to remove vehicles. 
    protected void removeHitVehicle()
    {
        getWorld().removeObject(this); 
    }  
}





