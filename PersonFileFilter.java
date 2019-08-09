package App;

import java.io.File;
import java.util.Locale.FilteringMode;

import javax.swing.filechooser.FileFilter;

public class PersonFileFilter extends FileFilter {

	public boolean accept(File file) {
	
		if(file.isDirectory()){
			return true;
		}
		String name = file.getName(); 
		String extension = Utils.getFileExtension(name);
		if(extension==null){
			return false;
		}
		if(extension.equals("prd")){
			return true;
		}
		return false;
	}

	public String getDescription() {
		return "Person DataBase File(*.prd)";
	}

}
