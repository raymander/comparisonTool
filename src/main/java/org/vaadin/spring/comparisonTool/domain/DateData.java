package org.vaadin.spring.comparisonTool.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class DateData {
    @Id
    private Date date;
    private double nokiaData;
    private double nordeaData;
    private double microsoftData;
    private double teliaData;

    public DateData() {
    }

    public DateData(Date date, double nokiaData, double nordeaData, double microsoftData, double teliaData) {
        this.date = date;
        this.nokiaData = nokiaData;
        this.nordeaData = nordeaData;
        this.microsoftData = microsoftData;
        this.teliaData = teliaData;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getNokiaData() {
        return nokiaData;
    }

    public void setNokiaData(double nokiaData) {
        this.nokiaData = nokiaData;
    }

    public double getNordeaData() {
        return nordeaData;
    }

    public void setNordeaData(double nordeaData) {
        this.nordeaData = nordeaData;
    }

    public double getMicrosoftData() {
        return microsoftData;
    }

    public void setMicrosoftData(double microsoftData) {
        this.microsoftData = microsoftData;
    }

    public double getTeliaData() {
        return teliaData;
    }

    public void setTeliaData(double teliaData) {
        this.teliaData = teliaData;
    }

    @Override
    public String toString() {
        return "DateData [date=" + date + ", nokiaData=" + nokiaData + ", nordeaData=" + nordeaData + ", microsoftData="
                + microsoftData + ", teliaData=" + teliaData + "]";
    }


}
