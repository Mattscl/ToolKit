$(function () {
    $.ajax({
        type: 'POST',
        dataType: 'json',
        url: osUtils.getRootPath() + "/index/getMenus",
        success: function(data)
        {
            var isFirstMenu;
            var menulist = data;
            var showlist = $("<ul class=\"sidebar-menu\"></ul>");  //定义一个菜单列表容器
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


    $('#tabs').addtabs();
    $('#save').click(function () {
        Addtabs.add({
            id: $(this).attr('addtabs'),
            title: $(this).attr('title') ? $(this).attr('title') : $(this).html(),
            content: Addtabs.options.content ? Addtabs.options.content : $(this).attr('content'),
            url: $(this).attr('url'),
            ajax: $(this).attr('ajax') ? true : false
        })
    });
});
