package org.reactome.server.model;

// Generated Jul 8, 2011 1:48:55 PM by Hibernate Tools 3.4.0.CR1

import javax.xml.bind.annotation.XmlRootElement;

/**
 * LiteratureReference generated by hbm2java
 */
@XmlRootElement
public class LiteratureReference extends Publication {

    private String journal;
    private String pages;
    private Integer pubMedIdentifier;
    private Integer volume;
    private Integer year;

    public LiteratureReference() {
    }

    public String getJournal() {
        return this.journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getPages() {
        return this.pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public Integer getPubMedIdentifier() {
        return this.pubMedIdentifier;
    }

    public void setPubMedIdentifier(Integer pubMedIdentifier) {
        this.pubMedIdentifier = pubMedIdentifier;
    }

    public Integer getVolume() {
        return this.volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getYear() {
        return this.year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

}