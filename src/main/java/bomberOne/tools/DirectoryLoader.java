package bomberOne.tools;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirectoryLoader {

	private static final String CONFIGURATION_DIRECTORY_NAME = ".bomberOne";
    private static final String RANK_STANDARD_NAME = "rankStd.txt";
    private static final String RANK_HARD_NAME = "rankHard.txt";
    private static final String USER_DIRECTORY = System.getProperty("user.home");
    private static final String SEPARATOR = File.separator;
    
    private static final String CONFIGURATION_DIRECTORY_PATH = USER_DIRECTORY + SEPARATOR + CONFIGURATION_DIRECTORY_NAME;
    static final String RANK_STANDARD_PATH = CONFIGURATION_DIRECTORY_PATH + SEPARATOR + RANK_STANDARD_NAME;
    static final String RANK_HARD_PATH = CONFIGURATION_DIRECTORY_PATH + SEPARATOR + RANK_HARD_NAME;
    
    /**
     * This Method checks if the directory ".bomberOne/" in the Home Directory exist, and if it not exist the method creates it.
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
     * This Method checks if the files "rankHard.txt & rankStd.txt" in the ".bomberOne/" directory, and if they not exist the method creates them.
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
     * This method launch both the methods that do their controls on Files and Directory
     */
    public static void start() {
    	try {
			DirectoryLoader.checkDirectory();
			DirectoryLoader.checkFiles();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
