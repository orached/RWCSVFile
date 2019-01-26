
public class Source {
	
	private static String[] source = {"linkedin", "viadeo", "facebook", "twitter"};
	
	public static String setSource(String filename){
		String[] parts = filename.toLowerCase().split("_");
		for(int i=0; i<parts.length; i++){
			for(String word : source){
				if(parts[i].equals(word)){
					return word;
				}
			}
		}
		return "inconnu";
	}
}
