package com.epam.transformation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Set;

@AllArgsConstructor
@Data
public class TransformationResponseDto {
    private String name;
    private Set<String> items;
    private Long timeStamp;
}
