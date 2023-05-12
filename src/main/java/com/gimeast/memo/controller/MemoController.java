package com.gimeast.memo.controller;

import com.gimeast.memo.data.dto.MemoDto;
import com.gimeast.memo.data.dto.MemoResponseDto;
import com.gimeast.memo.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memo")
public class MemoController {

    private final MemoService memoService;

    @Autowired
    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    @PostMapping
    public ResponseEntity<MemoResponseDto> createMemo(@RequestBody MemoDto memoDto) {
        MemoResponseDto result = memoService.save(memoDto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping
    public ResponseEntity<MemoResponseDto> findById(Long id) {
        MemoResponseDto result = memoService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping
    public ResponseEntity<MemoResponseDto> changeMemoContent(Long id, String content) {
        MemoResponseDto result = memoService.changeMemoContent(id, content);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteMemoById(Long id) {
        memoService.deleteMemoById(id);
        return ResponseEntity.status(HttpStatus.OK).body("메모가 정상적으로 삭제되었습니다.");
    }

    @GetMapping("/list")
    public ResponseEntity<List<MemoResponseDto>> findByContent(String content) {
        List<MemoResponseDto> result = memoService.findByContent(content);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


}
