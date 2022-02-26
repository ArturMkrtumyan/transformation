package com.epam.transformation.validator;

import com.epam.transformation.dto.TransformationRequestDto;
import com.epam.transformation.dto.TransformationResponseDto;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TransformationService {

    public TransformationResponseDto transform(TransformationRequestDto requestDto) {
        Set<String> items = requestDto.getItems().stream().map(this::snakeToCamel
        ).collect(Collectors.toSet());
        return new TransformationResponseDto(requestDto.getName(),
                items, System.currentTimeMillis());
    }

    private String snakeToCamel(String str) {
        str = str.substring(0, 1).toUpperCase()
                + str.substring(1);
        while (str.contains("_")) {
            str = str
                    .replaceFirst(
                            "_[a-z]",
                            String.valueOf(
                                    Character.toUpperCase(
                                            str.charAt(
                                                    str.indexOf("_") + 1))));
        }
        return str;
    }
}
