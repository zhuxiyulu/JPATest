import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestDelete {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		// 查找并删除

		Course cou = entityManager.find(Course.class, "C001");
		entityManager.remove(cou);
		Course cou1 = entityManager.find(Course.class, "C002");
		entityManager.remove(cou1);
		Student stu = entityManager.find(Student.class, "20154351134");
		System.out.println(stu.getClass1().getClassId());
		entityManager.remove(stu);
		Student stu1 = entityManager.find(Student.class, "20154351135");
		entityManager.remove(stu1);
		Student stu2 = entityManager.find(Student.class, "001");
		entityManager.remove(stu2);
		Classes c1 = entityManager.find(Classes.class, "001");
		entityManager.remove(c1);
		Classes c2 = entityManager.find(Classes.class, "002");
		entityManager.remove(c2);
		transaction.commit();
		// 设置关联

		// 6. 关闭EntityManager
		entityManager.close();

		// 7. 关闭EntityManagerFactory
		factory.close();
		System.out.println("删除成功");

	}

}
