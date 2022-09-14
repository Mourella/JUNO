package Model.GestioneUtente;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Observable;
import java.util.TreeMap;



/**
 * 
 * This class is used for save or load or update the statistics in a file.txt. This class is an observable 
 * This is a Singleton class.
 * @author Davide Morelli
 *
 */
@SuppressWarnings("deprecation")
public class SaveLoadData extends Observable {
	

	/*
	 * This field contains an instance of this class
	 */
	 private static SaveLoadData instance;
	 /**
	  * This field contains an instance of File
	  */
	 private File fileData;

	 /**
	  * This method @return a single instance of this class
	  */
	 public static SaveLoadData getInstance() {
		 if (instance==null) instance=new SaveLoadData();
		 return instance; }

	 /**
	  * Constructor of this class, create a new File
	  */
	 private SaveLoadData() {fileData=new File("FileData\\FileData.txt");}

	 
	 /**
	  * Thanks to this method we notify the observer of an update
	  */
	 public void updatePlayersDataOB() {
		this.setChanged(); 
		this.notifyObservers(readFile()); 
	 }
	 
	 /*
	  * This method saves a new "USER" in file.txt, thanks to its nickname
	  * Visibility package, because we use this method only in this package
	  */
	  void saveNewUtente(User user)  {
		Map<String,User> list = new TreeMap<>();
		if(fileData.length()==0) {list.put(user.getNickname(),user);writeFile(list);}
		else if (!(readFile().containsKey(user.getNickname()))) {
			list=readFile();
			list.put(user.getNickname(),user);writeFile(list);
		}
	 }
	 
	  
	 
	 /**
	  * This method update user statistics if the user already exists
	  * otherwise save the new User
	  * @param User to update the statistics 
	  */
	 public void updateUserStatistics(User user){
		 if (readFile().containsKey(user.getNickname())) {
			 Map<String, User> map=readFile();
			 map.put(user.getNickname(),user);
			 writeFile(map);} 									
		 else {
			 saveNewUtente(user);} 
	 }
	 
	 /**
	  * This method writes the changes to the file 
	  * @param mapWrite
	  */
	 private void writeFile(Map<String,User> mapWrite) {
		 try {
		        FileOutputStream fos=new FileOutputStream(fileData);
		        ObjectOutputStream oos=new ObjectOutputStream(fos);
		        oos.writeObject(mapWrite);
		        oos.flush();
		        oos.close();
		        fos.close();}
		     catch(Exception e) {e.printStackTrace();} }
	 
	 
	 

	 /**
	  * This method reads and returns the map saved in the file
	  * @return the map saved in the file
	  */
	@SuppressWarnings("unchecked")
	private Map<String,User> readFile() {
		 Map<String,User> readMapFile = new TreeMap<>();
		 if (fileData.length()>0) {
		 try {
		        FileInputStream fis=new FileInputStream(fileData);
		        ObjectInputStream ois=new ObjectInputStream(fis);
		        readMapFile=((Map<String, User>) ois.readObject());
		        ois.close();
		        fis.close();
		      
		    } catch(Exception e) {e.printStackTrace();}}
		return readMapFile;
		  }
		
}

	
	 
	
	 

