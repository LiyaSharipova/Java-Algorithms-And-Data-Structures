package ru.kpfu.itis.group11403.sharipova.queue;

public class Clinic {
	private Faculty [] faculties;
	private Queue<Student> studentQueue;
	public Clinic(Faculty[] faculties) {
		if (faculties == null){
			throw new NullPointerException("no faculty");
		}
		this.faculties = faculties;
	}
	public void createQueue(int size){
		int eachFacultyStudentAmount=size/faculties.length;
		studentQueue = new Queue<Student>(size);
			for (Faculty val : faculties){
				for (Student student : val.RandomLuckyStudents(size/faculties.length)){
					studentQueue.offer(student);
					
				}
			}
	}
	public void print(){
		while (studentQueue.size() > 0){
			System.out.println(studentQueue.poll().getName());
		}
	}
}
