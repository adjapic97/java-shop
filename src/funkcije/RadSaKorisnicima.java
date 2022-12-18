package funkcije;

import model.Administrator;
import model.Korisnik;
import model.Kupac;
import model.VlasnikRestorana;
import util.Meniji;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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

                    String noviKorisnik = ime + "," + prezime + "," + korisnickoIme + "," + lozinka + "," + "kupac";

                    upisiKorisnikaUCSV(noviKorisnik);

                    Korisnik noviKupac = new Kupac(ime, prezime, korisnickoIme, lozinka);
                    korisnik = noviKupac;
                }


            }
        } while (korisnikPostoji);
        return korisnik;
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
