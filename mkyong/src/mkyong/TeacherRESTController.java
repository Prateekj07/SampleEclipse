package mkyong;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

@Component
@Path("teacher")
public class TeacherRESTController {

/*	@GET
	@Produces({ MediaType.APPLICATION_XML })
	public Teacher getTeacher(){
		
		System.out.println("REST LAYER....");
		System.out.println("Inside getTeacher method...");
		
		StudentMainClass s = new StudentMainClass();
		Teacher teacher = s.getTeacher();
		
		System.out.println("done....");
		
		return teacher;
	}*/
	
	
	@GET
	@Path("/all")
	@Produces({ MediaType.APPLICATION_XML })
	public List<Teacher> getAllTeacher(){
		
		System.out.println("Inside getAllTeacher method...");
		
		StudentMainClass s = new StudentMainClass();
		List<Teacher> teachers = s.getTeachers();
		
		System.out.println("done....");
		
		return teachers;
	}
	
/*	@GET
	@Path("/test")
	@Produces({ MediaType.APPLICATION_XML })
	public Teacher test(){
		
		System.out.println("test....");
		
		Teacher t = new Teacher();
		t.setSname("Name");
		t.setTid(1);
		
		System.out.println("done....");
		
		return t;
	}*/
	
	/*public static void main(String[] args) {
		
		TeacherRESTController t = new TeacherRESTController();
		Teacher teacher = t.getTeacher();
		System.out.println(teacher);
	}*/
	
}
