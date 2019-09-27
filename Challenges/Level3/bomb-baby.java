import java.math.BigInteger;
public class Solution
{
  	public static String solution(String f, String m)
	{
		BigInteger ONE= BigInteger.valueOf(1);
		BigInteger ZERO = BigInteger.valueOf(0);
		BigInteger count=ZERO; 

		BigInteger F=  new BigInteger(f);
		BigInteger M = new BigInteger(m);
		BigInteger max, min;
		
		if(M.compareTo(F)==1)//(M>F)
		{
			max=M;
			min=F;
		}
		else
		{
			max=F;
			min=M;
		}
		
		while((max.compareTo(ONE)!=0 || min.compareTo(ONE)!=0)&& (max.compareTo(ZERO)==1 && min.compareTo(ZERO)==1)) //((max != 1 || min !=1) && (max>0 && min>0))
		{
			System.out.println("in loop");
			if(min.compareTo(max)==1)//(min>max)
			{
				BigInteger temp= max;
				max=min;
				min=temp;
			}
			
			BigInteger num= max.mod(min);
			
			if(num.equals(ZERO)|| num.equals(min))//(num ==0 || num==min)
			{
				if (max.equals(ONE) && min.equals(ONE))//(max==1 && min==1)
				{
					return ""+count;
				}
				else
				{
					max= max.subtract(min);//max-=min;
					count=count.add(ONE);//count++;
				}
			}
			else
			{
				count= count.add((max.subtract(num)).divide(min));//count+= (int)((max-num)/min);
				max=num;
			}
			
		}
		if(max.compareTo(ZERO)== 0 || min.compareTo(ZERO) ==0)//(max==0 || min==0)
		{
			return "impossible";
		}
		else
			return ""+count;
	}
}

