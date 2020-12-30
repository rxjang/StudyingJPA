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
//
//            Member member =new Member(200L,"member200");
//            em.persist(member);
//            em.flush();

            //영속
            Member member =em.find(Member.class,150L);
            member.setName("AAAA");

//            em.detach((member));
//            //조회만 하고 업데이트는 실행하지 않음

            em.clear();
            //영속성 컨텍스트 초기화

            Member member2 = em.find(Member.class,150L);

            System.out.println("=============================");
            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
