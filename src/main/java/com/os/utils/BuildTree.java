package com.os.utils;

import com.os.bean.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matt on 2018/5/12.
 */
public class BuildTree
{
    public static <T> List<Tree<T>> build(List<Tree<T>> nodes)
    {
        if(nodes == null)
        {
            return null;
        }
        List<Tree<T>> topNodes = new ArrayList<Tree<T>>();
        for(Tree<T> childern : nodes)
        {
            String pid = childern.getParentId();
            if(pid.equals(childern.getId()) || "0".equals(pid))
            {
                topNodes.add(childern);
                continue;
            }
            for(Tree<T> parent : nodes)
            {
                String id = parent.getId();
                if(id != null && id.equals(pid))
                {
                    parent.getChildren().add(childern);
                }
            }
        }
        return topNodes;
    }
}
