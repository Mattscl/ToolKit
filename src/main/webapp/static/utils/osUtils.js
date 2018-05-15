
var osUtils = (function ($) {

    var obj = {
        getRootPath     :       getRootPath,
        getProjectPath	:		getProjectPath
    };
    return obj;

    /**
     * 获得根目录
     * @returns {string}
     */
    function getRootPath() {
        var strFullPath=window.document.location.href;
        var strPath=window.document.location.pathname;
        var pos=strFullPath.indexOf(strPath);
        var prePath=strFullPath.substring(0,pos);
        var postPath=strPath.substring(0,strPath.substr(1).indexOf('/')+1);
        var path = prePath + postPath;
        return path;
    }

    /**
     * 获得项目路径
     */
    function getProjectPath(){
        var path = $('#path').val();
        var scheme = $('#scheme').val();
        var serverName = $('#serverName').val();
        var serverPort = $('#serverPort').val();
        var basePath = scheme + '://' + serverName +':'+ serverPort + path +'/';
        return basePath;
    }

})(jQuery);