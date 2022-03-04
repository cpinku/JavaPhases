package phase1allcodes;
import java.util.*;

class main {
	static int partition(int numArray[],int low,int high){
		int pivot =numArray[high];
		int i=(low-1);
		for(int j=low;j<=high-1;j++){
			
				if(numArray[j]<=pivot){
					i++;
					int temp=numArray[i];
					numArray[i]=numArray[j];
					numArray[j]=temp;
				}
			}
			int temp=numArray[i+1];
			numArray[i+1]=numArray[high];
			numArray[high]=temp;
			return i+1;
		}
		
		
		static void question39(int numArray[],int low,int high)
			{
				int[] intStack=new int[high-low+1];
				int top=-1;
				intStack[++top]=low;
				intStack[++top]=high;
				while(top>=0){
					high=intStack[top--];
					low=intStack[top--];
				int pivot=partition(numArray,low,high);
				if(pivot-1>low){
					intStack[++top]=pivot+1;
					intStack[++top]=high;
				}
			}
			
		}
		
		public static void main(String[] args) {
			int numArray[]={3,2,6,-1,9,1,-6,10,5};
			int n=8;
			System.out.println("original Array:" +Arrays.toString(numArray));
			question39(numArray,0,n-1);
			System.out.println("\n Sorted Array:" +Arrays.toString(numArray));
		}
	}