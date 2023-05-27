package com.simca.eis.service;

import com.simca.eis.dto.StaffDTO;
import com.simca.eis.model.Staff;
import com.simca.eis.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service("StaffServiceImpl")
public class StaffServiceImpl implements StaffService {

    @Autowired
    StaffRepository staffRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Staff login(StaffDTO payload) {
        Staff staff = staffRepository.findByEmail(payload.getEmail());
        if(null == staff || !passwordEncoder.matches(payload.getPassword(), staff.getPassword())){
            return null;
        }
        staff.setPassword(null);
        return staff;
    }

    @Override
    public List<Staff> get() {
        List<Staff> staffs = staffRepository.findAll();
        if(staffs == null || staffs.isEmpty()) {
            return new LinkedList<>();
        }
        return staffs;
    }

    @Override
    public Staff get(int id) {
        Staff staff = staffRepository.findById(id).orElse(null);
        if(null != staff){
            staff.setPassword(null);
        }
        return staff;
    }

    @Override
    public int add(StaffDTO staff) {
        Staff newStaff = new Staff();
        newStaff.setName(staff.getName());
        newStaff.setEmail(staff.getEmail());
        newStaff.setPassword(passwordEncoder.encode(staff.getPassword()));
        newStaff.setMobile(staff.getMobile());
        newStaff.setDesignation(staff.getDesignation());
        newStaff.setRole(staff.getRole());
        newStaff.setCreateTime(System.currentTimeMillis() / 1000);
        newStaff.setActive(true);
        staffRepository.save(newStaff);
        return newStaff.getId();
    }

    @Override
    public boolean update(StaffDTO staff) {
        Staff existingStaff = staffRepository.findById(staff.getId()).orElse(null);
        if(existingStaff == null){
            System.out.println("Staff id "+staff.getId()+" not found");
            return false;
        }
        existingStaff.setName(staff.getName());
        existingStaff.setMobile(staff.getMobile());
        existingStaff.setDesignation(staff.getDesignation());
        existingStaff.setActive(staff.isActive());
        staffRepository.save(existingStaff);
        return true;
    }

    @Override
    public boolean delete(int id) {
        Staff staff = staffRepository.findById(id).orElse(null);
        if(null == staff){
            return false;
        }
        staffRepository.delete(staff);
        return true;
    }
}