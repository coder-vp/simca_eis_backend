package com.simca.eis.service;

import com.simca.eis.dto.StaffDTO;
import com.simca.eis.model.Staff;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StaffService {
    Staff login(StaffDTO staff);
    List<Staff> get();
    Staff get(int id);
    int add(StaffDTO staff);
    boolean update(StaffDTO staff);
    boolean delete(int id);
}
