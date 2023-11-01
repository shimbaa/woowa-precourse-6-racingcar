package racingcar.controller;

import java.util.List;
import racingcar.Game;
import racingcar.RoundResult;
import racingcar.domain.TrialNumber;
import racingcar.view.OutputView;

public class MainController {

    private final InputController inputController = new InputController();
    private final OutputView outputView = new OutputView();
    private Game game;
    private TrialNumber trialNumber;

    public void initGame() {
        List<String> carNames = inputController.getCarNames();
        int trialNumberInput = inputController.getTrialNumber();
        game = new Game(carNames);
        trialNumber = new TrialNumber(trialNumberInput);
    }

    public void playGame() {
        outputView.printResultMessage();
        do {
            playSingleTrial();
        } while (!trialNumber.isZero());

        outputView.printWinners(game.getWinners());
    }

    private void playSingleTrial() {
        RoundResult roundResult = game.race();
        outputView.printRoundResult(roundResult);
        trialNumber.subtractOne();
    }
}