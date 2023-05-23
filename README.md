# World Cup Project

# 업데이트 내역

| 날짜  | 내용                 | 기타 |
|-----|:-------------------|:---|
| 5/8 | 주제 회의 및 ERD 작성     |    |
| 5/9 | ERD 수정 및 Entity 생성 | 백  |

## 데이터베이스 플레이중인 게임 지우기

```
delete from playing_game_tbl
where account_id is null
;
```

### Member

---

| 개발자 | 담당          |
|-----|-------------|
| 원석빈 | PM & Front  |
| 이채원 | Front       | 
| 이진호 | Front & Back|
| 조경훈 | Back        |

### DataBase Diagram

![erd.png](diagram%2Ferd.png)

### Flow Chart

![flow-chart.png](diagram%2Fflow-chart.png)