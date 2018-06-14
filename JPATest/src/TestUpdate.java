import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestUpdate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. ����EntityManagerFactory
		String persistenceUnitName = "JPATest";
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory(persistenceUnitName);

		// 2. ����EntityManager
		EntityManager entityManager = factory.createEntityManager();

		// 3.��������
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		// ���Ҳ��޸�
		Student stu = entityManager.find(Student.class, "001");
		stu.setSname("wl");
		entityManager.merge(stu);
		entityManager.refresh(stu);

		// 6. �ر�EntityManager
		entityManager.close();

		// 7. �ر�EntityManagerFactory
		factory.close();
		System.out.println("���ĳɹ�");
	}

}
