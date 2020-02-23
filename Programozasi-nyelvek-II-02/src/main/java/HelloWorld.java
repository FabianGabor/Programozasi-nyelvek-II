public class HelloWorld {
    public static void main (String[] args)
    {
        if (args.length != 0)
            System.out.println(args[0]);
        System.out.println("Hello Kitty");
        for (int i=2; i<=20; i+=2)
            System.out.println(i);
    }
}