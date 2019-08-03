package com.wengyingjian.epub;

public interface Analyser {

    void onLoadFile(String fileName);

    void onRead(Catalogue catalogue);
}
