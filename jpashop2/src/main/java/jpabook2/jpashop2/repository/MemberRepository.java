package jpabook2.jpashop2.repository;

import jpabook2.jpashop2.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    //select m from Member m where m.name = ? 자동으로
    List<Member> findByName(String name);
}
