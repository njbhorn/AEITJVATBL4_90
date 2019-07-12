package lambdas03;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class DemoCollectorGroupingBy {
    public static void main(String[] args) {
    	
        Student s1 = new Student("Bill", "A", 20);
        Student s2 = new Student("Fred", "B", 22);
        Student s3 = new Student("Jim", "A", 22);
        Student s4 = new Student("Eric", "C", 20);
        Student s5 = new Student("Sean", "B", 21);
        
        List<Student> list = Arrays.asList(s1,s2,s3,s4,s5);
        
        //Group Student on the basis of ClassName
        System.out.println("----Group Student on the basis of Grade----") ;
        Map < String, List < Student > > studentByClass = list.stream ( )
                    .collect ( Collectors.groupingBy ( Student::getGrade ) ) ;
        System.out.println(studentByClass);
        
        studentByClass.forEach ( ( k, v ) -> System.out.println ( "Key:" + k + "  " + 
                ( ( List < Student > ) v ).stream ( )
                	.map ( m -> m.getName ( ) )
                	.collect ( Collectors.joining ( "," ) ) ) ) ;
        
        //Group Student on the basis of age
        System.out.println("----Group Student on the basis of age----");
        Map < Integer, List < Student > > studentByAge = list.stream ( )
                    .collect ( Collectors.groupingBy ( Student::getAge ) ) ;
        System.out.println(studentByAge);
        
        studentByAge.forEach ( ( k, v ) -> System.out.println ( "Key:" + k + "  " + 
                ( ( List < Student > ) v ).stream ( ).map( m -> m.getName ( ) ).collect ( Collectors.joining ( "," ) ) ) ) ;
    }
} 
