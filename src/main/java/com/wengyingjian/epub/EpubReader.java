package com.wengyingjian.epub;

import com.wengyingjian.enums.LevelEnum;
import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.TOCReference;
import nl.siegmann.epublib.domain.TableOfContents;
import nl.siegmann.epublib.util.CollectionUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class EpubReader {

    private Book book;

    private Analyser analyser;

    public void read(String filePath, Analyser analyser) throws IOException {
        this.analyser = analyser;
        book = load(filePath);
        read();
    }

    /**
     * 加载epub文件，初始化book对象
     *
     * @param filePath
     * @return
     * @throws IOException
     */
    private Book load(String filePath) throws IOException {
        System.out.println("loading file:" + filePath + "...");

        File file = new File(filePath);
        InputStream inputStr = new FileInputStream(file);
        analyser.onLoadFile(file.getName());

        nl.siegmann.epublib.epub.EpubReader epubReader = new nl.siegmann.epublib.epub.EpubReader();
        return epubReader.readEpub(inputStr);
    }

    /**
     * 读取内容
     */
    private void read() {
        TableOfContents contents = book.getTableOfContents();
        readeCatalogue(contents);
    }

    /**
     * 读取目录
     *
     * @param contents
     */
    private void readeCatalogue(TableOfContents contents) {
        List<TOCReference> catalogue = contents.getTocReferences();
        //虚拟顶级目录
        Catalogue root = new Catalogue();
        root.setLevel(LevelEnum.ROOT.getLevel());
        doReadeCatalogue(catalogue, root, root.getLevel());
    }

    /**
     * 递归读取
     *
     * @param catalogue
     * @param level
     */
    private void doReadeCatalogue(List<TOCReference> catalogue, Catalogue parent, int level) {
        if (CollectionUtil.isEmpty(catalogue)) {
            return;
        }
        for (TOCReference reference : catalogue) {
            Catalogue cata = new Catalogue();
            cata.setLevel(level);
            cata.setTitle(reference.getTitle());
            cata.setParent(parent);
            analyser.onRead(cata);

            doReadeCatalogue(reference.getChildren(), cata, level + 1);
        }
    }


}
