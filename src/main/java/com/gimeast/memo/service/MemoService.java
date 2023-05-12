package com.gimeast.memo.service;

import com.gimeast.memo.data.dto.MemoDto;
import com.gimeast.memo.data.dto.MemoResponseDto;

import java.util.List;

public interface MemoService {

    /**
     * 메모저장
     * @param memoDto
     * @return MemoResponseDto
     */
    MemoResponseDto save(MemoDto memoDto);

    /**
     * 메모상세
     * @param id
     * @return MemoResponseDto
     */
    MemoResponseDto getMemoById(Long id);

    /**
     * 메모내용 수정
     * @param id
     * @param content
     * @return MemoResponseDto
     */
    MemoResponseDto changeMemoContent(Long id, String content);

    /**
     * 메모삭제 delete_yn값 변경
     * @param id
     */
    void deleteMemoById(Long id);

    /**
     * 내용으로 메모 가져오기 (default는 전부 가져오기)
     * @param content
     * @return List<MemoResponseDto>
     */
    List<MemoResponseDto> findByContent(String content);

}
