package mkyong;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="teacher")

@org.hibernate.annotations.GenericGenerator(
name = "test-increment-strategy",
strategy = "increment")
@XmlRootElement(name="teacher")
public class Teacher implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6304455753508956599L;

	Integer tid;
	
	String sname;
	
	Set<Student> student;
	
	
	@Id
	@GeneratedValue(generator = "test-increment-strategy")
	@Column(name = "tid")
	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}
	
	@Column(name = "sname")
	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}
	
	
	@OneToMany(mappedBy="teacher", fetch=FetchType.LAZY
			,cascade=CascadeType.ALL
			)
	@XmlTransient
	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Teacher [tid=");
		builder.append(tid);
		builder.append(", sname=");
		builder.append(sname);
		//builder.append(", student=");
		//builder.append(student);
		builder.append("]");
		return builder.toString();
	}
	
}
