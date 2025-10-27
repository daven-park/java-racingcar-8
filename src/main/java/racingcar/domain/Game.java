package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private final List<Car> carList;

    public Game(List<String> carList){
        this.carList = carList.stream().map(Car::new).collect(Collectors.toList());
    }

    public void startRound(){
        for (Car car : carList) {
            car.move();
        }
    }

    public List<String> getWinnerList() {
        int maxMoveCount = findMaxMoveCount();
        return carList.stream()
                .filter(car -> car.getCarMoveCount() == maxMoveCount)
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    private int findMaxMoveCount() {
        return carList.stream()
                .mapToInt(Car::getCarMoveCount)
                .max()
                .orElse(0);
    }

    public List<Car> getCarList(){
        return carList;
    }
}
