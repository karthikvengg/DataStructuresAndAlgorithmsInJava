/*
Singleton synchronized class
 */
import java.util.*;
/**
 *
 * @author Karthikeyan_Varadara
 */
public class SingletonExample {
    public static void main(String[] args) {
        Singleton s = Singleton.getSingleInstance();
        System.out.println(s);
        Singleton s2 = Singleton.getSingleInstance();
        System.out.println(s2);
    }
}

class Singleton{
    public String str;
    private static volatile Singleton obj;
    private Singleton(){}
    public static Singleton getSingleInstance(){
        if(obj==null){
            synchronized(Singleton.class){
                if(obj==null){
                    obj = new Singleton();                    
                }
            }            
        }
        return obj;
    }    
}
