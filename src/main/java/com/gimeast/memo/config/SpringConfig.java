package com.gimeast.memo.config;

import com.gimeast.memo.data.repository.MemoRepository;
import com.gimeast.memo.service.impl.MemoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemoRepository memoRepository;

    @Autowired
    public SpringConfig(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    @Bean
    public MemoServiceImpl memoServiceImpl() {
        return new MemoServiceImpl(memoRepository);
    }
}
