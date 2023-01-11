import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * MyWorld functions as the Controller for this Greenfoot
 * project which helps students understand inheritance
 * 
 * INSERT YOUR WRITTEN TASK HERE:
 * Inheritance is useful in scenario because the child classes can inherit certain methods from its 
 * parent so there is less redundant code. In Vehicle.class, subclasses inherit int speed, 
 * checkHitPedestrian(), checkEdges(), and drive(). The subclasses then add on their distinct 
 * checkHitPedestrian() code, while all sharing features from Vehicle.class. For example, Bus.class 
 * picks up DrunkPedestrian.class. It will get slower until it has taken 3 passengers. Then it will 
 * eject a passenger behind it and resume a slower speed.
 * In Pedestrian.class, subclasses inherit boolean isDead, the ability to be knocked over, healed, and 
 * picked up by a vehicle. It also includes walk(), atWorldEdge(), and getter and setter methods for isDead. 
 * These common behaviours apply to all Pedestrians. DrunkPedestrians have an additional random movement 
 * walk pattern. They "shake" back and forth as if they were drunk. There is an isSober boolean value.
 * 
 * @version October 2020
 * @since March 2015
 */
public class MyWorld extends World
{
    private int randomize;
    /**
     * Spawn Rates:
     * Lower number means more spawns
     * 3:spawnRate chance per act of spawning a random Vehicle
     * 1:pedSpawn chance per act of spawning a Pedestrian
     */
    private int spawnRate = 180; // must be higher than 3 ... should be higher than 30
    private int pedSpawn = 100; 

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
    }
    public void act ()
    {
        // Rum methods to see if any pedestrians or vehicles are going to be 
        // spawned this act:
        spawnPedestrians();
        spawnVehicles();    

    }
    private void spawnVehicles()
    {
        // Generate a random number to add a random element
        // to Vehicle spawning
        randomize = Greenfoot.getRandomNumber(spawnRate);

        // Chose a random lane in case a vehicle spawns
        int lane = Greenfoot.getRandomNumber (6);
        int spawnY = getYPosition (lane);

        // spawn vehicles
        if (randomize == 1)
        {
            // spawn a Car
            addObject (new Car(), 10, spawnY);
        }
        else if (randomize == 2)
        {
            // spawn a Bus
            addObject (new Bus(), 10, spawnY);
        }

        else if (randomize == 3 || randomize == 5)
        {
            // spawn a Car
            addObject (new Ambulance(), 10, spawnY);
        } 
        else if (randomize == 4) 
        {
            addObject (new Bulldozer(), 590, spawnY);           
        }
    }
    private void spawnPedestrians()
    {
        // spawn pedestrians
        if (Greenfoot.getRandomNumber(pedSpawn) == 1)
        {
            addObject (new TrafficLight(), Greenfoot.getRandomNumber(590) + 10, 395);
        }
        if (Greenfoot.getRandomNumber(pedSpawn) == 2)
        {
            addObject (new DrunkPedestrian(), Greenfoot.getRandomNumber(590) + 10, 395);
        }
    }
    /**
     * Returns the appropriate y coordinate for a given lane
     */
    private int getYPosition (int inLane)
    {
        // Manually input values based on the background graphic
        switch (inLane)
        {
            case 0: 
            return 78;

            case 1:
            return 127;

            case 2:
            return 175;

            case 3:
            return 222;

            case 4:
            return 272;

            case 5: 
            return 320;

        }  
        // In case an invalid value is passed in
        return 0;
    }    
}

