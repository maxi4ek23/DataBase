package com.platform.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class City {
    private Integer id;
    private String name;
    private Integer population;
    private Integer regionId;
}
