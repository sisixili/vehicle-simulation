import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

//By Mr. Cohen

public class LaneSpawnCheck extends Actor
{
    private GreenfootImage blank;
    // possibly uneccesary, but a good idea for future improvements/extensions.
    private int laneNum;
    
    // Constructor - requires a laneNum so it can be self-aware
    public LaneSpawnCheck (int laneNum){
        // create and set a blank image - so this can be present, but unseen.
        blank = new GreenfootImage(50, 50);
        setImage(blank);
        this.laneNum = laneNum;
    }
    
    /**
     * Check if this LaneSpawnCheck is touching a Vehicle
     * 
     * @return boolean  is a vehicle present?
     */
    public boolean vehiclePresent (){
        return isTouching (Vehicle.class);
    } 
}
