package az.aykanhasanli.lms.controller;

import az.aykanhasanli.lms.dto.request.RegistrationRequest;
import az.aykanhasanli.lms.dto.request.ScheduleRequest;
import az.aykanhasanli.lms.dto.response.RegistrationDto;
import az.aykanhasanli.lms.dto.response.ScheduleDto;
import az.aykanhasanli.lms.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/schedule")
@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;
    @PostMapping
    public ResponseEntity<ScheduleDto> create(@RequestBody ScheduleRequest scheduleRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.create(scheduleRequest));
    }
}
