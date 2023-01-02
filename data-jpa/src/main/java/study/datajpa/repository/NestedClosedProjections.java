package study.datajpa.repository;

public interface NestedClosedProjections {
    String getUsername(); // 최적화 됨 root 엔티티만 최적화
    TeamInfo getTeam(); // 최적화 안됨

    interface TeamInfo {
        String getName();
    }
}
