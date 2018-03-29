package com.memuli.oysterhutweb.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * 验证码抽象类,暂时不支持中文
 */
public class Captcha {
    private static final Logger LOGGER = LoggerFactory.getLogger(Captcha.class);
    private static final Random RANDOM = new Random();
    //定义验证码字符.去除了O和I等容易混淆的字母
    public static final char ALPHA[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'G', 'K', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '2', '3', '4', '5', '6', '7', '8', '9'};
    protected Font font = new Font("Verdana", Font.ITALIC | Font.BOLD, 28); // 字体

    private int len = 5; // 验证码随机字符长度
    private int width = 150; // 验证码显示跨度
    private int height = 40; // 验证码显示高度

    public Captcha() {
    }

    public Captcha(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Captcha(int width, int height, int len) {
        this(width, height);
        this.len = len;
    }

    public Captcha(int width, int height, int len, Font font) {
        this(width, height, len);
        this.font = font;
    }

    /**
     * 产生两个数之间的随机数
     */
    public static int num(int min, int max) {
        return min + RANDOM.nextInt(max - min);
    }

    /**
     * 产生0--num的随机数,不包括num
     */
    public static int num(int num) {
        return RANDOM.nextInt(num);
    }

    public static char alpha() {
        return ALPHA[num(0, ALPHA.length)];
    }

    /**
     * 生成随机字符数组
     */
    protected char[] alphas() {
        char[] cs = new char[len];
        for (int i = 0; i < len; i++) {
            cs[i] = alpha();
        }
        return cs;
    }

    /**
     * 给定范围获得随机颜色
     */
    protected Color color(int fc, int bc) {
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + num(bc - fc);
        int g = fc + num(bc - fc);
        int b = fc + num(bc - fc);
        return new Color(r, g, b);
    }

    /**
     * 验证码输出
     */
    public void out(OutputStream out, HttpServletRequest request) {
        graphicsImage(alphas(), out, request);
    }

    /**
     * 画随机码图
     */
    private boolean graphicsImage(char[] strs, OutputStream out, HttpServletRequest request) {
        boolean ok = false;
        try {
            BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = (Graphics2D) bi.getGraphics();
            AlphaComposite ac3;
            Color color;
            int len = strs.length;
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, width, height);
            // 随机画干扰的蛋蛋
            for (int i = 0; i < 15; i++) {
                color = color(150, 250);
                g.setColor(color);
                g.drawOval(num(width), num(height), 5 + num(10), 5 + num(10));// 画蛋蛋，有蛋的生活才精彩
                color = null;
            }
            g.setFont(font);
            int h = height - ((height - font.getSize()) >> 1),
                    w = width / len,
                    size = w - font.getSize() + 1;
            /* 画字符串 */
            for (int i = 0; i < len; i++) {
                ac3 = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f);// 指定透明度
                g.setComposite(ac3);
                color = new Color(20 + num(110), 20 + num(110), 20 + num(110));// 对每个字符都用随机颜色
                g.setColor(color);
                g.drawString(strs[i] + "", (width - (len - i) * w) + size, h - 4);
                color = null;
                ac3 = null;
            }
            HttpSession session = request.getSession(true);
            //存入Session
            String chars = new String(strs);
            session.setAttribute("_code", chars.toLowerCase());
            LOGGER.info("Captcha.graphicsImage 验证码：" + chars);
            ImageIO.write(bi, "png", out);
            out.flush();
            ok = true;
        } catch (IOException e) {
            ok = false;
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ok;
    }

}