package com.platform.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PlatformUser {
	private Integer id;
	private String email;
	private String phone;
}
