package phase1allcodes;
public class question13 implements Runnable{
	 
    public static int myCount = 0;
    public question13(){
         
    }
    public void run() {
        while( question13.myCount <= 10){
            try{
                System.out.println("Expl Thread: "+(++ question13.myCount));
                Thread.sleep(100);
            } catch (InterruptedException iex) {
                System.out.println("Exception in thread: "+iex.getMessage());
            }
        }
    } 
    public static void main(String a[]){
        System.out.println("Starting Main Thread...");
        question13 mrt = new  question13();
        Thread t = new Thread(mrt);
        t.start();
        while( question13.myCount <= 10){
            try{
                System.out.println("Main Thread: "+(++ question13.myCount));
                Thread.sleep(100);
            } catch (InterruptedException iex){
                System.out.println("Exception in main thread: "+iex.getMessage());
            }
        }
        System.out.println("End of Main Thread...");
    }
}
