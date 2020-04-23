package com.tostringtech.refp.application.scalars;

import graphql.schema.*;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static graphql.schema.GraphQLScalarType.newScalar;


@Component
public class DateScalar {

    public static final GraphQLScalarType DATE = newScalar()
            .name("Date")
            .description("Date values handler")
            .coercing(new Coercing() {
                @Override
                public Object serialize(Object dataFetcherResult) throws CoercingSerializeException {
                    LocalDate date = Instant.ofEpochMilli(((Timestamp) dataFetcherResult).getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
                    return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                }

                @Override
                public Object parseValue(Object input) throws CoercingParseValueException {
                    LocalDate date = Instant.ofEpochMilli(((Timestamp) input).getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
                    return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                }

                @Override
                public Object parseLiteral(Object input) throws CoercingParseLiteralException {
                    LocalDate date = Instant.ofEpochMilli(((Timestamp) input).getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
                    return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                }
            })
            .build();
}

