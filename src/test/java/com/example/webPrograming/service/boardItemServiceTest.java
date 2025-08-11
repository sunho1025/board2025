package com.example.webPrograming.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class boardItemServiceTest {
    @Autowired
    private boardItemService boardItemService;

    @Test
    void add() {
        assertEquals(10, boardItemService.add(5, 5));
    }
}