package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String carName;
    private int carMoveCount;

    public Car(String name){
        this.carName = name;
        this.carMoveCount = 0;
    }

    public void move(){
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4){
            this.carMoveCount++;
        }
    }

    public String getCarName(){
        return carName;
    }
    public int getCarMoveCount(){
        return carMoveCount;
    }

}
