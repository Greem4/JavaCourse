package edu.greem4.http.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserDto {
    long id;
    String mail;
}
