import java.util.logging.Logger;
public class Squirrel
{
    public static final Logger LOGGER = Logger.getLogger(Squirrel.class.getName());
    public int speed; // Declare a private variable for the squirrel speed.

    public Squirrel(int speed) // Constructor that takes a speed value
    {
        LOGGER.info("Creating a new Squirrel object with speed " + speed);
        this.speed = speed;
    }

    public int getSpeed() // Getter method for the speed variable.
    {
        LOGGER.info("Getting speed " + this.speed + " for a Squirrel object");
        return this.speed;
    }
}