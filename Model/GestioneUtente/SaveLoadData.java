package Model.GestioneUtente;


import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.Map;

import java.util.TreeMap;



/**
 * singleton class. 
 * This class is used for save or load or upadate the statistics 
 * in a txt
 * @author Davide Morelli
 *
 */
public class SaveLoadData {
	
	//TODO: vedi le eccezioni
	/*
	 * field instance
	 */
	 private static SaveLoadData instance;
	 private Map<String,String> mapUtenti,readMapFile;
	
	 private File fileData;

	 
	 /**
	  * @return a single instance of this class
	  */
	 public static SaveLoadData getInstance() {
		 if (instance==null) instance=new SaveLoadData();
		 return instance;
	 }

	 private SaveLoadData() {
		 //TODO: forse devi creare un modo che se già ce il file non lo ricrea altrimenti non ha senso
		 
		 fileData=new File("C:\\Users\\Davide Morelli\\Desktop\\Sapienza\\Java2k22\\JUNO\\FileData\\FileData.txt");
		 mapUtenti=new TreeMap<>();
		 }

	 
	 /*
	  * This method saves a new "UTENTE" in file.txt, thanks to its Id
	  */
	 public void saveNewUtente(Utente utente)  {
		
		readFile();  //Leggo il file, se la readMap è null allora salvo e scrivo con la nuova mappa altrimenti controllo dentro e se non c'è allora aggiungo
		if(readMapFile!=null) {
		if(!(readMapFile.containsKey(utente.getNickname()))) {
			readMapFile.put(utente.getNickname(),utente.getStatistics().toString());
			mapUtenti.put(utente.getNickname(),utente.getStatistics().toString());
			writeFile(readMapFile); 
		}}
		else {
			mapUtenti.put(utente.getNickname(),utente.getStatistics().toString());
			writeFile(mapUtenti); 
		}
		
	 }
	 
	 
	 public void readData(String idPlayer) {
		 readFile();
		// System.out.println(readMapFile.get(idPlayer));
	 }
	 
	 //TODO: aggiungere eccezione
	 public void updateStatisticsUtente(Utente utente,String nickname) throws UtenteNotExistException {
		 //TODO dai in input le statistiche desiderate e butti in mapUtenti
		 if (readMapFile.containsKey(nickname)) {
			 String[] oldValue=readMapFile.get(nickname).split("-");  //c'è un problema perchè forse devi mettere dentro mapUtenti le nuove statistiche
			 String[] newValue=mapUtenti.get(nickname).split("-");
			 for (int k=0;k<newValue.length;k++) {
				 int nValue=Integer.parseInt(newValue[k])+Integer.parseInt(oldValue[k]);
				 newValue[k]=String.valueOf(nValue);
			 }
			 
			 writeFile(mapUtenti); //riscrivo la nuova mappa
		 }
		 else {
			 saveNewUtente(utente); //salvo l'utente
			 throw new UtenteNotExistException();
			 
		 }
	 }
	 
	 private void writeFile(Map<String,String> mappa) {
		
		 try {
		       
		        FileOutputStream fos=new FileOutputStream(fileData);
		        ObjectOutputStream oos=new ObjectOutputStream(fos);

		        oos.writeObject(mappa);
		        oos.flush();
		        oos.close();
		        fos.close();
		    } catch(Exception e) {}
	 }
	 
	 
	 private void readFile() {
		 try {
		        
		        FileInputStream fis=new FileInputStream(fileData);
		        ObjectInputStream ois=new ObjectInputStream(fis);

		        readMapFile=(Map<String, String>) ois.readObject();

		        ois.close();
		        fis.close();
		        /**print All data in MAP
		        for(Map.Entry<String,String> m :readMapFile.entrySet()){
		            System.out.println(m.getKey()+" : "+m.getValue());  }**/
		      
		    } catch(Exception e) {}
		  }
	 }
	//TODO: quando le statistiche vengono aggiornate si richiama un metodo specifico, viene ricreata la nuova stringa da associare alla chiave
	 
	
	 
	
	 

