package com.gimeast.memo.data.dto;

import com.gimeast.memo.data.entity.MemoEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@ToString
public class MemoResponseDto {

    private Long id;
    private String content;
    private LocalDateTime createDt;
    private LocalDateTime deleteDt;
    private boolean isDeleteYn;

    @Builder
    public MemoResponseDto(Long id, String content, LocalDateTime createDt, LocalDateTime deleteDt, boolean isDeleteYn) {
        this.id = id;
        this.content = content;
        this.createDt = createDt;
        this.deleteDt = deleteDt;
        this.isDeleteYn = isDeleteYn;
    }

    public MemoResponseDto(MemoEntity o) {
        this.id = o.getId();
        this.content = o.getContent();
        this.createDt = o.getCreateDt();
        this.deleteDt = o.getDeleteDt();
        this.isDeleteYn = o.isDeleteYn();
    }
}
