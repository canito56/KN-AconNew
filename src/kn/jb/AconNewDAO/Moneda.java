package kn.jb.AconNewDAO;

public class Moneda {
	
	private String code, desc, decPlace, unitWord, decWord;
	
	public Moneda(String code, String desc, String decPlace, String unitWord, String decWord) {
		
		this.code = code;
		this.desc = desc;
		this.decPlace = decPlace;
		this.unitWord = unitWord;
		this.decWord  = decWord;
		
	} 

	public String getCode() {
		return code;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public String getDecPlace() {
		return decPlace;
	}
	
	public String getUnitWord() {
		return unitWord;
	}
	
	public String getDecWord() {
		return decWord;
	}
	
}
