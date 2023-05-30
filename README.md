# Full Stack Project : World Cup

<div align="center">

[![Hits](https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https%3A%2F%2Fgithub.com%2Fjava-4th-team-project-2023%2Fworld-cup&count_bg=%232DC3C4&title_bg=%2361AE37&icon=&icon_color=%23E7E7E7&title=hits&edge_flat=false)](https://github.com/java-4th-team-project-2023/world-cup)

</div>

## PickPick : Find My Favorite v1.0

> 중앙정보처리학원 데이터융합 자바(JAVA) 응용 SW개발자 취업과정 1조<br>
> 풀 스택 개발 학습 <br>
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


## Stacks 

### Environment

<div>

<img src="https://img.shields.io/badge/visual studio code-007ACC?style=for-the-badge&logo=visualstudiocode&logoColor=white"> 
<img src="https://img.shields.io/badge/intellij-000000?style=for-the-badge&logo=intellijidea&logoColor=white"> 
<img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white"> 
<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"> 

</div>

### Config

<div>

<img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white">

</div>

### Development

<div>

<img src="https://img.shields.io/badge/java-FFFFFF?style=for-the-badge&logo=openjdk&logoColor=black"> 
<img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"> 
<img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white"> 
<img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"> 
<img src="https://img.shields.io/badge/mariaDB-003545?style=for-the-badge&logo=mariaDB&logoColor=white"> 
<img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">

</div>

## Pages

### Main Page 
- Game List
![메인 페이지.PNG](readmeSources%2F%EB%A9%94%EC%9D%B8%20%ED%8E%98%EC%9D%B4%EC%A7%80.PNG)
- Side Menu
![사이드 메뉴.PNG](readmeSources%2F%EC%82%AC%EC%9D%B4%EB%93%9C%20%EB%A9%94%EB%89%B4.PNG)
### Sign-in & Sign-up Page

- sign-in
![로그인 페이지.PNG](readmeSources%2F%EB%A1%9C%EA%B7%B8%EC%9D%B8%20%ED%8E%98%EC%9D%B4%EC%A7%80.PNG)
- sign-up
![회원가입 페이지.PNG](readmeSources%2F%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85%20%ED%8E%98%EC%9D%B4%EC%A7%80.PNG)

### Game Page

- Game Start
![게임 시작.PNG](readmeSources%2F%EA%B2%8C%EC%9E%84%20%EC%8B%9C%EC%9E%91.PNG)
- Playing Game
![게임 진행.PNG](readmeSources%2F%EA%B2%8C%EC%9E%84%20%EC%A7%84%ED%96%89.PNG)
- Winner Page
![우승 페이지.PNG](readmeSources%2F%EC%9A%B0%EC%8A%B9%20%ED%8E%98%EC%9D%B4%EC%A7%80.PNG)
- Ranking Page
![랭킹 페이지.PNG](readmeSources%2F%EB%9E%AD%ED%82%B9%20%ED%8E%98%EC%9D%B4%EC%A7%80.PNG)
- Game Make & Modify Page
![수정 및 만들기 페이지.PNG](readmeSources%2F%EC%88%98%EC%A0%95%20%EB%B0%8F%20%EB%A7%8C%EB%93%A4%EA%B8%B0%20%ED%8E%98%EC%9D%B4%EC%A7%80.PNG)

## Main Function
- 원하는 월드컵을 만들 수 있습니다!
- 최소 4강부터 게임을 시작할 수 있습니다!
- 잘못 골랐을 경우를 대비하여 리셋할 수 있습니다!
- 첫 경기 이전으로는 돌아갈 수 없습니다!
- 우승 페이지와 랭킹 페이지에서 댓글을 작성할 수 있습니다!
- 좋은 댓글은 좋아요 버튼을 누를 수 있고, 부적절한 댓글은 신고해주세요!
- 자신이 만든 월드컵만 따로 볼 수 있습니다!

## Architecture

### erd

![erd.png](diagram%2Ferd.png)

### directory

```
.
├─.gradle
│  ├─7.6.1
│  │  ├─checksums
│  │  ├─dependencies-accessors
│  │  ├─executionHistory
│  │  ├─fileChanges
│  │  ├─fileHashes
│  │  └─vcsMetadata
│  ├─buildOutputCleanup
│  └─vcs-1
├─.idea
│  ├─dataSources
│  │  └─da6b8ef9-db03-4b11-a179-ee29ac2ca71d
│  │      └─storage_v2
│  │          └─_src_
│  │              └─schema
│  ├─httpRequests
│  └─modules
├─build
│  ├─classes
│  │  └─java
│  │      ├─main
│  │      │  └─com
│  │      │      └─pickpick
│  │      │          ├─api
│  │      │          ├─config
│  │      │          ├─controller
│  │      │          ├─dto
│  │      │          │  ├─account
│  │      │          │  │  ├─request
│  │      │          │  │  └─response
│  │      │          │  ├─game
│  │      │          │  ├─page
│  │      │          │  ├─player
│  │      │          │  ├─playingGame
│  │      │          │  ├─reply
│  │      │          │  │  ├─request
│  │      │          │  │  └─response
│  │      │          │  └─search
│  │      │          ├─entity
│  │      │          ├─interceptor
│  │      │          ├─repository
│  │      │          ├─service
│  │      │          └─util
│  │      │              └─upload
│  │      └─test
│  │          └─com
│  │              ├─example
│  │              │  └─worldcup
│  │              └─pickpick
│  │                  └─repository
│  ├─generated
│  │  └─sources
│  │      ├─annotationProcessor
│  │      │  └─java
│  │      │      ├─main
│  │      │      └─test
│  │      └─headers
│  │          └─java
│  │              ├─main
│  │              └─test
│  ├─reports
│  │  └─tests
│  │      └─test
│  │          ├─classes
│  │          ├─css
│  │          ├─js
│  │          └─packages
│  ├─resources
│  │  └─main
│  │      ├─mappers
│  │      ├─static
│  │      │  └─assets
│  │      │      ├─css
│  │      │      ├─img
│  │      │      └─js
│  │      └─templates
│  ├─test-results
│  │  └─test
│  │      └─binary
│  └─tmp
│      ├─compileJava
│      │  └─compileTransaction
│      │      ├─annotation-output
│      │      ├─compile-output
│      │      │  └─com
│      │      │      └─pickpick
│      │      │          ├─api
│      │      │          ├─config
│      │      │          ├─controller
│      │      │          ├─dto
│      │      │          │  ├─account
│      │      │          │  │  ├─request
│      │      │          │  │  └─response
│      │      │          │  ├─game
│      │      │          │  ├─page
│      │      │          │  ├─player
│      │      │          │  ├─playingGame
│      │      │          │  ├─reply
│      │      │          │  │  ├─request
│      │      │          │  │  └─response
│      │      │          │  └─search
│      │      │          ├─entity
│      │      │          ├─interceptor
│      │      │          ├─repository
│      │      │          ├─service
│      │      │          └─util
│      │      │              └─upload
│      │      ├─header-output
│      │      └─stash-dir
│      ├─compileTestJava
│      │  └─compileTransaction
│      │      ├─annotation-output
│      │      ├─compile-output
│      │      │  └─com
│      │      │      └─pickpick
│      │      │          └─repository
│      │      ├─header-output
│      │      └─stash-dir
│      └─test
├─diagram
├─gradle
│  └─wrapper
├─readmeSources
└─src
    ├─main
    │  ├─java
    │  │  └─com
    │  │      └─pickpick
    │  │          ├─api
    │  │          ├─config
    │  │          ├─controller
    │  │          ├─dto
    │  │          │  ├─account
    │  │          │  │  ├─request
    │  │          │  │  └─response
    │  │          │  ├─game
    │  │          │  ├─page
    │  │          │  ├─player
    │  │          │  ├─playingGame
    │  │          │  ├─reply
    │  │          │  │  ├─request
    │  │          │  │  └─response
    │  │          │  └─search
    │  │          ├─entity
    │  │          ├─interceptor
    │  │          ├─repository
    │  │          ├─service
    │  │          └─util
    │  │              └─upload
    │  ├─resources
    │  │  ├─mappers
    │  │  ├─static
    │  │  │  └─assets
    │  │  │      ├─css
    │  │  │      ├─img
    │  │  │      └─js
    │  │  └─templates
    │  └─webapp
    │      └─WEB-INF
    │          └─views
    │              ├─account
    │              ├─games
    │              ├─include
    │              └─rank
    └─test
        └─java
            └─com
                ├─example
                │  └─worldcup
                └─pickpick
                    ├─http
                    ├─repository
                    └─service
```
