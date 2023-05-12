package com.gimeast.memo.data.repository;

import com.gimeast.memo.data.entity.MemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemoRepository extends JpaRepository<MemoEntity, Long>, MemoRepositoryCustom {
}
