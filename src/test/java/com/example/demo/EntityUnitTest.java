package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.annotation.Generated;
import javax.persistence.GenerationType;

import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import com.example.demo.entities.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestInstance(Lifecycle.PER_CLASS)
class EntityUnitTest {

    @Autowired
    private TestEntityManager entityManager;

    private Doctor d1;

    private Patient p1;

    private Room r1;

    private Appointment a1;
    private Appointment a2;
    private Appointment a3;

    /**
     * TODO
     * Implement tests for each Entity class: Doctor, Patient, Room and Appointment.
     * Make sure you are as exhaustive as possible. Coverage is checked ;)
     */
    @Test
    public void should_doctor_not_null() {
        d1 = new Doctor();
        assertNotNull(d1);
    }

    @Test
    public void should_patient_not_null() {
        p1 = new Patient();
        assertNotNull(p1);
    }

    @Test
    public void should_room_not_null() {
        r1 = new Room();
        assertNotNull(r1);
    }

    @Test
    public void should_doctor_get_firstName() {
        d1 = new Doctor("Doctor", "Doe", 30, "doctor@example.com");

        assertThat(d1.getFirstName()).isEqualTo("Doctor");

    }

    @Test
    public void should_doctor_get_lastName() {
        d1 = new Doctor("Doctor", "Doe", 30, "doctor@example.com");

        assertThat(d1.getLastName()).isEqualTo("Doe");
    }

    @Test
    public void should_doctor_get_age() {
        d1 = new Doctor("Doctor", "Doe", 30, "doctor@example.com");

        assertThat(d1.getAge()).isEqualTo(30);
    }

    @Test
    public void should_doctor_get_email() {
        d1 = new Doctor("Doctor", "Doe", 30, "doctor@example.com");

        assertThat(d1.getEmail()).isEqualTo("doctor@example.com");
    }

    @Test
    public void should_doctor_set_firstName() {
        d1 = new Doctor("Doctor", "Doe", 30, "doctor@example.com");
        d1.setFirstName("John");

        assertThat(d1.getFirstName()).isEqualTo("John");
    }

    @Test
    public void should_doctor_set_LastName() {
        d1 = new Doctor("Doctor", "Doe", 30, "doctor@example.com");
        d1.setLastName("Brown");

        assertThat(d1.getLastName()).isEqualTo("Brown");
    }

    @Test
    public void should_doctor_set_age() {
        d1 = new Doctor("Doctor", "Doe", 30, "doctor@example.com");
        d1.setAge(23);

        assertThat(d1.getAge()).isEqualTo(23);
    }

    @Test
    public void should_doctor_set_email() {
        d1 = new Doctor("Doctor", "Doe", 30, "doctor@example.com");
        d1.setEmail("doctor2@example.com");

        assertThat(d1.getEmail()).isEqualTo("doctor2@example.com");
    }

    @Test
    public void should_patient_get_firstName() {
        p1 = new Patient("patient", "Doe", 30, "patient@example.com");

        assertThat(p1.getFirstName()).isEqualTo("patient");

    }

    @Test
    public void should_patient_get_lastName() {
        p1 = new Patient("patient", "Doe", 30, "patient@example.com");

        assertThat(p1.getLastName()).isEqualTo("Doe");
    }

    @Test
    public void should_patient_get_age() {
        p1 = new Patient("patient", "Doe", 30, "patient@example.com");

        assertThat(p1.getAge()).isEqualTo(30);
    }

    @Test
    public void should_patient_get_email() {
        p1 = new Patient("patient", "Doe", 30, "patient@example.com");

        assertThat(p1.getEmail()).isEqualTo("patient@example.com");
    }

    @Test
    public void should_patient_set_firstName() {
        p1 = new Patient("patient", "Doe", 30, "patient@example.com");
        p1.setFirstName("John");

        assertThat(p1.getFirstName()).isEqualTo("John");
    }

