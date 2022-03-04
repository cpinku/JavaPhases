package phase1allcodes;

class question19_poly
{
    public int sum(int x, int y) 
    { 
        return (x + y); 
    } 
    public int sum(int x, int y, int z) 
    { 
        return (x + y + z); 
    } 
    public double sum(double x, double y) 
    { 
        return (x + y); 
    } 
    public static void main(String args[]) 
    { 
    	question19_poly s = new question19_poly(); 
        System.out.println(s.sum(30, 50)); 
        System.out.println(s.sum(40, 50, 30)); 
        System.out.println(s.sum(70.5, 90.5)); 
    } 
}
