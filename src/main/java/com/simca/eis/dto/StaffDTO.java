package com.simca.eis.dto;

import lombok.Data;

@Data
public class StaffDTO {
    private int id;
    private String name;
    private String email;
    private String password;
    private String mobile;
    private String designation;
    private String role;
    private int createTime;
    private boolean isActive;
}
