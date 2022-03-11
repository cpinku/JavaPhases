package phase1allcodes;

public class question8 {
	
		public static void main(String[] args) {
		//methods of strings
		System.out.println("Methods of Strings");
		
		String sl=new String("hello people");
		System.out.println(sl.length());

		//substring
		String sub=new String("Welcome ");
		System.out.println(sub.substring(2));

		//String Comparison
		String s1="Hellooo";
		String s2="Heldooo";
		System.out.println(s1.compareTo(s2));

		//IsEmpty
		String s4="";
		System.out.println(s4.isEmpty());

		//toLowerCase
		String s5="Helloui";
		System.out.println(s1.toLowerCase());
		
		//replace
		String s6="Heldooo";
		String replace=s2.replace('l', 'd');
		System.out.println(replace);

		//equals
		String x="Welcome to Javaclass";
		String y="WeLcOmE tO JaVaclass";
		System.out.println(x.equals(y));

		System.out.println("\n");
		System.out.println("Creating StringBuffer");
		//Creating StringBuffer and append method
		StringBuffer s=new StringBuffer("Welcome to Javaclass!");
		s.append("Enjoy your learning in java class");
		System.out.println(s);

		//insert method
		s.insert(0, 'r');
		System.out.println(s);

		//replace method
		StringBuffer sb=new StringBuffer("Hello");
		sb.replace(0, 2, "hELLLL");
		System.out.println(sb);

		//delete method
		sb.delete(0, 1);
		System.out.println(sb);
		
		//StringBuilder
		System.out.println("\n");
		System.out.println("Creating StringBuilder");
		StringBuilder sb1=new StringBuilder("Happy");
		sb1.append("Learning");
		System.out.println(sb1);

		System.out.println(sb1.delete(0, 1));

		System.out.println(sb1.insert(1, "Welcome"));

		System.out.println(sb1.reverse());
				
		//conversion	
		System.out.println("\n");
		System.out.println("Conversion of string SringBuff and StringBuild");
		
		String str = "Helore"; 
	    
	    // conversion from String object to StringBuffer 
	    StringBuffer sbr = new StringBuffer(str); 
	    sbr.reverse(); 
	    System.out.println("String to StringBuff");
	    System.out.println(sbr); 
	      
	    // conversion from String object to StringBuilder 
	    StringBuilder sbl = new StringBuilder(str); 
	    sbl.append("people"); 
	    System.out.println("String to StringBuild");
	    System.out.println(sbl);              		
	}
	}


