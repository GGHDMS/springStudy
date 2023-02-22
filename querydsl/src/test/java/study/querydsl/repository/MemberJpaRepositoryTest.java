package study.querydsl.repository;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.querydsl.entity.Member;

import javax.persistence.EntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class MemberJpaRepositoryTest {

    @Autowired EntityManager em;
    @Autowired MemberJpaRepository memberJpaRepository;

    @Test
    public void basicTest() throws Exception{
        Member member = new Member("member1", 10);
        memberJpaRepository.save(member);

        Member findMember = memberJpaRepository.findById(member.getId()).get();
        assertThat(findMember).isEqualTo(member);

        List<Member> result = memberJpaRepository.findAll();
        assertThat(result).containsExactly(member);

        List<Member> result_querydsl = memberJpaRepository.findAll_Querydsl();
        assertThat(result_querydsl).containsExactly(member);

        List<Member> result2 = memberJpaRepository.findByUsernames(member.getUsername());
        assertThat(result2).containsExactly(member);

        List<Member> result2_querydsl = memberJpaRepository.findByUsernames_Querydsl(member.getUsername());
        assertThat(result2_querydsl).containsExactly(member);
    }


}