package jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em=emf.createEntityManager();
        EntityTransaction tx=em.getTransaction();
        tx.begin();

        //code
        try{

            Team team = new Team();
            team.setName("team1");
            em.persist(team);

            Member member = new Member();
            member.setUsername("관리자");
            member.setAge(10);
            member.setTeam(team);
            member.setType(MemberType.USER);
            em.persist(member);

            em.flush();
            em.clear();

//            String query = "SELECT " +
//                                    "CASE WHEN m.age <= 10 then '학생요금' " +
//                                    "     WHEN m.age >= 10 then '경로 요금' " +
//                                    "else '일반요금' " +
//                                    "end " +
//                            "FROM Member m";

//            String query = "SELECT COALESCE( m.username, '이름 없는 회원') FROM Member m";
            String query = "SELECT nullif( m.username, '관리자') FROM Member m";

            List<String> result = em.createQuery(query, String.class).getResultList();

            for(String s :result) {
                System.out.println("s = " + s);
            }

            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
