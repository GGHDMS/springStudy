package hellojpa;

import org.hibernate.Hibernate;
import org.hibernate.MappingException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.security.Principal;
import java.util.List;


public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Member member = new Member();
            member.setUsername("member1");
            member.setHomeAddress(new Address("city1", "street", "10000"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

            member.getAddressesHistory().add(new Address("old1", "street", "10000"));
            member.getAddressesHistory().add(new Address("old12", "street", "10000"));

            em.persist(member);

            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, member.getId());
            Address address = findMember.getHomeAddress();
            findMember.setHomeAddress(new Address("newCity", address.getStreet(), address.getZipcode()));

            //치킨 -> 한신
            findMember.getFavoriteFoods().remove("치킨");
            findMember.getFavoriteFoods().add("한신");

            findMember.getAddressesHistory().remove(new Address("old1", "street", "10000"));
            findMember.getAddressesHistory().add(new Address("newCity1", "street", "10000"));

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
