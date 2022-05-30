package com.example.p2project.Logs;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor @Data
public class Logs {
    private String Message;
    private Integer Status;

    private String error;

    public Logs(String Message, Integer Status) {
        this.Message = Message;
        this.Status = Status;
    }
}
