package hellojpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //이걸 꼭 넣어줘야 한다. 그래야 jpa가 처음 로딩될 때 jpa를 사용하는 얘라고 인식
public class Member {
    @Id //어노테이션 작업을 할 때 꼭 persistence로 넣어주기
    private Long id; //id랑 name을 넣는 이유는 현재 db에 있기 때문
    private String name;

    public Member() { //기본 생성자
    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
