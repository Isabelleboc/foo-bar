import java.math.BigInteger;
public class Solution
{
         public static int solution(String s)
         {
		BigInteger N= new BigInteger(s);
		if(N.compareTo(BigInteger.valueOf(1))<0)
			return 2;
		if(N.equals(BigInteger.valueOf(0)))
		{
			return 0;
		}
		int count=0;
		int cat;
		while(!N.equals(BigInteger.valueOf(1)))
		{
			cat= intToDec(N);
			if(cat==1 || N.equals(BigInteger.valueOf(2)))
			{
				N=N.subtract(BigInteger.valueOf(1));
			}
			else if(cat==0)
			{
				N=N.divide(BigInteger.valueOf(2));
			}
			else
				N=N.add(BigInteger.valueOf(1));
			count++;
		}
		return count;
	}
	
	public static int intToDec(BigInteger N)
	{
		if(N.equals(BigInteger.valueOf(3)))
			return 1;
		String x = new String("");
		String bin= new String("");
		BigInteger A= BigInteger.valueOf(0);
		while(N.compareTo(BigInteger.valueOf(0))==1)
		{
			A= N.mod(BigInteger.valueOf(2));
			x = x + A;
			N = N.divide(BigInteger.valueOf(2));
		}
		for(int y=x.length()-1; y>=0;y--)
		{
			bin=bin+x.charAt(y);
		}
		String temp = bin.substring(bin.length()-2,bin.length());
		if(temp.charAt(1)=='0')
			return 0;
		else if(temp.equals("01"))
			return 1;
		else
			return -1;
		
	}
}
