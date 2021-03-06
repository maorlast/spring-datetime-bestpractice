package com.maorlast.datetime.service;

import com.maorlast.datetime.model.DateTimeModel;
import com.maorlast.datetime.repository.DateTimeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.time.ZoneOffset.UTC;

/**
 * @author Maor Last
 */
@Service
public class DateTimeService {

    @Autowired
    DateTimeRepository dateTimeRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(DateTimeService.class);

    public void processDate(LocalDate date) {
        LOGGER.info("Processing date: {}", date);
    }

    public void processDateAndTime(LocalDateTime localDateTime) {
        Date input = new Date();
        Instant instant = localDateTime.toInstant(UTC);
        Date date = Date.from(instant);
        LOGGER.info("Processing datetime: {}", date);

        // Original Code
        //Date date = java.sql.Date.valueOf(dateAndTime.toLocalDate());

        // Create ZonedDateTime
        ZoneId zoneId = ZoneId.of( "America/Montreal" );
        ZonedDateTime zdt = ZonedDateTime.ofInstant( instant , zoneId );

        // Create java.sql.Date
        java.sql.Date javaDate = java.sql.Date.valueOf( localDateTime.toLocalDate() );

        DateTimeModel dateTimeModel = new DateTimeModel(localDateTime, date, zdt, javaDate);
        //DateTimeModel dateTimeModel = new DateTimeModel(localDateTime, date, zdt);

        // I want to convert the Date and Time
        // From java.time.LocalDateTime to java.util.Date
        //Date date = java.sql.Date.valueOf(dateAndTime.toLocalDate());

        // Save to Database
        addDateTimeModel(dateTimeModel);
    }

    public void processZonedDateAndTime(ZonedDateTime dateAndTime) {
        LOGGER.info("Processing utc datetime: {}", dateAndTime);
    }

    public void addDateTimeModel(DateTimeModel dateTimeModel) {
        dateTimeRepository.save(dateTimeModel);
    }

    public List<DateTimeModel> getAllDateTimeModels() {
        List<DateTimeModel> dateTimes = new ArrayList<>();
        dateTimeRepository.findAll().forEach(dateTimes::add);
        return dateTimes;
    }
}
