package az.aykanhasanli.lms.controller;

import az.aykanhasanli.lms.dto.request.RegistrationRequest;
import az.aykanhasanli.lms.dto.request.StudentRequest;
import az.aykanhasanli.lms.dto.response.RegistrationDto;
import az.aykanhasanli.lms.enity.Registration;
import az.aykanhasanli.lms.enity.Student;
import az.aykanhasanli.lms.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/registration")
@RestController
@RequiredArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;
    @PostMapping
    public ResponseEntity<RegistrationDto> create(@RequestBody RegistrationRequest registrationRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(registrationService.create(registrationRequest));
    }
}