    @Test
    public void should_patient_set_LastName() {
        p1 = new Patient("patient", "Doe", 30, "patient@example.com");
        p1.setLastName("Brown");

        assertThat(p1.getLastName()).isEqualTo("Brown");
    }

    @Test
    public void should_patient_set_age() {
        p1 = new Patient("patient", "Doe", 30, "patient@example.com");
        p1.setAge(23);

        assertThat(p1.getAge()).isEqualTo(23);
    }

    @Test
    public void should_patient_set_email() {
        p1 = new Patient("patient", "Doe", 30, "patient@example.com");
        p1.setEmail("patient2@example.com");

        assertThat(p1.getEmail()).isEqualTo("patient2@example.com");
    }

    @Test
    public void should_room_has_attributes_with_values() {
        r1 = new Room("room");
        assertThat(r1).hasFieldOrPropertyWithValue("roomName", "room");
    }

    @Test
    public void should_room_get_roomName() {
        r1 = new Room("room");
        assertThat(r1.getRoomName()).isEqualTo("room");
    }

    @Test
    public void should_appointment_get_patient() {
        p1 = new Patient("patient", "Doe", 30, "patient@example.com");

        LocalDateTime startsAt = LocalDateTime.now();
        LocalDateTime finishesAt = LocalDateTime.now();

        entityManager.persist(p1);

        a1 = new Appointment(p1, d1, r1, startsAt, finishesAt);
        assertThat(a1.getPatient()).isEqualTo(p1);
    }

    @Test
    public void should_appointment_get_doctor() {
        d1 = new Doctor("Doctor", "Doe", 30, "doctor@example.com");

        LocalDateTime startsAt = LocalDateTime.now();
        LocalDateTime finishesAt = LocalDateTime.now();

        entityManager.persist(d1);

        a1 = new Appointment(p1, d1, r1, startsAt, finishesAt);
        assertThat(a1.getDoctor()).isEqualTo(d1);
    }

    @Test
    public void should_appointment_get_room() {
        r1 = new Room("room");

        LocalDateTime startsAt = LocalDateTime.now();
        LocalDateTime finishesAt = LocalDateTime.now();

        entityManager.persist(r1);

        a1 = new Appointment(p1, d1, r1, startsAt, finishesAt);

        assertThat(a1.getRoom()).isEqualTo(r1);
    }

    @Test
    public void should_appointment_get_startsAt() {
        LocalDateTime startsAt = LocalDateTime.now();
        LocalDateTime finishesAt = LocalDateTime.now();

        a1 = new Appointment(p1, d1, r1, startsAt, finishesAt);

        assertThat(a1.getStartsAt()).isEqualTo(startsAt);
    }

    @Test
    public void should_appointment_get_finishesAt() {
        LocalDateTime startsAt = LocalDateTime.now();
        LocalDateTime finishesAt = LocalDateTime.now();

        a1 = new Appointment(p1, d1, r1, startsAt, finishesAt);

        assertThat(a1.getFinishesAt()).isEqualTo(finishesAt);
    }

    @Test
    public void should_appointment_set_patient() {
        a1 = new Appointment();
        p1 = new Patient("patient", "Doe", 30, "patient@example.com");
        entityManager.persist(p1);
        a1.setPatient(p1);
        assertThat(a1.getPatient()).isEqualTo(p1);
    }

    @Test
    public void should_appointment_set_doctor() {
        a1 = new Appointment();
        d1 = new Doctor("doctor", "Doe", 30, "doctor@example.com");
        entityManager.persist(d1);
        a1.setDoctor(d1);
        assertThat(a1.getDoctor()).isEqualTo(d1);
    }

    @Test
    public void should_appointment_set_room() {
        a1 = new Appointment();
        r1 = new Room("room");
        entityManager.persist(r1);
        a1.setRoom(r1);
        assertThat(a1.getRoom()).isEqualTo(r1);
    }

