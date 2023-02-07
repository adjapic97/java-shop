package funkcije;

import model.Administrator;
import model.Korisnik;
import model.Kupac;
import model.Restoran;
import model.VlasnikRestorana;
import util.Meniji;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

public class RadSaKorisnicima {

    public static Boolean korisnikPostoji(String korisnickoIme) {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("data/korisnici.csv"))) {
            while ((line = br.readLine()) != null) {
                String[] korisnik = line.split(",");
                if (korisnickoIme.equals(korisnik[2])) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    public static Boolean vlasnikPostoji(String korisnickoIme, String idRestorana) {
    	String line;
    	try (BufferedReader br = new BufferedReader(new FileReader("data/restorani.csv"))) {
			// treba da iteriramo kroz listu restoraana i vidimo li se poklapa id restorana i korisnicko ime restorana, u tom slucaju vrati true
            while ((line = br.readLine()) != null) {
                String[] restoran = line.split(",");
                if (korisnickoIme.equals(restoran[4]) && idRestorana.equals(restoran[0])) {
                    return true;
                }
            }
		} catch (Exception e) {
			System.out.println(e);
		}
    	return false;
    }
    
    public static VlasnikRestorana pronadjiVlasnika(String korisnickoIme) {
    	String line;
    	try (BufferedReader br = new BufferedReader(new FileReader("data/korisnici.csv"))) {
			// treba da iteriramo kroz listu restoraana i vidimo li se poklapa id restorana i korisnicko ime restorana, u tom slucaju vrati true
            while ((line = br.readLine()) != null) {
            	String[] k = line.split(",");
                VlasnikRestorana vlasnikRestorana = new VlasnikRestorana();
                if (korisnickoIme.equals(k[2])) {
                	vlasnikRestorana.setIme(k[0]);
                	vlasnikRestorana.setPrezime(k[1]);
                	vlasnikRestorana.setKorisnickoIme(k[2]);
                    return vlasnikRestorana;
                }
            }
		} catch (Exception e) {
			System.out.println(e);
		}
    	return null;
    }


    public static Korisnik ulogujSe() {
        // treba nam unos korisnika
        // treba da tog korisnika pronadjemo u bazi
        // proverimo njegove kredencijale
        // ako je ispravan, kreiramo novu instancu tog korisnika i vracamo je. Na osnovu toga, printamo meni dalje
        Boolean ulogovan = false;
        while (!ulogovan) {
            String line;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Unesite korisnicko ime: ");
            String korisnickoIme = scanner.nextLine();
            System.out.println("Unesite lozinku");
            String lozinka = scanner.nextLine();
            try (BufferedReader br = new BufferedReader(new FileReader("data/korisnici.csv"))) {
                while ((line = br.readLine()) != null) {
                    String[] korisnik = line.split(",");
                    if (korisnickoIme.equals(korisnik[2])) {
                        if (lozinka.equals(korisnik[3])) {
                            if (korisnik[4].equals("admin")) {
                                Administrator ulogovaniAdmin = new Administrator(
                                        korisnik[0],
                                        korisnik[1],
                                        korisnik[2],
                                        korisnik[3]
                                );
                                return ulogovaniAdmin;
                            } else if (korisnik[4].equals("vlasnik")) {
                                VlasnikRestorana ulogovaniVlasnik = new VlasnikRestorana(
                                        korisnik[0],
                                        korisnik[1],
                                        korisnik[2],
                                        korisnik[3]
                                );
                                return ulogovaniVlasnik;
                            } else {
                                Kupac ulogovaniKupac = new Kupac(
                                        korisnik[0],
                                        korisnik[1],
                                        korisnik[2],
                                        korisnik[3]
                                );
                                return ulogovaniKupac;
                            }
                        } else {
                            ulogovan = false;
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return new Kupac();
    }

	public static Korisnik kreirajKorisnika() {
        Scanner scanner = new Scanner(System.in);
        Korisnik korisnik = null;
        Boolean korisnikPostoji = true;
        do {
            System.out.println("Unesite korisnicko ime korisnika: ");
            String korisnickoIme = scanner.nextLine();
            korisnikPostoji = korisnikPostoji(korisnickoIme);

            if (!korisnikPostoji) {
                System.out.println("Odaberite tip korisnika");
                Integer tipKorisnika = MeniPrint.print(Meniji.TIP_KORISNIKA);

                if (tipKorisnika == 1) {
                    System.out.println("Kreirate korisnika administratora");
                    System.out.println(Meniji.MENI_DELIMITER);

                    System.out.println("Unesite Ime korisnika: ");
                    String ime = scanner.nextLine();

                    System.out.println("Unesite prezime korisnika: ");
                    String prezime = scanner.nextLine();

                    System.out.println("Unesite lozinku korisnika: ");
                    String lozinka = scanner.nextLine();

                    String noviKorisnik = ime + "," + prezime + "," + korisnickoIme + "," + lozinka + "," + "admin";

                    upisiKorisnikaUCSV(noviKorisnik);

                    Korisnik noviAdmin = new Administrator(ime, prezime, korisnickoIme, lozinka);
                    korisnik = noviAdmin;
                } else if (tipKorisnika == 2) {
                    System.out.println("Kreirate korisnika kupca");
                    System.out.println(Meniji.MENI_DELIMITER);

                    System.out.println("Unesite Ime korisnika: ");
                    String ime = scanner.nextLine();

                    System.out.println("Unesite prezime korisnika: ");
                    String prezime = scanner.nextLine();

                    System.out.println("Unesite lozinku korisnika: ");
                    String lozinka = scanner.nextLine();

                    System.out.println("Unesite kucnu adresu korisnika: ");
                    String kucnaAdresa = scanner.nextLine();

                    String noviKorisnik = ime + "," + prezime + "," + korisnickoIme + "," + lozinka + "," + "kupac";

                    upisiKorisnikaUCSV(noviKorisnik);
                    upisiKupcaUCSV(korisnickoIme, kucnaAdresa);

                    Korisnik noviKupac = new Kupac(ime, prezime, korisnickoIme, lozinka);
                    korisnik = noviKupac;
                }
                else {
                    System.out.println("Kreirate korisnika vlasnika restorana");
                    System.out.println(Meniji.MENI_DELIMITER);

                    System.out.println("Unesite Ime korisnika: ");
                    String ime = scanner.nextLine();

                    System.out.println("Unesite prezime korisnika: ");
                    String prezime = scanner.nextLine();

                    System.out.println("Unesite lozinku korisnika: ");
                    String lozinka = scanner.nextLine();

                    String noviKorisnik = ime + "," + prezime + "," + korisnickoIme + "," + lozinka + "," + "vlasnik";

                    upisiKorisnikaUCSV(noviKorisnik);

                    Korisnik noviKupac = new VlasnikRestorana(ime, prezime, korisnickoIme, lozinka);
                    korisnik = noviKupac;
                }


            }
        } while (korisnikPostoji);
        return korisnik;
    }
	
	
	public static VlasnikRestorana dodajVlasnikaRestorana() {
        Scanner scanner = new Scanner(System.in);
        VlasnikRestorana vlasnikRestorana = null;
        Boolean vlasnikPostoji = true;
        do {
        	System.out.println("1.Izaberi restoran ");
        	System.out.println("2.Kreiraj novi restoran \n");
        	Integer opcija = scanner.nextInt();
        	if(opcija == 1) {
        		// isprintaj sve restorane i uzmi novi input od usera, i prebaci ga da bira korisnika
        		// bira korisnika tako sto unese korisnicko ime, ako ne postoji reci mu da ne postoji i baci ga da kreira novog
        		List<Restoran> restorani = RadSaRestoranima.ucitajPostojeceRestorane();
        		for (Restoran restoran : restorani) {
					System.out.println(restoran);
				}
        	} else if (opcija == 2) {
        		
        	}
        	// treba da isprintamo restorane ili da kreiramo novi
        	
            System.out.println("Unesite korisnicko ime korisnika: ");
            String korisnickoIme = scanner.nextLine();
            vlasnikPostoji = false;
            
        } while (vlasnikPostoji);
        return vlasnikRestorana;
	}

    public static void upisiKorisnikaUCSV(String korisnik) {
        try {
            String finalniZaUpis = korisnik + "\n";
            FileWriter fw = new FileWriter("data/korisnici.csv", true);
            BufferedWriter bw =  new BufferedWriter(fw);
            bw.write(finalniZaUpis);
            bw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void upisiKupcaUCSV(String korisnickoIme, String kucnaAdresa) {
        try {
            String kupac =  korisnickoIme + "," + 10000 + "," + kucnaAdresa + "\n";
            FileWriter fw = new FileWriter("data/kupci.csv", true);
            BufferedWriter bw =  new BufferedWriter(fw);
            bw.write(kupac);
            bw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
