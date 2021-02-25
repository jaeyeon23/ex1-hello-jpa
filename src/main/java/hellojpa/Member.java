package hellojpa;

import javafx.util.converter.LocalDateTimeStringConverter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Member")
public class Member {

    // PK
    @Id
    private Long id;

    // DB 컬럼 이름 : name
    @Column(name = "name", insertable = true, updatable = true, nullable = false)
    private String username;

    private int age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    // 현재는 사용하지 않는다.
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    private LocalDateTime modifiedDate;

    // varchar를 넘어서는 큰 컨텐츠
    @Lob
    private String description;
}
