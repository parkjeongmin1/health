package com.health.entity;

import com.health.constant.DayOfWeek;
import jakarta.persistence.*;
import lombok.Getter;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "pt")
@Getter
public class Pt {
    @Id
    @Column(name = "pt_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //primary키 생성
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "day_of_week")
    private DayOfWeek dayOfWeek;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @Column(name = "created_at")
    private LocalDate createdAt;
}
