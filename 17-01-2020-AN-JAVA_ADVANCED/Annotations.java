import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

// Class Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface ClassAnnotation {
    String type() default "DEFAULT VALUE";
}

// Class Annotation - Examples
@ClassAnnotation(type="Class Annotation Value")
class ClassAnnotationExample {
}


// Method Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MethodAnnotation {
    String type() default "DEFAULT VALUE";
}

// Method Annotation - Examples
class MethodAnnotationExample {
    @MethodAnnotation(type="Method Annotation Value")
    public void apply() {
    }

    @MethodAnnotation
    public void applyDefault() {
    }
}


// Main Class
public class Annotations {
    public static void main(String[] args) throws Exception {
        // Class Annotation - Test `type` value
        ClassAnnotationExample classAnnotationExample = new ClassAnnotationExample();
        ClassAnnotation classAnnotation = classAnnotationExample.getClass().getAnnotation(ClassAnnotation.class);
        System.out.println("Type: " + classAnnotation.type());


        // Method Annotation - Test
        MethodAnnotationExample methodAnnotationExample = new MethodAnnotationExample();

        // Method Annotation - Test `type` value
        Method methodAnnotationExampleMethod = methodAnnotationExample.getClass().getMethod("apply");
        MethodAnnotation methodAnnotation = methodAnnotationExampleMethod.getAnnotation(MethodAnnotation.class);
        System.out.println("Type: " + methodAnnotation.type());

        // Method Annotation - Test default value
        Method methodAnnotationExampleDefaultMethod = methodAnnotationExample.getClass().getMethod("applyDefault");
        MethodAnnotation methodAnnotationDefault = methodAnnotationExampleDefaultMethod.getAnnotation(MethodAnnotation.class);
        System.out.println("Type: " + methodAnnotationDefault.type());
    }
}
