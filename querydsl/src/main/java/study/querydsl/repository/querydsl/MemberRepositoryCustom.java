package study.querydsl.repository.querydsl;

import study.querydsl.dto.MemberSearchCondition;
import study.querydsl.dto.MemberTeamDto;

import java.util.List;

public interface MemberRepositoryCustom { //특정 api 에 종속적인 거면 이것보다는 searchRepository 를 만들어서 하는게 더 좋은 방법이 될 수도 있다.
    List<MemberTeamDto> search(MemberSearchCondition condition);
}
