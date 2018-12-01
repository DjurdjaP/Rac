package serviser;

import java.util.ArrayList;
import java.util.Scanner;

import demo.ProveraExceptiona;

public class Serviser {

	private ArrayList<EvidencijaRacunara> listaRacunara;

	//prazan konstruktor
	public Serviser() {
		this.listaRacunara = new ArrayList<>(); 
	}

	// DODELJIVANJE SERVISERU RACUNAR
	public void ubaciUListu (EvidencijaRacunara er) {
		listaRacunara.add(er);
	}
	// metoda koja ce u listu da ubacuje objekte kao sto su evidencijaRacunara; 
	// kada se insancira objekat lt1, er1, er2.. objekat postoji ali on nista ne radi, zato je potrebno da se ubaci u listu i dodeli serviseru
	// kada budemo proveravali nesto, zelimo da to bude globalno, za sve unete racunare a ne za pojedinacne
	// void zato sto ne treba dalje sa tim da radimo, vec samo preko for petlje da pozivamo
	
	public void ukloniIzListe (EvidencijaRacunara stigoRacunar) {
		listaRacunara.remove(stigoRacunar);
	}
	
	// PRIKAZ INFORMACIJA
	public void prikazInformacijaZaSveRacunare () {
		for(int i = 0; i < listaRacunara.size(); i++) {
			System.out.println(listaRacunara.get(i).getRacunarNaServisu().informacijeORacunaru());
			System.out.println(listaRacunara.get(i).informacijeOEvidenciji());
			System.out.println(listaRacunara.get(i).getNaplataServisa().informacijeONaplati());  
		}
	}
	
	// PRIKAZ INFORMACIJA PO TIPU (LAPTOP / DESKTOP)
	public void prikazInformacijaZaSveRacunarePoTipu () {
		
	}
	
	// METODA ZA SKRACENJE KODA SVAKE DRUGE METODE KOJA PROVERAVA PREKO EVIDENCIONOG BROJA
	// PRETRAGA PO EVIDENCIONOM BROJU - UKOLIKO POSTOJI VRACA KONKRETAN OBJEKAT 
	public EvidencijaRacunara pretragaPoEvidencionomBroju() {
		
		System.out.println("Unesite evidencioni broj: ");
		String eBroj = new Scanner(System.in).nextLine();
		boolean objekatNePostoji = true;
		
		for(int i = 0; i < getListaRacunara().size(); i++) {
			if (getListaRacunara().get(i).getEvidencioniBroj().equals(eBroj)) {
				objekatNePostoji = false;
				return getListaRacunara().get(i);  //****
				
			}
		}if(objekatNePostoji == true)
			System.err.println("Racunar sa ovim evidencionim brojem ne postoji na servisu! Pokusajte ponovo!");
		
		
		return null;  //****
	}
	
	//METODA ZA PROMENU STATUSA PRIMENOM FOR EACH PETLJE
//	public void zavrsiServis (String evidencioniBroj2, Naplata naplataServisa) { 
//		for (EvidencijaRacunara evidencija2 : listaRacunara) {
//			if(evidencija2.getEvidencioniBroj().equals(evidencioniBroj2)) {
//				evidencija2.setStatusServisa(Status.ZAVRSEN_SERVIS);
//				evidencija2.setNaplataServisa(naplataServisa);
//			}
//		}
//	}
	
	// MENJA STATUS RACUNARA PO EVIDENCIONOM BROJ U PRIPREMA
	public void promenaStatusaUPriprema () {
		// ne mozemo da pristupimo EvidencijaRacunara kreiramo objekat tipa EvidencijaRacunar i preko njega 
		// pristupimo svemu iz Evidencije Racunara, ovo ne bi moralo da nismo pravili listu		
		
		EvidencijaRacunara e = pretragaPoEvidencionomBroju();  //***** objekat = metoda (u kojoj je radi sa objektom tog tipa)
		if(e != null) 
			e.setStatusServisa(Status.PRIPREMA); ///***
	}
	
	// MENJA STATUS RACUNARA PO EVIDENCIONOM BROJ U PREUZET
	public void promenaStatusaUPreuzet () {
		EvidencijaRacunara e2 = pretragaPoEvidencionomBroju();		
		if(e2.getNaplataServisa().getPlaceno() == true) {
			e2.setStatusServisa(Status.PREUZET);
		}else {
			System.err.println("Ne mozete preuzeti racunar dok dok ne platite racun!");
		}
		
//		if(e2 != null) {
//			e2.setStatusServisa(Status.PREUZET);
//			e2.getNaplataServisa().setPlaceno(true);
//		}
		
	}
	
	//PRIKAZ INFORMACIJA PO STATUSU
	public void prikazInformacijaZaSveRacunarePoStatusu () {
		boolean b = true;
		while(b == true) {
			System.out.println("1 - Prijem");
			System.out.println("2 - Priprema");
			System.out.println("3 - Zavrsen");
			System.out.println("4 - Preuzet");
			System.out.println("0 - Povratak na prethodni meni");
			System.out.println("Unesite opciju za prikaz uredjaja po statusu: ");
			
			String brojOdluke = new Scanner(System.in).nextLine();
			
			for(int i = 0; i < getListaRacunara().size(); i++) {
				if(brojOdluke.equals("1")) {
					
				}
				if(brojOdluke.equals("2")) {
					
				}
				if(brojOdluke.equals("3")) {
					
				}
				if(brojOdluke.equals("4")) {
					
				}
				if(brojOdluke.equals("0")) {
					
				}
			}
		}
		
	}

	
	
	
	public void zarada () {
		Long placeno = 0L;  //tj na gomilici placeno dodajemo svaki "i" koji je placen
		Long nijePlaceno = 0L;  //nijePlaceno ili gomilica za naplatu
		
		for(int i = 0; i < listaRacunara.size(); i++) {
			if(listaRacunara.get(i).getNaplataServisa().getPlaceno() == true) {
				placeno = placeno + listaRacunara.get(i).getNaplataServisa().getIznos();
			}else {
				nijePlaceno = nijePlaceno + listaRacunara.get(i).getNaplataServisa().getIznos();
			}
		}
		
		// mora da bude van for petlje da ne bi svaki put kada nadje ispisao, vec samo konacnu sumu
		System.out.println("Placeno do sad: " + placeno);
		System.out.println("Za naplatu: " + nijePlaceno);
	}
	
	
	public void placanjeServisa () {
		
	}
	
	public void napraviTxtZaUredjaje () {
		
		
	}
	

	


	
	public void lapTopRacunariNaServisu () {
		
	}
		
//get//set	
	public ArrayList<EvidencijaRacunara> getListaRacunara() {
		return listaRacunara;
	}

	public void setListaRacunara(ArrayList<EvidencijaRacunara> listaRacunara) {
		this.listaRacunara = listaRacunara;
	}
	
//	public static ArrayList<EvidencijaRacunara> getListaRacunara() {
//		return listaRacunara;
//	}
//
//	public static void setListaRacunara(ArrayList<EvidencijaRacunara> listaRacunara) {
//		Serviser.listaRacunara = listaRacunara;
//	}
	
	
			
}
