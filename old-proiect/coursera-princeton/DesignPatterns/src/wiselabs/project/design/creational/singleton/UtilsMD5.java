package wiselabs.project.design.creational.singleton;

import java.security.MessageDigest;

import javax.crypto.spec.SecretKeySpec;

public class UtilsMD5 {

	
	public static String md5(String message) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		} catch(Exception e) {}
		
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
