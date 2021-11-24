package az.aykanhasanli.lms.enity;

import lombok.Data;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "classes")
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_room_id")
    @Fetch(FetchMode.SELECT)
    private List<Registration> registrations=new ArrayList<>();


    @ManyToOne
    private Lesson lesson;

    @ManyToOne
    private Lecturer lecturer;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_room_id")
    @Fetch(FetchMode.SELECT)
    private List<Schedule> schedules=new ArrayList<>();


    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
