package com.project.bookstore.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse2 {
    private Boolean result;
    private String msg;
    private Object userInfo;
    private Object card;
    private Object addr;
}