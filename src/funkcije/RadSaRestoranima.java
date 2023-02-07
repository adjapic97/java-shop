package funkcije;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import model.Restoran;

public class RadSaRestoranima {

	
	public static List<Restoran> ucitajPostojeceRestorane() {
		List<Restoran> restorani = new ArrayList<Restoran>();
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader("data/restorani.csv")))  {
		       while ((line = br.readLine()) != null) {
	                String[] r = line.split(",");
	                Restoran restoran = new Restoran();
	                restoran.setId(r[0]);
	                restoran.setMeni(RadSaMenijima.ucitajMeni(r[3]));
	                restoran.setNaziv(r[1]);
	                restoran.setBesplatnaDostava(Double.parseDouble(r[2]));
	                restoran.setVlasnik(RadSaKorisnicima.pronadjiVlasnika(r[4]));
	                restorani.add(restoran);
	            }
		       return restorani;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
		
	}
}
