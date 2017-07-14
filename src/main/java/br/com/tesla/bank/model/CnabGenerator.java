package br.com.tesla.bank.model;

import java.util.List;

import br.com.tesla.financial.model.entities.Duplicate;
import br.com.tesla.financial.model.entities.DuplicateContract;

public class CnabGenerator {

	
	public String generate(List<Duplicate> duplicates, DuplicateContract contract){
		StringBuilder sb = new StringBuilder();
		
		sb.append(generateHeader(contract));

		for(Duplicate duplicate : duplicates){
			sb.append(generateLot(duplicate));
		}
		
		sb.append(generateTrailer(contract));
		
		return sb.toString();
	}
	
	private String generateHeader(DuplicateContract contract){
		return "HEADER";
	}
	
	private String generateLot(Duplicate duplicate){
		return "HEADER";
	}
	
	private String generateTrailer(DuplicateContract contract){
		return "TRAILER";
	}
	
}
