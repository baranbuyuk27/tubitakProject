package com.tubitak.tubitak.models;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "focus_trackings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FocusTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Boolean isFollowing;

    private LocalDateTime timestamp;
}
