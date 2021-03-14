package com.elvisbaranoski.mc.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Categoria implements Serializable{
	private static final long serialVersionUID= 1L;
	
	private Long id;
	private String nome;
	
}
