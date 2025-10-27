package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public final String CAR_NAMES_INPUT_MESSAGE= "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public final String TRY_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    public final String CAR_NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 5자 이하만 가능합니다.";
    public final String TRY_COUNT_ERROR_MESSAGE = "시도 횟수는 숫자여야 합니다.";

    public List<String> readCarNames() {
        System.out.println(CAR_NAMES_INPUT_MESSAGE);
        String carNamesStr = Console.readLine();

        List<String> carNames = Arrays.asList(carNamesStr.split(","));
        validateNameCheck(carNames);

        return carNames.stream().map(String::trim).collect(Collectors.toList());
    }

    public int readCount(){
        System.out.println(TRY_COUNT_INPUT_MESSAGE);
        String tryCountStr = Console.readLine();

        validateTryCountCheck(tryCountStr);
        return Integer.parseInt(tryCountStr);
    }

    public void validateNameCheck(List<String> carNames){
        for (String str : carNames){
            if (str.trim().isEmpty() || str.trim().length() > 5){
                throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
            }
        }
    }

    public void validateTryCountCheck(String str){
        try{
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TRY_COUNT_ERROR_MESSAGE);
        }
    }


}
