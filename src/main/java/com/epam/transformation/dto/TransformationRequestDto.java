package com.epam.transformation.dto;

import com.epam.transformation.validator.IsLetter;
import lombok.Data;

import java.util.Set;

@Data
public class TransformationRequestDto {
    private String name;
    @IsLetter
    private Set<String> items;
}
