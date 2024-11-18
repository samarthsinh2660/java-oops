public class l7q5 {
    public static void main(String[] args){
        try{
            int data = 25/0;
        }
        catch(ArithmeticException e){
            System.out.println("error is handled ");
            System.out.println(e);
        }
        finally{
            System.out.println("try catch is complete and final is excuted ");
        }
        
        System.out.println("rest of the code ");
    }
}
