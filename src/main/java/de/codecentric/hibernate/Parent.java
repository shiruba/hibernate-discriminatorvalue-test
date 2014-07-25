package de.codecentric.hibernate;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
public class Parent {

	@Id
	private Integer id;

	@Column
	private String name;

	public Parent() {
	}

	public Parent(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Parent)) return false;

		Parent parent = (Parent) o;

		if (id != null ? !id.equals(parent.id) : parent.id != null) return false;
		return !(name != null ? !name.equals(parent.name) : parent.name != null);

	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		return result;
	}
}
