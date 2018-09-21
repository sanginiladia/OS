
import java.util.Scanner;


public class Producer_consumer_without_thread {

    
    public static int S=1;
    public static int E=10;
    public static int F=0;
 

    public static void main(String[] args) {
        while(true)
        {   Scanner sc = new Scanner(System.in); 
            System.out.println("1. Producer  2. Consumer  3. EXIT");
            int ch = sc.nextInt();
           switch(ch)
                
            {
                case 1:
                    if(S==1 && E!=0)
                    producer();
                    else
                        System.out.println("producer is busy");
                    break;
                case 2:
                    if(S==1 && F!=0)
                    consumer();
                    else
                        System.out.println("consumer is busy");
                    break;
                case 3:
                    System.exit(0);
            }
                    
        }
        
    }
    static int wait(int S)
    {
        return --S;
    }
    static int signal(int S)
    {
        return ++S;
    }
    static void producer()
    {
        S=signal(S);
       
         E=wait(E);
         F =signal(F);
          S =wait(S);
         System.out.println("producer is producing ");
         
    }
    static void consumer()
    {
        S= signal(S); 
        E = signal(E);
        System.out.println("consumer is consuming");
        F= wait(F);
    }
}
