package com.noh.yaho.member.command.domain.model;

import lombok.*;
import javax.persistence.*;
import java.util.*;

/**
 * <pre>
 * Class : Sample
 * Comment : 어떤 클래스인지 간단한 설명
 * History
 * 2022-10-26 노재원 처음 작성
 * </pre>
 *
 * @author 노재원(최초 작성자 명)
 * @version 1.0(클래스의 버전)
 * @see 참고할 class나 외부 url
 */
@Entity
@Table(name="TBL_MEMBER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@SequenceGenerator(
        name="MEMBER_SEQUENCE",
        sequenceName = "SEQ_MEMBER_SEQUENCE",
        initialValue = 1,
        allocationSize = 1
)
public class Member{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQUENCE")
    @Column(name="MEMBER_NO")
    private int memberNo;
    @Column(name="MEMBER_ID", unique = true)
    private String memberId;
    @Column(name="MEMBER_PW")
    private String memberPw;

    @Column(name="NAME")
    private String name;

    @Column(name="PHONE")
    private String phone;

    @Column(name="EMAIL")
    private String email;

    @Embedded
    private AddressVO address;

    @OneToMany
    @JoinColumn(name="MEMBER_NO")
    private List<MemberRole> memberAuthorities;

    public Member(String memberId, String memberPw, String name, String phone, String email, AddressVO address) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }
}