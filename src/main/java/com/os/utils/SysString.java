//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.os.utils;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Random;

public class SysString {
    public SysString() {
    }

    public static boolean isEmpty(Object obj) {
        return obj == null?true:"".equals(obj.toString().trim());
    }

    public static String reverse(String str) {
        if(isEmpty(str)) {
            return "";
        } else {
            StringBuffer sb = new StringBuffer(str);
            sb.reverse();
            return sb.toString();
        }
    }

    public static int findCount(String sSource, String sFind) {
        int iCount = 0;
        if(!isEmpty(sSource)) {
            for(int iIndex = sSource.indexOf(sFind, 0); iIndex != -1; iIndex = sSource.indexOf(sFind, iIndex + 1)) {
                ++iCount;
            }
        }

        return iCount;
    }

    public static String toString(Object param) {
        return param == null?"":param.toString();
    }

    public static String getMapStr(Map<String, Object> map, String sKey) {
        return map.get(sKey) == null?"":toString(map.get(sKey).toString());
    }

    public static String lpad(String sSource, int iLen, String str) {
        String sValue = "";
        if(str.length() < iLen) {
            for(int i = 0; i < iLen - str.length(); ++i) {
                sValue = sValue + str;
            }
        }

        return sValue + str;
    }

    public static String rPad(String sSource, int iLen, String str) {
        String sValue = "";
        if(str.length() < iLen) {
            for(int i = 0; i < iLen - str.length(); ++i) {
                sValue = sValue + str;
            }
        }

        return str + sValue;
    }

    public static int byteLength(String str) {
        try {
            return str.getBytes("GBK").length;
        } catch (Exception var2) {
            return 0;
        }
    }

    public static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";

        for(int n = 0; n < b.length; ++n) {
            stmp = Integer.toHexString(b[n] & 255);
            if(stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }

            if(n < b.length - 1) {
                hs = hs + ":";
            }
        }

        return hs.toUpperCase();
    }

    public static String repeatStr(int iCount, String str) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < iCount; ++i) {
            sb.append(str);
        }

        return sb.toString();
    }

    public static String removeRepeat(String sSource, String sSplitStr) {
        boolean iCount = false;
        String[] cSource = null;
        String sRet = "";
        String sFindStr = "";
        cSource = sSource.split(sSplitStr);

        for(int i = 0; i < cSource.length; ++i) {
            if(!isEmpty(cSource[i])) {
                sFindStr = cSource[i] + sSplitStr;
                int var7 = findCount(sSource, sFindStr);
                if(var7 > 1) {
                    if(sRet.indexOf(sFindStr) == -1) {
                        sRet = sRet + sFindStr;
                    }
                } else {
                    sRet = sRet + sFindStr;
                }
            }
        }

        if(!isEmpty(sRet)) {
            sRet = sRet.replace(sSplitStr + sSplitStr, sSplitStr);
        }

        if(sRet.endsWith(sSplitStr)) {
            sRet = sRet.substring(0, sRet.length() - 1);
        }

        return sRet;
    }

    public static String getGBK(String pString) {
        if(isEmpty(pString)) {
            return "";
        } else {
            try {
                pString = new String(pString.getBytes("ISO-8859-1"), "GBK");
            } catch (UnsupportedEncodingException var2) {
                pString = "";
            }

            return pString;
        }
    }

    public static String randomCN() {
        String outCharacter = null;
        Random random = new Random();
        int hightPos = 176 + Math.abs(random.nextInt(39));
        int lowPos = 161 + Math.abs(random.nextInt(93));
        byte[] b = new byte[]{(new Integer(hightPos)).byteValue(), (new Integer(lowPos)).byteValue()};

        try {
            outCharacter = new String(b, "GBK");
        } catch (UnsupportedEncodingException var6) {
            var6.printStackTrace();
        }

        return outCharacter;
    }
}
