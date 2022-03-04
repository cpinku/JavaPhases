package phase1allcodes;
import java.util.Scanner;

public class question3 {

	public static void main(String[] args) {
		double a1;
		double a2;
		double ans;
		char op;
		Scanner reader=new Scanner(System.in);
		System.out.println("Enter two numbers:");
		a1=reader.nextDouble();
		a2=reader.nextDouble();
		System.out.println("Enter required operator (+,-,*,/):");
		op=reader.next().charAt(0);
		switch(op){
		case '+': ans= a1+a2;
		break;
		case '-': ans= a1-a2;
		break;
		case '*': ans= a1*a2;
		break;
		case '/': ans= a1/a2;
		break;
		
		default:System.out.printf("error");
		return;
		}
		System.out.println("\nresult");
		System.out.println(a1 +""+op+" "+a2+" = "+ans);
	}
}

		
		
	