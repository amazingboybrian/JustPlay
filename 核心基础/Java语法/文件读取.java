package Java语法;/* 2020/9/15 22:35 */

import org.junit.Test;

import java.io.*;

public class 文件读取 {//

    /**
     * File类  注意文件路径
     * 文本文件  字符流处理 FileReader
     * 非文本文件 字节流处理  FileInputStream
     *
     * 缓冲流 提高流的读写速度，内部有一个缓冲区，默认为 8 kb
     *
     * 1. IO 面向流； 2. NIO 面向缓冲区，基于通道的IO 操作
     */

    /* main 相对路径为当前的 Project 下 */
    public static void main(String[] args) throws Exception {
        File file = new File("核心基础/Java语法/1.txt");//文件句柄 File类
        FileInputStream fis = new FileInputStream(file);//节点流-访问文件（字节输入流） 写入内存
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");//处理流.【转换流】（字符输入流）  (fis, "UTF-8")
        BufferedReader br = new BufferedReader(isr);//处理流.【缓冲流】（字符输入流）
        String s;
        //while (br.read() != -1) {//-1 ! 读到文件尾了
        while ((s = br.readLine()) != null) {
            s = br.readLine();
            System.out.println(s);
        }
        //String s = br.readLine();
        //System.out.println(s);
        //关闭流资源
    }

    @Test //JUnit单元测试 相对路径为当前的 Module 下
    public void readFile() throws Exception {//
        File file = new File("Java语法/1.txt");//文件句柄 File类
        FileInputStream fis = new FileInputStream(file);//节点流-访问文件（字节输入流） 写入内存
        InputStreamReader isr = new InputStreamReader(fis);//处理流.转换流（字符输入流）
        BufferedReader br = new BufferedReader(isr);//处理流.缓冲流（字符输入流）
        String s;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
        //关闭流资源
        BufferedReader br1 = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
    }

    @Test
    public void testFileReader() throws Exception {
        File file = new File("Java语法/1.txt");
        FileReader fr = new FileReader(file);//一步到位，字符输入流

        char[] cbuf = new char[5];
        int len;

        while ((len = fr.read(cbuf)) != -1) {
            String s = new String(cbuf, 0, len);
            System.out.print(s);
        }
    }
}
