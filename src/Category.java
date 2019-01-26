import java.util.*;

public class Category {
	private static HashMap<String, String[]> myMap = new HashMap<String, String[]>();
	private static String[] categories = {"VIPXX", "ASSOC", "COMXX", "MEDIA", "ENTRP", "DIVER"};
	
	//Keywords for each category --> Non exhaustive list
	private static String[] vip = {"directeur", "président", "president", "ceo", "pdg"};
	private static String[] assoc = {"association", "non lucratif", "aide"};
	private static String[] com = {"publicité", "publicite"};
	private static String[] media = {"journaliste", "bloggeur", "redacteur", "rédacteur"};
	private static String[] entrp = {"marketing", "prospection", "ingénieur", "ingenieur", "informatique", "méthodes", "methodes", "organisation", "responsable", "engineer"};
	
	//Mapping categories with suffix
	public static void populateMap(){
		myMap.clear();
		myMap.put(categories[0], vip);
		myMap.put(categories[1], assoc);
		myMap.put(categories[2], com);
		myMap.put(categories[3], media);
		myMap.put(categories[4], entrp);
	}
	
	//Return the category if defined, else return DIVER
	public static String setCategory(String fonction){
		populateMap();
		String lowFonction = fonction.toLowerCase();
		//System.out.println(lowFonction);
		for(int i=0; i<myMap.size(); i++){
			for(String word : myMap.get(categories[i])){
				if(lowFonction.contains(word)){
					return categories[i];
				}
			}
		}
		return "DIVER";
	}
	
	/*Method to set contact's category
     * [XXYYZZZZZWW], où :
		XX : correspond au continent (EU pour l’Europe, HE sinon)
		YY : correspond au pays (FR pour la France par exp.)
		ZZZZZ : correspond à la catégorie (MEDIA pour un poste relatif au domaine des médias : journaliste, chroniqueur radio … etc.)
		WW : correspond au numéro de département
     */
    public static String createCategory(String fonction, String pays, String departement) {
    	StringBuilder category = new StringBuilder();
    	//Here we have to test the country based on (the abreviation from another class and if it's european)
		if(EuropeanC.isEuropean(pays)){
			category.append("EU"+EuropeanC.setIsoCode(pays));
		}
		else category.append("HEXX");
		//Here we have to analyse the function based on management rules
		category.append(Category.setCategory(fonction));
		
		//Writing the departement number
		//if(!departement.equals(""))
		//	category.append(departement.substring(0, 2));
		//else category.append(99);
    	return category.toString();
    }
	
}
