class Bank {
    
    double getInterestRate() {
        return 0.0; 
    }
}

class BankA extends Bank {

    double getInterestRate() {
        return 5.0; 
    }
}

class BankB extends Bank {

    double getInterestRate() {
        return 6.5; 
    }
}

class BankC extends Bank {
       double getInterestRate() {
        return 7.0; 
    }
}

public class l4q2{
    public static void main(String[] args) {
        Bank bankA = new BankA();
        Bank bankB = new BankB();
        Bank bankC = new BankC();
        
       
        System.out.println("Bank A Interest Rate: " + bankA.getInterestRate() + "%");
        System.out.println("Bank B Interest Rate: " + bankB.getInterestRate() + "%");
        System.out.println("Bank C Interest Rate: " + bankC.getInterestRate() + "%");
    }
}
