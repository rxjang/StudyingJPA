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
            member.setUsername("team1");
            member.setAge(10);
            member.setTeam(team);
            member.setType(MemberType.USER);
            em.persist(member);

            em.flush();
            em.clear();

            String query = "SELECT m.username, 'HELLO', TRUE FROM Member m " +
                            "where m.type = jpql.MemberType.USER";
            List<Object[]> result = em.createQuery(query)
                    .getResultList();

            for(Object[] objects : result) {
                System.out.println("objects = " + objects[0]);
                System.out.println("objects = " + objects[1]);
                System.out.println("objects = " + objects[2]);
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
