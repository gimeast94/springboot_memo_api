package com.gimeast.memo.data.repository.impl;

import com.gimeast.memo.data.dto.MemoResponseDto;
import com.gimeast.memo.data.entity.MemoEntity;
import com.gimeast.memo.data.entity.QMemoEntity;
import com.gimeast.memo.data.repository.MemoRepositoryCustom;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;
import java.util.stream.Collectors;

public class MemoRepositoryCustomImpl extends QuerydslRepositorySupport implements MemoRepositoryCustom {

    public MemoRepositoryCustomImpl() {
        super(MemoEntity.class);
    }

    @Override
    public List<MemoEntity> getMemoByContent(String content) {
        QMemoEntity qMemoEntity = QMemoEntity.memoEntity;

        List<MemoEntity> memoEntityList = from(qMemoEntity)
                .where(
                        qMemoEntity.content.contains(content == null ? "" : content),
                        qMemoEntity.isDeleteYn.eq(false)
                )
                .select(qMemoEntity).orderBy(qMemoEntity.createDt.desc())
                .fetch();


        return memoEntityList;
    }
}
