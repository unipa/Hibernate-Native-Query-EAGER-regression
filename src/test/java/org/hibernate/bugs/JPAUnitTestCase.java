package org.hibernate.bugs;
import java.util.Calendar;

import java.util.Date;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.domain.Classroom;
import org.hibernate.domain.Building;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using the Java Persistence API.
 */
public class JPAUnitTestCase {

	private EntityManagerFactory entityManagerFactory;

	@Before
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory( "templatePU" );
	}

	@After
	public void destroy() {
		entityManagerFactory.close();
	}

	// Entities are auto-discovered, so just add them anywhere on class-path
	// Add your tests, using standard JUnit.
	@Test
	public void hhh123Test() throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Building building = new Building(0L, "building number one");
		entityManager.persist(building);
		entityManager.persist(new Classroom(0L, "classroom1", building));

		entityManager.getTransaction().commit();
		entityManager.close();

		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Classroom> classrooms = fetchEagerNative(entityManager, "%classroom1%");
//		List<Classroom> classrooms = fetchEager(entityManager, "%classroom1%");
		entityManager.getTransaction().commit();
		entityManager.close();

		System.out.println("----------------------> Record count " + classrooms.size());
		classrooms.forEach(a -> System.out.println("----------------------> Description " + a.getDesCompletaAula()));
	}
	
	private List<Classroom> fetchEagerNative(EntityManager entityManager, String pattern) {
		String sqlQuery = "select t.*" +
				" from CLASSROOM t," +
				"     BUILDING e" +
				" where t.OID_BUILDING = e.OID" +
				"  and t.description like :pattern";

		return (List<Classroom>)entityManager
				.createNativeQuery(sqlQuery, Classroom.class)
				.setParameter("pattern", pattern)
				.getResultList();
	}

	private List<Classroom> fetchEager(EntityManager entityManager, String pattern) {
		String sqlQuery = //"select t.*" +
				" from Classroom t" +
				" where" +
				"  t.description like :pattern";

		return (List<Classroom>)entityManager
				.createQuery(sqlQuery)
				.setParameter("pattern", pattern)
				.getResultList();
	}
}
