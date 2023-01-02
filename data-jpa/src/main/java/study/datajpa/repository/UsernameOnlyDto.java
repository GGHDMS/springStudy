package study.datajpa.repository;

public class UsernameOnlyDto {

    private final String username;


    public UsernameOnlyDto(String username) { //parameter 명으로 분석
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
