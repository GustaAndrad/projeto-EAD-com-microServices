package com.ead.authuser.dtos;

import io.micrometer.core.lang.NonNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class JwtDto {

    @NonNull
    private String token;

    private final String type = "Bearer";
}