    @Test
    public void should_appointment_set_startsAt() {
        LocalDateTime startsAt = LocalDateTime.now();
        LocalDateTime finishesAt = LocalDateTime.now();

        a1 = new Appointment(p1, d1, r1, startsAt, finishesAt);

        LocalDateTime startsAt2 = LocalDateTime.now();

        a1.setFinishesAt(startsAt2);

        assertThat(a1.getStartsAt()).isEqualTo(startsAt2);
    }

    @Test
    public void should_appointment_set_finishesAt() {
        LocalDateTime startsAt = LocalDateTime.now();
        LocalDateTime finishesAt = LocalDateTime.now();

        a1 = new Appointment(p1, d1, r1, startsAt, finishesAt);

        LocalDateTime finishesAt2 = LocalDateTime.now();

        a1.setFinishesAt(finishesAt2);

        assertThat(a1.getFinishesAt()).isEqualTo(finishesAt2);
    }

    @Test
    public void should_appoointments_overlap_start_same_time() {
        p1 = new Patient("patient", "Brown", 30, "patient@example.com");
        d1 = new Doctor("doctor", "Doe", 30, "doctor@example.com");
        r1 = new Room("room");
        LocalDateTime startsAt = LocalDateTime.now();
        LocalDateTime finishesAt = LocalDateTime.now();

        a1 = new Appointment(p1, d1, r1, startsAt, finishesAt);
        LocalDateTime finishesAt2 = LocalDateTime.now();
        a2 = new Appointment(p1, d1, r1, startsAt, finishesAt2);
        assertTrue(a1.overlaps(a2));
    }

    @Test
    public void should_appoointments_overlap_finish_same_time() {
        p1 = new Patient("patient", "Brown", 30, "patient@example.com");
        d1 = new Doctor("doctor", "Doe", 30, "doctor@example.com");
        r1 = new Room("room");
        LocalDateTime startsAt = LocalDateTime.now();
        LocalDateTime finishesAt = LocalDateTime.now();

        a1 = new Appointment(p1, d1, r1, startsAt, finishesAt);
        LocalDateTime startsAt2 = LocalDateTime.now();
        a2 = new Appointment(p1, d1, r1, startsAt2, finishesAt);
        assertTrue(a1.overlaps(a2));
    }

    @Test
    public void should_appoointments_overlap_finishB_first_finishA() {
        p1 = new Patient("patient", "Brown", 30, "patient@example.com");
        d1 = new Doctor("doctor", "Doe", 30, "doctor@example.com");
        r1 = new Room("room");
        LocalDateTime startsAt = LocalDateTime.now();
        LocalDateTime finishesAt = LocalDateTime.now();
        LocalDateTime startsAt2 = LocalDateTime.now();
        LocalDateTime finishesAt2 = LocalDateTime.now();

        a1 = new Appointment(p1, d1, r1, startsAt, finishesAt2);
        a2 = new Appointment(p1, d1, r1, startsAt2, finishesAt);
        assertTrue(a1.overlaps(a2));
    }

    @Test
    public void should_appoointments_overlap_startB_first_startA() {
        LocalDateTime startsAt = LocalDateTime.now();
        LocalDateTime finishesAt = LocalDateTime.now();
        LocalDateTime startsAt2 = LocalDateTime.now();
        LocalDateTime finishesAt2 = LocalDateTime.now();

        a1 = new Appointment(p1, d1, r1, startsAt2, finishesAt);
        a2 = new Appointment(p1, d1, r1, startsAt, finishesAt2);
        assertTrue(a1.overlaps(a2));
    }

    @Test
    public void shouldnt_appoointments_overlap() {
        p1 = new Patient("patient", "Brown", 30, "patient@example.com");
        d1 = new Doctor("doctor", "Doe", 30, "doctor@example.com");
        r1 = new Room("room");
        Room r2 = new Room("room2");
        LocalDateTime startsAt = LocalDateTime.now();
        LocalDateTime finishesAt = LocalDateTime.now();
        a1 = new Appointment(p1, d1, r1, startsAt, finishesAt);
        a2 = new Appointment(p1, d1, r2, startsAt, finishesAt);
        assertFalse(a1.overlaps(a2));
    }
}