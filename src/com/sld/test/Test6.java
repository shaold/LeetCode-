package com.sld.test;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

public class Test6 {

    public static final String GET_URL = "https://item.upload.taobao.com/router/asyncOpt.htm?optType=categorySelectChildren&catId=200584005";


    // 测试接口
    public static final String POST_URL = "http://116.11.122.12:8180/mdserver/service/installLock";

    /**
     * 接口调用 GET
     */
    public static void httpURLConectionGET() {
        try {
            //把字符串转换为URL请求地址
            URL url = new URL(GET_URL);
            // 打开连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //addRequestProperty添加相同的key不会覆盖，如果相同，内容会以{name1,name2}
            //connection.addRequestProperty("authority", "item.upload.taobao.com");  //来源哪个系统
            //setRequestProperty添加相同的key会覆盖value信息
            //setRequestProperty方法，如果key存在，则覆盖；不存在，直接添加。
            //addRequestProperty方法，不管key存在不存在，直接添加。
            //connection.setRequestProperty("method", "GET");  //访问申请用户
            //connection.setRequestProperty("path", "/router/asyncOpt.htm?optType=categorySelectChildren&catId=1625");
            //connection.setRequestProperty("scheme", "https");
            connection.setRequestProperty("accept", "application/json, text/plain, */*");
            connection.setRequestProperty("accept-encoding", "gzip, deflate, br");
            connection.setRequestProperty("accept-language", "zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7");
            connection.setRequestProperty("cookie", "x-gpf-submit-trace-id=210822d716045642731777826e5e62; x-gpf-render-trace-id=2105834116046619448937589e1f50; _samesite_flag_=true; cookie2=19c69b56e2b3434fca919897c89625b7; t=f70d2636e26dcea429f40732e4e4b659; _tb_token_=b6f7113e3073; cna=JzzdFyoKMk0CAbeeVT+xeJRZ; v=0; lgc=%5Cu5C1A%5Cu6F9C%5Cu70C8%5Cu8FBE; dnk=%5Cu5C1A%5Cu6F9C%5Cu70C8%5Cu8FBE; publishItemObj=Ng%3D%3D; tracknick=%5Cu5C1A%5Cu6F9C%5Cu70C8%5Cu8FBE; thw=cn; enc=gew2pSaQkf6OQl64lKIfDBk4Xvnof%2BnVEx7XMwPkY3gTBWrt3Hg8nuusQ8L%2BsdVpSY%2FAWQ6Fr3d4pEmfiQJy6w%3D%3D; hng=CN%7Czh-CN%7CCNY%7C156; miid=313811291982507960; XSRF-TOKEN=3e4c21a4-d452-4853-830b-b913fe92ada6; mt=ci=29_1; tk_trace=oTRxOWSBNwn9dPyorMJE%2FoPdY8zfvmw%2Fq5v3h2ffrPeEYUr0JF834kBHKkUTR6%2Boy44IsKrKu2%2Fhn4Ze8TaIVIaEFTiN5N4Jks%2Bl%2B4cEdRgbq%2FM3pK4eJjhfrbFEy3YZJuFQa%2BkRHj70yd61KOtbQIa2krMxmt%2FwD8Vwjk9FPfmj9amelhocN5augQ%2BP4mMo1bc4NAJ0YUGad%2BFGkk68o4fNFLVMeaILwAvksNU%2Bz%2FWhB6DQyYCmEdWmuRbK10Qagzehik9mwQRtvC2nd9pvmVfG%2F6DLxg%3D%3D; everywhere_tool_welcome=true; _cc_=UtASsssmfA%3D%3D; xlly_s=1; sgcookie=E100ckW1KZRAKK2PDc7Hv5I3fwW%2BBGUEyy8xLG8KsleTi%2Ba6TTAhrrOqkVJN2NgzFKbQn7RTJ5Dl%2FM2rDdMOvUtPbQ%3D%3D; unb=918191623; uc3=nk2=qj8uqVKhVv0%3D&vt3=F8dCufOGCzvHHrGNUoY%3D&lg2=U%2BGCWk%2F75gdr5Q%3D%3D&id2=WvEDItGkrEV2; csg=9e7b2a86; cookie17=WvEDItGkrEV2; skt=1824e5e024926a27; existShop=MTYwNDY2MTkzOQ%3D%3D; uc4=nk4=0%40qAVBmNiiAvaZ3ahux4qvOdsixw%3D%3D&id4=0%40WDb26c5JECAiksmiL9DUvhGG4eQ%3D; _l_g_=Ug%3D%3D; sg=%E8%BE%BE37; _nk_=%5Cu5C1A%5Cu6F9C%5Cu70C8%5Cu8FBE; cookie1=VT4NNRxVyQyI%2FCj3f%2FAf%2Bn70quRhGekwXXt1LxHEgZM%3D; _m_h5_tk=c25c51bb24a51b32e14b3aafcccddab7_1604669501171; _m_h5_tk_enc=d3384eec3b4e23761422dd5f8cd2087d; uc1=cookie15=V32FPkk%2Fw0dUvg%3D%3D&existShop=true&pas=0&cookie16=W5iHLLyFPlMGbLDwA%2BdvAGZqLg%3D%3D&cookie14=Uoe0abRqGHHCbw%3D%3D&cookie21=VT5L2FSpcHv%2BujM8lw%3D%3D; tfstk=cJH5Bpxu0abSnzAFU0t44iG0hawGaVS_AQaoVbhbtqCHrni7ks2OQPalbXbKpwEf.; l=eBrIJz5PO-ZqX9JFBO5Zlurza77TWQRfGsPzaNbMiInca61d_eifVNQVVTVX8dtjgt5DiexzYAkGMRHB8k4U-EieKvNsx5ifSKvw8e1..; isg=BDEx6zj5ymWNjmZ3Ft7v6znPQL3LHqWQXOaxyxNE0fg3OlWMWW9XYVYcXM5c8j3I");
            connection.setRequestProperty("referer", "https://item.upload.taobao.com/router/publish.htm?spm=a211vu.server-web-home.favorite.d48.64f02d58BuTnmn");
            connection.setRequestProperty("sec-fetch-mode", "cors");
            connection.setRequestProperty("sec-fetch-site", "same-origin");
            connection.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36");
            connection.setRequestProperty("x-requested-with", "XMLHttpRequest");
            //connection.setRequestProperty("设置请求头key", "请求头value");
            connection.connect();// 连接会话
            // 获取输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {// 循环读取流
                sb.append(line);
            }
            br.close();// 关闭流
            connection.disconnect();// 断开连接
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("失败!");
        }
    }

    /**
     * 接口调用  POST
     */
    public static void httpURLConnectionPOST() {
        try {
            //传递参数
            String Parma = "?cardType={}&cardID={}";

            URL url = new URL(POST_URL);
            // 将url 以 open方法返回的urlConnection  连接强转为HttpURLConnection连接  (标识一个url所引用的远程对象连接)
            // 此时cnnection只是为一个连接对象,待连接中
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // 设置连接输出流为true,默认false (post 请求是以流的方式隐式的传递参数)
            connection.setDoOutput(true);
            // 设置连接输入流为true
            connection.setDoInput(true);
            // 设置请求方式为post
            connection.setRequestMethod("POST");
            // post请求缓存设为false
            connection.setUseCaches(false);
            // 设置该HttpURLConnection实例是否自动执行重定向
            connection.setInstanceFollowRedirects(true);
            // 设置请求头里面的各个属性 (以下为设置内容的类型,设置为经过urlEncoded编码过的from参数)
            // application/x-javascript text/xml->xml数据 application/x-javascript->json对象 application/x-www-form-urlencoded->表单数据
            // ;charset=utf-8 必须要，不然妙兜那边会出现乱码【★★★★★】
            //addRequestProperty添加相同的key不会覆盖，如果相同，内容会以{name1,name2}
            connection.addRequestProperty("from", "sfzh");  //来源哪个系统
            //setRequestProperty添加相同的key会覆盖value信息
            //setRequestProperty方法，如果key存在，则覆盖；不存在，直接添加。
            //addRequestProperty方法，不管key存在不存在，直接添加。
            connection.setRequestProperty("user", "user");  //访问申请用户
            InetAddress address = InetAddress.getLocalHost();
            String ip = address.getHostAddress();//获得本机IP
            connection.setRequestProperty("ip", ip);  //请求来源IP
            connection.setRequestProperty("encry", "123456");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            // 建立连接 (请求未开始,直到connection.getInputStream()方法调用时才发起,以上各个参数设置需在此方法之前进行)
            connection.connect();
            // 创建输入输出流,用于往连接里面输出携带的参数,(输出内容为?后面的内容)
            DataOutputStream dataout = new DataOutputStream(connection.getOutputStream());
            // 格式 parm = aaa=111&bbb=222&ccc=333&ddd=444
            String parm = "username=zhagnsan&password=0000";
            System.out.println("传递参数：" + parm);
            // 将参数输出到连接
            dataout.writeBytes(parm);
            // 输出完成后刷新并关闭流
            dataout.flush();
            dataout.close(); // 重要且易忽略步骤 (关闭流,切记!)
            //System.out.println(connection.getResponseCode());
            // 连接发起请求,处理服务器响应  (从连接获取到输入流并包装为bufferedReader)
            BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line;
            StringBuilder sb = new StringBuilder(); // 用来存储响应数据

            // 循环读取流,若不到结尾处
            while ((line = bf.readLine()) != null) {
                //sb.append(bf.readLine());
                sb.append(line).append(System.getProperty("line.separator"));
            }
            bf.close();    // 重要且易忽略步骤 (关闭流,切记!)
            connection.disconnect(); // 销毁连接
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws UnknownHostException {
        httpURLConectionGET();
        //httpURLConnectionPOST();
    }
}
