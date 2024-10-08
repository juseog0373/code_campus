package hanium.cocam.domain.tutor.dto;

import hanium.cocam.domain.user.entity.UserSex;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TutorSearchCond {
    private String userSex;
    private String classType;
    private String[] level;
    private String keyword;
    private String orderCondition;
}
