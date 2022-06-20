package com.te.learnspringbootwithdatajpa.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Nationality {
	INDIA("INDIA"), CHINA("CHINA"), RUSSIA("RUSSIA"), SRILANKA("SHRILANKA");

	private final String nation;
}
