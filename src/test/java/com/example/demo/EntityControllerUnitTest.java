
package com.example.demo;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.assertThat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import java.time.LocalDateTime;
import java.time.format.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.example.demo.controllers.*;
import com.example.demo.repositories.*;
import com.example.demo.entities.*;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * TODO
 * Implement all the unit test in its corresponding class.
 * Make sure to be as exhaustive as possible. Coverage is checked ;)
 */

@WebMvcTest(DoctorController.class)
class DoctorControllerUnitTest {

    @MockBean
    private DoctorRepository doctorRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldCreateDoctor() throws Exception {
        Doctor doctor = new Doctor("John", "Brown", 28, "doctor@example.com");
        mockMvc.perform(post("/api/doctor").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(doctor)))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteDoctorById() throws Exception {
        Doctor doctor = new Doctor("John", "Brown", 28, "doctor@example.com");
        mockMvc.perform(delete("/api/doctor/" + doctor.getId()))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldNotDeletePatientById() throws Exception {
        long id = 21;
        mockMvc.perform(delete("/api/doctor/" + id))
                .andExpect(status().isNotFound());
    }

    @Test
    public void shoudlGetDoctorById() throws Exception {
        Doctor doctor = new Doctor("John", "Brown", 28, "doctor@example.com");
        mockMvc.perform(get("/api/doctor/" + doctor.getId()))
                .andExpect(status().isOk());
    }

    @Test
    public void shoudlNotGetDoctorById() throws Exception {
        long id = 0;
        mockMvc.perform(get("/api/doctor/" + id))
                .andExpect(status().isNotFound());
    }
}

@WebMvcTest(PatientController.class)
class PatientControllerUnitTest {

    @MockBean
    private PatientRepository patientRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldCreatePatient() throws Exception {
        Patient patient = new Patient("John", "Brown", 28, "patient@example.com");
        mockMvc.perform(post("/api/patient").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(patient)))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeletePatientById() throws Exception {
        Patient patient = new Patient("Alfonso", "Tello", 28, "patient@example.com");
        mockMvc.perform(delete("/api/patient/" + patient.getId()))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldNotDeletePatientById() throws Exception {
        long id = 21;
        mockMvc.perform(delete("/api/patient/" + id))
                .andExpect(status().isNotFound());
    }

    @Test
    public void shoudlGetPatientById() throws Exception {
        Patient patient = new Patient("Alfonso", "Tello", 28, "patient@example.com");
        mockMvc.perform(get("/api/patient/" + patient.getId()))
                .andExpect(status().isOk());
    }

    @Test
    public void shoudlNotGetPatientById() throws Exception {
        long id = 0;
        mockMvc.perform(get("/api/patient/" + id))
                .andExpect(status().isNotFound());
    }

}

@WebMvcTest(RoomController.class)
class RoomControllerUnitTest {

    @MockBean
    private RoomRepository roomRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldCreateRoom() throws Exception {
        Room room = new Room("room");
        mockMvc.perform(post("/api/room").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(room)))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteRoomByRoomName() throws Exception {
        Room room = new Room("room");
        mockMvc.perform(delete("/api/doctor").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(room.getRoomName())))
                .andExpect(status().isOk());
    }

    @Test
    public void shoudlNotDeleteRoomByRoomName() throws Exception {
        String roomName = "NotRoomName";
        mockMvc.perform(delete("/api/patient/" + roomName))
                .andExpect(status().isNotFound());
    }

    @Test
    public void shoudlGetRoomByRoomName() throws Exception {
        Room room = new Room("room");
        mockMvc.perform(get("/api/patient/" + room.getRoomName()))
                .andExpect(status().isOk());
    }

    @Test
    public void shoudlNotGetRoomByRoomName() throws Exception {
        String roomName = "NotRoomName";
        mockMvc.perform(get("/api/patient/" + roomName))
                .andExpect(status().isNotFound());
    }

}
