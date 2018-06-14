import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name = "Course")
@Entity
@Access(AccessType.FIELD)
public class Course {
	@Column(name = "Cno")
	// @GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private String Cno;
	@Column(name = "Cname")
	private String Cname;
	@ManyToMany(mappedBy = "cous")
	private List<Student> stus = new ArrayList<Student>();

	public Course(String cno, String cname, List<Student> stus) {
		super();
		Cno = cno;
		Cname = cname;
		this.stus = stus;
	}

	public Course() {
		// super();
		// TODO Auto-generated constructor stub
	}

	public String getCno() {
		return Cno;
	}

	public void setCno(String cno) {
		Cno = cno;
	}

	public String getCname() {
		return Cname;
	}

	public void setCname(String cname) {
		Cname = cname;
	}

	public List<Student> getStus() {
		return stus;
	}

	public void setStus(List<Student> stus) {
		this.stus = stus;
	}

}