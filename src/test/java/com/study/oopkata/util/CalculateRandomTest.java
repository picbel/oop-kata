package com.study.oopkata.util;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Log4j2
class CalculateRandomTest {

    @DisplayName("1~100이하의 난수 생성기")
    @Test
    void generateRandomInt() {
        CalculateRandom random = new CalculateRandom();

        for (int i = 0; i < 1000; i++) {
            int randomInt = random.generateRandomInt();
            assertThat(randomInt > 0).isTrue();
            assertThat(randomInt < 101).isTrue();
        }
    }

    // 확률테스트라 정확한 검증보다는 로그로 확인하였습니다. (안티패턴이지만 다른 좋은방법이 생각이 안나서 로그로 직접 확인하였습니다.)
    @DisplayName("확률 테스트")
    @Test
    void persentTest() throws Exception {
        //given
        int trueCount = 0;
        int falseCount = 0;
        CalculateRandom random = new CalculateRandom();
        //when
        for (int i = 0; i < 100000; i++) {
            boolean b = random.randomEventResult(0.8);
            if (b){
                trueCount++;
            }else {
                falseCount++;
            }
        }
        //then
        log.info("true count = {}", trueCount);
        log.info("false count = {}", falseCount);
        log.info("total count = {}", trueCount+falseCount);
        log.info("true persent = {} / 기댓값 {}", (double)trueCount/(trueCount+falseCount) ,0.8);

    }

    @DisplayName("0% 확률 테스트")
    @Test
    void persentTestError() throws Exception {
        //given
        CalculateRandom random = new CalculateRandom();
        //when
        boolean b = random.randomEventResult(0);
        //then
        assertThat(b).isFalse();

    }
    @DisplayName("100% 확률 테스트")
    @Test
    void persentTestError_2() throws Exception {
        //given
        CalculateRandom random = new CalculateRandom();
        //when
        boolean b = random.randomEventResult(1);
        //then
        assertThat(b).isTrue();

    }
}