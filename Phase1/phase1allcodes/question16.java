package phase1allcodes;

import java.util.Scanner;
public class question16 {
	float l,b;
	static float area;
	void calculate(float l,float b){
	this.l=l;
	this.b=b;
	areaFunc(l,b);
	
	}
	void areaFunc(float l,float b){
		try{
			display(l,b);
		}
		
		catch(areaException e)
		{
			System.out.println("Exception Occurred"+e.getMessage());
			
		}
	}
	
	static void display(float l,float b) throws areaException
	{
		if(l<b)
		{
			throw new areaException("IOException");
		}
		else{
			area=l*b;
			System.out.println("Area of rectangle:"+area);
		}
	}
	
	
	public static void main(String[] args) {
		question16 q=new question16();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter L of rectangle:");
		float l=sc.nextFloat();
		System.out.println("enter B of rectangle:");
		float b=sc.nextFloat();
		q.calculate(l, b);;
	}
}
class areaException extends Exception{
	
	areaException(String s){
		super(s);
	}
}

