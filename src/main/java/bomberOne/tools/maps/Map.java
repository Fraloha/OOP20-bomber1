package bomberOne.tools.maps;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public enum Map {

	MAP1("mappa.csv");
	
	private static final String RES_PATH = "."  + File.separator;
	private List<List<String>> list = new ArrayList<>();
	private String fileName;
	
	Map(String string) {
		this.fileName=string;
	}

	public void setList(List<List<String>> list) {
		this.list=list;
	}
	
	public List<List<String>> getList(){
		return this.list;
	}
	
	public String getFilePath() {
		return RES_PATH + this.fileName;
	}
}
