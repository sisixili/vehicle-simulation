    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
public class Ambulance extends Vehicle
{
    private int offset = (this.getImage().getWidth() / 2) + 1;
    public Ambulance ()
    {
        speed = 3;
    }
    public void act ()
    {
        checkHitPedestrian ();  
        drive();
        checkEdges();
    }
    // Check collision for a pedestrian one pixel ahead of the Vehicle
    public void checkHitPedestrian ()
    {       
        DrunkPedestrian d = (DrunkPedestrian)getOneObjectAtOffset(offset, 0, DrunkPedestrian.class);
        if (d != null)
        {
            d.healMe();
            d.setIsDead(false);
            d.setIsSober(true);
        }                 
        TrafficLight l = (TrafficLight)getOneObjectAtOffset(offset, this.getImage().getHeight() / 2 - 1, TrafficLight.class);       
        if (l != null && l.getIsDead() == true)
        {
            l.healMe();
            l.setIsDead(false);
        }        
    }
}
