package jpabook2.jpashop2.api;

import jpabook2.jpashop2.domain.Member;
import jpabook2.jpashop2.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController //  = @Controller + @ResponseBody
@RequiredArgsConstructor
public class MemberApiController {
    private final MemberService memberService;

    @PostMapping("/api/v1/members")
    public createMemberResponse saveMemberV1(@RequestBody @Valid Member member){ // @RequestBody json(다른것도)으로 온것을 member로 바꿔준다.
        Long id = memberService.join(member);
        return new createMemberResponse(id);
    }


    @PostMapping("/api/v2/members")
    public createMemberResponse saveMemberV2(@RequestBody @Valid CreateMemberRequest request){ // member Entity에서 name명을 바꿨을때 문제가 발생하지 않는다.
        Member member = new Member();
        member.setName(request.getName());
        Long id = memberService.join(member);
        return new createMemberResponse(id);
    }

    @PutMapping("/api/v2/members/{id}")
    public UpdateMemberResponse updateMemberV2(
            @PathVariable("id")Long id,
            @RequestBody @Valid UpdateMemberRequest request){
        memberService.update(id, request.getName());
        Member member = memberService.findOne(id);
        return new UpdateMemberResponse(member.getId(), member.getName());
    }

    @Data
    static class UpdateMemberRequest{
        private String name;
    }

    @Data
    @AllArgsConstructor
    static class UpdateMemberResponse{
        private Long id;
        private String name;
    }



    @Data
    static class CreateMemberRequest {
        private String name;
    }


    @Data
    static class createMemberResponse{
        private Long id;

        public createMemberResponse(Long id) {
            this.id = id;
        }
    }

}
