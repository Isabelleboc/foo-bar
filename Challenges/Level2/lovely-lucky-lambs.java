public class Solution
{
 public static int solution(int lambCount)
	{
	    return generous(lambCount)-stingy(lambCount);
	}
	public static int stingy(int lambCount)
	{
	   //keep subtracting doubles from lambCount until there isn't enough LAMBS left
		int dub=1, count=0;
		while(lambCount>0)
		{
		    if((lambCount-dub)<0)
		        break;
		    else
		        lambCount-=dub;
		        dub*=2;
		        count++;
		}
		return count;
	}
	public static int generous(int lambCount)
	{
	  //iterative fibonacci sequence
	  int count=1;
		lambCount--; //because count=1, first henchman was paid 1 LAMB
		int prevPrev, prev=0 ,current=1;
		for(int i=0;i<lambCount;i++)
		{
			prevPrev=prev;
			prev=current;
			current=prevPrev+prev;
			lambCount-=current;
			if(lambCount<0)
				break;
			else
				count++;
		}
		return count;
	}
}
