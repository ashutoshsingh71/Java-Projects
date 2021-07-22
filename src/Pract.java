import java.util.ArrayList;
import java.util.List;

public class Pract {
    public static void main(String[] args)
    {
        try
        {
            return;
        }
        finally
        {
            System.out.println( "Finally" );
        }
    }
}

class AAA{
    public void m1() throws ArrayIndexOutOfBoundsException {
        System.out.println("A class");
    }
}

class B extends AAA{
    public void m1() throws IndexOutOfBoundsException {
        System.out.println("B class");
    }
}
