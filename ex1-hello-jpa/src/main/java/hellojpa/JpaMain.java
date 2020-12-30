package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args){
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("hello");
        //DB와 연결
        EntityManager em=emf.createEntityManager();

        EntityTransaction tx=em.getTransaction();
        tx.begin();

        //code
        try{

            //영속
//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);
//
//            System.out.println("result = " + (findMember1 ==findMember2));

//            Member member1 =new Member(150L,"A");
//            Member member2 =new Member(160L,"B");
//
//            em.persist(member1);
//            em.persist(member2);
//            System.out.println("=============================");

            Member member = em.find(Member.class,150L);
            member.setName("ZZZZZZZ");
            

            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
