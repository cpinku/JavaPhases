package phase1allcodes;
import java.util.*;
public class question37 {
	void question37(int arr[]){
		int s=arr.length;
		for(int p=1;p<s;p++){
			int k=arr[p];
			int j=p-1;
			while(j>=0 && k<arr[j]){
				arr[j+1]=arr[j];
				--j;
			}
			arr[j+1]=k;
		}
	}
	public static void main(String[] args) {
		int[] d={7,9,1,5,2};
		question37 is=new question37();
		is.question37(d);;
		System.out.println("Required array: ");
		System.out.println(Arrays.toString(d));
	}
}

		
		
