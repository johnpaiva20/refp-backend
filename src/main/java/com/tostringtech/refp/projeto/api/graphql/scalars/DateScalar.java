package com.tostringtech.refp.projeto.api.graphql.scalars;

import graphql.schema.*;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

@Component
public class DateScalar extends GraphQLScalarType {
    public DateScalar() {
        super("Date", "Date values", new Coercing() {
            @Override
            public Object serialize(Object o) throws CoercingSerializeException {
                LocalDate date = Instant.ofEpochMilli(((Timestamp)o).getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
                return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }

            @Override
            public Object parseValue(Object o) throws CoercingParseValueException {
                LocalDate date = Instant.ofEpochMilli(((Timestamp)o).getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
                return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }

            @Override
            public Object parseLiteral(Object o) throws CoercingParseLiteralException {
                LocalDate date = Instant.ofEpochMilli(((Timestamp)o).getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
                return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }
        });
    }
}
