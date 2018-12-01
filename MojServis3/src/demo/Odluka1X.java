package demo;

import java.util.Scanner;
import racunar.Desktop;
import racunar.LapTop;
import racunar.Racunar;
import racunar.TipKucista;
import serviser.EvidencijaRacunara;
import serviser.Status;

public class Odluka1X {
	
	public Odluka1X() {
		super();
	}

//	OTVORENA NOVA KLASA ZA KODA IZ ODLUKE 1 (OVO JE PROBA KOJA RADI, ZA POZIVANJE JE U KLASI Odluka1)
	public EvidencijaRacunara unosEvidencijeZaSveRacunare() {
		Scanner ulaz = new Scanner(System.in);
		System.out.println("Unesite evidencioni broj: ");
		String evBroj = ulaz.nextLine();
		System.out.println("Unesite ime vlasnika: ");
		String ime = ulaz.nextLine();
	
		System.out.println("Unesite racunar: Unesite L za LapTop i D za Desktop! ");
//****	String odluka2 = ulaz.nextLine().toUpperCase();  //**** mora odluka da se nalazi u do petlji inace ne vidi
		
//		ZAJEDNICKI UNOS ZA ISTE PARAMETRE; NE MOZE OVAKO POSTO PRVO IDE UNOS SERIJSKI,MARKA,BRZINA.. PRE NEGO STO MOZE DA SE UNESE L i D
// 		(URADJENO U Odluka1, BEZ KORISCENJA 2 SCANNERA ZA ISTE PARAMETRE)
		Scanner unos1 = new Scanner(System.in);
		System.out.println("Unesite serijski broj: ");
		String serijskiBr = unos1.nextLine();
		System.out.println("Unesite marku racunara: ");
		String marka = unos1.nextLine();
		Integer brzina = ProveraExceptiona.proveraBroja("Unesite brzinu procesora: ");
		
		Racunar r = null;
		boolean uslov = true;
		
		do {
			
			String odluka = ulaz.nextLine().toUpperCase();   //****
			
			if(odluka.equals("L")) {
//				Scanner unos1 = new Scanner(System.in);
//				System.out.println("Unesite serijski broj: ");
//				String serijskiBr = unos1.nextLine();
//				System.out.println("Unesite marku racunara: ");
//				String marka = unos1.nextLine();
//				Integer brzina = ProveraExceptiona.proveraBroja("Unesite brzinu procesora: ");
				
				Integer velicina = ProveraExceptiona.proveraBroja("Unesite velicinu displeja: ");
				r = new LapTop(serijskiBr, brzina, marka, velicina);
				uslov = false;
				
			} else if(odluka.equals("D")) {
//				Scanner unos2 = new Scanner(System.in);
//				System.out.println("Unesite serijski broj: ");
//				String serijskiBr = unos2.nextLine();
//				System.out.println("Unesite marku racunara: ");
//				String marka = unos2.nextLine();
//				Integer brzina = ProveraExceptiona.proveraBroja("Unesite brzinu procesora: ");
				
				TipKucista ispisTk = ProveraExceptiona.proveraEnumaTipKuciste("Unesite tip kucista: ATX ili MICRO_ATX");
				r = new Desktop(serijskiBr, brzina, marka, ispisTk);
				uslov = false;
				
			} else {
				System.out.println("Pogresan unos! Pokusajte ponovo");
				uslov = true;
			}
	
		}while (uslov == true);
	
		Status s = ProveraExceptiona.proveraEnumaStatus("Unesite status: ");
		Integer dani = ProveraExceptiona.proveraBroja("Unesite broj dana za koji ce racunar biti popravljen: ");
		return new EvidencijaRacunara(evBroj, ime, r, s, dani);
	}
	
}
