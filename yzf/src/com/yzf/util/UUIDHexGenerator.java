package com.yzf.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 生成唯一的数字订单号
 */
public class UUIDHexGenerator {
    private static List<String> list = new ArrayList<String>();
    public static String produceUID(int bits){
        StringBuffer sb = new StringBuffer("");
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
        String dateString = formatter.format(currentTime);
        sb.append(dateString);
        for(int i = 0; i < bits; i ++){
            sb.append((int)(Math.random()*10));
        }
        String tmp = sb.toString();
        if(list.contains(tmp)){
            produceUID(bits);
        }else{
            list.add(tmp);
            return tmp;
        }
        return "-1";
    }
    public String UUIDNumber () {
    	return UUIDHexGenerator.produceUID(10);
    }
    public static void main(String[] args) {
     	System.out.println(UUIDHexGenerator.produceUID(10));
     }
}