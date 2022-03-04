package phase1allcodes;
class question {
	void question(int a[],int beg,int mid,int end)
	{
		int i,j,k;
		int n1=mid-beg+1;
		int n2=end-mid;
		int LArray[]=new int[n1];
		int RArray[]=new int[n2];
		for(i=0;i<n1;i++)
			LArray[i]=a[beg+i];
		for(j=0;j<n2;j++)
			RArray[j]=a[mid+1+j];
		i=0;
		j=0;
		k=beg;
		while(i<n1 && j<n2)
		{
			if(LArray[i]<=RArray[j])
			{
				a[k]=LArray[i];
				i++;
			}
			else
			{
				a[k]=RArray[j];
				j++;
			}
			k++;
		}
		while(i<n1)
		{
			a[k]=LArray[i];
			i++;
			k++;
		}
		while(j<n2)
		{
			a[k]=RArray[j];
			j++;
			k++;
		}
	}
	void question38(int a[],int beg,int end)
	{
		if(beg<end)
		{
			int mid=(beg+end)/2;
			question38(a,beg,mid);
			question38(a,mid+1,end);
			question(a,beg,mid,end); 
		}
	}
	void printArray(int a[],int n)
	{
		int i;
		for(i=0;i<n;i++)
			System.out.println(a[i]+" ");
	}
	public static void main(String[] args) {
		int a[]={1,5,8,3,9,2,4};
		int n=a.length;
		question m1=new question();
		System.out.println("before sorting: ");
		m1.printArray(a,n);
		m1.question38(a,0,n-1);
		System.out.println("after sorting: ");
		m1.printArray(a,n);;
		System.out.println(" ");
	}
	
}