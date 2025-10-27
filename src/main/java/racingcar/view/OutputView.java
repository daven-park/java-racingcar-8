package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    private static final String WINNER_RESULT_OUTPUT = "최종 우승자 : ";
    private static final String RACE_PROGRESS_BAR = "-";

    public void printRound(List<Car> carList) {
        for (Car car : carList){
            String carMoveCountProgress = RACE_PROGRESS_BAR.repeat(car.getCarMoveCount());
            System.out.println(car.getCarName() + " : " + carMoveCountProgress);
        }
        System.out.println();
    }

    public void printWinnerList(List<String> winnerList){
        String winnerNameList = String.join(", ", winnerList);
        System.out.println(WINNER_RESULT_OUTPUT + winnerNameList);
    }

    public void printResultMessage(){
        System.out.println("\n실행 결과");
    }

}
