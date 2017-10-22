package com.ooad.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PATIENT_REPORT")
public class PatientReport {
    @EmbeddedId
    private PatientDate patientDate;

    @Column(name = "DIAGNOSIS", nullable = true)
    private String diagnosis;

    @Column(name = "PRESCRIPTION", nullable = true)
    private String prescription;

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public PatientDate getPatientDate() {
        return patientDate;
    }

    public void setPatientDate(PatientDate patientDate) {
        this.patientDate = patientDate;
    }
}
