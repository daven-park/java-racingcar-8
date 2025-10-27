# java-racingcar-precourse
> 자동자 경주 게임

## 기능 요구 사항

- [X] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
  - GameCountroller.run()
- [X] 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
  - Car(), InputView.readCarNames(), OutputView.printRound()
- [X] 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
  - InputView.validateNameCheck()
- [X] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
  - InputView.readCount()
- [X] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
  - Car.move()
- [X] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
  - OutputView.printWinnerList()
- [X] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
  - OutputView.printWinnerList()
- [X] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
  - InputView.validateNameCheck(), InputView.validateTryCountCheck()

## Class

- Game : 실제 자동차 경주에 사용되는 클래스
- Car : 자동차 정보를 다루는 객체 클래스
- GameController : Car, Game 데이터를 업데이트하는 컨트롤러 클래스
- InputView : 입력값(이름, 시도 횟수, 검증) 처리 클래스
- OutputView : 출력값(경주 결과, 우승자) 처리 클래스
