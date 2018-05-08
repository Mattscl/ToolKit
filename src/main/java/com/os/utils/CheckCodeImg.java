package com.os.utils;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * 类说明： web登录页面验证码，原理：
 *  在后台指定验证码的所有字符总集合，然后用random随机获取集合中的几个字符
 *  作为验证码。验证码生成后再用awt为这几个字符加上噪点
 *  生成图片，通过BufferedImage类传到前台img的src属性即可
 * Created by Administrator on 2018/5/8.
 */
public class CheckCodeImg
{

    /**
     * 方法说明： 获取校验码
     * @param length  验证码长度
     * @param level  验证码难度
     * @param isCanRepeat  能否出现重复字符
     * @return  String 验证码
     */
    public static String getSecurityCode(int length, int level, Boolean isCanRepeat)
    {
        //字符集合，出掉容易混淆的字母o和数字0、字母l和数字1
        char[] codes =
                {'1','2','3','4','5','6','7','8','9'
                        ,'a','b','c','d','e','f','g'
                        ,'h','i','j','k','l','m','n'
                        ,'o','p','q','r','s','t','u'
                        ,'v','w','x','y','z'
                        ,'A','B','C','D','E','F','G'
                        ,'H','I','J','K','L','M','N'
                        ,'O','P','Q','R','S','T','U'
                        ,'V','W','X','Y','Z'

        };
        //根据难度筛选验证码的字符集合
        if(level == 0)
        {
            codes = Arrays.copyOfRange(codes,0,9);
        }
        //获取字符集合的长度
        int n = codes.length;
        //当验证码位数大于字符集合长度且不允许重复时，抛出运行时异常
        if(length > n && isCanRepeat == false)
        {
            throw new RuntimeException(String.format(
                    "调用CheckCodeImg.getSecurityCode(%1$s,%2$s,%3$s)出现异常，"
                    + "当isCanRepeat为%3$s时，传入参数%1$s不能大于%4$s",length,level,isCanRepeat,n
            ));
        }
        //存放抽取出的验证码
        char[] result = new char[length];
        //判断验证码是否允许重复
        if(isCanRepeat)
        {
            for(int i = 0;i<result.length;i++)
            {
                result[i] = codes[(int)(Math.random()*n)];
            }
        }
        else
        {
            for(int i = 0;i<result.length;i++)
            {
                int r = (int)(Math.random() * n);
                result[i] = codes[r];
                //必须确保不会再次抽取到已经抽取到的字符串
                //因为所有的字符串必须不一样！，所以把已经选中的从codes中移除
                codes[r] = codes[--n];  //把最后一个元素替代指定的元素，然后数组缩容，其实就是将指定元素移除
            }
        }
        return String.valueOf(result);
    }

    /**
     * 绘制图片及噪点
     * @param securityCode  校验码
     * @return
     */
    public static BufferedImage createImg(String securityCode)
    {
        //验证码长度
        int codeLength = securityCode.length();
        //字体大小
        int fSize = 15;
        int fWidth = fSize + 1;
        //图片宽度
        int width = codeLength * fWidth + 6;
        //图片高度
        int height = fSize * 2 + 1;

        //图片
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics g = image.createGraphics();

        //设置背景色
        g.setColor(Color.white);
        //填充背景
        g.fillRect(0,0,width,height);

        //设置边框颜色
        g.setColor(Color.LIGHT_GRAY);
        //边框字体样式
        g.setFont(new Font("Arial",Font.BOLD,height - 2));
        //绘制边框
        g.drawRect(0,0,width - 1,height - 1);

        //绘制噪点
        int codeY = height - 10;
        //设置字体颜色和样式
        g.setColor(new Color(19,148,246));
        g.setFont(new Font("Georiga",Font.BOLD,fSize));
        for(int i=0;i<codeLength;i++)
        {
            g.drawString(String.valueOf(securityCode.charAt(i)),i * 16 + 5,codeY);
        }
        //关闭资源
        g.dispose();
        return image;
    }

    private static ByteArrayInputStream convertImageToStream(BufferedImage image)
    {
        ByteArrayInputStream inputStream = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        JPEGImageEncoder jpeg = JPEGCodec.createJPEGEncoder(bos);
        try
        {
            jpeg.encode(image);
            byte[] bts = bos.toByteArray();
            inputStream = new ByteArrayInputStream(bts);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return inputStream;
    }
}
