package com.platform.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DwellingOwner {
	private Integer id;
	private String name;
	private String surname;
	private Integer platformUserId;
}
