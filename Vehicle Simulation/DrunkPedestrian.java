import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DrunkPedestrian here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DrunkPedestrian extends Pedestrian
{
    /**
     * Act - do whatever the DrunkPedestrian wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */  
    private boolean isSober = false;
    
    public DrunkPedestrian()
    {
        GreenfootImage drunk = getImage();
        drunk.scale(drunk.getWidth() - 160, drunk.getHeight() - 240);
        setImage(drunk);   
    }
    //DrunkPedestrian "shakes", or is drunk, before an Ambulance hits it. 
    //It resumes a normal walk after being hit into sobriety.
    public void act() 
    {       
         if (isSober == false) 
             walk(225 + (Greenfoot.getRandomNumber(90)),Greenfoot.getRandomNumber(4));         
         else          
             walk(270, speed);         
    }
    public void setIsSober(boolean b)
    {
         isSober = b;
    } 
}
