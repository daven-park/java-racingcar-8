package racingcar.controller;

import racingcar.domain.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        List<String> carNameList = inputView.readCarNames();
        int count = inputView.readCount();

        Game game = new Game(carNameList);

        outputView.printResultMessage();

        for(int i = 0; i < count; i++){
            game.startRound();
            outputView.printRound(game.getCarList());
        }
        List<String> winnerList = game.getWinnerList();
        outputView.printWinnerList(winnerList);

    }
}
