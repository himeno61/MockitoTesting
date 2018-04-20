package app;

public interface Screen {
    default void printOnScreen(String str){
        System.out.println(str);
    }
}
