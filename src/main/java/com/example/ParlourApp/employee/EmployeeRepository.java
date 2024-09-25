package com.example.ParlourApp.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeRegModel, Long> {

  @Query("SELECT e.employeeName FROM EmployeeRegModel e JOIN e.parlour p WHERE p.parlourName = :parlourName")
  List<String> findEmployeeNamesByParlourName(@Param("parlourName") String parlourName);

  Long countByActive(boolean active);

  Optional<EmployeeRegModel> findByEmployeeName(String employeeName);

  List<EmployeeRegModel> findByParlour_Id(Long parlourId);

  List<EmployeeRegModel> findByParlour_IdAndIsAvailableTrue(Long parlourId);

  @Query("SELECT COUNT(e) FROM EmployeeRegModel e WHERE e.active = true")
  Long countActiveEmployees(); // Choose one count method for clarity

  List<EmployeeRegModel> findByParlourId_Id(Long parlourId);

  Long countActive();
}
