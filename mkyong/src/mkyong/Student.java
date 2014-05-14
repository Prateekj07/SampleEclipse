package mkyong;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name="student")

@org.hibernate.annotations.GenericGenerator(
name = "test-increment-strategy",
strategy = "increment")
@XmlRootElement
public class Student implements Serializable{
	
	private static final long serialVersionUID = 6008904645896590371L;

	Integer sid;
	
	String tname;
	
	Teacher teacher;
	
	@Id
	@GeneratedValue(generator = "test-increment-strategy")
	@Column(name = "sid")
	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}
	
	@Column(name = "tname")
	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}
	
	@ManyToOne(targetEntity=Teacher.class )
	@JoinColumn(name="fk_teacher_Id")
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [sid=");
		builder.append(sid);
		builder.append(", tname=");
		builder.append(tname);
		//builder.append(", teacher=");
		//builder.append(teacher);
		builder.append("]");
		return builder.toString();
	}
	
}
