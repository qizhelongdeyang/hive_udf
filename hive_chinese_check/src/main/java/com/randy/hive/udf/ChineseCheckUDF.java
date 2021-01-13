package com.randy.hive.udf;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hive.ql.exec.UDF;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : RandySun (sunfeng152157@sina.com)
 * @date : 2021-01-13  10:36
 * Comment :
 */
public class ChineseCheckUDF extends UDF {


    public Boolean evaluate(String input) {
        return isChinese(input);
    }


    public static void main(String args[]){
        ChineseCheckUDF helloUDF = new ChineseCheckUDF();
        boolean rs = helloUDF.evaluate("훈민정음训民正bai音" );
        System.out.println(rs);
    }


    private  boolean isChinese(String content){
        if(StringUtils.isEmpty(content)) return true;
        Pattern pattern = Pattern.compile("^[\\u1100-\\u11ff\\uac00-\\ud7af\\u3130–\\u318F\\u3200–\\u32FF\\uA960–\\uA97F\\uD7B0–\\uD7FF\\uFF00–\\uFFEF\\w\\s]+$");
        Matcher matcher = pattern.matcher(content);
        if(matcher.find()) return false;
        return true;
    }
}
