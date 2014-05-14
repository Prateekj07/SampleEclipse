package mkyong;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentMainClass {

	Session session ;
	public StudentMainClass() {
		// TODO Auto-generated constructor stub
		session = HibernateUtil.getSessionFactory().openSession();
	
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Hibernate one to many (Annotation)");
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		/*Transaction transaction = null;
		transaction = session.beginTransaction();
		
		Teacher teacher = new Teacher();
		teacher.setSname("t1name");
		
		Student student1 = new Student();
		student1.setTname("s1name");
		student1.setTeacher(teacher);
		
		Student student2 = new Student();
		student2.setTname("s2name");
		student2.setTeacher(teacher);
		
		Set<Student> h = new HashSet<Student>();
		h.add(student1);h.add(student2);
		
		teacher.setStudent(h);
		
		session.save(teacher);
		transaction.commit();*/
		
		Teacher t = (Teacher) session.load(Teacher.class, 1);
		System.out.println("T : "+t);

		List<Teacher> tList = session.createQuery("from Teacher").list();
		System.out.println("TList : "+tList);

		Student s = (Student) session.load(Student.class, 1);
		System.out.println("S : "+s);

		List<Student> sList = session.createQuery("from Student").list();
		System.out.println("SList : "+sList);

		
		

	}
	
	public Teacher getTeacher(){
		
		System.out.println("Hibernate one to many (Annotation)");
	
		Teacher t = (Teacher) session.load(Teacher.class, 1);
		System.out.println("T : "+t);
		session.close();
		return t;
	}

	public Student getStudent(){
		Student s = (Student) session.load(Student.class, 1);
		System.out.println("S : "+s);
		return s;
	}
	
	public List<Teacher> getTeachers(){
		List<Teacher> tList = session.createQuery("from Teacher").list();
		System.out.println("TList : "+tList);
		return tList;
	}
	
	public List<Student> getStudents() {
		List<Student> sList = session.createQuery("from Student").list();
		System.out.println("SList : "+sList);
		return sList;
	}
	
}
