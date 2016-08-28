package com.ufc.json;

import java.io.IOException;
import java.util.Calendar;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class CalendarSerialize extends StdSerializer<Calendar> {

	public CalendarSerialize() {
		this(null);
	}

	protected CalendarSerialize(Class<Calendar> t) {
		super(t);
	}

	@Override
	public void serialize(Calendar calendar, JsonGenerator jgen, SerializerProvider sp) throws IOException {
		jgen.writeStartObject();
		jgen.writeNumberField("year", calendar.get(Calendar.YEAR));
		jgen.writeNumberField("month", calendar.get(Calendar.MONTH));
		jgen.writeNumberField("dayOfMonth", calendar.get(Calendar.DAY_OF_MONTH));
		jgen.writeNumberField("hourOfDay", calendar.get(Calendar.HOUR_OF_DAY));
		jgen.writeNumberField("minute", calendar.get(Calendar.MINUTE));
		jgen.writeNumberField("second", calendar.get(Calendar.SECOND));
		jgen.writeEndObject();
	}

}
