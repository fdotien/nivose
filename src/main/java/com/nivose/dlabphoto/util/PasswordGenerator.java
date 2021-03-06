package com.nivose.dlabphoto.util;

import java.util.Random;

public class PasswordGenerator {
	
	private static final char[] symbols;
    static {
	    StringBuilder tmp = new StringBuilder();
	    for (char ch = '0'; ch <= '9'; ++ch)
	      tmp.append(ch);
	    for (char ch = 'a'; ch <= 'z'; ++ch)
	      tmp.append(ch);
	    for (char ch = 'A'; ch <= 'Z'; ++ch)
		  tmp.append(ch);
	      tmp.append( "!@#$%&*()=-+" );
	    symbols = tmp.toString().toCharArray();
	  }   

	  private static final Random random = new Random();

	  public static String prepareRandomString(int len) {
		char[] buf = new char[len];
	    for (int idx = 0; idx < buf.length; ++idx) 
	      buf[idx] = symbols[random.nextInt(symbols.length)];
	    return new String(buf);
	  }
	  	  
	  public static void main(String args[]) {
		
		  System.out.println(BCrypt.gensalt());
	  }
}
