public class l7q1 {
    public static void main(String[] args){
        try{
            int data = 50/0;
            System.out.println("Rest of the code");
        }
        catch(ArithmeticException e){
            System.out.println(e);
            System.out.println("cant be divide by zero");
        }
    }
}
