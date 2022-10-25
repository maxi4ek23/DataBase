package com.platform.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Reservation {
	private Integer id;
	private Boolean isPossible;
	private String name;
	private String time;
	private String howLong;
	private Boolean isConfirmed;
	private Integer lesseeId;
}
