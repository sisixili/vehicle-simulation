import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 
public class Bus extends Vehicle
{    
    public Bus ()
    {
        speed = 3;
    }
    public void act()
    {
        checkHitPedestrian();  
        drive();
        checkEdges();        
    }
    public void checkHitPedestrian ()
    {
        // Check collision for DrunkPedestrian. Picks up any living DrunkPedestrian while decreasing 
        //speed until 3 passengers have been picked up. 
        //Third passenger is dropped off and speed becomes 1. 
        DrunkPedestrian d = (DrunkPedestrian)getOneObjectAtOffset((this.getImage().getWidth() / 2) + 1, 0, DrunkPedestrian.class);
        if (d != null)
        {
            d.pickMeUp();
            speed--;
            if (speed == 0)
            {
                getWorld().addObject(d, getX() - this.getImage().getWidth() / 2 - 2 , getY());             
                speed = 1;
            }
        }
    }
}
