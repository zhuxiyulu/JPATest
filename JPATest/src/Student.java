import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Table(name = "Student")
@Entity
@Access(AccessType.FIELD)
public class Student {
	@Column(name = "Sno")
	// @GeneratedValue
	@Id
	private String Sno;
	@Column(name = "Sname")
	private String Sname;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH }, targetEntity = Classes.class)
	@JoinColumn(name = "ClassId")
	private Classes Class1;
	@ManyToMany(cascade = { CascadeType.ALL }, targetEntity = Course.class)
	@JoinTable(name = "SC", joinColumns = @JoinColumn(name = "Sno"), inverseJoinColumns = @JoinColumn(name = "Cno"), uniqueConstraints = @UniqueConstraint(columnNames = {
			"Sno", "Cno" }))
	private List<Course> cous = new ArrayList<Course>();

	public Student(String sno, String sname, Classes class1, List<Course> cous) {
		super();
		Sno = sno;
		Sname = sname;
		Class1 = class1;
		this.cous = cous;
	}

	public Student() {
		// super();
		// TODO Auto-generated constructor stub
	}

	public String getSno() {
		return Sno;
	}

	public void setSno(String sno) {
		Sno = sno;
	}

	public String getSname() {
		return Sname;
	}

	public void setSname(String sname) {
		Sname = sname;
	}

	public Classes getClass1() {
		return Class1;
	}

	public void setClass1(Classes class1) {
		Class1 = class1;
	}

	public List<Course> getCous() {
		return cous;
	}

	public void setCous(List<Course> cous) {
		this.cous = cous;
	}

}