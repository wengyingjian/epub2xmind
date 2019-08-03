package com.wengyingjian.epub;

import com.wengyingjian.xmind.XmindContext;

public class Catalogue extends XmindContext {

    /**
     * 所属层级
     *
     * @see com.wengyingjian.enums.LevelEnum
     */
    private int level;

    /**
     * 内容
     */
    private String title;


    /**
     * 父级
     */
    private Catalogue parent;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Catalogue getParent() {
        return parent;
    }

    public void setParent(Catalogue parent) {
        this.parent = parent;
    }
}
