package com.azericard.simplecaching.controller;

import com.azericard.simplecaching.service.CachingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CachingController {

    private CachingService cachingService;

    public CachingController(CachingService cachingService) {
        this.cachingService = cachingService;
    }

    @GetMapping("/clearAllCaches")
    public void clearAllCaches() {
        cachingService.evictAllCaches();
    }
}