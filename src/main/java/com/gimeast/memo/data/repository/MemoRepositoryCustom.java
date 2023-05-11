package com.gimeast.memo.data.repository;

import com.gimeast.memo.data.dto.MemoDto;
import com.gimeast.memo.data.dto.MemoResponseDto;
import com.gimeast.memo.data.entity.MemoEntity;

import java.util.List;

public interface MemoRepositoryCustom {
    List<MemoEntity> getMemoByContent(String content);
}
