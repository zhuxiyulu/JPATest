import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 锟斤拷锟斤拷EntityManagerFactory
		String persistenceUnitName = "JPATest";
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(persistenceUnitName);

		// 2. 锟斤拷锟斤拷EntityManager
		EntityManager entityManager = factory.createEntityManager();

		// 3.锟斤拷锟斤拷锟斤拷锟斤拷
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		// 4. 锟街久伙拷锟斤拷锟斤拷

		Classes cl = new Classes();
		cl.setClassId("001");
		cl.setClassName("rz");

		Classes c2 = new Classes();
		c2.setClassId("002");
		c2.setClassName("rj");

		// entityManager.persist(cl);
		// entityManager.persist(c2);

		Student stu = new Student();
		stu.setSno("20154351134");
		stu.setSname("张三");
		stu.setClass1(cl);

		Student stu1 = new Student();
		stu1.setSno("20154351135");
		stu1.setSname("李四");
		stu1.setClass1(cl);

		Student stu2 = new Student();
		stu2.setSno("001");
		stu2.setSname("王五");
		stu2.setClass1(c2);

		entityManager.persist(stu);
		entityManager.persist(stu1);
		entityManager.persist(stu2);
		transaction.commit();
		transaction.begin();

		Course cou = new Course();
		cou.setCno("C001");
		cou.setCname("JavaEE");

		Course cou1 = new Course();
		cou1.setCno("C002");
		cou1.setCname("Java");

		// entityManager.persist(cou);
		// entityManager.persist(cou1);
		// transaction.commit();
		// transaction.begin();

		stu.getCous().add(cou);
		stu.getCous().add(cou1);
		stu1.getCous().add(cou);
		stu1.getCous().add(cou1);
		stu2.getCous().add(cou);
		cou.getStus().add(stu);
		cou.getStus().add(stu1);
		cou.getStus().add(stu2);
		cou1.getStus().add(stu);
		cou1.getStus().add(stu1);

		// 锟斤拷锟絬ser锟斤拷锟斤拷锟捷库，锟洁当锟斤拷hibernate锟斤拷save();
		// entityManager.persist(cl);
		// entityManager.persist(c2);
		entityManager.persist(stu);
		entityManager.persist(stu1);
		entityManager.persist(stu2);
		entityManager.persist(cou);
		entityManager.persist(cou1);

		// 5. 锟结交锟斤拷锟斤拷
		transaction.commit();
		entityManager.refresh(stu);
		entityManager.refresh(stu1);
		entityManager.refresh(stu2);
		// 锟斤拷锟矫癸拷锟斤拷

		// 6. 锟截憋拷EntityManager
		entityManager.close();

		// 7. 锟截憋拷EntityManagerFactory
		factory.close();
		System.out.println("锟斤拷映晒锟�");
	}

}
