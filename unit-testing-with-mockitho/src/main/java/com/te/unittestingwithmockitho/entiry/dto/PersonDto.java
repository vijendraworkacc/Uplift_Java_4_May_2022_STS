package com.te.unittestingwithmockitho.entiry.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonDto {
	private String personId;
	private String personName;
	private int personAge;
	private String personEmail;
}
