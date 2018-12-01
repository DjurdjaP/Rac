package demo;

import java.util.Scanner;

import racunar.Desktop;
import racunar.LapTop;
import racunar.Racunar;
import racunar.TipKucista;
import serviser.EvidencijaRacunara;

public class Citac {

	// metode: 
	// piblic/private + (static) + tip objekta koji vraca/ ili void + ime metode + (ulazne promenljive, tip sa kojim radimo u metodi)
	// kod unosa pravimo objekat tipa laptopa sto znaci da treba da vratimo tj return laptop
	// uvek je dobro odmah na pocetku return new - taj objekat sa svim parametrima i po tome znas koja polja trebaju 
	// integere na kraju, ovde nije bitan redosled; ali je bitano u return new da bude redosled kao u konstruktoru
	
	//CITAC BEZ EXCEPTIONA
	public static LapTop unosLapTopa () {
		Scanner unos = new Scanner(System.in);
		
		System.out.println("Unesite serijski broj: ");
		String serijskiBr = unos.nextLine();
		System.out.println("Unesite marku racunara: ");
		String marka = unos.nextLine();
		System.out.println("Unesite velicinu displeja: ");
		Integer velicina = unos.nextInt();
		System.out.println("Unesite brzinu procesora: ");
		Integer brzina = unos.nextInt();
		
		return new LapTop(serijskiBr, brzina, marka, velicina);
	}
	
	
	public static Desktop unosDektopa () {  
		Scanner unos = new Scanner(System.in);
		
		System.out.println("Unesite serijski broj: ");
		String serijskiBr = unos.nextLine();
		System.out.println("Unesite marku racunara: ");
		String marka = unos.nextLine();
		
		System.out.println("Unesite tip kucista: ATX ili MICRO_ATX");   // unos enuma preko konzole
		String promTipKucista = unos.nextLine().toUpperCase();
		TipKucista tipK = TipKucista.valueOf(promTipKucista);
		
		System.out.println("Unesite brzinu procesora: ");
		Integer brzina = unos.nextInt();
		
		return new Desktop(serijskiBr, brzina, marka, tipK);
	}
	
	
	public static EvidencijaRacunara unosEvidencijeZaLaptop () {
		Scanner unos = new Scanner(System.in);
		
		System.out.println("Unesite evidencioni broj: ");
		String evBr = unos.next();
		System.out.println("Unesite ime vlasnika: ");
		String ime = unos.next();
		
		return new EvidencijaRacunara(evBr, ime, unosLapTopa());
	}
	
	
	public static EvidencijaRacunara unosEvidencijeZaDesktop() { 
		// bez pozivanja metode unosDektopa () // new return new
		Scanner unos = new Scanner(System.in);
		
		
		System.out.println("Unesite evidencioni broj: ");
		String evBr = unos.next();
		System.out.println("Unesite ime vlasnika: ");
		String ime = unos.next();
		System.out.println("Unesite serijski broj: ");
		String serijskiBr = unos.next();
		System.out.println("Unesite marku racunara: ");
		String marka = unos.next();

		System.out.println("Unesite tip kucista: ATX ili MICRO_ATX");
		String promenTipKucista = unos.next().toUpperCase();           
		TipKucista tipKuc = TipKucista.valueOf(promenTipKucista);

		System.out.println("Unesite brzinu procesora: ");
		Integer brzina = unos.nextInt();

		Racunar r = new Desktop(serijskiBr, brzina, marka, tipKuc);
		EvidencijaRacunara er = new EvidencijaRacunara(evBr, ime, r);

		return er;
	}
//	// PLUS JEDNA OD OVE DVE OPCIJE
	
	
//	// UNOS EVIDENCIJE // logika u citacu 
//
//	public static void unosEvidencije() {
//		Scanner unos = new Scanner(System.in);
//		
//		System.out.println("Unos racunara! Za unos LapTop-a ukucajte L, za unos Desktop-a D: ");
//		String odluka = unos.nextLine().toUpperCase();
//
//		// potrebno je kada pozovemo ovu metodu u app da objekat, koji nastaje preko konzole, ubaci u listu (ista funkcija kao za er1, er2)
//		// posto je ova metoda void ne vraca nam objekat sa kojim se dalje radi (ubacivanje preko metode ubaciUListu)
//		// zbog toga logiku moramo da ubacimo u metodu, u okviru if uslova: Servis.getListaRacunara().ADD(evidencijaZaLaptop());
//		// za pristup getListaRacunara, ArrayListu menjamo u static (menjaju se i geteri i seteri)
//		
//		if(odluka.equals("L")) {
//			//unosEvidencijeZaLaptop(); 
//			Serviser.getListaRacunara().add(unosEvidencijeZaLaptop());
//			
//		} else if(odluka.equals("D")) {
//			//unosEvidencijeZaDesktop();
//			Serviser.getListaRacunara().add(unosEvidencijeZaDesktop());
//			
//		} else {
//			System.out.println("Pogresan unos! ");
//		}
//			
//		// return new EvidencijaRacunara(evidencioniBroj, vlasnik, RACUNAR) ne treba 
//		// svakako imam sve u metodama gore unosEvidencijeZaLaptop();...
//	}
	
	
	
//	// UNOS EVIDENCIJE // logika u aplikaciji (u if) (da lista ne bi bila static)
//
//		System.out.println("Ukoliko zelite unos LapTop-a unesite L, ukoliko zelite Desktop D: ");
//		String odluka2 = new Scanner(System.in).nextLine().toUpperCase();
//			
//		if(odluka2.equals("L")) {
//			EvidencijaRacunara evid1 = CitacEx.unosEvidencijeZaLaptop();
//			mirko.ubaciUListu(evid1);
//			
//		} else if (odluka2.equals("D")) {
//			EvidencijaRacunara evid1 = CitacEx.unosEvidencijeZaDesktop();
//			mirko.ubaciUListu(evid1);
//				
//		} else {
//			System.out.println("Pogresan unos: ");
//		}	
	
	
	
	
	
}
