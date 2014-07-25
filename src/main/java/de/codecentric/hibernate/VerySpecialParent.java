package de.codecentric.hibernate;

import javax.persistence.Entity;

@Entity
public class VerySpecialParent extends SpecialParent {

	public VerySpecialParent() {}

	public VerySpecialParent(Integer id, String name) {
		super(id, name);
	}
}
