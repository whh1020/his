package com.qhit.utils; /**
 * Change chinese to pin yin 中文转拼音
 */

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class ZhongWenToPinYin {

    /*
    获取汉字的拼音，小写首字母缩写，大写首字母缩写
     */
    public static String getPinyin(String zhongwen) {
        //创建汉语拼音处理类
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        //设置音调
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        //设置小写
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        String result = "";
        try {
            result = PinyinHelper.toHanyuPinyinString(zhongwen,format,"");
        } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
            badHanyuPinyinOutputFormatCombination.printStackTrace();
        }
        return result;
    }

    /*
   获取汉字的拼音，小写首字母缩写，大写首字母缩写
    */
    public static String getPinyinFirstLetter(String zhongwen) {
        //创建汉语拼音处理类
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        //设置音调
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        //设置小写
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        String result = "";
        try {
            String pinyin = PinyinHelper.toHanyuPinyinString(zhongwen,format,",");
            String[] arr = pinyin.split(",");
            for(String py:arr){
                result+=py.charAt(0);
            }

        } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
            badHanyuPinyinOutputFormatCombination.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "中文";
        String pinyin = ZhongWenToPinYin.getPinyin(str);
        String pinyinFirstLetter = ZhongWenToPinYin.getPinyinFirstLetter(str);
        System.out.println(pinyin);
        System.out.println(pinyinFirstLetter);
    }

}

 