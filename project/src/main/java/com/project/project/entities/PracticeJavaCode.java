package com.project.project.entities;

public class PracticeJavaCode {

	public static void main(String[] args) {
//		String s="Helloe";
//		for(int i=0;i<s.length();i++)
//		{
//			//System.out.println(s.charAt(i+1));
//			/** output :-
//			 * e
//l
//l
//o
//e
//Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 6
//	at java.base/java.lang.StringLatin1.charAt(StringLatin1.java:48)
//	at java.base/java.lang.String.charAt(String.java:712)
//	at com.project.project.entities.PracticeJavaCode.main(PracticeJavaCode.java:9)
//			 */
//		}
		int a=3;
		int cnt=0;
		System.out.println("cnt value "+cnt);
		while(cnt++ <3)
		{
			System.out.println(cnt);
			int b= (1+ 2*cnt)%3;
			switch(b)
			{
				default:
				case 0: a-=1; break;
				case 2: a+=5;
			}
			System.out.println("a value"+a);
			
		}
		System.out.println(a);
		
	
		
		
		
	}
}
