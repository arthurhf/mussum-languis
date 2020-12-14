import java.util.Scanner; 
public class MainClass{ 
  public static void main(String args[]) { 
    Scanner _key = new Scanner(System.in); 
    int a;
    String ab;
    int b;
    int c;
    String text;
    boolean bol;
    a = 4;
    c = 5;
    bol = false;
    a = 5;
    b = 10;
    for ( c = 0;c<3;c-- ) {
        System.out.println(a);
    }
    while ( a==10 ) {
        while ( b==50 ) {
        System.out.println(a);
        if ( b==a ) {
        b = _key.nextInt();
    }
    }
    }
    do {
        while ( b==50 ) {
        System.out.println(a);
        if ( b==a ) {
        b = _key.nextInt();
    }
    }
    } while (a==10 ); 
    ab = "textinho teste";
  }}