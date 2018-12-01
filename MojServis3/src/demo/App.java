package demo;

import java.util.Scanner;

import racunar.Desktop;
import racunar.LapTop;
import racunar.TipKucista;
import serviser.EvidencijaRacunara;
import serviser.Serviser;
import serviser.Status;

public class App {

	public static void main(String[] args) {
		
		
		Serviser mirko = new Serviser();
		
		EvidencijaRacunara er1 = new EvidencijaRacunara("5b", "Isidora", new LapTop("2222", 2000, "Dell", 18), Status.PRIJEM, 3);
		EvidencijaRacunara er2 = new EvidencijaRacunara("3b", "Nemanja", new Desktop("9999", 1500, "Toshida", TipKucista.ATX), Status.PRIJEM, 9);

	//| Rucno menjanje Naplata, zato sto nam je konstruktor prazan
		er1.getNaplataServisa().setIznos(2000L);
		er1.getNaplataServisa().setPlaceno(true);
		
		er2.getNaplataServisa().setIznos(3000L);
		//placeno ostaje false
	//|	
	
		
		
	//| Dodavanje serviseru sve racunare (u listu)
		// da bi konkretan objekat (er1, er2) mogli da ubacimo u listu, tj da dodelimo serviseru, pravili smo ubaciULisu();
			
		mirko.ubaciUListu(er1);
		mirko.ubaciUListu(er2);
		
		System.out.println("Promet: ");
		mirko.zarada(); // posle ubacivanja u listu
	//|
		
		
		
	//|	Prikaz informacija za sve rac		
		// treba nam da prikazemo informacijeORacunaru za sve mirkove racunare, sad su svi racunari u listi, sto znaci da radimo preko for petlje
		// mora u syso zato sto metoda informacijeORacunaru() nije void 
		
		// kada ovo ne radimo u klasi u kojoj se nalazi lista : mirko. 
		// kada su promenljive privatne, iz drugih klasa im pristupamo preko klasa u kojoj nalaze (Serviser), tj preko objekta iz te klase (mirko.)
		
		// generalno za sve sto hocemo da radimo moramo da pristupimo nekom objektu, a ukoliko se taj objekat nalazi u nekom drugom objektu, 
		// moras prvo njemu da pristupis..
		
		System.out.println("");
		System.out.println("Varijanta 1 - PRIKAZ INFORMACIJA za sve mirkove racunare (bez metode)");
		for(int i = 0; i < mirko.getListaRacunara().size(); i++) {
			System.out.println(mirko.getListaRacunara().get(i).getRacunarNaServisu().informacijeORacunaru());
		}
		
		System.out.println("Varijanta 2 - PRIKAZ samo druge mirkove evidencije");
		System.out.println(mirko.getListaRacunara().get(1).getRacunarNaServisu().informacijeORacunaru());
		
		System.out.println("Bingo - RIKAZ INFORMACIJA preko metode iz Serviser");
		mirko.promenaStatusaUPreuzet(); //
		mirko.prikazInformacijaZaSveRacunare();
		
	//|		
		
		
		
		System.out.println("");
		System.out.println("***unos preko komandi***");
		System.out.println("");
		
		boolean prikaz = true;
		
		do {
			System.out.println("");
			System.out.println("Izaberite opciju: ");
			System.out.println("0 - za izlaz iz aplikacije");
			System.out.println("1 - za unos novog racunara");
			System.out.println("2 - za unos cene servisa");
			System.out.println("3 - za placanje servisa");
			System.out.println("4 - za prikaz svi racunara na servisu");
			System.out.println("5 - za prikaz zarade");
			
			Scanner unos = new Scanner(System.in);
			Integer odluka = unos.nextInt();
			
			if(odluka == 0) {
				System.out.println("***Hvala sto ste nasi korisnici***");
				prikaz = false;
			}
			if(odluka == 1) {
				Odluka1 o = new Odluka1();
				mirko.ubaciUListu(o.unosEvidencijeZaSveRacunare());
			}
			if(odluka == 2) {
				// uslov mora da postoji
				// boolean objekatNePostoji = true;  // 1
				boolean objekatPostoji = false; // 2*
				
				do {
					// scanner mora da bude unutar do petlje inace ce vrteti beskonacnu petlju
			        // drugi uslov mora da bude van for petlje
					
					System.out.println("Unesite evidencioni broj: ");
					String eBr = new Scanner(System.in).nextLine();  // sigurnije je kad se u svakom if otvara nov Scanner (skracena verzija)
					
					// for mora da se nalazi u do petlji, ne obrunuto
					for(int i  = 0; i < mirko.getListaRacunara().size(); i++) {
						if(mirko.getListaRacunara().get(i).getEvidencioniBroj().equals(eBr)) {
							Long cena = ProveraExceptiona.proveraBrojaLongZaCenuS("Unesite cenu servisa: ");
							mirko.getListaRacunara().get(i).getNaplataServisa().setIznos(cena);
							
							//objekatNePostoji = false; // 1
							objekatPostoji = true; // 2
						}
					}
					if (objekatPostoji == false) {
						//objekatNePostoji = true; // 1
						System.err.println("Racunar sa ovim evidencionim brojem ne postoji na servisu! Pokusajte ponovo!");	
					}
					
				}while(objekatPostoji == false);
						//objekatNePostoji = true; // 1
					
				
			}
			if(odluka == 3) {
				
			}
			if(odluka == 4) {
				mirko.prikazInformacijaZaSveRacunare();
			}
			if(odluka == 5) {
				mirko.zarada();
			}
			
		}while(prikaz == true);
	
		
	}
}
