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
import java.util.List;

import bomberone.model.user.User;

public class RankLoader {
	
	/**
	 * This method takes in input two Lists of Users and serialize every Object in the corresponding file
	 * @param userRankStandard the list of Users that played in Standard Difficulty
	 * @param userRankHard the list of Users that played in Hard Difficulty
	 */
	public static void writeUsers(List<User> userRankStandard, List<User> userRankHard) {
		try (
				ObjectOutput outputStd = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(DirectoryLoader.getRankStandardPath())));
				ObjectOutput outputHard = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(DirectoryLoader.getRankHardPath())));
				){
			outputStd.writeObject(userRankStandard);
		    outputHard.writeObject(userRankHard);
	    }  
	    catch(IOException ex){
	    	System.out.println("Cannot perform the output");
	    }
	}
	
	/**
	 * This method take in input two list of User, load from file the different ranks and puts them in the lists.
	 * @param userRankStandard the list to fill with the Rank of User that played in Standard Difficulty
	 * @param userRankHard the list to fill with the Rank of User that played in Hard Difficulty
	 */
	@SuppressWarnings("unchecked")
	public static void readUsers(List<User> userRankStandard, List<User> userRankHard) {
		try(
			    ObjectInput inputStd = new ObjectInputStream (new BufferedInputStream(new FileInputStream(DirectoryLoader.getRankStandardPath())));
				ObjectInput inputHard = new ObjectInputStream (new BufferedInputStream(new FileInputStream(DirectoryLoader.getRankHardPath())));
				){
			//deserialize the List
			userRankStandard.addAll((List<User>) inputStd.readObject());
			userRankHard.addAll((List<User>) inputHard.readObject());
		}
		catch(ClassNotFoundException ex){
			System.out.println("Cannot perform input. Class not found.");
		}
		catch(IOException ex){
			System.out.println("Cannot perform input.");
		}
	}


	

		    
}
