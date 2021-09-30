package org.zerock.club.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class ClubMember extends BaseEntity {
    @Id
    private String email;

    private String password;
    private String name;
    private boolean fromSocial;

    //One to Many
    @ElementCollection(fetch = FetchType.LAZY) //컬렉션 객체임을 JPA에게 알려주는 어노테이션
    @Builder.Default
    private Set<ClubMemberRole> roleSet = new HashSet<>();
    public void addMemberRole(ClubMemberRole clubMemberRole) {
        roleSet.add(clubMemberRole);
    }
}
