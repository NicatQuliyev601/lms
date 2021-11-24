package az.aykanhasanli.lms.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class ClassRoomDto {
    private Long id;
    private String lessonName;
    private String lecturerName;
    private List<StudentDto> student;

}
