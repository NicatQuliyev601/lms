package az.aykanhasanli.lms.dto.request;

import lombok.Data;

@Data
public class ScheduleRequest {
    private Long classRoomId;
    private String date;
}
