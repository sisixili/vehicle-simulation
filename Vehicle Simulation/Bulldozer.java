import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bulldozer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bulldozer extends Vehicle
{
    //Offset: collission test is done one pixel ahead of vehicle.
    private int offset = (this.getImage().getWidth() / 2) + 1;
    private DrunkPedestrian d;    
    private TrafficLight l;
    private Vehicle v;
    
    public Bulldozer () 
    {                
        speed = 2;
        GreenfootImage bulldozer = getImage();
        bulldozer.scale(bulldozer.getWidth() - 2, bulldozer.getHeight() - 6);
        setImage(bulldozer);
        turn(180);
        getImage().mirrorVertically();
    }
    /**
     * Act - do whatever the Bulldozer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //Bulldozer kills every other object. 
    public void act() 
    {  
        move(speed);       
        if (getX() - offset >= 0) {
            checkHitVehicle(); 
        }        
        checkHitPedestrian();
        checkEdges();
    }  
    public void checkHitPedestrian()
    {
        Pedestrian d = (Pedestrian)getOneObjectAtOffset(-offset, 0, Pedestrian.class);
        if (d != null)
        {
            d.knockMeOver();
            d.setIsDead(true); 
        }        
    } 
    public void checkHitVehicle()
    {
        v = (Vehicle)getOneObjectAtOffset(-offset, 0, Vehicle.class);
        if (v != null)
        {
            v.removeHitVehicle();
        } 
    } 
}
