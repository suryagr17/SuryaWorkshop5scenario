import java.util.Scanner;
public class FixedDepositNIB {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char choice;
        while (true) 
        {
            System.out.println("\n--- Nepal Investment Bank FD Calculator ---");
            System.out.print("Enter Principal Amount (Minimum Rs.1000):");
            double principal=sc.nextDouble();
            if (principal<1000) 
            {
                System.out.println("Error: Minimum deposit is Rs.1000");
                continue;
            }
            System.out.print("Enter Annual Interest Rate(8-12%):");
            double annualRate=sc.nextDouble();
            System.out.print("Enter Duration in Years(Maximum 5 years):");
            int years=sc.nextInt();
            if (years>5) 
            {
                System.out.println("Error:Maximum duration is 5 years");
                continue;
            }
            double monthlyRate=(annualRate/100)/12;
            int totalMonths=years*12;
            double maturityAmount=principal*Math.pow(1 + monthlyRate,totalMonths);
            double feeRate=0.005; 
            double processingFee=maturityAmount * feeRate;
            double finalAmount=maturityAmount - processingFee;
            System.out.println("\n--- FD Statement ---");
            System.out.printf("Maturity Amount(Before Fee):Rs. %.2f\n",maturityAmount);
            System.out.printf("Processing Fee(0.5%%):      Rs. %.2f\n",processingFee);
            System.out.printf("Final Amount to Receive:    Rs. %.2f\n",finalAmount);
            System.out.print("Do you want to perform another calculation?(y/n):");
            choice=sc.next().toLowerCase().charAt(0);
            if (choice=='n') 
            {
                break;
            }
        }
        System.out.println("Thank you for using NIB Services");
        sc.close();
    }
}
