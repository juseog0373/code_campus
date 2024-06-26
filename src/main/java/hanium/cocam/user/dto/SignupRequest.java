package hanium.cocam.user.dto;

import hanium.cocam.user.User;
import hanium.cocam.user.UserSex;
import hanium.cocam.user.UserType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
public class SignupRequest {
    private String userId;
    private String password;
    private String userName;
    private String userEmail;
    private UserSex userSex;
    private String userPhone;
    private UserType userType;

    public User toEntity() {
        return User.builder()
                .userId(userId)
                .password(password)
                .userName(userName)
                .userEmail(userEmail)
                .userSex(userSex)
                .userPhone(userPhone)
                .userType(userType)
                .build();
    }
}
