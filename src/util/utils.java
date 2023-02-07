package util;

import java.util.Arrays;
import java.util.List;

public class utils {
	
	
	public static List<String> vratiStavkeSaMenija(String stavke) {
		stavke = stavke.replace("[", "").replace("]", "");
		String[] split = stavke.split("-");
		return Arrays.asList(split);
	}

}
