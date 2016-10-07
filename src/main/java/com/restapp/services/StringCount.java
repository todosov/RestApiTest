package com.restapp.services;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by tadasyan
 */
@Getter
@Setter
@Builder
public class StringCount {

    private String string;

    private Long count;
}
