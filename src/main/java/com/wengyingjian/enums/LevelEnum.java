package com.wengyingjian.enums;

/**
 *
 */
public enum LevelEnum {
    /**
     *
     */
    ROOT(1, "中心主题"),

    /**
     *
     */
    SECOND(2, "");

    private int level;

    private String desc;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    LevelEnum(int level, String desc) {

        this.level = level;
        this.desc = desc;
    }
}
