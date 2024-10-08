package hanium.cocam.domain.user.entity;

import hanium.cocam.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "TB_USERS")
@AllArgsConstructor
@Builder
public class User extends BaseEntity {
    @Id
    @GeneratedValue
    private Long userNo; // 유저 번호
    private String userEmail;
    private String password;
    private String userName;

    private String userSex;
    private String userPhone;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_no")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Profile profile;
}