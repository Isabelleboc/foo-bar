public class Solution
{
  public static String solution(String s)
	{
		String sol= new String("");  
		String revAlph = new String ("zyxwvutsrqponmlkjihgfedcba");
		int index=0;
		
		for(int i=0; i<s.length();i++)
		{
			
			index= (int)s.charAt(i);
			if(index>='a' && index<='z')
			{
				
				sol+= revAlph.charAt(index-97);
			}
			else
			{
				sol+= s.charAt(i);
			}
		}
		return sol;
	}
}
