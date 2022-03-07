# oop-kata

OOP에 기반하여 프로젝트를 만들었습니다.\
TDD를 이용하여 최대한 상세한 테스트코드 작성을 목표로 하였습니다.

요구사항
- 종족
    - 휴먼
    - 오크
    - 엘프

- 속성
    - 레벨
    - HP
    - MP
    - 공격력
    - 공격속도
    - 방어력
    - 회피율 (%)

- 스킬
    - 공용 스킬
        - Heal (HP가 오른다)
        - steam (공격력이 20%)
    - 휴먼스킬
        - guard (방어력 상승)
    - 엘프스킬
        - Elusion (회피력 상승)
    - 오크스킬
        - Anger (공격력 상승, 방어력 하락)
    - 궁극 스킬
        - 휴먼 Invincible (10초 동안 무적이 됨.)
        - 엘프 Rapid (1분 동안 공격 속도가 500% 상승 한다.)
        - 오크 Frenzy (1분 동안 공격력이 500% 상승 한다.)

- 무기
    - 휴먼 (검)
        - Short sword 공격력 +5%
        - Long sword 공격력 +10%
    - 엘프 (활)
        - Short bow 공격 속도 +5%
        - Iron bow 공격 속도 +10%
    - 오크 (도끼, 둔기)
        - Short Axe 공격력 +10%, 공격 속도 -5%
        - Iron Hammer 공격력 +20%, 공격 속도 -10%
        
- 몬스터
    - HP (생명력) HP는 0 이 되면 죽는다.
    - 공격력
    - 방어력
    - 스킬
        - 반격 (%) 30% 지렁이도 밟으면 꿈틀. 해당되는 퍼센테이지 수치의 확률로 상대에게 반격을 한다.\ 본인 공격력의 70% 만큼 대미지를 입힘


### 구현 액션
테스트 패키지 com/study/oopkata/Action.java 에서 해당 구현 액션을 검증하였습니다.

- 캐릭터는 무기를 착용하여 몬스터에게 공격을 할 수 있다.
    - 공격 후에는 공격 속도에 따라 딜레이가 발생.
  > 메서드 action1 입니다.\
  > 공격 딜레이는 공격로그을 스택으로 쌓아 마지막에 들어온 시간으로 부터 계산하여 공격딜레이를 계산하였습니다.\
  > ex 공격 딜레이사이에 공격요청이 와도 공격하지 않습니다.
  
- 몬스터 또한 캐릭터를 공격할 수 있다.
  > 메서드 action2 입니다.\
  > 몬스터가 캐릭터를 반격한 상황에 대한 검증입니다.\
  > 확률이 들어간 부분이라 spy를 이용하여 확률관련 메서드부분은 모킹하였습니다.

- 공격 또는 반격시(몬스터) 대상의 회피율에 따라 무시될 수 있다.
  > 메서드 action3 입니다.\
  > 몬스터의 반격을 플레이어가 회피하여 데미지를 입지 않은 상황입니다.\
  > 확률이 들어간 부분이라 spy를 이용하여 확률관련 메서드부분은 모킹하였습니다.
    
- 캐릭터는 본인이 습득한 스킬을 사용할 수 있다.
  > Characters 클래스에서 스킬을 종족별로 주입받아 사용하기 때문에 습득한 스킬을 제외하면 사용 할 수 없습니다.
  



