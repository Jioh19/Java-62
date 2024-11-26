package entidades;

import org.hibernate.Session;

public class TestDaoHbm {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Curso curso = new Curso();
		curso.setDescripcion("SPRING");
		curso.setPrecio(200000);
		// si la secuencia no esta creada comentar.
//		session.createSQLQuery("DROP SEQUENCE CURSOID").executeUpdate();
//		session.createSQLQuery(
//				"CREATE SEQUENCE CURSOID " + "START WITH 4 " + "MAXVALUE 999999 " + "MINVALUE 0 " + "INCREMENT BY 1")
//				.executeUpdate();
		session.persist(curso);
		session.getTransaction().commit();
		System.out.println("curso insertado " + curso.getDescripcion());
	}
}