package org.reactome.server.model;

// Generated Jul 8, 2011 1:48:55 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Pathway generated by hbm2java
 */
@XmlRootElement
public class Pathway extends Event {

    private String doi;
    private String isCanonical;
    private List<Event> hasEvent;
    private Boolean hasDiagram;


    public List<Event> getHasEvent() {
        return hasEvent;
    }
    
    public Boolean getHasDiagram() {
        return this.hasDiagram;
    }
    
    public void setHasDiagram(Boolean hasDiagram) {
        this.hasDiagram = hasDiagram;
    }

    public void setHasEvent(List<Event> hasEvent) {
        this.hasEvent = hasEvent;
    }

    public Pathway() {
    }

    public String getDoi() {
        return this.doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getIsCanonical() {
        return this.isCanonical;
    }

    public void setIsCanonical(String isCanonical) {
        this.isCanonical = isCanonical;
    }

}