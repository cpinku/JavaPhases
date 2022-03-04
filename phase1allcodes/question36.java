package phase1allcodes;

import java.util.Arrays;

class bubble {
	static void question36(int arr[]){
		int s=arr.length;
		for(int i=0;i<s-1;i++)
			for(int j=0;j<s-i-1;j++)
				if(arr[j]>arr[j+1]){
					int t=arr[j];
					arr[j+1]=t;
				}
	}
	public static void main(String[] args) {
		int[] d={7,8,9,1,5};
		bubble.question36(d);
		System.out.println("after sorting:");
		System.out.println(Arrays.toString(d));
	}
}
