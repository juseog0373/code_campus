package hanium.cocam.mentorship.dto;

import hanium.cocam.mentorship.Mentorship;
import hanium.cocam.user.entity.Category;
import hanium.cocam.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MentorshipRequest {
    private Long tutorNo;
    private Long tuteeNo;
    private String mentorshipDay; // 수업 요일
    private String mentorshipTime; // 수업 시간
    private Category category;

    public Mentorship toEntity(User tutor, User tutee) {
        return Mentorship.builder()
                .tutor(tutor)
                .tutee(tutee)
                .mentorshipDay(mentorshipDay)
                .mentorshipTime(mentorshipTime)
                .category(category)
                .build();
    }
}
