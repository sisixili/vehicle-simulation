import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TrafficLight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TrafficLight extends Pedestrian
{
    /**
     * Act - do whatever the TrafficLight wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public TrafficLight() 
    {
        GreenfootImage trafficLight = getImage();
        trafficLight.scale(trafficLight.getWidth() - 260, trafficLight.getHeight() - 540);
        setImage(trafficLight);
    }
    //TrafficLight walk cycle. 
    public void act() 
    {       
        walk(270, speed);
    }
}
