package app;

public interface Printer {
    default void print(String str){
        System.out.println("\t:PRINTER:\n"+str);
    }
}
