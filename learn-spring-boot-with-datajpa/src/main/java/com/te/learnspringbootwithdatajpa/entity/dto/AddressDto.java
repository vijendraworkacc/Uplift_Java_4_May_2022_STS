package com.te.learnspringbootwithdatajpa.entity.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.te.learnspringbootwithdatajpa.entity.enums.AddressType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AddressDto {
	private String city;
	@Enumerated(EnumType.STRING)
	private AddressType addressType;
}
