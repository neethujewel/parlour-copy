package com.example.ParlourApp.employee;

import com.example.ParlourApp.parlour.ParlourRegModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "employee")
public class EmployeeRegModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parlour_id")
    private ParlourRegModel parlour;

    @Column(name = "employee_name", nullable = false)
    private String employeeName;

    @Column(name = "image", columnDefinition = "bytea")
    private byte[] image;

    @Column(name = "is_available")
    private Boolean isAvailable;

    @Column(name = "active")
    private Boolean active;

    @ElementCollection
    @CollectionTable(name = "employee_availability", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "available_time_slot")
    private List<String> availableTimeSlots;

    @Column(name = "status", nullable = false)
    private boolean status;

    // Constructor with all fields (excluding ID)
    public EmployeeRegModel(String employeeName, ParlourRegModel parlour, byte[] image, Boolean isAvailable,
                            Boolean active, List<String> availableTimeSlots, boolean status) {
        this.employeeName = employeeName;
        this.parlour = parlour;
        this.image = image;
        this.isAvailable = isAvailable;
        this.active = active;
        this.availableTimeSlots = availableTimeSlots;
        this.status = status;
    }

    // Constructor for required fields
    public EmployeeRegModel(String employeeName, ParlourRegModel parlour) {
        this.employeeName = employeeName;
        this.parlour = parlour;
    }

    // Constructor for initializing status only
    public EmployeeRegModel(boolean status) {
        this.status = status;
    }
}
