/**
 * User: zlin
 * Date: 2019/8/5
 * Time: 14:56
 **/

package com.example.mistroe.util;

import java.util.UUID;

public class UUIDUtils {

    /**
     * 生成唯一id
     * @return
     */
    public static String getUUIDAsString(){
        String uuid = UUID.randomUUID().toString();
        char[] cs=new char[36];
        char c=0;
        for (int i = 0,j=0;j<25;i++) {
            if ((c=uuid.charAt(i))!='-'){
                cs[j++]=c;
            }
        }
        return new String(cs).trim();
    }

    /*public static void main(String[] args) {
        System.out.println(getUUIDAsString());
    }*/
}
