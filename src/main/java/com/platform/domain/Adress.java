package com.platform.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Adress {
	private Integer id;
	private String street;
	private Integer houseNumber;
	private Integer cityId;
}
