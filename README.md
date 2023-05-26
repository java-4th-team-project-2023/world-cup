# World Cup Project


사용자가 월드컵 게임을 직접 만들고 사용할 수 있도록 합니다. 온라인의 타 웹페이지들 보다 사용자 편의를 위해 계속 업데이트 중입니다.


## 사용기술 


<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"> <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white"> <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"> <img src="https://img.shields.io/badge/mariaDB-003545?style=for-the-badge&logo=mariaDB&logoColor=white"> <img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white"> <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">



## 개발 기간

* v1: 2023년 5월 8일 ~ 2023년 5월 25일 

### Member

| 개발자 | 담당          |
|-----|-------------|
| 원석빈 | 전체 페이지 css 구현  |
| 이채원 | 메인페이지, 게임로직구상, 게임전체구현, 파일CRUD, 검색기능, 형상관리    | 
| 이진호 | 댓글(CRUD) 및 좋아요, 신고하기 구현, ranking구현, 로그인/회원가입 BACK, Paging구현 |
| 조경훈 | 파일 업로드 FRONT, 파일업로드BACK 일부, 로그인/회원가입 JS구현     |



## 업데이트 내역

| 날짜  | 내용                 | 기타 |
|-----|:-------------------|:---|
| 5/8 | 주제 회의 및 ERD 작성     |    |
| 5/9 | ERD 수정 및 Entity 생성 |   |
| 5/26 | world-cup.v1 시작  |   |

## 데이터베이스 플레이중인 게임 지우기

```
delete from playing_game_tbl
where account_id is null
;
```


### DataBase Diagram
<img src="./diagram/new ERD.png">
