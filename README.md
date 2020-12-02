# java - lotto - test
우아한테크코스 3기 프리코스에 앞서, 이전 기수의 미션을 혼자 연습하기 위한 저장소

## 기능 목록

- #### 사용자 입력
    - 로또 구입 금액을 입력한다.
    - 당첨 번호를 입력한다. (6개 번호, 쉼표로 구분)
    - 보너스 번호를 입력한다.
    
- #### 출력
    - 사용자 로또 개수와 번호 출력
    - 당첨 통계 출력

- #### 예외 처리
    - 사용자 추측 입력 문자열이 지정된 개수(3개)를 벗어난 길이를 갖는 경우 
    - 사용자 추측 입력 문자열이 유효 문자 범위(1~9)를 벗어난 경우
    - 사용자 추측 입력 문자열의 3개의 수에 중복이 존재하는 경우
    - 게임 재진행 여부 구분자 입력이 유효 문자 범위(1~2)를 벗어난 경우

- #### 사용자 로또 생성 
    - 사용자가 구매 가능한 로또의 개수만큼 로또를 생성한다.
    - 로또는 1~45 이내의 숫자 중 서로 다른 6개의 임의의 숫자로 구성된다.
    
- #### 로또 당첨 계산
    - 사용자의 로또가 당첨 되었는지 확인한다.
    - 모두 맞으면 1등
    - 5개 맞고 보너스가 일치하면 2등
    - 5개 맞고 보너스가 틀리면 3등
    - 4개 맞으면 4등
    - 3개 맞으면 5등

- #### 수익률 계산
    - 당첨 결과에 따른 수익률을 계산한다.
  
   
<br>

## 프로그램 구조도

- #### lotto
    - Application : 사용자로부터 금액과 로또 번호를 입력 받는다.
    - User : 사용자의 사용 금액과 로또 번호 리스트를 포함한다.
    - Lotto : 6개의 번호 리스트와 보너스 번호를 포함한다. 
    - Lottos : 사용자의 Lotto 리스트를 저장한다.
    - Rank : Lotto의 당첨과 상금을 계산한다.
    - WinningLotto : 사용자가 입력한 우승 로또 번호와 보너스 번호를 저장한다.
    
- #### utils
    - InputValidator : 사용자 입력이 유효한지 검증한다.
    - LottoFactory : 로또 번호를 생성한다.
    - RandomUtils : 범위 내 임의의 숫자를 리턴한다.
    - StringHandler : 사용자의 입력 문자열 처리를 위한 클래스이다.
    
- #### view
    - InputView : 사용자로부터 입력을 받는다.
    - OutputView : 메시지를 출력한다.
    
<br>

## 미션 요구 사항

<details>
<summary> 접기 / 펼치기 </summary>
