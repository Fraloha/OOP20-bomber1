package bomberOne.tools;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import bomberOne.model.User;

public class RankLoader {

	
	/**
	 * This method takes in input two Lists of Users and serialize every Object in the corresponding file
	 * @param userRankStandard the list of Users that played in Standard Difficulty
	 * @param userRankHard the list of Users that played in Hard Difficulty
	 */
	public static void writeUsers(List<User> userRankStandard, List<User> userRankHard) {
		try (
				ObjectOutput rankHardOutput = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(DirectoryLoader.RANK_HARD_PATH)));
				ObjectOutput rankStdOutput = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(DirectoryLoader.RANK_STANDARD_PATH)));
				){
		      rankStdOutput.writeObject(userRankStandard);
		      rankHardOutput.writeObject(userRankHard);
	    }  
	    catch(IOException ex){
	     System.out.println("Cannot perform the output");
	    }
	}
	
	public static void readUsers() {
		List<User> userRankStandard = new ArrayList<>();
		List<User> userRankHard = new ArrayList<>();
		try(
			      InputStream file = new FileInputStream(DirectoryLoader.RANK_HARD_PATH);
			      InputStream buffer = new BufferedInputStream(file);
			      ObjectInput input = new ObjectInputStream (buffer);
			    ){
			      //deserialize the List
			      userRankHard = (List<User>)input.readObject();
			      //display its data
			      userRankHard.stream().forEach(e -> {
			    	  System.out.println(e.getName() + " " + e.getScore());
			      });
			    }
			    catch(ClassNotFoundException ex){
			      System.out.println("Cannot perform input. Class not found.");
			    }
			    catch(IOException ex){
			    	System.out.println("Cannot perform input.");
			    }
	}


	

		    
}
