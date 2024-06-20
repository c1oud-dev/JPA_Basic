package hellojpa;

import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.util.Date;

@Entity //이걸 꼭 넣어줘야 한다. 그래야 jpa가 처음 로딩될 때 jpa를 사용하는 얘라고 인식
public class Member {
    @Id //어노테이션 작업을 할 때 꼭 persistence로 넣어주기
    private Long id; //id랑 name을 넣는 이유는 현재 db에 있기 때문
    @Column(name = "name")
    private String username;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Lob
    private String description;

    public Member() { //기본 생성자
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUsername(String a) {
    }

    public void setRoleType(RoleType user) {
    }
}
