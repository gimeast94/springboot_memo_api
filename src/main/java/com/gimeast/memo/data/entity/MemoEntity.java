package com.gimeast.memo.data.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "memo")
@Getter
@NoArgsConstructor
@ToString
@Entity
public class MemoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createDt;

    @Column
    private LocalDateTime deleteDt;

    @Column(nullable = false)
    @ColumnDefault("0")
    private boolean isDeleteYn;

    @Builder
    public MemoEntity(Long id, String content, LocalDateTime createDt, LocalDateTime deleteDt, boolean isDeleteYn) {
        this.id = id;
        this.content = content;
        this.createDt = createDt;
        this.deleteDt = deleteDt;
        this.isDeleteYn = isDeleteYn;
    }

    public void updateContent(String content) {
        this.content = content;
    }

    public void updateDeleteYn(boolean isDeleteYn) {
        this.isDeleteYn = isDeleteYn;
    }
}
