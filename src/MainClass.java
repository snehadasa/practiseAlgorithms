public class MainClass
{
    public MainClass(int i, int j)
    {
//        System.out.println(i++);
//        System.out.println(++j);
        System.out.println(method(i, j));
    }

    int method(int i, int j)
    {
        return (i++ + ++i);
    }

    public static void main(String[] args)
    {
        MainClass main = new MainClass(10, 20);
    }
}
