package org.hibernate.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLASSROOM")
public class Classroom {


    /**
     *
     */
    private static final long serialVersionUID = -2220681662831144716L;


    @Id
    @Column(name = "OID", unique = true, nullable = false, precision = 9, scale = 0)
    private Long oid;


    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "OID_BUILDING")
    private Building building;

    public Classroom() {
    }

    public Classroom(Long oid, String description, Building building) {
        this.oid = oid;
        this.description = description;
        this.building = building;
    }

    public Long getOid() {
        return this.oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDesCompletaAula() {
        return description + " - " + building.getDescription();
    }

    public Building getBuilding() {
        return building;
    }


    public void setBuilding(Building oidBuilding) {
        this.building = oidBuilding;
    }
}
