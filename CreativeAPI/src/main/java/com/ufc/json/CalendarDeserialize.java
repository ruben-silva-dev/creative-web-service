package com.ufc.json;

import java.io.IOException;
import java.util.Calendar;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class CalendarDeserialize extends StdDeserializer<Calendar> {

	public CalendarDeserialize() {
		this(null);
	}

	protected CalendarDeserialize(Class<Calendar> c) {
		super(c);
	}

	@Override
	public Calendar deserialize(JsonParser parser, DeserializationContext ctx)
			throws IOException, JsonProcessingException {
		JsonNode node = parser.getCodec().readTree(parser);

		Integer year = (Integer) node.get("year").numberValue();
		Integer month = (Integer) node.get("month").numberValue();
		Integer date = (Integer) node.get("dayOfMonth").numberValue();
		Integer hourOfDay = (Integer) node.get("hourOfDay").numberValue();
		Integer minute = (Integer) node.get("minute").numberValue();
		Integer second = (Integer) node.get("second").numberValue();

		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, date, hourOfDay, minute, second);

		return calendar;
	}

}
