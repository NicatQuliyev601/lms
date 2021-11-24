package az.aykanhasanli.lms.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RegistrationRequest {
    private Long classRoomId;
    private Long studentId;
    private BigDecimal fee;
}
