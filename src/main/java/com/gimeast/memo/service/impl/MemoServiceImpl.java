package com.gimeast.memo.service.impl;

import com.gimeast.memo.data.dto.MemoDto;
import com.gimeast.memo.data.dto.MemoResponseDto;
import com.gimeast.memo.data.entity.MemoEntity;
import com.gimeast.memo.data.repository.MemoRepository;
import com.gimeast.memo.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
public class MemoServiceImpl implements MemoService {

    private final MemoRepository memoRepository;

    @Autowired
    public MemoServiceImpl(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }


    @Override
    public MemoResponseDto save(MemoDto memoDto) {
        MemoEntity memo = MemoEntity.builder()
                .content(memoDto.getContent())
                .isDeleteYn(false)
                .build();

        MemoEntity entity = memoRepository.save(memo);

        MemoResponseDto result = MemoResponseDto.builder()
                .id(entity.getId())
                .content(entity.getContent())
                .createDt(entity.getCreateDt())
                .deleteDt(entity.getDeleteDt())
                .build();

        return result;
    }

    @Transactional(readOnly = true)
    @Override
    public MemoResponseDto findById(Long id) {
        MemoEntity entity = memoRepository.findById(id).orElse(null);

        MemoResponseDto result = MemoResponseDto.builder()
                .id(entity.getId())
                .content(entity.getContent())
                .createDt(entity.getCreateDt())
                .deleteDt(entity.getDeleteDt())
                .isDeleteYn(entity.isDeleteYn())
                .build();
        return result;
    }


    @Override
    public MemoResponseDto changeMemoContent(Long id, String content) {
        MemoEntity entity = memoRepository.findById(id).orElse(null);
        entity.updateContent(content);

        MemoResponseDto result = MemoResponseDto.builder()
                .id(entity.getId())
                .content(entity.getContent())
                .createDt(entity.getCreateDt())
                .deleteDt(entity.getDeleteDt())
                .build();
        return result;
    }


    @Override
    public void deleteMemoById(Long id) {
//        memoRepository.deleteById(id); // 실제 데이터 삭제는 하면안됨
        MemoEntity entity = memoRepository.findById(id).orElse(null);
        entity.updateDeleteYn(true);
    }


    @Transactional(readOnly = true)
    @Override
    public List<MemoResponseDto> findByContent(String content) {
        List<MemoEntity> entityList = memoRepository.findByContent(content);

        List<MemoResponseDto> result = entityList.stream()
                .map(o -> new MemoResponseDto(o))
                .collect(Collectors.toList());

        return result;
    }


}
