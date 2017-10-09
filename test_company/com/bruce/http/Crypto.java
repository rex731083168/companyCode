package com.bruce.http;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Crypto {
	
	public static byte[] md5(String waitSign, String encoding, StringBuilder sbErr)
	  {
	    try
	    {
	      MessageDigest digest = MessageDigest.getInstance("MD5");
	      digest.update(waitSign.getBytes(encoding));

	      return digest.digest();
	    } catch (NoSuchAlgorithmException e) {
	      sbErr.append(String.format("鍙戠敓寮傚父锛�s", new Object[] { e }));
	      e.printStackTrace();
	    } catch (Exception ex) {
	      sbErr.append(String.format("寮傚父锛�s", new Object[] { ex }));
	    }
	    return null;
	  }
	
	public static String md5ToHexString(String waitSign, String encoding, StringBuilder sbErr)
	  {
	    return bytesToHexString(md5(waitSign, encoding, sbErr));
	  }
	
	public static String bytesToHexString(byte[] p_bytes)
	  {
	    if ((p_bytes == null) || (p_bytes.length <= 0)) {
	      return null;
	    }
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < p_bytes.length; i++) {
	      int each = p_bytes[i] & 0xFF;
	      String eachHex = Integer.toHexString(each);
	      if (eachHex.length() < 2) {
	        sb.append(0);
	      }
	      sb.append(eachHex);
	    }
	    return sb.toString();
	  }
	
	public static String buildObjectSortWaitSign(Map<String, Object> mapPars, boolean ExcludeBlankValue) {
	    StringBuilder sbPars = new StringBuilder();
	    List lsPars = new ArrayList();
	    for (Iterator i = mapPars.keySet().iterator(); i.hasNext(); ) {
	      String strKey = String.valueOf(i.next());
	      lsPars.add(strKey);
	    }
	    String[] tmpPars = (String[])lsPars.toArray(new String[lsPars.size()]);
	    Arrays.sort(tmpPars);
	    for (Integer i = Integer.valueOf(0); i.intValue() < tmpPars.length; i = Integer.valueOf(i.intValue() + 1)) {
	      String strKey = tmpPars[i.intValue()];
	      String strValue = String.valueOf(mapPars.get(strKey));
	      if ((strValue == null) || (strValue.length() == 0)) {
	        if (ExcludeBlankValue) {
	          strValue = "";
	        }

	      }
	      else if (i.intValue() == tmpPars.length - 1)
	        sbPars.append(String.format("%s=%s", new Object[] { strKey, strValue }));
	      else {
	        sbPars.append(String.format("%s=%s&", new Object[] { strKey, strValue }));
	      }
	    }
	    return sbPars.toString();
	  }
}
