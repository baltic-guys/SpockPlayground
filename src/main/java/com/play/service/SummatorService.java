package com.play.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SummatorService {

    private ArgumentSafeParserService argumentSafeParserService;

    @Autowired
    public SummatorService(ArgumentSafeParserService argumentSafeParserService) {
        this.argumentSafeParserService = argumentSafeParserService;
    }

    public int sum(String a, String b) {
        int aNum = argumentSafeParserService.safeParse(a);
        int bNum = argumentSafeParserService.safeParse(b);
        return aNum + bNum;
    }
}
