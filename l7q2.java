public class l7q2 {
    public static void main(String[] args){
        try{
            //je pela error ae encounter ave pachi na jove beju 
            int a[] = new int[5];
            a[5] = 30/0;
            System.out.println("the array is "+ a[10]); 
            //for exception e parent exception
            //String s = Null
            //print(s.length())
        }
        catch(ArithmeticException e){
              System.out.println(e);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
        catch(Exception e){
            System.out.println("parent exception occured");
        }
        System.out.println("rest of the code ");
    }
}
