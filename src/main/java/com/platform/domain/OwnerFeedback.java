package com.platform.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OwnerFeedback {
	private Integer id;
	private Integer rating;
	private String response;
	private Integer dwellingOwnerId;
}
