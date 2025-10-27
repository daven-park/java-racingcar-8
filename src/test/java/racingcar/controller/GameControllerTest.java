package racingcar.controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameControllerTest extends NsTest {
    @Test
    @DisplayName("우승자 한명일때 테스트")
    void 우승자_한명_테스트(){
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni", "1");
            assertThat(output())
                    .contains("pobi : -")
                    .contains("woni :");
        }, 4, 3);
    }


    @Test
    @DisplayName("여러 라운드 우승자 표시")
    void 여러_라운드_우승자_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni", "2");
            assertThat(output())
                    .contains("pobi : -")
                    .contains("woni :")     // 1라운드 출력 포함
                    .contains("pobi : --")  // 2라운드 누적 이동
                    .contains("woni : -")
                    .contains("최종 우승자 : pobi");
        }, 4, 3, 4, 4);
    }

    @Test
    @DisplayName("공동 우승자 표시")
    void 여러_우승자_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,jun", "1");
            assertThat(output())
                    .contains("pobi : -", "jun : -")
                    .contains("최종 우승자 : pobi, jun");
        }, 4, 4);
    }

    @Test
    @DisplayName("자동차 이름 6자 이상이면 예외")
    void 자동차_이름_길이_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("pobiislong,woni", "1"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    @DisplayName("자동차 이름 빈 값 금지 - 빈 이름 포함시 예외")
    void 자동차_이름_입력_빈값_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("pobi,,woni", "1"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    @DisplayName("자동차 이름 중복 금지")
    void 자동차_이름_중복_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("pobi,woni,pobi", "1"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    @DisplayName("0, 음수, 정수 아닐떄 처리")
    void 시도횟수_예외처리() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("pobi,woni", "0"))
                    .isInstanceOf(IllegalArgumentException.class);
            assertThatThrownBy(() -> runException("pobi,woni", "-3"))
                    .isInstanceOf(IllegalArgumentException.class);
            assertThatThrownBy(() -> runException("pobi,woni", "abc"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    @DisplayName("입력에 공백 포함시 처리")
    void 자동차_이름_공백_처리테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("  pobi  ,   woni ", "1");
            assertThat(output())
                    .contains("pobi :")
                    .contains("woni :");
        }, 4, 4);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
