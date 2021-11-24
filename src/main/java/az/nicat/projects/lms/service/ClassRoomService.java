package az.aykanhasanli.lms.service;


import az.aykanhasanli.lms.dto.request.ClassRoomRequest;
import az.aykanhasanli.lms.dto.request.LecturerRequest;
import az.aykanhasanli.lms.dto.response.ClassRoomDto;
import az.aykanhasanli.lms.dto.response.StudentDto;
import az.aykanhasanli.lms.enity.ClassRoom;
import az.aykanhasanli.lms.enity.Lecturer;
import az.aykanhasanli.lms.enity.Lesson;
import az.aykanhasanli.lms.enity.Registration;
import az.aykanhasanli.lms.exception.LecturerNotFoundException;
import az.aykanhasanli.lms.exception.LessonNotFoundException;
import az.aykanhasanli.lms.mapper.LecturerMapper;
import az.aykanhasanli.lms.repository.ClassRoomRepository;
import az.aykanhasanli.lms.repository.LecturerRepository;
import az.aykanhasanli.lms.repository.LessonRepository;
import az.aykanhasanli.lms.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClassRoomService {
    private final ClassRoomRepository classRoomRepository;
    private final LecturerRepository  lecturerRepository;
    private final LessonRepository lessonRepository;


    @Transactional
    public ClassRoom create(ClassRoomRequest classRoomRequest) {
        log.info("start...  classRoomRequest  {}", classRoomRequest);
        Lesson lesson=lessonRepository.findById(classRoomRequest.getLessonId())
                .orElseThrow(()->new LessonNotFoundException(classRoomRequest.getLessonId()));
        Lecturer lecturer=lecturerRepository.findById(classRoomRequest.getLecturerId())
                .orElseThrow(() -> new LecturerNotFoundException(classRoomRequest.getLecturerId()));
        ClassRoom classRoom = new ClassRoom();
        classRoom.setLecturer(lecturer);
        classRoom.setLesson(lesson);

        classRoom = classRoomRepository.save(classRoom);
        log.info("end... classRoom  {}", classRoom);
        return classRoom;
    }

    public ClassRoomDto getById(Long id) {

        ClassRoom classRoom = classRoomRepository.findById(id)
                .orElseThrow(() -> new LessonNotFoundException(id));
        ClassRoomDto classRoomDto = new ClassRoomDto();
        classRoomDto.setId(classRoom.getId());
        classRoomDto.setLecturerName(classRoom.getLecturer().getName());
        classRoomDto.setLessonName(classRoom.getLesson().getLessonName());
        List<StudentDto> studentDtos = new ArrayList<>();
        for (Registration r:classRoom.getRegistrations()){
            StudentDto s=new StudentDto();
            s.setName(r.getStudent().getName());
            s.setSurName(r.getStudent().getSurname());
            s.setId(r.getStudent().getId());
            studentDtos.add(s);
        }

        classRoomDto.setStudent(studentDtos);
        return classRoomDto;

    }


}
