package bomberone.tools;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Test;

/**
 * Test if the game's map has been loaded correctly.
 * 
 */
public class TestMap {

    @Test
    public void testLoadMap() {
        ClassLoader classLoader = getClass().getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream("maps/mappa.csv")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String currentString;
            while ((currentString = reader.readLine()) != null) {
                assertTrue(!currentString.isEmpty());
                System.out.println(currentString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
}
