package com.gimeast.memo.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@ToString
public class MemoDto {

    private Long id;
    private String content;
    private LocalDateTime createDt;
    private LocalDateTime deleteDt;
    private boolean isDeleteYn;

    @Builder
    public MemoDto(Long id, String content, LocalDateTime createDt, LocalDateTime deleteDt, boolean isDeleteYn) {
        this.id = id;
        this.content = content;
        this.createDt = createDt;
        this.deleteDt = deleteDt;
        this.isDeleteYn = isDeleteYn;
    }
}
