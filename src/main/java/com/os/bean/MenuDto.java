package com.os.bean;

/**
 * Created by Matt on 2018/5/12.
 */
public class MenuDto
{
    private Long id;
    private String menuName;
    private Long parentId;

    public MenuDto(Long id, String menuName, Long parentId) {
        this.id = id;
        this.menuName = menuName;
        this.parentId = parentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

}
