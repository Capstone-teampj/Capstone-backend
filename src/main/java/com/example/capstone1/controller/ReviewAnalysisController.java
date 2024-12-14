package com.example.capstone1.controller;

import com.example.capstone1.dto.ReviewAnalysisResponseDTO;
import com.example.capstone1.service.ReviewAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 리뷰 분석 요청을 처리하는 컨트롤러.
 */
@RestController
@RequestMapping("/api/analysis")
public class ReviewAnalysisController {

    @Autowired
    private ReviewAnalysisService analysisService;

    @GetMapping("/store/{storeId}")
    public ResponseEntity<ReviewAnalysisResponseDTO> getReviewAnalysis(@PathVariable Long storeId) {
        // RestTemplate 타임아웃 적용은 RestTemplateConfig에서 처리됨.
        // analysisService는 해당 설정이 적용된 RestTemplate Bean을 사용.
        ReviewAnalysisResponseDTO responseDTO = analysisService.getReviewAnalysisResponse(storeId);
        return ResponseEntity.ok(responseDTO);
    }
}