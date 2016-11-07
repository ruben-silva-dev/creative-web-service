package com.ufc.geral.json;

import java.io.IOException;
import java.util.Calendar;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class CalendarDeserialize extends StdDeserializer<Calendar> {

	private static final long serialVersionUID = 1L;

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

		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(node.get("timeInMillis").longValue());

		return calendar;
	}

}
