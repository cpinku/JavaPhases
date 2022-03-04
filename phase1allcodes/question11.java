package phase1allcodes;
public class question11 {
	public static void main(String[] args) {
System.out .println("Checking if one String contains another String in Java");
String input = "Java is the best programming language"; 
boolean isPresent = input.indexOf("Java") != -1 ? true : false; 
if (isPresent) { 
	System.out.println("input string: " + input);
	System.out.println("search string: " + "Java");
	System.out.println("does String contains substring? " + "YES"); 
	}
System.out.println("Doing search with different case"); 
isPresent = input.indexOf("java") != -1 ? true : false; 
System.out.println("isPresent: " + isPresent);

System.out.println("Checking if one String contains another String using contains in Java"); 
input = ("Hello everyone"); 
boolean isFound = input.contains("Java"); 
if (isFound) 
{ 
	System.out.println("input string: " + input);
}
System.out.println("search string: " + "Java"); 
System.out.println("does substring is found inside String? " + "YES");
} 
}