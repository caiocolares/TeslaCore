package br.com.tesla.core.model.entities;

public enum UF {
	
	AC("Acre", 12),
	AL("Alagoas", 27),
	AP("Amapá", 16),
	AM("Amazonas", 13),
	BA("Bahia", 29),
	CE("Ceará", 23),
	DF("Distrito Federal", 53),
	ES("Espírito Santo", 32),
	GO("Goiás", 52),
	MA("Maranhão", 21),
	MT("Mato Grosso", 51),
	MS("Mato Grosso do Sul", 50),
	MG("Minas Gerais", 31),
	PA("Pará", 15),
	PB("Parnaíba", 25),
	PR("Paraná", 41),
	PE("Pernanbuco", 26),
	PI("Piauí", 22),
	RJ("Rio de Janeiro", 33),
	RN("Rio Grande do Norte", 24),
	RS("Rio Grande do Sul", 43),
	RO("Rondônia", 11),
	RR("Roraima", 14),
	SC("Santa Catarina", 42),
	SP("São Paulo", 35),
	SE("Sergipe", 28),
	TO("Tocantins", 17);	
	
	private String name;
	private Integer code;	
	
	private UF(String name, Integer code){		
		this.name = name;
		this.code = code;		
	}
	
	public String getName(){
		return this.name;
	}
	
	public Integer getCode(){
		return this.code;
	}
	
	public static UF[] getList(){
		return new UF[] {AC, AL, AP, AM, BA, CE, DF, ES, GO, MA, MT, MS, MG, PA, PB, PR, PE, PI, RJ, RN, RS, RO, RR, SC, SP, SE, TO};
	}
}