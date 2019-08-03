package com.wengyingjian;

import org.xmind.core.*;

import java.io.IOException;

public class Test {

    //25jrbpvmbq2mp1qr30nknj7j1e
    public static void main(String[] args) throws IOException, CoreException {
        IWorkbookBuilder builder = Core.getWorkbookBuilder();//初始化builder
        IWorkbook workbook = null;
//        workbook = builder.loadFromPath("资本论.xmind");//打开XMind文件
        workbook = builder.loadFromPath("1233.xmind");//打开XMind文件
        ISheet defSheet = workbook.getPrimarySheet();//获取主Sheet

        String themeId = defSheet.getThemeId();
        String st = defSheet.getStyleId();

        ISheetSettings sheetSettings = defSheet.getSettings();


        System.out.println(111);
    }
}
