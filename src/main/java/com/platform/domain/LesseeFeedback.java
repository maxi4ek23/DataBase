package com.platform.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LesseeFeedback {
	private Integer id;
	private Integer rating;
	private String response;
	private Integer lesseeId;
}
