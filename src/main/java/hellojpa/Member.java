package hellojpa;

import jakarta.persistence.*;


@Entity //이걸 꼭 넣어줘야 한다. 그래야 jpa가 처음 로딩될 때 jpa를 사용하는 얘라고 인식
public class Member {
    @Id //기본 키 매핑
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "name", nullable = false)
    private String username;

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

    public void setUsername(String username) {
        this.username = username;
    }
}
