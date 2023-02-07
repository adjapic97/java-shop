import funkcije.MeniPrint;
import funkcije.RadSaKorisnicima;
import model.Administrator;
import model.Korisnik;
import model.Kupac;
import util.Meniji;

public class Main {
	public static void main(String[] args) {
		Integer opcija = MeniPrint.print(Meniji.LOGIN_MENI);
		if (opcija == 1) {
			Korisnik ulogovaniKorisnik = RadSaKorisnicima.ulogujSe();
			if (ulogovaniKorisnik instanceof Kupac) {

				do {
					System.out.println("Ulogovali ste se kao kupac");
					System.out.println(Meniji.MENI_DELIMITER);
					Integer kupacOpcija = MeniPrint.print(Meniji.KUPAC_MENI);

					if (kupacOpcija == 1) {

					} else if (kupacOpcija == 4) {
						ulogovaniKorisnik = null;
					}
				} while (ulogovaniKorisnik != null);
			} else if (ulogovaniKorisnik instanceof Administrator) {

				do {
					System.out.println("Ulogovali ste se kao administrator");
					System.out.println(Meniji.MENI_DELIMITER);
					Integer adminOpcija = MeniPrint.print(Meniji.ADMIN_MENI);
					if (adminOpcija == 1) {
						System.out.println("Dodavanje novog korisnika");
						System.out.println(Meniji.MENI_DELIMITER);
						RadSaKorisnicima.kreirajKorisnika();
						continue;
					} else if (adminOpcija == 2) {
						RadSaKorisnicima.dodajVlasnikaRestorana();
					} else if (adminOpcija == 3) {
						continue;
					} else if (adminOpcija == 4) {
						ulogovaniKorisnik = null;
					}
				} while (ulogovaniKorisnik != null);

			} else {
				System.out.println("Ulogovali ste se kao vlasnik restorana");
				System.out.println(Meniji.MENI_DELIMITER);
				Integer vlasnikOpcija = MeniPrint.print(Meniji.VLASNIK_RESTORANA_MENI);
			}
		}
	}

}