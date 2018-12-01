package serviser;

public class Naplata {

	private Long iznos;
	private Boolean placeno;

	public Naplata() { // da se nista ne unosi preko konzole vec da se posebno menja preko setera
		super();
		this.iznos = 0L;  //pocetne vrednosti (kada je primljen)
		this.placeno = false; //*
	}
	
	public String informacijeONaplati () {
		return "Vas racun iznosi: " + getIznos() + "\nVas racun je: " + FormaterZaNaplatu.proveraPlaceno(getPlaceno()) + "\n";
	}
		//bez formatera je getPlaceno(), zato je to u () 
	
//get//set	
	public Long getIznos() {
		return iznos;
	}
	public void setIznos(Long iznos) {
		this.iznos = iznos;
	}
	public Boolean getPlaceno() {
		return placeno;
	}
	public void setPlaceno(Boolean placeno) {
		this.placeno = placeno;
	}
	
	
}
