package com.yanbingxu.lucenedemo;

import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.LongPoint;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author Yuanzhibx
 * @Date 2020-08-10
 */
public class Test1 {

    String[] a = {"3, 华为 - 华为电脑, 爆款",
            "4, 华为手机, 旗舰",
            "5, 联想 - Thinkpad, 商务本",
            "6, 联想手机, 自拍神器"};

    @Test
    public void test1() throws IOException {
        // 存储索引文件的路径 /Users/yanbingxu/Desktop/doc
        FSDirectory d = FSDirectory.open(new File("/Users/yanbingxu/Desktop/doc").toPath());

        // 创建 lucene 提供的中文分词器
        IndexWriterConfig conf = new IndexWriterConfig(new SmartChineseAnalyzer());
        IndexWriter writer = new IndexWriter(d, conf);

        // 处理四篇文章, 生成倒排索引输出
        for (String s : a) {
            String[] strs = s.split(", ");

            Document doc = new Document();
            doc.add(new LongPoint("id", Long.parseLong(strs[0])));
            doc.add(new TextField("title", strs[1], Field.Store.YES));
            doc.add(new TextField("sellPoint", strs[2], Field.Store.YES));

            writer.addDocument(doc);
        }

        writer.close();
    }

}
