package com.gimeast.memo.service;

import com.gimeast.memo.data.dto.MemoDto;
import com.gimeast.memo.data.dto.MemoResponseDto;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
public class MemoServiceTest {

    private Logger LOGGER = LoggerFactory.getLogger(MemoServiceTest.class);

    private final MemoService memoService;

    @Autowired
    public MemoServiceTest(MemoService memoService) {
        this.memoService = memoService;
    }

    @Test
    void 메모_저장() {
        MemoDto memoDto = MemoDto.builder()
                .content("메모 저장 테스트 입니다3.")
                .build();

        MemoResponseDto result = memoService.save(memoDto);

        assertThat(result.getContent()).isEqualTo(memoDto.getContent());

        LOGGER.info("result:" + result);
    }

    @Test
    void 메모_조회() {
        MemoDto memoDto = MemoDto.builder()
                .content("메모 조회 테스트 입니다.")
                .build();

        MemoResponseDto saveResult = memoService.save(memoDto);

        MemoResponseDto result = memoService.findById(saveResult.getId());
        assertThat(result.getContent()).isEqualTo(memoDto.getContent());

        LOGGER.info("result:" + result);
    }

    @Test
    void 메모_수정() {
        MemoDto memoDto = MemoDto.builder()
                .content("메모 수정 테스트 입니다.")
                .build();

        MemoResponseDto saveResult = memoService.save(memoDto);

        MemoResponseDto result = memoService.changeMemoContent(saveResult.getId(), "수정성공! 테스트 완료");

        assertThat(result.getContent()).isNotEqualTo(memoDto.getContent());
        LOGGER.info("result:" + result);
    }

    @Test
    void 메모_삭제() {
        MemoDto memoDto = MemoDto.builder()
                .content("메모 삭제 테스트 입니다.")
                .build();

        MemoResponseDto saveResult = memoService.save(memoDto);

        memoService.deleteMemoById(saveResult.getId());

        MemoResponseDto result = memoService.findById(saveResult.getId());

        assertThat(result.isDeleteYn()).isNotEqualTo(memoDto.isDeleteYn());
        LOGGER.info("result:" + result);
    }

    @Test
    void 메모_목록_조회() {
        MemoDto memoDto1 = MemoDto.builder()
                .content("1메모 목록 조회 테스트 입니다.")
                .build();

        MemoResponseDto saveResult1 = memoService.save(memoDto1);

        MemoDto memoDto2 = MemoDto.builder()
                .content("2메모 목록 조회 테스트 입니다.")
                .build();

        MemoResponseDto saveResult2 = memoService.save(memoDto2);

        MemoDto memoDto3 = MemoDto.builder()
                .content("3메모 목록 조회 테스트 입니다.")
                .build();

        MemoResponseDto saveResult3 = memoService.save(memoDto3);

        List<MemoResponseDto> result = memoService.findByContent("");

        assertThat(result.get(0).getContent()).isEqualTo(memoDto3.getContent());
        assertThat(result.get(1).getContent()).isEqualTo(memoDto2.getContent());
        assertThat(result.get(2).getContent()).isEqualTo(memoDto1.getContent());
        LOGGER.info("result:" + result);
    }

}
