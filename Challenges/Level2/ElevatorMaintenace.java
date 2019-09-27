public class Solution
{
        public static String[] solution(String[] l)
        {
		recMergeSort(l,l.length);
		return l;
	}
  
	public static boolean compare (String v1, String  v2)
	{
		String[] v1Parts = v1.split("[.]"), v2Parts = v2.split("[.]");
		int i=0; 
		while(true)
		{
			int n1=Integer.parseInt(v1Parts[i]);
			int n2=Integer.parseInt(v2Parts[i]);
			if(n1<n2)
				return true;
			else if(n1==n2)
				if(i==v1Parts.length-1)
					return true;
				else if(i==v2Parts.length-1)
					return false;
				else 
					i++;
			else
				return false;
		}
	}
  
	public static void recMergeSort(String[] ar, int n)
	{
		if(n<2)
			return;
		int mid =n/2;
		String[] l = new String[mid];
		String[] r= new String[n-mid];
		for(int i=0; i<mid; i++)
			l[i]=ar[i];
		for(int i=mid; i<n;i++)
			r[i-mid]=ar[i];
		recMergeSort(l,mid);
		recMergeSort(r,n-mid);
		merge(ar,l,r,mid,n-mid);
	}
  
	public static void merge (String[] ar, String[] l , String[] r, int left, int right)
	{
		int i=0, j=0, k=0; 
		while(i<left && j<right)
			if(compare(l[i],r[j]))
				ar[k++]=l[i++];
			else
				ar[k++]=r[j++];
		while(i<left)
			ar[k++]=l[i++];
		while(j<right)
			ar[k++]=r[j++];
	}
}
