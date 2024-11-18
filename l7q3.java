public class l7q3 {
    public static void main(String[] args){
        try{
            try{
                System.out.println("going to dvide by zero ");
                int data = 30/0;
            }
            catch(ArithmeticException e){
                System.out.println(e);
            }
            try{
                System.out.println("trying for array");
                int a[] = new int[5];
                System.out.println(a[10]);
            }
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println(e);
            }

            System.out.println("Other statement ");
        }
        catch(Exception e){
            System.out.println("handled exception (outer catch )");
        }

        System.out.println("normal flow... ");
    }
}
