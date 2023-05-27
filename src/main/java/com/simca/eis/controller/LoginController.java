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

@RestController
@RequestMapping("/login")
@CrossOrigin(value = "*")
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    StaffService staffService;

    @PostMapping("/staff")
    public ResponseEntity<EISResponse<Staff>> add(@RequestBody StaffDTO payload) {
        EISResponse<Staff> response = new EISResponse<>();
        logger.info("Incoming request: Staff login");
        Staff staff = staffService.login(payload);
        if(staff == null){
            response.setStatusCode(ResponseCode.UNAUTHORIZED);
            response.setStatusMessage(ResponseCode.INCORRECT_CREDENTIALS);
            return ResponseEntity.ok().body(response);
        }
        response.setStatusCode(ResponseCode.SUCCESS);
        response.setResponse(staff);
        return ResponseEntity.ok().body(response);
    }
}
