package com.epam.transformation.controller;

import com.epam.transformation.dto.TransformationRequestDto;
import com.epam.transformation.dto.TransformationResponseDto;
import com.epam.transformation.validator.TransformationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1")
public class TransformationController {
    private final TransformationService transformationService;

    public TransformationController(TransformationService transformationService) {
        this.transformationService = transformationService;
    }

    @PostMapping("/transformation")
    public ResponseEntity<?> transformJson(@Valid @RequestBody TransformationRequestDto requestDto) {
        TransformationResponseDto transformationResponseDto = transformationService.transform(requestDto);
        return new ResponseEntity<>(transformationResponseDto, HttpStatus.OK);
    }
}
