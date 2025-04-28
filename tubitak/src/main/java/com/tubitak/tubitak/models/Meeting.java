package com.tubitak.tubitak.models;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "meetings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String meetingCode;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String status;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    @OneToMany(mappedBy = "meeting", cascade = CascadeType.ALL)
    private List<MeetingParticipant> participants;

    @OneToMany(mappedBy = "meeting", cascade = CascadeType.ALL)
    private List<EmotionAnalysis> emotionAnalyses;

    @OneToMany(mappedBy = "meeting", cascade = CascadeType.ALL)
    private List<FocusTracking> focusTrackings;

    @OneToOne(mappedBy = "meeting", cascade = CascadeType.ALL)
    private Recording recording;
}
