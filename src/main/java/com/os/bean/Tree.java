package com.os.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matt on 2018/5/12.
 */
public class Tree<T>
{

    //节点显示文本
    private String text;
    //节点子节点
    private List<Tree<T>> children = new ArrayList<Tree<T>>();
    //父节点id
    private String parentId;
    //节点id
    private String id;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Tree<T>> getChildren() {
        return children;
    }

    public void setChildren(List<Tree<T>> children) {
        this.children = children;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
