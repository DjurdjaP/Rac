package demo;

import java.util.Scanner;

import racunar.Desktop;
import racunar.LapTop;
import racunar.TipKucista;
import serviser.EvidencijaRacunara;
import serviser.Status;

public class CitacEx {

	// CITAC SA PRIMENOM EXCEPTIONA 
	public static LapTop unosLapTopa () {
		Scanner unos = new Scanner(System.in);
		
		System.out.println("Unesite serijski broj: ");
		String serijskiBr = unos.nextLine();
		System.out.println("Unesite marku racunara: ");
		String marka = unos.nextLine();
		
		Integer velicina = ProveraExceptiona.proveraBroja("Unesite velicinu displeja: ");
		Integer brzina = ProveraExceptiona.proveraBroja("Unesite brzinu procesora: ");
		
		return new LapTop(serijskiBr, brzina, marka, velicina);
	}
	
	
	public static Desktop unosDektopa () {  
		Scanner unos = new Scanner(System.in);
		
		System.out.println("Unesite serijski broj: ");
		String serijskiBr = unos.nextLine();
		System.out.println("Unesite marku racunara: ");
		String marka = unos.nextLine();
		
		TipKucista ispisTk = ProveraExceptiona.proveraEnumaTipKuciste("Unesite tip kucista: ATX ili MICRO_ATX");
		//TipKucista tipK = (TipKucista) ProveraExceptiona.proveraEnumaTipKuciste();  //2
		
		Integer brzina = ProveraExceptiona.proveraBroja("Unesite brzinu procesora: ");
		
		return new Desktop(serijskiBr, brzina, marka, ispisTk);
	}
	
	
	public static EvidencijaRacunara unosEvidencijeZaLaptop () {
		Scanner unos = new Scanner(System.in);
		
		System.out.println("Unesite evidencioni broj: ");
		String evBr = unos.next();
		System.out.println("Unesite ime vlasnika: ");
		String ime = unos.next();
		Status s = ProveraExceptiona.proveraEnumaStatus("Unesite status: ");
		Integer dani = ProveraExceptiona.proveraBroja("Unesite broj dana za koji ce racunar biti popravljen: ");
		
		return new EvidencijaRacunara(evBr, ime, unosLapTopa(), s, dani);
	}
	
	
	public static EvidencijaRacunara unosEvidencijeZaDesktop() { 
		Scanner unos = new Scanner(System.in);
		
		System.out.println("Unesite evidencioni broj: ");
		String evBr = unos.next();
		System.out.println("Unesite ime vlasnika: ");
		String ime = unos.next();
		Status s = ProveraExceptiona.proveraEnumaStatus("Unesite status: ");
		Integer dani = ProveraExceptiona.proveraBroja("Unesite broj dana za koji ce racunar biti popravljen: ");
		
		return new EvidencijaRacunara(evBr, ime, unosDektopa(), s, dani);
	}
	
	// PLUS KOD U OKVIRU IF USLOVA (odluka 1)

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
