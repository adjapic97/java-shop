package funkcije;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import model.JedinicaMere;
import model.Jelo;
import model.Meni;
import model.Stavka;
import model.TipJela;
import util.utils;

public class RadSaMenijima {
	
	
	public static Meni ucitajMeni(String idMenija) {
        String line;
        List<Stavka> stavkeMenija = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("data/meniji.csv"))) {
            while ((line = br.readLine()) != null) {
                String[] m = line.split(",");
                if (idMenija.equals(m[0])) {
                	List<String> listaStavkiSaMenija = utils.vratiStavkeSaMenija(m[1]);
                	for (String idStavke : listaStavkiSaMenija) {
						Stavka stavkaMenija = ucitajStavku(idStavke);
						stavkeMenija.add(stavkaMenija);
					}
                	Meni meni = new Meni();
                	meni.setId(idMenija);
                	meni.setListaStavki(stavkeMenija);
                    return meni;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
	}
	
	
	public static Stavka ucitajStavku(String idStavke) {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("data/stavke.csv"))) {
            while ((line = br.readLine()) != null) {
                String[] s = line.split(",");
                if (idStavke.equals(s[0])) {
                	if(s[4].equals(TipJela.HRANA.name())) {
                    	Jelo stavka = new Jelo();
                    	stavka.setId(idStavke);
                    	stavka.setNaziv(s[1]);
                    	stavka.setKolicina(Double.parseDouble(s[2]));
                    	stavka.setJedinicaMere(JedinicaMere.valueOf(s[3]));
                    	stavka.setTipJela(TipJela.valueOf(s[4]));
                    	return stavka;
                	} else if (s[4].equals(TipJela.PICE.name())) {
                		
                	}
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
	}

}
