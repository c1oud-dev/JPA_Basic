package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;


import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin(); //트랜잭션 시작
        try {
           /* //Member findmember = em.find(Member.class, 1L);
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5) //5번부터
                    .setMaxResults(8) //8개 가져오라는 뜻 (페이지 네이션?)
                    .getResultList();

            for (Member member : result) {
                System.out.println("member.name = " + member.getName());
            }*/
            /*//비영속 상태(Member 엔티티가 비영속 상태라는 것 즉, JPA와 관련이 없다. 그래서 DB에도 들어가지 않음)
            Member member = new Member();
            member.setId(101L);
            member.setName("HelloJPA");

            //영속상태(엔티티매니저의 영속성 컨텍스트를 통해 member가 관리된다.)
            //하지만 이렇게 해도 DB에 저장되진 않는다.
            em.persist(member);

            Member findMember1 = em.find(Member.class, 101L);
            //1. 위에서 find를 사용해 조회를 했지만 DB에 selectquery가 안 나간 상태
            Member findMember2 = em.find(Member.class, 101L);
            //member2는 캐시에 없어서 DB에서 조회를 한 후 캐시에 저장하고 반환한다.*/

            /* DB에 나가는지 확인해보기
            //Member.java 클래스에 Member 생성자 생성필요
            Member member1 = new Member(150L, "A");
            Member member2 = new Member(160L, "B");

            em.persist(member1);//여기까지만 하면 DB에 등록되는 게 아니라
            em.persist(member2); //영속성 컨텍스트에 차곡차곡 쌓이게 되는 것
            //commit을 하는 순간 DB에 저장 된다.
            //실행을 해보면 쿼리가 2개가 나가는 걸 확인할 수 있다.*/

            /*//150Line의 A라는 이름을 다른 이름으로 변경해보기
            Member member = em.find(Member.class, 150L);
            member.setName("ZZZZZ");
            //여기서 주의할 점은 em.persist(member)를 적을 필요가 없다.
            //왜냐하면 변경 감지 기능이 있기 때문이다. */

            /*//플러시 기능 확인해보기
            Member member = new Member(200L,"member200");
            em.persist(member);
            em.flush(); //이렇게 하면 DB에 즉시 반영 된다.
            //실행 시점을 확인하고 싶으면 "======"을 commit 전에 출력해보자.*/

            //준영속 상태 확인해보기
            //Member member = em.find(Member.class, 150L);

            Member member = new Member();
            member.setUsername("C");

            em.persist(member);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); //엔티티 매니저 종료
        }
        emf.close(); //엔티티 매니저 팩토리 종료
    }
}
