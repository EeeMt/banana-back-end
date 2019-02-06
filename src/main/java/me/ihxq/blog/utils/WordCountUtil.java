package me.ihxq.blog.utils;

import java.util.regex.Pattern;

/**
 * author: HuangXiquan <br/>
 * date: 2017/11/19/019 <br/>
 * time: 14:15 <br/>
 * description:
 */
public class WordCountUtil {


    /**
     * 中文字符
     */
    private int chCharacter = 0;

    /**
     * 英文字符
     */
    private int enCharacter = 0;
    private int jpCharacter = 0;
    /**
     * 空格
     */
    private int spaceCharacter = 0;

    /**
     * 数字
     */
    private int numberCharacter = 0;

    /**
     * 其他字符
     */
    private int otherCharacter = 0;

    /***
     * 统计字符串中中文，英文，数字，空格等字符个数
     * @param str 需要统计的字符串
     */
    public void count(String str) {
        if (null == str || str.equals("")) {
            System.out.println("字符串为空");
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            if ((tmp >= 'A' && tmp <= 'Z') || (tmp >= 'a' && tmp <= 'z')) {
                enCharacter++;
            } else if ((tmp >= '0') && (tmp <= '9')) {
                numberCharacter++;
            } else if (tmp == ' ') {
                spaceCharacter++;
            } else if (isChinese(tmp)) {
                chCharacter++;
            } else {
                otherCharacter++;
            }
        }
        System.out.println("字符串:" + str + "");
        System.out.println("中文字符有:" + chCharacter);
        System.out.println("英文字符有:" + enCharacter);
        System.out.println("数字有:" + numberCharacter);
        System.out.println("空格有:" + spaceCharacter);
        System.out.println("其他字符有:" + otherCharacter);
    }

    /***
     * 判断字符是否为中文
     * @param ch 需要判断的字符
     * @return 中文返回true，非中文返回false
     */
    private boolean isChinese(char ch) {
        //获取此字符的UniCodeBlock
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(ch);
        //  GENERAL_PUNCTUATION 判断中文的“号
        //  CJK_SYMBOLS_AND_PUNCTUATION 判断中文的。号
        //  HALFWIDTH_AND_FULLWIDTH_FORMS 判断中文的，号
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
            System.out.println(ch + " 是中文");
            return true;
        }
        if (ub == Character.UnicodeBlock.HIRAGANA) {
            System.out.println(ch + " 是日文");
        }
        return false;
    }

    public static void main(String[] args) {
        // String str = "adbs13姿z势12年概~3!a @x # $率 论zs12 szsgss  1234@#￥說說愛き ，。？！%……&*（）——{}【】";
        // String str = "你好啊 hello";
        // String str = "あいうえおかきくけこさしすせそたちつてとなにぬねのはひふへほまみむめもやいゆえよらりるれろわいうんを";
        String str = "アイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤイユエヨラリルレロワイウンヲ";
        WordCountUtil countCharacter = new WordCountUtil();
        countCharacter.count(str);

    }

}

class CharUtil {

    public static void main(String[] args) {
        String[] strArr = new String[]{"www.micmiu.com", "!@#$%^&*()_+{}[]|\"'?/:;<>,.", "！￥……（）——：；“”‘’《》，。？、", "不要啊", "やめて", "韩佳人", "???"};
        for (String str : strArr) {
            System.out.println("===========> 测试字符串：" + str);
            System.out.println("正则判断结果：" + isChineseByREG(str) + " -- " + isChineseByName(str));
            System.out.println("Unicode判断结果 ：" + isChinese(str));
            System.out.println("详细判断列表：");
            char[] ch = str.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                char c = ch[i];
                System.out.println(c + " --> " + (isChinese(c) ? "是" : "否"));
            }
        }
    }

    // 根据Unicode编码完美的判断中文汉字和符号
    private static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
            return true;
        }
        return false;
    }

    // 完整的判断中文汉字和符号
    public static boolean isChinese(String strName) {
        char[] ch = strName.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (isChinese(c)) {
                return true;
            }
        }
        return false;
    }

    // 只能判断部分CJK字符（CJK统一汉字）
    public static boolean isChineseByREG(String str) {
        if (str == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("[\\u4E00-\\u9FBF]+");
        return pattern.matcher(str.trim()).find();
    }

    // 只能判断部分CJK字符（CJK统一汉字）
    public static boolean isChineseByName(String str) {
        if (str == null) {
            return false;
        }
        // 大小写不同：\\p 表示包含，\\P 表示不包含
        // \\p{Cn} 的意思为 Unicode 中未被定义字符的编码，\\P{Cn} 就表示 Unicode中已经被定义字符的编码
        String reg = "\\p{InCJK Unified Ideographs}&&\\P{Cn}";
        Pattern pattern = Pattern.compile(reg);
        return pattern.matcher(str.trim()).find();
    }
}