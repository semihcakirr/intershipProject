import java.util.logging.Logger;
import java.util.*;
public class DiegoTheMathGenius
{
    public static final Logger LOGGER = Logger.getLogger(DiegoTheMathGenius.class.getName());
    static int fastest, slowest; // Declare two static variables for the fastest and slowest squirrel speeds.
    static int besttime, worsttime; // Declare two static variables to store best case and worst case.
    static int sumofspeeds; // Declare a static variable to use in formulas.
    static int[] times; // Declare an array to store the speeds of the squirrels.

    public static void main(String[] args)
    {
        LOGGER.info("Starting DiegoTheMathGenius application...");
        // Create four squirrel objects with different speeds.
        Squirrel squirrel1 = new Squirrel(10);
        Squirrel squirrel2 = new Squirrel(12);
        Squirrel squirrel3 = new Squirrel(14);
        Squirrel squirrel4 = new Squirrel(15);

        // Store the squirrel speeds in the array called "times".
        times = new int[]{squirrel1.getSpeed(), squirrel2.getSpeed(), squirrel3.getSpeed(), squirrel4.getSpeed()};
        LOGGER.info("Squirrel speeds: " + times[0] + ", " + times[1] + ", " + times[2] + ", " + times[3]);
        fastest = findFastest(); // Find the fastest squirrels speed.
        LOGGER.info("Fastest squirrel speed: " + fastest);
        slowest = findSlowest(); // Find the slowest squirrels speed.
        LOGGER.info("Slowest squirrel speed: " + slowest);
        besttime = bestCase(); // Calculate the minimum time based on the squirrel speeds.
        LOGGER.info("Minimum seconds in total: " + besttime);
        worsttime = worstCase(); // Calculate the maximum time based on the squirrel speeds.
        LOGGER.info("Maximum seconds in total: " + worsttime);
        printTimes(); // Print out the results.
        LOGGER.info("Exiting DiegoTheMathGenius application...");
    }

    public static int findFastest() // Method to find the fastest squirrels speed.
    {
        LOGGER.info("Finding fastest squirrel speed...");
        fastest = times[0]; // Set the fastest squirrel speed to the first element in the array.
        for (int i = 1; i < times.length; i++) // Loop through the array starting from the second element.
        {
            if (times[i] < fastest) // If the current element is smaller than the current fastest squirrel speed...
            {
                fastest = times[i]; // ...set the current element as the new fastest squirrel speed.
            }
        }
        return fastest; // Return the fastest squirrel speed.
    }

    public static int findSlowest() // Method to find the slowest squirrels speed.
    {
        LOGGER.info("Finding slowest squirrel speed...");
        slowest = times[0]; // Set the slowest squirrel speed to the first element in the array
        for (int i = 1; i < times.length; i++) // Loop through the array starting from the second element.
        {
            if (times[i] > slowest) // If the current element is greater than the current slowest squirrel speed...
            {
                slowest = times[i]; // ...set the current element as the new slowest squirrel speed.
            }
        }
        return slowest; // Return the slowest squirrel speed.
    }

    public static int bestCase() // Method to calculate the minimum seconds in total.
    {
        LOGGER.info("Calculating minimum time...");
        for (int i = 0; i < times.length; i++) // Loop through the array of squirrel speeds.
        {
            sumofspeeds += times[i]; // Add each squirrel speed to the sumofspeeds variable to find how many seconds would it take if they would cross one by one.
        }
        besttime = (sumofspeeds + (times.length - 3) * fastest); // Calculate the minimum time based on the sum of all speeds, the fastest speed and the number of squirrels.
        return besttime; // Return the minimum time in total.
    }

    public static int worstCase() // Method to calculate the maximum seconds in total.
    {
        LOGGER.info("Calculating maximum time...");
        worsttime = (((times.length * 2) - 3) * slowest); // Calculate the maximum time based on the slowest speed and the number of squirrels.
        return worsttime; // Return the maximum time in total.
    }

    public static void printTimes()
    {
        LOGGER.info("Printing results...");
        // Print out the fastest and slowest squirrel speeds; minimum and maximum times.
        System.out.println("Speed of fastest squirrel: " + fastest);
        System.out.println("Speed of slowest squirrel: " + slowest);
        System.out.println("Minimum seconds in total: " + besttime);
        System.out.println("Maximum seconds in total: " + worsttime);
    }
}