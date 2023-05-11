package com.gimeast.memo.data.repository;

import com.gimeast.memo.data.entity.MemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<MemoEntity, Long>, MemoRepositoryCustom {
}
