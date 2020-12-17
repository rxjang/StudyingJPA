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
//            Member findMember=em.find(Member.class,1L);
//            //삭제
//            //em.remove(findeMember)
//            //수정
//            findMember.setName("HelloJPA");
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());

            List<Member> result=em.createQuery("select m from Member as m",Member.class)
                    .setFirstResult(2)
                    .setMaxResults(5)
                    .getResultList();
            //페이징 예시
            
            for(Member member:result){
                System.out.println("member.name = " + member.getName());
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
