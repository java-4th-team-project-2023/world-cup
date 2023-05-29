# Full Stack Project : World Cup

<div align="center">

[![Hits](https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https%3A%2F%2Fgithub.com%2Fjava-4th-team-project-2023%2Fworld-cup&count_bg=%232DC3C4&title_bg=%2361AE37&icon=&icon_color=%23E7E7E7&title=hits&edge_flat=false)](https://github.com/java-4th-team-project-2023/world-cup)

</div>

## PickPick : Find My Favorite v1.0

> 중앙정보처리학원 데이터융합 자바(JAVA) 응용 SW개발자 취업과정 1조
> 풀 스택 개발 학습
> 개발기간 : 2023.05.08 ~ 2023.05.25

## About Team

- 원석빈
  - PM
  - 
- 이채원
  - .
- 이진호
  - Back : 게임 및 선수 DB 설계, 게임 로직 구현
  - Front : 게임 리스트 페이지, 게임 플레이 페이지, 게임 수정 페이지 구현
- 조경훈
  - .

## About Project



사용자가 월드컵 게임을 직접 만들고 사용할 수 있도록 합니다. 온라인의 타 웹페이지들 보다 사용자 편의를 위해 계속 업데이트 중입니다.


## 사용기술 

<div>

<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> 
<img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"> 
<img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white"> 
<img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"> 
<img src="https://img.shields.io/badge/mariaDB-003545?style=for-the-badge&logo=mariaDB&logoColor=white"> 
<img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white"> 
<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">

</div>

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

### 향후 수정사항
- 게임 만들거나 수정할 때 빈칸으로 넘기면 빈 파일이 등록되지 않도록 수정
- 마찬가지로 게임 제목이나 선수 이름을 빈 칸으로 넘기면 등록되지 않도록 수정