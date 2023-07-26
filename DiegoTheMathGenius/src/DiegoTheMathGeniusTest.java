import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

public class DiegoTheMathGeniusTest
{
    public static int[] times = {3, 5, 8, 13};
    @Test
    public void testFindFastest() throws IOException {
        DiegoTheMathGenius.times = times;
        int expectedFastest = 3;
        int actualFastest = DiegoTheMathGenius.findFastest();
        assertEquals(expectedFastest, actualFastest);
        saveResult("The fastest squirrel crosses the river in " + actualFastest + " seconds.");
    }

    @Test
    public void testFindSlowest() throws IOException {
        DiegoTheMathGenius.times = times;
        int expectedSlowest = 13;
        int actualSlowest = DiegoTheMathGenius.findSlowest();
        assertEquals(expectedSlowest, actualSlowest);
        saveResult("The slowest squirrel crosses the river in " + actualSlowest + " seconds.");
    }

    @Test
    public void testBestCase() throws IOException {
        DiegoTheMathGenius.times = times;
        int expectedBestTime = 32;
        DiegoTheMathGenius.findFastest();
        int actualBestTime = DiegoTheMathGenius.bestCase();
        assertEquals(expectedBestTime, actualBestTime);
        saveResult("In best case, Scrat and his friends crosses the river in " + actualBestTime + " seconds.");
    }

    @Test
    public void testWorstCase() throws IOException {
        DiegoTheMathGenius.times = times;
        int expectedWorstTime = 65;
        DiegoTheMathGenius.findSlowest();
        int actualWorstTime = DiegoTheMathGenius.worstCase();
        assertEquals(expectedWorstTime, actualWorstTime);
        saveResult("In worst case, Scrat and his friends crosses the river in " + actualWorstTime + " seconds.");
    }
    private void saveResult(String result) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String timestamp = formatter.format(now);
        String fileName = "junittestdatas.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.append("The data set used: " + java.util.Arrays.toString(times) + "\n");
            writer.append(timestamp + " - " + result + "\n\n");
        }
    }
}
