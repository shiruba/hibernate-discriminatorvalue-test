package de.codecentric.hibernate;

import javax.persistence.*;

@Entity
public class SpecialParent extends Parent {

	public SpecialParent() {}

	public SpecialParent(Integer id, String name) {
		super(id, name);
	}
}
