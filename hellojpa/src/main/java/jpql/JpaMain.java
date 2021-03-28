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

//            String query = "SELECT concat('a', 'b') FROM Member m";
//            String query = "SELECT locate('de','abcdefg') FROM Member m";   //위치를 알려줌
            String query = "SELECT function('group_concat', m.username) FROM Member m";

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
