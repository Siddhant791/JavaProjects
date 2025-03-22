package src.Annotations;

public interface AnnotionInterface {
    String getName();
    default void checkIfAnnoted(AnnotionInterface an){
        if (an.getClass().isAnnotationPresent(myAnnotation.class)){
            System.out.println("class is annotated");
        }else{
            System.out.println("class is not annotated");
        }
    }
}
