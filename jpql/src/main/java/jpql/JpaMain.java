package jpql;

import org.hibernate.sql.Select;

import javax.persistence.*;
import javax.xml.transform.Result;
import java.util.List;



public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

                Team team = new Team();
                team.setName("teamA");
                em.persist(team);

                Member member = new Member();
                member.setUsername("관리자");
                member.setAge(10);
                member.changeTeam(team);
                member.setType(MemberType.ADMIN);
                em.persist(member);

            em.flush();
            em.clear();
//            String query =
//                    "select " +
//                            "case when m.age <=10 then '학생요금' " +
//                            "     when m.age >=60 then '경로요금' " +
//                            "     else '일반요금' " +
//                            "end " +
//                    "from Member m";
//            String query = "select coalesce(m.username, '이름 없는 회원') from Member m"; // m.username 없으면 이름 없는 회원 반환
            String query = "select nullif(m.username, '관리자') from Member m"; //같으면 null 반환

            List<String> result = em.createQuery(query, String.class)
                    .getResultList();

            for (String s : result) {
                System.out.println("s = " + s);
            }
            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
