package bomberOne.tools;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import bomberOne.model.User;
import bomberOne.model.UserImpl;

public class TestResourceLoader {

	User gigino = new UserImpl();
	
	@Test
	public void testDirCreation() throws IOException {
		DirectoryLoader.checkDirectory();
		DirectoryLoader.checkFiles();
		gigino.setName("Luigi");
		gigino.setScore(100);
		RankLoader.writeUsers(List.of(gigino), List.of());
		RankLoader.readUsers();
	}
	
}
