package com.pickpick.repository;

import com.pickpick.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountMapper {

    // 회원가입
    boolean signUp(Account account);

    // 회원 정보 조회
    Account findAccount(String accountId);

    // 중복 체크(account, email) 기능
    int isDuplicate(
            @Param("type") String type
            ,@Param("keyword") String keyword);

}
