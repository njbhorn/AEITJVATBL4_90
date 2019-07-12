package lambdas03;

public class Student {
	
    private String name;
    private int age;
    private String grade;
    
    public Student ( String name, String grade, int age ) {
        this.name = name ;
        this.age = age ;
        this.grade = grade ;
    }
    
    public String getName() {
        return name ;
    }
    
    public int getAge() {
        return age ;
    }
    
    public String getGrade() {
        return grade ;
    }
} 



