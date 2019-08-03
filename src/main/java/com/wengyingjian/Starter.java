package com.wengyingjian;

import com.wengyingjian.config.XmindProperties;
import com.wengyingjian.epub.Analyser;
import com.wengyingjian.epub.Catalogue;
import com.wengyingjian.epub.EpubReader;
import com.wengyingjian.xmind.XmindGenerator;
import org.xmind.core.CoreException;
import org.xmind.core.ITopic;

import java.io.IOException;

public class Starter {

    public static void main(String[] args) throws IOException, CoreException {
        final XmindProperties properties = new XmindProperties();
        properties.setTitle("资本论");
        properties.setDestFilePath("file/xmind/资本论.xmind");

        final XmindGenerator generator = new XmindGenerator();


        new EpubReader().read("file/epub/资本论.epub", new Analyser() {
            private ITopic root;

            public void onLoadFile(String fileName) {
                System.out.println("load file" + fileName);
                root = generator.init(properties);
            }

            public void onRead(Catalogue catalogue) {
                System.out.println("read :" + catalogue.getParent());
                Catalogue parent = catalogue.getParent();
                if (parent.getiTopic() == null) {
                    parent.setiTopic(root);
                }
                ITopic iTopic = generator.addNode(parent.getiTopic(), catalogue.getTitle(), true);
                catalogue.setiTopic(iTopic);
            }
        });

        generator.save();
    }
}
