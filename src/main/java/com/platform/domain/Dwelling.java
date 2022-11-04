package com.platform.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Dwelling {
	private Integer id;
	private Integer area;
	private Integer floor;
	private Integer roomsNumber;
	private String description;
	private Integer adressId;
	private Integer dwellingOwnerId;
	private Integer reservationId;
}
