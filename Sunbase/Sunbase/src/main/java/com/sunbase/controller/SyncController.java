package com.sunbase.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbase.service.SyncService;

@RestController
@RequestMapping("/api/sync")
public class SyncController {
 @Autowired
 private SyncService syncService;

 @GetMapping
 public void syncCustomers() {
     syncService.syncCustomers();
 }
}

