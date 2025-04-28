package com.tubitak.tubitak.models;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "emotion_analyses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmotionAnalysis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String emotion;

    private LocalDateTime timestamp;
}
