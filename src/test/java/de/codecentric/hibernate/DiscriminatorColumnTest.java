package de.codecentric.hibernate;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import static org.junit.Assert.assertNotNull;

public class DiscriminatorColumnTest {

	@Test
	public void testDiscriminatorColumnInInheritance() {
		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();

		Parent parent = new Parent(1, "Parent");
		SpecialParent specialParent = new SpecialParent(2, "SpecialParent");
		VerySpecialParent verySpecialParent = new VerySpecialParent(3, "VerySpecialParent");

		entityManager.merge(parent);
		entityManager.merge(specialParent);
		entityManager.merge(verySpecialParent);

		entityManager.getTransaction().commit();

		Parent actualParent = entityManager.find(Parent.class, 1);
		assertNotNull(actualParent);

		SpecialParent actualSpecialParent = entityManager.find(SpecialParent.class, 2);
		assertNotNull(actualSpecialParent);

		VerySpecialParent actualVerySpecialParent = entityManager.find(VerySpecialParent.class, 3);
		assertNotNull(actualVerySpecialParent);
	}

	private EntityManager getEntityManager() {
		return Persistence
				.createEntityManagerFactory("defaultPersistenceUnit")
				.createEntityManager();
	}
}
