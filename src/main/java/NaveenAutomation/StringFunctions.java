package NaveenAutomation;

public class StringFunctions {

	public static void main(String[] args) {
// 1.  Write a program to check two different strings equality.
String s1="sangita";
String s2="sangita";
System.out.println(s1.equalsIgnoreCase(s2));
System.out.println(s1.equals(s2));
System.out.println(s1==s2);
		
//2. Remove all  spaces in a String . 
String spaceStr =  "         Hello      Everyone       ";
System.out.println(spaceStr.replaceAll("\\s",""));

//3. Write a program that will  print out the last character and first character of a word.
String lastFstChar = "sangita";
System.out.println("Frist Character in string 'sangita' is: " + lastFstChar.charAt(0) );
System.out.println("Last  Character in string 'sangita' is: " + lastFstChar.charAt(lastFstChar.length()-1) );


//4. Write a program to verify a word or a character contained in the sentence.
String a1 = "Ryan is a cool guy!!!!   ";
if (a1.contains("Ryan") == true){
	System.out.println(a1 + "COONTIANS the word 'Ryan'");
}

//5.Write a function/ method to reverse your own name.
String strToReverse = "Sangita";
String rev = "";
int len=strToReverse.length() ;
for(int i = len-1; i >= 0; i-- ) {
	rev = rev + strToReverse.charAt(i);	
}
System.out.println("Reverse  of  "  + strToReverse +"  is " + rev);

String reversed="";
char a[]=strToReverse.toCharArray();
int lenth=a.length;
for(int arrInt =lenth-1; arrInt>=0; arrInt --) {
	reversed = reversed + strToReverse.charAt(arrInt);	
}
System.out.println("Reverse of ARRAY "  + strToReverse +"  is   " + reversed);

StringBuffer sb = new StringBuffer(strToReverse);
System.out.println("Reverse of Using StringBuffer   "  + sb.reverse());

//6. Write a program that gives you the last half of the string.
String wholeString="Sangita Panday is going home!";
char strArray[]=wholeString.toCharArray();
for(int i = strArray.length/2;  i <strArray.length; i++) {
	System.out.print(strArray[i]);
}

//7.Write a program to get the 3rd  “ e “ of the string .
//For example: “Welcome to Naveen Automation Labs ! “.
String msg = "Welcome to Naveen Automation Labs !";
System.out.println(msg.indexOf("e", msg.indexOf("e")+1));

//8. Write a method which gives an index of (-1) if string is not available. . it should return integer. if String is present, then it should return the specific index.
System.out.println(msg.indexOf("Hello"));
System.out.println(msg.indexOf("Automation"));

//9. Write a program that breaks a whole string into small strings, and prints out its all values . (Hint: split, loop) .
String strT0split="This string needs to be split by using white spaces!!";
String array[] = strT0split.split(" ");
for(int i =0; i < array.length; i ++) {
	System.out.println("The Result of the string spit are:  " + array[i] );
}

//10. Assume that a string consists of 3 words, print out the middle one. 
String threeWords = "Welcome You Wisemen!!";
String ar[]=threeWords.split(" ");
System.out.println(ar[1]);


//11. get only numeric part from this String:
String s = "your transaction id is: 12345 and reference id is 34567";
System.out.println( s.replaceAll("[^0-9]", " "));



}
}