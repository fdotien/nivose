/**
 * 
 */
package com.nivose.dlabphoto.util;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.springframework.stereotype.Component;

/**
 * @author Dotien Joel
 *
 */
@Component
public class InternetConnectionTest {

	public  boolean testInet(String site) {
	    Socket sock = new Socket();
	    InetSocketAddress addr = new InetSocketAddress(site,80);
	    try {
	        sock.connect(addr,3000);
	        return true;
	    } catch (IOException e) {
	        return false;
	    } finally {
	        try {sock.close();}
	        catch (IOException e) {}
	    }
	}

}
