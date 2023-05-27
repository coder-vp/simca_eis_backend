package com.simca.eis.controller;

import com.simca.eis.dto.StaffDTO;
import com.simca.eis.model.Staff;
import com.simca.eis.service.StaffService;
import com.simca.eis.util.EISResponse;
import com.simca.eis.util.ResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
@CrossOrigin(value = "*")
public class StaffController {
    private static final Logger logger = LoggerFactory.getLogger(StaffController.class);

    @Autowired
    StaffService staffService;

    @GetMapping
    public ResponseEntity<EISResponse<List<Staff>>> getAll() {
        EISResponse<List<Staff>> response = new EISResponse<>();
        logger.info("Incoming request: Get all staff");
        List<Staff> staffs = staffService.get();
        response.setStatusCode(ResponseCode.SUCCESS);
        response.setResponse(staffs);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EISResponse<Staff>> get(@PathVariable int id) {
        EISResponse<Staff> response = new EISResponse<>();
        logger.info("Incoming request: Get staff");
        Staff staff = staffService.get(id);
        response.setStatusCode(ResponseCode.SUCCESS);
        response.setResponse(staff);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<EISResponse<Integer>> add(@RequestBody StaffDTO payload) {
        EISResponse<Integer> response = new EISResponse<>();
        logger.info("Incoming request: Add staff");
        int id = staffService.add(payload);
        response.setStatusCode(ResponseCode.SUCCESS);
        response.setResponse(id);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping
    public ResponseEntity<EISResponse<Boolean>> update(@RequestBody StaffDTO payload) {
        EISResponse<Boolean> response = new EISResponse<>();
        logger.info("Incoming request: Update staff");
        boolean status = staffService.update(payload);
        response.setStatusCode(ResponseCode.SUCCESS);
        response.setResponse(status);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EISResponse<Boolean>> delete(@PathVariable int id) {
        EISResponse<Boolean> response = new EISResponse<>();
        logger.info("Incoming request: Delete staff");
        boolean status = staffService.delete(id);
        response.setStatusCode(ResponseCode.SUCCESS);
        response.setResponse(status);
        return ResponseEntity.ok().body(response);
    }
}