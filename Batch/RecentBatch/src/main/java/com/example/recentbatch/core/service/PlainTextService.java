package com.example.recentbatch.core.service;

import com.example.recentbatch.core.domain.PlainText;
import com.example.recentbatch.core.domain.PlainTextRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class PlainTextService {
    private final PlainTextRepository plainTextRepository;

    public List<PlainText> getAllText() {
        return plainTextRepository.findAll();
    }
}
