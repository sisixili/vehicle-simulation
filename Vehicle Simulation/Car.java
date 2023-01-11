import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Car extends Vehicle
{
    public Car ()
    {
        speed = 4;
    }   
    public void act()
    {
        checkHitPedestrian();  
        drive();
        checkEdges();
    }    
    //check if I hit a Pedestrian, and if so, knock it down.     
    public void checkHitPedestrian()
    {
        // Check collision for a pedestrian one pixel ahead of the Vehicle
        DrunkPedestrian p = (DrunkPedestrian)getOneObjectAtOffset((this.getImage().getWidth() / 2) + 1, 0, DrunkPedestrian.class);
        if (p != null)
        {            
            p.knockMeOver();
            p.setIsDead(true);
        }
    }
}
