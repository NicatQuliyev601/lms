package az.aykanhasanli.lms.service;


import az.aykanhasanli.lms.dto.request.ScheduleRequest;
import az.aykanhasanli.lms.dto.response.ScheduleDto;
import az.aykanhasanli.lms.enity.ClassRoom;
import az.aykanhasanli.lms.enity.Schedule;
import az.aykanhasanli.lms.repository.ClassRoomRepository;
import az.aykanhasanli.lms.repository.ScheduleRepository;
import az.aykanhasanli.lms.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
@Slf4j
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final ClassRoomRepository classRoomRepository;

    public ScheduleDto create(ScheduleRequest scheduleRequest) {
        ClassRoom classRoom = classRoomRepository.getById(scheduleRequest.getClassRoomId());
        Schedule schedule = new Schedule();
        schedule.setClassRoom(classRoom);
       // String str = "2016-03-04 11:30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(scheduleRequest.getDate(), formatter);

        schedule.setDateTime(dateTime);
        scheduleRepository.save(schedule);
        ScheduleDto scheduleDto = new ScheduleDto();
        scheduleDto.setId(schedule.getId());
        return scheduleDto;

    }
}
