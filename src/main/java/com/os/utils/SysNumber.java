//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.os.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SysNumber {
    private static final String[] CN_UPPER_NUMBER = new String[]{"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    private static final String[] CN_UPPER_MONETRAY_UNIT = new String[]{"分", "角", "元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "兆", "拾", "佰", "仟"};
    private static final String CN_FULL = "整";
    private static final String CN_NEGATIVE = "负";
    private static final int MONEY_PRECISION = 2;
    private static final String CN_ZEOR_FULL = "零元整";

    public SysNumber() {
    }

    public static String num2Money(BigDecimal numberOfMoney) {
        StringBuffer sb = new StringBuffer();
        int signum = numberOfMoney.signum();
        if(signum == 0) {
            return "零元整";
        } else {
            long number = numberOfMoney.movePointRight(2).setScale(0, 4).abs().longValue();
            long scale = number % 100L;
            boolean numUnit = false;
            int numIndex = 0;
            boolean getZero = false;
            if(scale <= 0L) {
                numIndex = 2;
                number /= 100L;
                getZero = true;
            }

            if(scale > 0L && scale % 10L <= 0L) {
                numIndex = 1;
                number /= 10L;
                getZero = true;
            }

            for(int zeroSize = 0; number > 0L; ++numIndex) {
                int var11 = (int)(number % 10L);
                if(var11 > 0) {
                    if(numIndex == 9 && zeroSize >= 3) {
                        sb.insert(0, CN_UPPER_MONETRAY_UNIT[6]);
                    }

                    if(numIndex == 13 && zeroSize >= 3) {
                        sb.insert(0, CN_UPPER_MONETRAY_UNIT[10]);
                    }

                    sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                    sb.insert(0, CN_UPPER_NUMBER[var11]);
                    getZero = false;
                    zeroSize = 0;
                } else {
                    ++zeroSize;
                    if(!getZero) {
                        sb.insert(0, CN_UPPER_NUMBER[var11]);
                    }

                    if(numIndex == 2) {
                        if(number > 0L) {
                            sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                        }
                    } else if((numIndex - 2) % 4 == 0 && number % 1000L > 0L) {
                        sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                    }

                    getZero = true;
                }

                number /= 10L;
            }

            if(signum == -1) {
                sb.insert(0, "负");
            }

            if(scale <= 0L) {
                sb.append("整");
            }

            return sb.toString();
        }
    }

    public static String percent(double f, int iDigit) {
        NumberFormat nf = NumberFormat.getPercentInstance();
        nf.setMaximumFractionDigits(iDigit);
        return nf.format(f);
    }

    public static double round(double value, int iDigit) {
        BigDecimal bd = new BigDecimal(value);
        BigDecimal nvalue = bd.setScale(iDigit, 4);
        return nvalue.doubleValue();
    }

    public static boolean isNumber(String str) {
        try {
            if(SysString.isEmpty(str)) {
                return true;
            } else {
                str = str.replace(",", "").replace("%", "").replace("‰", "");
                double e = Double.parseDouble(str);
                return !Double.isInfinite(e) && !Double.isNaN(e);
            }
        } catch (Exception var3) {
            return false;
        }
    }

    public static int getMapInt(Map<String, Object> map, String sKey) {
        return toInt(map.get(sKey));
    }

    public static double getMapDouble(Map<String, Object> map, String sKey) {
        return toDouble(map.get(sKey));
    }

    public static double toDouble(Object obj) {
        double d = 0.0D;
        d = toDouble(obj, 2);
        return d;
    }

    public static double toDouble(Object obj, int iDigit) {
        double d = 0.0D;
        if(obj != null && !"".equals(obj.toString())) {
            try {
                String e = obj.toString();
                e = e.replace(",", "");
                if(e.indexOf("%") != -1) {
                    d = Double.parseDouble(e.replace("%", "")) / 100.0D;
                } else if(e.indexOf("‰") != -1) {
                    d = Double.parseDouble(e.replace("‰", "")) / 1000.0D;
                } else {
                    d = Double.parseDouble(e);
                    BigDecimal big = new BigDecimal(d);
                    d = big.setScale(iDigit, 4).doubleValue();
                }
            } catch (Exception var6) {
                d = 0.0D;
            }
        }

        return d;
    }

    public static String toString(Object obj) {
        String str = "";

        try {
            if(obj == null) {
                str = "";
            } else {
                if(!(obj instanceof Double) && !(obj instanceof Float)) {
                    str = obj.toString();
                } else {
                    str = String.format("%f", new Object[]{obj});
                }

                if(str.equalsIgnoreCase("NaN") || str.equalsIgnoreCase("Infinitely")) {
                    str = "";
                }
            }
        } catch (Exception var3) {
            ;
        }

        return str;
    }

    public static int toInt(Object obj) {
        try {
            double e = toDouble(obj);
            if(!Double.isInfinite(e) && !Double.isNaN(e)) {
                BigDecimal bd = new BigDecimal(e);
                return bd.setScale(0, 4).intValue();
            } else {
                return 0;
            }
        } catch (Exception var4) {
            return 0;
        }
    }

    public static String getPercent(int divisor, int dividend) {
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(1);
        decimalFormat.setMinimumFractionDigits(1);
        String percent;
        if(divisor != 0) {
            percent = decimalFormat.format((double)dividend * 100.0D / (double)divisor) + "%";
            return percent;
        } else {
            percent = decimalFormat.format(0.0D) + "%";
            return percent;
        }
    }

    public static int random(int min, int max) {
        return (int)Math.round(Math.random() * (double)(max - min) + (double)min);
    }

    public static List<Integer> toBinaryList(int number) {
        ArrayList list = new ArrayList();
        String binaryString = Integer.toBinaryString(number);

        for(int i = 0; i < binaryString.length(); ++i) {
            if(binaryString.charAt(i) == 49) {
                list.add(Integer.valueOf((int)Math.pow(2.0D, (double)(binaryString.length() - i - 1))));
            }
        }

        return list;
    }
}
