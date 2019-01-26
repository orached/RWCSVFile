import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RWCSVFile {

	private static CSVReader reader;
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	private static final String FILE_HEADER = "Nom complet, Email, Fonction, Entreprise, Pays, Département, Téléphone, Date d'ajout, Catégorie, Source";
    
    public static void createNewCSV(File file) throws IOException {
        String fileAddress = file.getAbsolutePath();
        String fileName = file.getName();
        if (fileName.endsWith(".csv")) {
            fileName = fileName.substring(0, fileName.length()-4);
            fileName = fileName + "-modified.csv";
        }
        System.out.println(fileName);
        createNewCSV(fileAddress, FILE_HEADER, NEW_LINE_SEPARATOR, COMMA_DELIMITER, fileName);
    }
    
    //Method to create the new light CSV File
    public static void createNewCSV(String fileAddress, String fileHeader, String newLineSeparator, String commaDelimiter, String fileName) throws IOException{
    	
    	reader = new CSVReader(new FileReader(fileAddress), ',' , '"' , 1 );
        String[] nextLine;
        //String fileName = "contacts.csv";
        
        //Write in new csv file
        FileWriter fileWriter = null;
		
		try {
			fileWriter = new FileWriter(fileName);

			//Write the CSV file header
			fileWriter.append(fileHeader);
			
			//Add a new line separator after the header
			fileWriter.append(newLineSeparator);
			//Write a new contact to the CSV file from a Viadeo CSV File
			if(Source.setSource(fileName).equals("viadeo")){
				while ((nextLine = reader.readNext()) != null) {
					fileWriter.append(nextLine[1]);
					fileWriter.append(commaDelimiter);
					fileWriter.append(nextLine[19]);
					fileWriter.append(commaDelimiter);
					fileWriter.append(nextLine[2]);
					fileWriter.append(commaDelimiter);
					//Ajouter ici l'entreprise !!
					fileWriter.append(commaDelimiter);
					fileWriter.append(nextLine[6]);
					fileWriter.append(commaDelimiter);
					fileWriter.append(nextLine[5]);
					fileWriter.append(commaDelimiter);
					fileWriter.append(nextLine[12]);
					fileWriter.append(commaDelimiter);
					fileWriter.append(CurrentDate.getCurrentDate());
					fileWriter.append(commaDelimiter);
					fileWriter.append(Category.createCategory(nextLine[2], nextLine[6], nextLine[5]));
					fileWriter.append(commaDelimiter);
					fileWriter.append(Source.setSource(fileName));
					fileWriter.append(newLineSeparator);
				}
			}
			//Write a new contact to the CSV file from a Linkedin CSV File
			if(Source.setSource(fileName).equals("linkedin")){
					//Write a new contact to the CSV file
					while ((nextLine = reader.readNext()) != null) {
						fileWriter.append(nextLine[1]);
						fileWriter.append(" "+nextLine[3]);
						fileWriter.append(commaDelimiter);
						fileWriter.append(nextLine[5]);
						fileWriter.append(commaDelimiter);
						fileWriter.append(nextLine[31]);
						fileWriter.append(commaDelimiter);
						fileWriter.append(nextLine[29]);
						fileWriter.append(commaDelimiter);
						//Ajouter ici pays !
						fileWriter.append(commaDelimiter);
						//Ajouter ici département !
						fileWriter.append(commaDelimiter);
						//Ajouter ici téléphone !
						fileWriter.append(commaDelimiter);
						fileWriter.append(CurrentDate.getCurrentDate());
						fileWriter.append(commaDelimiter);
						//les champs pays et département ne sont pas remplis !
						fileWriter.append(Category.createCategory(nextLine[31], "XX", "YY"));
						fileWriter.append(commaDelimiter);
						fileWriter.append(Source.setSource(fileName));
						fileWriter.append(newLineSeparator);
					}
				}
			System.out.println("CSV file was created successfully !!!");
			
		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
			}
		}
    }
    
    
}
