package phase1allcodes;
class Std{
	int id;
	String name;

	Std(int i,String n)
	{
	id=i;
	name=n;
	}

	void display() {
	System.out.println(id+" "+name);
	}
}

public class question5 {
public static void main(String[] args) {

	Std std1=new Std(10,"pradeep");
	Std std2=new Std(5,"pranathi");
	std1.display();
	std2.display();
		}
}


