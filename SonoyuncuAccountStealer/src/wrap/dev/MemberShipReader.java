package wrap.dev;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class MemberShipReader {
	public static final JsonParser jsonParser = new JsonParser();
	public static final SecureRandom secureRandom = new SecureRandom();
	
	 public static JsonSonOyuncuMembership readMembershipJson(final File file) {
	        try {
	            if (!file.exists() || !file.isFile()) {
	                return null;
	            }
	            byte[] array = null;
	            byte[] array2 = null;
	            ByteArrayOutputStream byteArrayOutputStream = null;
	            Throwable t = null;
	            try {
	                final FileInputStream fileInputStream = new FileInputStream(file);
	                try {
	                    try {
	                        final DataInputStream dataInputStream = new DataInputStream(fileInputStream);
	                        try {
	                            if (dataInputStream.read() != 31) {
	                                return null;
	                            }
	                            array = new byte[8];
	                            dataInputStream.read(array, 0, array.length);
	                            array2 = new byte[dataInputStream.readInt()];
	                            dataInputStream.read(array2, 0, array2.length);
	                            byteArrayOutputStream = new ByteArrayOutputStream();
	                            final byte[] array3 = new byte[1024];
	                            int read;
	                            while ((read = dataInputStream.read(array3, 0, array3.length)) != -1) {
	                                byteArrayOutputStream.write(array3, 0, read);
	                            }
	                        }
	                        finally {
	                            if (dataInputStream != null) {
	                                dataInputStream.close();
	                            }
	                        }
	                    }
	                    finally {
	                      
	                    }
	                }
	                finally {
	                    if (fileInputStream != null) {
	                        fileInputStream.close();
	                    }
	                }
	            }
	            finally {
	                if (t == null) {
	                   
	                }
	                else {
	                   
	                }
	            }
	            final byte[] array4 = (byte[])((byteArrayOutputStream == null) ? null : byteArrayOutputStream.toByteArray());
	            if (array4 == null) {
	                return null;
	            }
	            final SecretKeySpec secretKeySpec = new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(new PBEKeySpec(getEnvName().toCharArray(), array, 65536, 128)).getEncoded(), "AES");
	            final Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
	            instance.init(2, secretKeySpec, new IvParameterSpec(array2));
	            return JsonSonOyuncuMembership.fromJsonElement(jsonParser.parse(new String(instance.doFinal(array4), StandardCharsets.UTF_8)));
	        }
	        catch (Exception throwable) {
	        	 return null;
	        }
	    }
	    
	   private static String getEnvName() {
	        try {
	            final String getenv = System.getenv("COMPUTERNAME");
	            if (getenv != null && !getenv.isEmpty()) {
	                return getenv;
	            }
	        }
	        catch (Exception ex) {}
	        try {
	            final String hostName = InetAddress.getLocalHost().getHostName();
	            if (hostName != null && !hostName.isEmpty()) {
	                return hostName;
	            }
	        }
	        catch (Exception ex2) {}
	        return System.getProperty("user.name");
	    }
	 
}
  