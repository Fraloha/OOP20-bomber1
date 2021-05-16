package bomberone.tools;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import bomberone.model.user.User;

/**
 * Utility class that can read or write the Ranks on their specific file.
 *
 */
public final class RankLoader {

    private static List<User> rankStandard = new ArrayList<User>();
    private static List<User> rankHard = new ArrayList<User>();

    private RankLoader() {
    }

    /**
     * 
     * @return the Standard Difficulty Rank
     */
    public static List<User> getRankStandard() {
        return RankLoader.rankStandard;
    }

    /**
     * 
     * @return the Hard Difficulty Rank
     */
    public static List<User> getRankHard() {
        return RankLoader.rankHard;
    }

    /**
     * This method takes in input two Lists of Users and serialize every Object in
     * the corresponding file.
     * @param hardList list to serialize
     * @param stdList list to serialize
     * 
     */
    public static void writeUsers(final List<User> hardList, final List<User> stdList) {
        try (ObjectOutput outputStd = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(DirectoryLoader.getRankStandardPath())));
                ObjectOutput outputHard = new ObjectOutputStream(
                        new BufferedOutputStream(new FileOutputStream(DirectoryLoader.getRankHardPath())));) {
            outputStd.writeObject(stdList);
            outputHard.writeObject(hardList);
        } catch (IOException ex) {
            System.out.println("Cannot perform the output");
        }
    }

    /**
     * This method take in input two list of User, load from file the different
     * ranks and puts them in the lists.
     * 
     */
    @SuppressWarnings("unchecked")
    public static void readUsers()  {
        RankLoader.rankStandard.clear();
        RankLoader.rankHard.clear();
        try (ObjectInput inputStd = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(DirectoryLoader.getRankStandardPath())));
                ObjectInput inputHard = new ObjectInputStream(
                        new BufferedInputStream(new FileInputStream(DirectoryLoader.getRankHardPath())));) {
            // deserialize the List
            rankStandard.addAll((List<User>) inputStd.readObject());
            rankHard.addAll((List<User>) inputHard.readObject());
        } catch (ClassNotFoundException ex) {
            System.out.println("Cannot perform input. Class not found.");
        } catch (IOException ex) {
            System.out.println("Cannot perform input.");
        }
    }

}
