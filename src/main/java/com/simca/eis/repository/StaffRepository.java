package com.simca.eis.repository;

import com.simca.eis.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
    Staff findByEmail(String email);
}
