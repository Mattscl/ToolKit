package com.os.index.control;

import com.google.gson.Gson;
import com.os.bean.MenuDto;
import com.os.bean.Tree;
import com.os.utils.BuildTree;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Matt on 2018/3/2.
 * 接口说明： 主页面的请求操作
 */
@Controller
public class IndexControl
{
    @RequestMapping(value = "/index/getMenus",method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String,Object> getMenus()
    {
        HashMap<String,Object> obj = new HashMap<String, Object>();
        List<Tree<MenuDto>> trees = new ArrayList<Tree<MenuDto>>();
        List<MenuDto> menuDtoList = new ArrayList<MenuDto>();
        menuDtoList.add(new MenuDto(1L,"主菜单",1L));
        menuDtoList.add(new MenuDto(2L,"权限系统",1L));
        menuDtoList.add(new MenuDto(3L,"内容管理",1L));
        menuDtoList.add(new MenuDto(4L,"用户管理",2L));
        menuDtoList.add(new MenuDto(5L,"角色管理",2L));
        menuDtoList.add(new MenuDto(6L,"权限管理",2L));
        menuDtoList.add(new MenuDto(7L,"权限增加",6L));
        menuDtoList.add(new MenuDto(8L,"权限删除",6L));
        menuDtoList.add(new MenuDto(9L,"轮播图管理",3L));
        menuDtoList.add(new MenuDto(10L,"商品管理",3L));

        menuDtoList.add(new MenuDto(11L,"主菜单1",11L));
        menuDtoList.add(new MenuDto(21L,"权限系统1",11L));
        menuDtoList.add(new MenuDto(31L,"内容管理1",11L));

        menuDtoList.add(new MenuDto(12L,"主菜单2",12L));
        menuDtoList.add(new MenuDto(22L,"权限系统1",12L));
        menuDtoList.add(new MenuDto(32L,"内容管理1",12L));

        menuDtoList.add(new MenuDto(13L,"主菜单3",13L));
        menuDtoList.add(new MenuDto(23L,"权限系统3",13L));
        menuDtoList.add(new MenuDto(33L,"内容管理3",13L));

        menuDtoList.add(new MenuDto(14L,"主菜单4",14L));
        menuDtoList.add(new MenuDto(24L,"权限系统4",14L));
        menuDtoList.add(new MenuDto(34L,"内容管理4",14L));

        menuDtoList.add(new MenuDto(15L,"主菜单5",15L));
        menuDtoList.add(new MenuDto(25L,"权限系统5",15L));
        menuDtoList.add(new MenuDto(35L,"内容管理5",15L));

        menuDtoList.add(new MenuDto(16L,"主菜单6",16L));
        menuDtoList.add(new MenuDto(26L,"权限系统6",16L));
        menuDtoList.add(new MenuDto(36L,"内容管理6",16L));

        for(MenuDto menuDto : menuDtoList)
        {
            Tree<MenuDto> tree = new Tree<MenuDto>();
            tree.setId(menuDto.getId().toString());
            tree.setText(menuDto.getMenuName());
            tree.setParentId(menuDto.getParentId().toString());
            trees.add(tree);
        }
        List<Tree<MenuDto>> children = BuildTree.build(trees);
        Gson gson = new Gson();
        obj.put("children",children);
        return obj;
    }
}
