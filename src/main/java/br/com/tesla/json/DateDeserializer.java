package br.com.tesla.json;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class DateDeserializer extends JsonDeserializer<Date>{

	private static final SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	
	@Override
	public Date deserialize(JsonParser parse, DeserializationContext ctx) throws IOException, JsonProcessingException {
		String date = parse.getText();
		try {
			return format.parse(date);
		} catch (ParseException e) {
			throw new RuntimeException("Formato de data invalido");
		}
	}

}
