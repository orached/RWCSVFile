import java.util.Arrays;

public class EuropeanC {
	//Le CSV exporté de Viadéo respecte exactement cette casse "Pays"
	private static String[] pays = {"Allemagne", "Autriche", "Belgique", "Bulgarie", "Chypre", "Croatie", "Danemark", "l'Espagne", "Estonie", "Finlande", "France", "Grèce", "Hongrie", "Irlande", "Italie", "Lettonie", "Lituanie", "Luxembourg", "Malte", "Pays-Bas", "Pologne", "Portugal", "République tchèque", "Roumanie", "Royaume-Uni", "Slovaquie", "Slovénie", "Suède"};
	private static String[] code = {"DE", "AT", "BE", "BG", "CY", "HR", "DK", "ES", "EE", "FI", "FR", "GR", "HU", "IE", "IT", "LV", "LT", "LU", "MT", "NL", "PL", "PT", "CZ", "RO", "GB", "SK", "SI", "SE"};
	
	//Return true if the country passed in parameter is European
	public static boolean isEuropean(String country){
		for(String countr : pays){
			if(countr.equals(country))
				return true;
		}
		return false;
	}
	
	//Return the ISO code of the country passed in parameter
	public static String setIsoCode(String country){
		StringBuilder isoCode = new StringBuilder();
		
		if(isEuropean(country)){
			int idx = Arrays.asList(pays).indexOf(country);
			isoCode.append(code[idx]);
			return isoCode.toString();
		}
		
		return "This is not an Europeean country";
	}
}
