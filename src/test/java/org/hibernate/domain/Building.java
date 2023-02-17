package org.hibernate.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "BUILDING")
public class Building {
    private static final long serialVersionUID = -2220681662831144716L;

    @Id
    @Column(name = "OID", unique = true, nullable = false, precision = 9, scale = 0)
    private Long oid;

    @Column(name = "description")
    private String description;

    public Building() {
    }

    public Building(Long oid, String description) {
        this.oid = oid;
        this.description = description;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descrizione) {
        this.description = descrizione;
    }
}
