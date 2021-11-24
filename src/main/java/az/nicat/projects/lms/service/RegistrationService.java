package az.aykanhasanli.lms.service;


import az.aykanhasanli.lms.dto.request.RegistrationRequest;
import az.aykanhasanli.lms.dto.response.RegistrationDto;
import az.aykanhasanli.lms.enity.Registration;
import az.aykanhasanli.lms.enity.Student;
import az.aykanhasanli.lms.repository.ClassRoomRepository;
import az.aykanhasanli.lms.repository.RegistrationRepository;
import az.aykanhasanli.lms.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RegistrationService {
    private final RegistrationRepository registrationRepository;
    private final StudentRepository studentRepository;
    private final ClassRoomRepository classRoomRepository;

    @Transactional
    public RegistrationDto create(RegistrationRequest registrationRequest) {
        Registration registration=new Registration();
        registration.setFee(registrationRequest.getFee());
        var student=studentRepository.getById(registrationRequest.getStudentId());
        var classRoom=classRoomRepository.getById(registrationRequest.getClassRoomId());
        registration.setStudent(student);
        registration.setClassRoom(classRoom);

        registration = registrationRepository.save(registration);
        RegistrationDto registrationDto=new RegistrationDto();
        registrationDto.setId(registration.getId());
        return registrationDto;
    }
}
