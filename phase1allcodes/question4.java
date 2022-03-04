package phase1allcodes;

public class question4 {
	int m1()
	{
		System.out.println("m1 method");
		return 20;
	}
	float m2()
	{
		System.out.println("m2 method");
		return 20.6f;
	}
	static char m3()
	{
		System.out.println("m3 method");
		return 'g';
	}
	public static void main(String[] args){
		
		question4 q=new question4();
		int x=q.m1();
		System.out.println("return value of m1()="+x);
		float y=q.m2();
		System.out.println("return value of m2()="+y);
		char ch=q.m3();
		System.out.println("return value of m3()="+ch);
	}
}