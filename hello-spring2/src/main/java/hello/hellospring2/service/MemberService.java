package hello.hellospring2.service;


import hello.hellospring2.domain.Member;
import hello.hellospring2.repository.MemberRepository;
import hello.hellospring2.repository.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.SavepointManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    /**
     * 회원가입
     */
    public Long join(Member member){
//        long start = System.currentTimeMillis();
//
//        try {
//            // 같은 이름 중복 회원 x
//            validateDuplicateMember(member); // 중복 회원 검증
//            memberRepository.save(member);
//            return member.getId();
//        } finally {
//            long finish = System.currentTimeMillis();
//            long timeMs = finish - start;
//            System.out.println("timeMs = " + timeMs + "ms");
//        }

        // 같은 이름 중복 회원 x
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다");
            });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
//        long start = System.currentTimeMillis();
//
//        try {
//            return memberRepository.findAll();
//        } finally {
//            long finish = System.currentTimeMillis();
//            long timeMs = finish - start;
//            System.out.println("timeMs = " + timeMs + "ms");
//        }

        return memberRepository.findAll();
    }



    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
