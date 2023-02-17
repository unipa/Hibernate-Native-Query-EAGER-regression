# Hibernate ORM 6.x Regression with `FetchType.EAGER`

Since Hibernate ORM 6.x the `FetchType.EAGER` raises the following error when called from native queries

	could not initialize proxy [org.hibernate.domain.Building#0] - no Session

Using the same `@Entity` with hibernate `createQuery()`, everything works as expected