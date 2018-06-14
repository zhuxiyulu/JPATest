import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "classes")
// @Access(AccessType.FIELD)
public class Classes {
	@Column(name = "ClassId")
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private String ClassId;
	@Column(name = "ClassName")
	private String ClassName;

	// @OneToMany(targetEntity = Student.class, mappedBy = "student")
	// private List<Student> students;

	public Classes() {
		// super();
		// TODO Auto-generated constructor stub
	}

	public Classes(String classId, String className) {
		super();
		ClassId = classId;
		ClassName = className;
	}

	public String getClassId() {
		return ClassId;
	}

	public void setClassId(String classId) {
		ClassId = classId;
	}

	public String getClassName() {
		return ClassName;
	}

	public void setClassName(String className) {
		ClassName = className;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ClassId == null) ? 0 : ClassId.hashCode());
		result = prime * result
				+ ((ClassName == null) ? 0 : ClassName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Classes other = (Classes) obj;
		if (ClassId == null) {
			if (other.ClassId != null)
				return false;
		} else if (!ClassId.equals(other.ClassId))
			return false;
		if (ClassName == null) {
			if (other.ClassName != null)
				return false;
		} else if (!ClassName.equals(other.ClassName))
			return false;
		return true;
	}

}
