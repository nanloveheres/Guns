package cn.stylefeng.guns.modular.util;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.BeanUtilsBean2;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.PropertyUtils;


public class StringUtil {
    private static final String algorithm = "MD5";
    /*  35 */   public static String[] chars = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
    /*     */   
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */   public StringUtil() {}
    /*     */   
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */   public static String generate16ShortUUID()
    /*     */   {
    /*  48 */     StringBuffer shortBuffer = new StringBuffer();
    /*  49 */     String uuid = UUID.randomUUID().toString().replace("-", "");
    /*  50 */     for (int i = 0; i < 16; i++) {
    /*  51 */       String str = uuid.substring(i * 2, i * 2 + 2);
    /*  52 */       int x = Integer.parseInt(str, 16);
    /*  53 */       shortBuffer.append(chars[(x % 62)]);
    /*     */     }
    /*  55 */     return shortBuffer.toString();
    /*     */   }
    /*     */   
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */   public static String getUUID()
    /*     */   {
    /*  65 */     return UUID.randomUUID().toString().replaceAll("-", "");
    /*     */   }
    /*     */   
    /*     */   public static String md5(String str) {
    /*     */     try {
    /*  70 */       MessageDigest md = MessageDigest.getInstance("MD5");
    /*  71 */       md.update(str.getBytes());
    /*     */       
    /*  73 */       byte[] b = md.digest();
    /*  74 */       StringBuffer sb = new StringBuffer();
    /*  75 */       for (int i = 0; i < b.length; i++) {
    /*  76 */         int v = b[i];
    /*  77 */         v = v < 0 ? 256 + v : v;
    /*  78 */         String cc = Integer.toHexString(v);
    /*  79 */         if (cc.length() == 1)
    /*  80 */           sb.append('0');
    /*  81 */         sb.append(cc);
    /*     */       }
    /*     */       
    /*  84 */       return sb.toString();
    /*     */     }
    /*     */     catch (Exception localException) {}
    /*  87 */     return "";
    /*     */   }
    /*     */   
    /*     */   public static String[][] merge2D(String[][] twoDArray1, String[][] twoDArray2) {
    /*  91 */     int size1 = 0;
    /*  92 */     int size2 = 0;
    /*     */     
    /*  94 */     if (twoDArray1 != null)
    /*  95 */       size1 = twoDArray1.length;
    /*  96 */     if (twoDArray2 != null) {
    /*  97 */       size2 = twoDArray2.length;
    /*     */     }
    /*  99 */     if (size1 + size2 == 0) {
    /* 100 */       return (String[][])null;
    /*     */     }
    /* 102 */     String[][] merge2DArray = new String[size1 + size2][2];
    /* 103 */     for (int i = 0; i < size1; i++) {
    /* 104 */       merge2DArray[i][0] = twoDArray1[i][0];
    /* 105 */       merge2DArray[i][1] = twoDArray1[i][1];
    /*     */     }
    /* 107 */     for (int i = 0; i < size2; i++) {
    /* 108 */       merge2DArray[(i + size1)][0] = twoDArray2[i][0];
    /* 109 */       merge2DArray[(i + size1)][1] = twoDArray2[i][1];
    /*     */     }
    /* 111 */     return merge2DArray;
    /*     */   }
    /*     */   
    /*     */   public static String[][] merge(String[][] sourceArray) {
    /* 115 */     return sourceArray;
    /*     */   }
    /*     */   
    /*     */   public static String[] convert2DTo1D(String[][] twoDArray) {
    /* 119 */     if (twoDArray == null) {
    /* 120 */       return null;
    /*     */     }
    /* 122 */     String[] result = new String[twoDArray.length];
    /* 123 */     for (int i = 0; i < twoDArray.length; i++) {
    /* 124 */       result[i] = twoDArray[i][0];
    /*     */     }
    /* 126 */     return result;
    /*     */   }
    /*     */   
    /*     */   public static String[] merge1D(String[] oneDArray1, String[] oneDArray2) {
    /* 130 */     int size1 = 0;
    /* 131 */     int size2 = 0;
    /*     */     
    /* 133 */     if (oneDArray1 != null)
    /* 134 */       size1 = oneDArray1.length;
    /* 135 */     if (oneDArray2 != null) {
    /* 136 */       size2 = oneDArray2.length;
    /*     */     }
    /* 138 */     String[] merge1DArray = new String[size1 + size2];
    /* 139 */     for (int i = 0; i < size1; i++) {
    /* 140 */       merge1DArray[i] = oneDArray1[i];
    /*     */     }
    /* 142 */     for (int i = 0; i < size2; i++) {
    /* 143 */       merge1DArray[(i + size1)] = oneDArray2[i];
    /*     */     }
    /* 145 */     return merge1DArray;
    /*     */   }
    /*     */   
    /*     */   public static String[] merge1D(String[] oneDArray1, String stringToMerge) {
    /* 149 */     if (oneDArray1 == null) {
    /* 150 */       String[] result = new String[1];
    /* 151 */       result[0] = new String(stringToMerge);
    /* 152 */       return result;
    /*     */     }
    /* 154 */     String[] result = new String[oneDArray1.length + 1];
    /* 155 */     for (int i = 0; i < oneDArray1.length; i++) {
    /* 156 */       result[i] = oneDArray1[i];
    /*     */     }
    /* 158 */     result[oneDArray1.length] = stringToMerge;
    /* 159 */     return result;
    /*     */   }
    /*     */   
    /*     */   public static String splitForIn(String[] oneDArray) {
    /* 163 */     if ((oneDArray == null) || (oneDArray.length == 0)) {
    /* 164 */       return null;
    /*     */     }
    /* 166 */     StringBuffer idStr = new StringBuffer("");
    /* 167 */     for (String str : oneDArray) {
    /* 168 */       idStr.append("'").append(str).append("',");
    /*     */     }
    /* 170 */     return idStr.substring(0, idStr.length() - 1);
    /*     */   }
    /*     */   
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */   public static String splitListToStr(List<String> list, String delimiter)
    /*     */   {
    /* 181 */     if ((list == null) || (list.size() == 0)) {
    /* 182 */       return null;
    /*     */     }
    /* 184 */     StringBuffer idStr = new StringBuffer("");
    /* 185 */     for (int i = list.size() - 1; i > -1; i--) {
    /* 186 */       String ss = (String)list.get(i);
    /* 187 */       idStr.append(ss).append(delimiter);
    /*     */     }
    /* 189 */     return idStr.substring(0, idStr.length() - 1);
    /*     */   }
    /*     */   
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */   public static String splitArrayToStr(Object[] arr, String delimiter)
    /*     */   {
    /* 199 */     String result = "";
    /* 200 */     if ((arr != null) && (arr.length > 0)) {
    /* 201 */       for (int i = 0; i < arr.length; i++) {
    /* 202 */         if (i + 1 == arr.length) {
    /* 203 */           result = result + arr[i];
    /*     */         } else {
    /* 205 */           result = result + arr[i] + delimiter;
    /*     */         }
    /*     */       }
    /*     */     }
    /* 209 */     return result;
    /*     */   }
    /*     */   
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */   public static String getArrayStrByIndex(Object[] arr, int index, String delimiter)
    /*     */   {
    /* 221 */     String result = "";
    /* 222 */     if ((arr != null) && (arr.length > 0)) {
    /* 223 */       for (int i = 0; i <= index; i++) {
    /* 224 */         if (i == index) {
    /* 225 */           result = result + arr[i];
    /*     */         } else {
    /* 227 */           result = result + arr[i] + delimiter;
    /*     */         }
    /*     */       }
    /*     */     }
    /* 231 */     return result;
    /*     */   }
    /*     */   

