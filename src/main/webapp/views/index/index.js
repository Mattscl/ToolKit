$(function () {


    /**
     * 获取请求接口路径前缀
     */
    function getRequestUrl() {
        var strFullPath = window.document.location.href;
        var strPath = window.document.location.pathname;
        var pos = strFullPath.indexOf(strPath);
        var prePath = strFullPath.substring(0, pos);
        var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
        var path = prePath + postPath;
        return path;
    }

    $.ajax({
        type: 'POST',
        dataType: 'json',
        url: getRequestUrl() + "/index/getMenus",
        success: function(data)
        {
            var isFirstMenu;

            //var menulist ={"code":100,"msg":"操作成功","extend":{"children":[{"id":"1","text":"主菜单","children":[{"id":"2","text":"权限系统","children":[{"id":"4","text":"用户管理","children":[],"parentId":"2"},{"id":"5","text":"角色管理","children":[],"parentId":"2"},{"id":"6","text":"权限管理","children":[{"id":"7","text":"权限增加","children":[],"parentId":"6"},{"id":"8","text":"权限删除","children":[],"parentId":"6"}],"parentId":"2"}],"parentId":"1"},{"id":"3","text":"内容管理","children":[{"id":"9","text":"轮播图管理","children":[],"parentId":"3"},{"id":"10","text":"商品管理","children":[],"parentId":"3"}],"parentId":"1"}],"parentId":"1"}]}};

            //var menulist ={"extend":{"children":[{"id":"1","text":"主菜单","children":[{"id":"2","text":"权限系统","children":[{"id":"4","text":"用户管理","children":[],"parentId":"2"},{"id":"5","text":"角色管理","children":[],"parentId":"2"},{"id":"6","text":"权限管理","children":[{"id":"7","text":"权限增加","children":[],"parentId":"6"},{"id":"8","text":"权限删除","children":[],"parentId":"6"}],"parentId":"2"}],"parentId":"1"},{"id":"3","text":"内容管理","children":[{"id":"9","text":"轮播图管理","children":[],"parentId":"3"},{"id":"10","text":"商品管理","children":[],"parentId":"3"}],"parentId":"1"}],"parentId":"1"}]}};


            var menulist = data;

            var showlist = $("<ul class=\"sidebar-menu\"></ul>");
            $("<li class=\"header\">主导航</li>").appendTo(showlist);
            /*isFirstMenu=menulist.extend.children.length;
            showall(menulist.extend.children, showlist);*/
            isFirstMenu=menulist.children.length;
            showall(menulist.children, showlist);
            $("#div_menu").append(showlist);

            function showall(menu_list, parent) {
                for (var menu in menu_list) {
                    if (menu_list[menu].children.length > 0) {
                        var li = $("<li></li>");
                        if(isFirstMenu==0){
                            li = $("<li></li>");
                        }else{
                            li = $("<li class=\"treeview\"></li>");
                            isFirstMenu=isFirstMenu-1;
                        }
                        $(li).append("<a href=\"#\"><i class=\"fa fa-share\"></i> <span>"+menu_list[menu].text+"</span><i class=\"fa fa-angle-right pull-right\"></i></a>");
                        var nextParent=$("<ul class=\"treeview-menu\"></ul>");
                        $(nextParent).appendTo(li);
                        $(li).appendTo(parent);
                        showall(menu_list[menu].children, nextParent);
                    }
                    else {
                        $("<li><a href=\"#\"><i class=\"fa fa-circle-o\"></i>"
                            +menu_list[menu].text
                            +"</a></li>").appendTo(parent);
                    }
                }
            }
        },
        error: function(xhr) {
            alert('error:');
        }
    }).done(function(data) {
        // 请求成功后要做的工作
        console.log('success');
    }).fail(function() {
        // 请求失败后要做的工作
        console.log('error');
    }).always(function() {
        // 不管成功或失败都要做的工作
        console.log('complete');
    });

    function show()
    {
        window.location = "../kickOut.jsp";
    }


    /*$('#tabs').addtabs();
    $('#save').click(function () {
        Addtabs.add({
            id: $(this).attr('addtabs'),
            title: $(this).attr('title') ? $(this).attr('title') : $(this).html(),
            content: Addtabs.options.content ? Addtabs.options.content : $(this).attr('content'),
            url: $(this).attr('url'),
            ajax: $(this).attr('ajax') ? true : false
        })
    });*/
});
