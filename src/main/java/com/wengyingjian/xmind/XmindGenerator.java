package com.wengyingjian.xmind;

import com.wengyingjian.config.XmindProperties;
import org.xmind.core.*;

import java.io.IOException;

public class XmindGenerator {


    private XmindProperties properties;

    private IWorkbook workbook;


    public ITopic addNode(ITopic parent, String text, boolean folded) {
        ITopic topic1 = workbook.createTopic();
        topic1.setTitleText(text);
        topic1.setFolded(folded);
        parent.add(topic1, ITopic.ATTACHED);

        return topic1;
    }

    public ITopic init(XmindProperties properties) {
        this.properties = properties;

        IWorkbookBuilder builder = Core.getWorkbookBuilder();
        workbook = builder.createWorkbook();
        //
        ISheet sheet = workbook.getPrimarySheet();
sheet.setThemeId("25jrbpvmbq2mp1qr30nknj7j1e");
        //中心主题
        ITopic root = sheet.getRootTopic();
        root.setTitleText(properties.getTitle());
        return root;
    }


    public void save() throws IOException, CoreException {
        workbook.save(properties.getDestFilePath());
    }


}
