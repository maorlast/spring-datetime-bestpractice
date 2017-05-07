package com.maorlast.datetime.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Created by Maor Last on 02/05/2017.
 */
@Entity
public class DateTimeModel {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    long id;
    private LocalDateTime localDateTime;
    private ZonedDateTime zonedDateTime;
    private Date date;
    private java.sql.Date sqlDate;

    public DateTimeModel() {

    }

    public DateTimeModel(LocalDateTime localDateTime, Date date, ZonedDateTime zonedDateTime, java.sql.Date javaDate) {
        this.localDateTime = localDateTime;
        this.date = date;
        this.zonedDateTime = zonedDateTime;
        this.sqlDate = javaDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }

    public void setZonedDateTime(ZonedDateTime zonedDateTime) {
        this.zonedDateTime = zonedDateTime;
    }

    public java.sql.Date getSqlDate() {
        return sqlDate;
    }

    public void setSqlDate(java.sql.Date sqlDate) {
        this.sqlDate = sqlDate;
    }
}
