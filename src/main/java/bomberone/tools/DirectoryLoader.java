package bomberone.tools;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Utility class that prepare the ".bomberOne" directory in the User's Home directory.
 *
 */
public final class DirectoryLoader {

    private static final String CONFIGURATION_DIRECTORY_NAME = ".bomberOne";
    private static final String RANK_STANDARD_NAME = "rankStd.txt";
    private static final String RANK_HARD_NAME = "rankHard.txt";
    private static final String USER_DIRECTORY = System.getProperty("user.home");
    private static final String SEPARATOR = File.separator;
    private static final String CONFIGURATION_DIRECTORY_PATH = USER_DIRECTORY + SEPARATOR
                                                                                + CONFIGURATION_DIRECTORY_NAME;
    private static final String RANK_STANDARD_PATH = CONFIGURATION_DIRECTORY_PATH + SEPARATOR + RANK_STANDARD_NAME;
    private static final String RANK_HARD_PATH = CONFIGURATION_DIRECTORY_PATH + SEPARATOR + RANK_HARD_NAME;


    private DirectoryLoader() {

    }

    /**
     * This Method checks if the directory ".bomberOne/" in the Home Directory
     * exist, and if it not exist the method creates it.
     * 
     * @throws IOException
     */
    public static void checkDirectory() throws IOException {

        if (!Files.isDirectory(Path.of(CONFIGURATION_DIRECTORY_PATH))) {
            Files.deleteIfExists(Path.of(CONFIGURATION_DIRECTORY_PATH));
        }
        if (Files.notExists(Path.of(CONFIGURATION_DIRECTORY_PATH))) {
            Files.createDirectory(Path.of(CONFIGURATION_DIRECTORY_PATH));
        }
    }

    /**
     * This Method checks if the files "rankHard.txt & rankStd.txt" in the
     * ".bomberOne/" directory, and if they not exist the method creates them.
     * 
     * @throws IOException
     */
    public static void checkFiles() throws IOException {

        if (Files.notExists(Path.of(RANK_STANDARD_PATH))) {
            Files.createFile(Path.of(RANK_STANDARD_PATH));
        }

        if (Files.notExists(Path.of(RANK_HARD_PATH))) {
            Files.createFile(Path.of(RANK_HARD_PATH));
        }
    }

    /**
     * This method launch both the methods that do their controls on Files and Directory.
     * 
     * 
     * @throws IOException
     */
    public static void start() throws IOException {
        DirectoryLoader.checkDirectory();
        DirectoryLoader.checkFiles();
    }

    /**
     * 
     * @return The path of the file that contains the Rank of "Standard" Game
     */
    public static String getRankStandardPath() {
        return RANK_STANDARD_PATH;
    }

    /**
     * 
     * @return The path of the file that contains the Rank of "Hard" Game
     */
    public static String getRankHardPath() {
        return RANK_HARD_PATH;
    }
}
