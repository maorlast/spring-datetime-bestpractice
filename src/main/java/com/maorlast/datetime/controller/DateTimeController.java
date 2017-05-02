package com.maorlast.datetime.controller;

import com.maorlast.datetime.model.DateTimeModel;
import com.maorlast.datetime.service.DateTimeService;
import com.sun.xml.internal.ws.client.ResponseContext;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.servlet4preview.RequestDispatcher;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.catalina.util.RequestUtil;
import org.apache.coyote.RequestInfo;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.*;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author Maor Last
 */
@RestController
@RequestMapping("/api")
public final class DateTimeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateTimeController.class);
    private final DateTimeService dateTimeService;

    @Autowired
    public DateTimeController(DateTimeService dateTimeService) {
        this.dateTimeService = dateTimeService;
    }

    @RequestMapping(value = "date", method = RequestMethod.POST)
    public void processDate(@RequestParam("date") LocalDate date) {
        LOGGER.info("Processing date: {}", date);
        dateTimeService.processDate(date);
    }

    // i.e http://localhost:8080/api/datetime?datetime=2015-09-26T01:30:00.000
    @RequestMapping(value = "datetime", method = RequestMethod.POST)
    public void processDateTime(@RequestParam("datetime") LocalDateTime  dateAndTime) {
        LOGGER.info("Processing date and time: {}", dateAndTime);
        dateTimeService.processDateAndTime(dateAndTime);
    }

    @RequestMapping("/datetimes")
    public List<DateTimeModel> getAllDateTimes(){
        return dateTimeService.getAllDateTimeModels();
    }

    @RequestMapping(value = "/zoneddatetime", method = RequestMethod.POST)
    public void processZonedDateTime(@RequestParam("zoneddatetime") ZonedDateTime dateAndTime) {
        LOGGER.info("Processing zoned date and time: {}", dateAndTime);
        dateTimeService.processZonedDateAndTime(dateAndTime);
    }
}