    /*     */   
    /*     */   public static Integer add(Integer int1, Integer int2) {
    /* 278 */     return Integer.valueOf(int1.intValue() + int2.intValue());
    /*     */   }
    /*     */   
    /*     */   public static Integer subtract(Integer int1, Integer int2) {
    /* 282 */     return Integer.valueOf(int1.intValue() - int2.intValue());
    /*     */   }
    /*     */   
    /*     */   public static BigDecimal add(BigDecimal int1, Integer int2) {
    /* 286 */     return int1.add(BigDecimal.valueOf(int2.intValue()));
    /*     */   }
    /*     */   
    /*     */   public static Set<Integer> authStringToSet(String auth) {
    /* 290 */     Set authSet = new HashSet();
    /* 291 */     if (auth == null) {
    /* 292 */       return authSet;
    /*     */     }
    /* 294 */     String[] auths = auth.split(",");
    /* 295 */     for (int i = 0; i < auths.length; i++) {
    /* 296 */       authSet.add(Integer.valueOf(Integer.parseInt(auths[i])));
    /*     */     }
    /* 298 */     return authSet;
    /*     */   }
    /*     */   
    /*     */   public static String authSetToString(Set<Integer> auth) {
    /* 302 */     if (auth == null)
    /* 303 */       return "";
    /* 304 */     String authString = "";
    /* 305 */     Iterator iter = auth.iterator();
    /* 306 */     while (iter.hasNext()) {
    /* 307 */       authString = authString + iter.next() + ",";
    /*     */     }
    /* 309 */     if (authString.length() == 0)
    /* 310 */       return "";
    /* 311 */     authString = authString.substring(0, authString.length() - 1);
    /*     */     
    /* 313 */     return authString;
    /*     */   }
    /*     */   
    /*     */   public static String message(String message, Object[] variables) {
    /* 317 */     String output = MessageFormat.format(message, variables);
    /* 318 */     return output;
    /*     */   }
    /*     */   
    /*     */   public static String formatBDToS(BigDecimal value, String[] format) {
    /* 322 */     if (value == null) {
    /* 323 */       return null;
    /*     */     }
    /* 325 */     String DCformat = "##########0.00";
    /* 326 */     if ((format.length > 0) && (!isEmpty(format[0]))) {
    /* 327 */       DCformat = format[0];
    /*     */     }
    /* 329 */     DecimalFormat decimalFormat = new DecimalFormat(DCformat);
    /* 330 */     return decimalFormat.format(value);
    /*     */   }
    /*     */   
    /*     */   public static String setToString(Set<String> setMsg) {
    /* 334 */     if (setMsg == null)
    /* 335 */       return " ";
    /* 336 */     String msgString = "";
    /* 337 */     Iterator iter = setMsg.iterator();
    /* 338 */     while (iter.hasNext()) {
    /* 339 */       msgString = msgString + iter.next() + ", ";
    /*     */     }
    /* 341 */     if (msgString.length() == 0)
    /* 342 */       return " ";
    /* 343 */     msgString = msgString.substring(0, msgString.length() - 2);
    /*     */     
    /* 345 */     return msgString;
    /*     */   }
    /*     */   
    /*     */   public static String getClassName(Object obj) {
    /* 349 */     if (obj == null)
    /* 350 */       return null;
    /* 351 */     String className = obj.getClass().getName();
    /* 352 */     int index = className.lastIndexOf(".");
    /* 353 */     return className.substring(index + 1);
    /*     */   }
    /*     */   
    /*     */   public static String getClassNameLowCase(Object obj) {
    /* 357 */     return getClassName(obj).toLowerCase();
    /*     */   }
    /*     */   
    /*     */   public static String messageNoErrCode(String message, Object[] variables) {
    /* 361 */     String output = MessageFormat.format(message, variables);
    /* 362 */     int index = output.indexOf(":");
    /* 363 */     if ((index >= 0) && (index <= 16)) {
    /* 364 */       return output.substring(index + 1);
    /*     */     }
    /* 366 */     return output;
    /*     */   }
    /*     */   
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */   public static boolean isNull(String str)
    /*     */   {
    /* 376 */     if (str == null) {
    /* 377 */       return true;
    /*     */     }
    /*     */     
    /* 380 */     return false;
    /*     */   }
    /*     */   
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */   public static boolean isEmpty(Object str)
    /*     */   {
    /* 390 */     if (str == null) {
    /* 391 */       return true;
    /*     */     }
    /*     */     
    /* 394 */     if (("".equals(str.toString().trim())) || ("NULL".equals(str.toString().trim())) || 
    /* 395 */       ("null".equals(str.toString().trim()))) {
    /* 396 */       return true;
    /*     */     }
    /*     */     
    /* 399 */     return false;
    /*     */   }
    /*     */   
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */   public static String getStrValue(String str)
    /*     */   {
    /* 409 */     String temp = "";
    /* 410 */     if (!isEmpty(str)) {
    /* 411 */       temp = str.trim();
    /*     */     }
    /* 413 */     return temp;
    /*     */   }
    /*     */   
    /*     */   public static boolean isUpperCase(String value) {
    /* 417 */     boolean isUpperCase = false;
    /* 418 */     if (isNotEmpty(value)) {
    /* 419 */       for (int i = 0; i < value.length(); i++) {
    /* 420 */         if (Character.isLowerCase(value.charAt(i))) {
    /* 421 */           return false;
    /*     */         }
    /*     */       }
    /* 424 */       isUpperCase = true;
    /*     */     }
    /* 426 */     return isUpperCase;
    /*     */   }
    /*     */   
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */   public static boolean isNotEmpty(Object str)
    /*     */   {
    /* 436 */     if (str == null) {
    /* 437 */       return false;
    /*     */     }
    /*     */     
    /* 440 */     if ("".equals(str.toString().trim())) {
    /* 441 */       return false;
    /*     */     }
    /*     */     
    /* 444 */     return true;
    /*     */   }
    /*     */   
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */   public static boolean isNum(String strIn)
    /*     */   {
    /* 454 */     String s = "1234567890";
    /* 455 */     int i = 0;
    /* 456 */     boolean b = true;
    /*     */     
    /* 458 */     if ((strIn == null) || ("".equals(strIn))) {
    /* 459 */       return false;
    /*     */     }
    /* 461 */     for (i = 0; i < strIn.length(); i++) {
    /* 462 */       if (s.indexOf(strIn.charAt(i)) < 0) {
    /* 463 */         b = false;
    /* 464 */         break;
    /*     */       }
    /*     */     }
    /* 467 */     return b;
    /*     */   }
    /*     */   
    /*     */   public static String convertSpecialChars(String origin_text)
    /*     */   {
    /* 472 */     String convertedStr = origin_text != null ? origin_text : "";
    /*     */     
    /* 474 */     if (convertedStr.indexOf("\"") >= 0)
    /*     */     {
    /* 476 */       convertedStr = convertedStr.replaceAll("\"", "&quot;");
    /*     */     }
    /* 478 */     if (convertedStr.indexOf("'") >= 0)
    /*     */     {
    /* 480 */       convertedStr = convertedStr.replaceAll("'", "&#146;");
    /*     */     }
    /* 482 */     if (convertedStr.indexOf("<") >= 0)
    /*     */     {
    /* 484 */       convertedStr = convertedStr.replaceAll("<", "&lt;");
    /*     */     }
    /* 486 */     if (convertedStr.indexOf(">") >= 0)
    /*     */     {
    /* 488 */       convertedStr = convertedStr.replaceAll(">", "&gt;");
    /*     */     }
    /*     */     
    /* 491 */     return convertedStr;
    /*     */   }
    /*     */   
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */   public static String genRandomStr(int pwd_len)
    /*     */   {
    /* 502 */     int maxNum = 36;
    /*     */     
    /* 504 */     int count = 0;
    /* 505 */     char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    /*     */     
    /*     */ 
    /* 508 */     StringBuffer pwd = new StringBuffer("");
    /* 509 */     Random r = new Random();
    /* 510 */     while (count < pwd_len)
    /*     */     {
    /* 512 */       int i = Math.abs(r.nextInt(36));
    /* 513 */       if ((i >= 0) && (i < str.length)) {
    /* 514 */         pwd.append(str[i]);
    /* 515 */         count++;
    /*     */       }
    /*     */     }
    /*     */     
    /* 519 */     return pwd.toString();
    /*     */   }
    /*     */   
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */   public static String genRandomNum(int pwd_len)
    /*     */   {
    /* 530 */     int maxNum = 10;
    /*     */     
    /* 532 */     int count = 0;
    /* 533 */     char[] str = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    /*     */     
    /* 535 */     StringBuffer pwd = new StringBuffer("");
    /* 536 */     Random r = new Random();
    /* 537 */     while (count < pwd_len)
    /*     */     {
    /* 539 */       int i = Math.abs(r.nextInt(10));
    /* 540 */       if ((i >= 0) && (i < str.length)) {
    /* 541 */         pwd.append(str[i]);
    /* 542 */         count++;
    /*     */       }
    /*     */     }
    /* 545 */     return pwd.toString();
    /*     */   }
    /*     */   
    /*     */ 
    /*     */ 
    /*     */   public static Object getArrayValue(Object[] arrays, int index)
    /*     */   {
    /* 585 */     if (index >= arrays.length) {
    /* 586 */       return null;
    /*     */     }
    /* 588 */     return arrays[index];
    /*     */   }
    /*     */   
    /*     */   public static String toSql(Object sour) {
    /* 592 */     return toStr(sour).replaceAll("'", "''").replaceAll("[%\\[]", "");
    /*     */   }
    /*     */   
    /*     */   public static String toSqlInsert(Object sour) {
    /* 596 */     return toStr(sour).replaceAll("'", "''");
    /*     */   }
    /*     */   
    /*     */   public static String toStr(Object sour) {
    /* 600 */     return toStr(sour, "");
    /*     */   }
    /*     */   
    /*     */   public static String toStr(Object sour, String init) {
    /* 604 */     String dest = init;
    /*     */     try {
    /* 606 */       if ((sour != null) && (sour.toString().trim().length() > 0)) {
    /* 607 */         dest = sour.toString();
    /*     */       }
    /*     */     } catch (Exception e) {
    /* 610 */       dest = init;
    /*     */     }
    /* 612 */     return dest.trim();
    /*     */   }
    /*     */   
    /*     */   public static String right(String sour, int length) {
    /* 616 */     if (sour == null)
    /* 617 */       return null;
    /* 618 */     if (sour.length() > length) {
    /* 619 */       return sour.substring(sour.length() - length, sour.length());
    /*     */     }
    /* 621 */     return sour;
    /*     */   }
    /*     */   
    /*     */   public static String left(String sour, int length) {
    /* 625 */     if (sour == null)
    /* 626 */       return null;
    /* 627 */     if (sour.length() > length) {
    /* 628 */       return sour.substring(0, length);
    /*     */     }
    /* 630 */     return sour;
    /*     */   }
    /*     */   
    /*     */   public static String elapsedDate(long millisecond) {
    /* 634 */     String returnValue = "";
    /* 635 */     long s = millisecond / 1000L;
    /* 636 */     long y = s / 31536000L;
    /* 637 */     s %= 31536000L;
    /* 638 */     long d = s / 86400L;
    /* 639 */     s %= 86400L;
    /* 640 */     long h = s / 3600L;
    /* 641 */     s %= 3600L;
    /* 642 */     long m = s / 60L;
    /* 643 */     s %= 60L;
    /* 644 */     if (y > 0L)
    /* 645 */       returnValue = y + "年";
    /* 646 */     if (d > 0L)
    /* 647 */       returnValue = returnValue + d + "天";
    /* 648 */     if (h > 0L)
    /* 649 */       returnValue = returnValue + h + "时";
    /* 650 */     if (m > 0L)
    /* 651 */       returnValue = returnValue + m + "分";
    /* 652 */     if (s > 0L)
    /* 653 */       returnValue = returnValue + s + "秒";
    /* 654 */     return returnValue;
    /*     */   }
    /*     */   
    /*     */   public static Integer toInt(Object sour, Integer init) {
    /* 658 */     Integer dest = init;
    /*     */     try {
    /* 660 */       if (sour != null) {
    /* 661 */         dest = Integer.valueOf(Integer.parseInt(String.valueOf(sour)));
    /*     */       }
    /*     */     } catch (Exception e) {
    /* 664 */       dest = init;
    /*     */     }
    /* 666 */     return dest;
    /*     */   }
    /*     */   
    /*     */   public static int toInt(Object sour) {
    /* 670 */     return toInt(sour, Integer.valueOf(0)).intValue();
    /*     */   }
    /*     */   
    /*     */   public static boolean isNumeric(String str) {
    /* 674 */     if ((str == null) || (str.length() == 0)) {
    /* 675 */       return false;
    /*     */     }
    /* 677 */     int i = str.length(); for (;;) { i--; if (i < 0) break;
    /* 678 */       int chr = str.charAt(i);
    /* 679 */       if ((chr < 48) || (chr > 57))
    /* 680 */         return false;
    /*     */     }
    /* 682 */     return true;
    /*     */   }
    /*     */   
    /*     */   public static float toFloat(Object sour) {
    /* 686 */     return toFloat(sour, 0.0F);
    /*     */   }
    /*     */   
    /*     */   public static float toFloat(Object sour, float init) {
    /* 690 */     float dest = init;
    /*     */     try {
    /* 692 */       if (sour != null) {
    /* 693 */         dest = Float.parseFloat(sour.toString());
    /*     */       }
    /*     */     } catch (Exception e) {
    /* 696 */       dest = init;
    /*     */     }
    /* 698 */     return dest;
    /*     */   }
    /*     */   
    /*     */   public static short toShort(Object sour) {
    /* 702 */     short dest = 0;
    /*     */     try {
    /* 704 */       if (sour != null) {
    /* 705 */         dest = Short.parseShort(sour.toString());
    /*     */       }
    /*     */     } catch (Exception e) {
    /* 708 */       dest = 0;
    /*     */     }
    /* 710 */     return dest;
    /*     */   }
    /*     */   
    /*     */   public static long toLong(Object sour, long init) {
    /* 714 */     long dest = init;
    /*     */     try {
    /* 716 */       if (sour != null) {
    /* 717 */         dest = Long.parseLong(sour.toString());
    /*     */       }
    /*     */     } catch (Exception e) {
    /* 720 */       dest = init;
    /*     */     }
    /* 722 */     return dest;
    /*     */   }
    /*     */   
    /*     */   public static long toLong(Object sour) {
    /* 726 */     return toLong(sour, 0L);
    /*     */   }
    /*     */   
    /*     */   public static BigDecimal toBigDecimal(String sour)
    /*     */   {
    /* 731 */     if (isEmpty(sour)) {
    /* 732 */       return BigDecimal.ZERO;
    /*     */     }
    /*     */     try {
    /* 735 */       return new BigDecimal(sour);
    /*     */     } catch (Exception e) {
    /* 737 */       System.out.println(sour + " :" + e.getMessage());
    /* 738 */       e.printStackTrace(); }
    /* 739 */     return BigDecimal.ZERO;
    /*     */   }
    /*     */   
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */   public static List removeDuplicate(List list)
    /*     */   {
    /* 766 */     HashSet h = new HashSet(list);
    /* 767 */     list.clear();
    /* 768 */     list.addAll(h);
    /* 769 */     return list;
    /*     */   }
    /*     */   
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */   public static List removeDuplicateObj(List list)
    /*     */   {
    /* 778 */     Set set = new HashSet();
    /* 779 */     List newList = new ArrayList();
    /* 780 */     for (Iterator iter = list.iterator(); iter.hasNext();) {
    /* 781 */       Object element = iter.next();
    /* 782 */       if (set.add(element))
    /* 783 */         newList.add(element);
    /*     */     }
    /* 785 */     return newList;
    /*     */   }
    /*     */   
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */   public static String[] delArrItemByIndex(String[] str, int index)
    /*     */   {
    /* 794 */     List<String> list = new ArrayList();
    /* 795 */     for (int i = 0; i < str.length; i++) {
    /* 796 */       list.add(str[i]);
    /*     */     }
    /* 798 */     list.remove(index);
    /*     */     
    /*     */ 
    /* 801 */     String[] newStr = (String[])list.toArray(new String[1]);
    /* 802 */     return newStr;
    /*     */   }
    /*     */   
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */   public static <T> boolean contains(T[] array, T v)
    /*     */   {
    /* 811 */     for (T e : array) {
    /* 812 */       if ((e == v) || ((v != null) && (v.equals(e))))
    /* 813 */         return true;
    /*     */     }
    /* 815 */     return false;
    /*     */   }
    /*     */   
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */   public static int getArrayIndexByValue(String[] strs, String value)
    /*     */   {
    /* 824 */     if ((strs != null) && (strs.length > 0)) {
    /* 825 */       for (int i = strs.length - 1; i >= 0; i--) {
    /* 826 */         if (value.equals(strs[i])) {
    /* 827 */           return i;
    /*     */         }
    /*     */       }
    /*     */     }
    /* 831 */     return -1;
    /*     */   }
    /*     */   
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */   public static String[] getArrayOfMergeSameValue(String[] arr)
    /*     */   {
    /* 840 */     String[] newArr = null;
    /* 841 */     List<String> list = new ArrayList();
    /*     */     
    /* 843 */     if ((arr != null) && (arr.length > 0)) {
    /* 844 */       String temp = null;
    /* 845 */       for (String str : arr) {
    /* 846 */         if ((isNotEmpty(str)) && (!str.equals(temp))) {
    /* 847 */           temp = str;
    /* 848 */           list.add(str);
    /*     */         }
    /*     */       }
    /* 851 */       newArr = (String[])list.toArray(new String[list.size()]);
    /*     */     }
    /*     */     
    /* 854 */     return newArr;
    /*     */   }
    /*     */   
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */   public static String[] getArrayOfRemoveItem(String[] arr, String val)
    /*     */   {
    /* 863 */     String[] newArr = null;
    /* 864 */     List<String> list = new ArrayList();
    /*     */     
    /* 866 */     if ((arr != null) && (arr.length > 0)) {
    /* 867 */       for (String str : arr) {
    /* 868 */         if ((isNotEmpty(str)) && (!str.equals(val))) {
    /* 869 */           list.add(str);
    /*     */         }
    /*     */       }
    /* 872 */       newArr = (String[])list.toArray(new String[list.size()]);
    /*     */     }
    /*     */     
    /* 875 */     return newArr;
    /*     */   }
    /*     */   
    /*     */ 
    /*     */   
    /*     */   public static void sleep(int second) {
    /*     */     try {
    /* 908 */       Thread.currentThread();Thread.sleep(second * 1000);
    /*     */     }
    /*     */     catch (Exception localException) {}
    /*     */   }
    /*     */   
    /*     */   public static BigDecimal getRandomTemperature()
    /*     */   {
    /* 915 */     return new BigDecimal(String.format("%.2f", new Object[] { Double.valueOf(Math.random() * 30.0D) }));
    /*     */   }
    /*     */   
    /*     */ 
    /*     */ 
    /*     */   public static BigDecimal getRandomHumidity()
    /*     */   {
    /* 922 */     return new BigDecimal(String.format("%.2f", new Object[] { Double.valueOf(35.0D + Math.random() * 41.0D) }));
    /*     */   }
    /*     */   
    /*     */   public static String getDecodeString(String encodeString) {
    /* 926 */     return URLDecoder.decode(encodeString);
    /*     */   }
    /*     */  
    /*     */   }

