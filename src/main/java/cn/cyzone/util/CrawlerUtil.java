package cn.cyzone.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.Scanner;


public class CrawlerUtil {

    /***
     * 输入url,获取网页总数
     * @param url
     * @return
     */

    public static int pageTotal(String url) {
        Document doc = getDocument(url);
        Elements elementsByClass = doc.select("#pages");
        Elements elements =elementsByClass.select("a");
        int i = 0;
        String total = null;
        for (Element e : elements) {
            i++;
            if(i==8){
                total = e.text().substring(3);
                return Integer.parseInt(total);
            }
        }
        System.out.println(total);
        return -1;
    }


    /***
     * 获取Document对象
     * @param url
     * @return
     * @throws IOException
     */
    public static Document getDocument(String url) {
        String s = HttpClientUtil.get(url);
        if(s == null){
            return null;
        }
        return Jsoup.parse(s);
    }

    /***
     * 获取文本最后一行
     * @param path
     * @return
     * @throws Exception
     */
    public static String getUrlFromFile(String path){
        File file = new File(path);
        String line = null;
        if (!file.exists()) {
            return "文本不存在";
        }
        FileReader out = null;
        try {
            out = new FileReader(file);
            Scanner sc = new Scanner(out);
            while(sc.hasNextLine()){
                String l = sc.nextLine();
                if(!l.equals("")){
                    line = l;
                }
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return line;
    }

    public static void setUrlToFile(String path,String content){
        File file = new File(path);
        if (!file.exists()) {
            return;
        }
        FileWriter fw = null;
        try {
            fw = new FileWriter(file,true);
            fw.write(content+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
