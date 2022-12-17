package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String COACH_NAME_INPUT_INFO_MESSAGE_FORMAT = "코치의 이름을 입력해 주세요. (%s 로 구분)";

    private static final String INPUT_DIVIDER = ",";

    private final InputValidator inputValidator;

    public InputView() {
        inputValidator = new InputValidator();
    }

    public List<String> readCoachNames(int minCouchNumber, int maxCouchNumber) {
        printReadCoachNameInfoMessage();
        String nameInput = Console.readLine();
        List<String> coachNames = divideStringToList(nameInput);
        inputValidator.validateInputCount(coachNames, minCouchNumber, maxCouchNumber);
        return coachNames;
    }

    private void printReadCoachNameInfoMessage() {
        System.out.println(String.format(COACH_NAME_INPUT_INFO_MESSAGE_FORMAT, INPUT_DIVIDER));
    }

    private List<String> divideStringToList(String input) {
        return Arrays.stream(input.split(INPUT_DIVIDER))
                .map(str -> str.trim())
                .collect(Collectors.toList());
    }
}