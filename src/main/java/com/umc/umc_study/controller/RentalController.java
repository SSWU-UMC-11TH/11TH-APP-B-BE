package com.umc.umc_study.controller;

import com.umc.umc_study.service.RentalService;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.Map;

@RestController
@RequestMapping("/rentals")
@RequiredArgsConstructor
public class RentalController {

    private final RentalService rentalService;

    // post mapping
    @PostMapping
    public String createRental(@RequestBody Map<String, Object> body) {
        rentalService.createRental(body);
        return "대여 기록이 성공적으로 생성되었습니다.";
    }
}