package reflection02;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention ( RetentionPolicy.RUNTIME)
@Target ( value={
		ElementType.TYPE,
		ElementType.FIELD,
		ElementType.CONSTRUCTOR,
		ElementType.METHOD,
		ElementType.LOCAL_VARIABLE
})
public @interface MyDemoAnnotation {
	public String myInfo() ;
}
