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
		// 1. 创建EntityManagerFactory
		String persistenceUnitName = "JPATest";
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory(persistenceUnitName);

		// 2. 创建EntityManager
		EntityManager entityManager = factory.createEntityManager();

		// 3.开启事务
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		// 查找并修改
		Student stu = entityManager.find(Student.class, "001");
		stu.setSname("wl");
		entityManager.merge(stu);
		entityManager.refresh(stu);

		// 6. 关闭EntityManager
		entityManager.close();

		// 7. 关闭EntityManagerFactory
		factory.close();
		System.out.println("更改成功");
	}

}
