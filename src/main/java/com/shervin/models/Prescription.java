package com.shervin.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Prescription implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private Date issueDate;

    @Column(nullable = false)
    private Date referralDate;

    @ManyToOne
    private Patient patient;

    public Prescription() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getReferralDate() {
        return referralDate;
    }

    public void setReferralDate(Date referralDate) {
        this.referralDate = referralDate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", issueDate=" + issueDate +
                ", referralDate=" + referralDate +
                '}';
    }
}
