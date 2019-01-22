define(function (require) {
    var $ = require('$');
    var PATH = address + "systemManage/accountManage";
    var form;
    layui.use('form', function(){
        form = layui.form;
        form.render();
    });
    var h = window.innerHeight;
    $('.main').height(h - 70);
    $(window).resize(function () {
        var h = window.innerHeight;
        $('.main').height(h - 70);
    });

    layui.use(['layer', 'laypage', 'element']);

    //通过编号设置账号
    $(".serial").on("blur",function () {
        $(".account").val($(this).val());
    });

    //当你在iframe页面关闭自身时
    $(".close_bnt").on("click",function () {
        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        parent.layer.close(index); //再执行关闭
    });

    //保存点击事件
    $(".conserve_bnt").on("click", function () {
        if (checkoutRequestDate()) {
            if (type == "add") {    //添加操作
                $.ajax({
                    url: PATH + "/addUserInfo",	//请求url
                    type: "POST",	//请求类型  post|get
                    data: getRequestData(),
                    success: function (date) {	//回调函数 和 后台返回的 数据
                        layer.msg(date["message"]);
                        parent.refreshTable();
                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index); //再执行关闭
                    }
                });
            } else if (type = "edit") {    //编辑操作
                $.ajax({
                    url: PATH + "/editUserInfo",	//请求url
                    type: "POST",	//请求类型  post|get
                    data: getRequestData(),
                    success: function (date) {	//回调函数 和 后台返回的 数据
                        layer.msg(date["message"]);
                        parent.refreshTable();
                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index); //再执行关闭
                    }
                });
            }
        }
    });

    //校验请求数据
    var checkoutRequestDate = function () {
        var requestData = getRequestData();
        if (!requestData.name) {
            layer.msg("姓名不能为空！");
            return false;
        } else if (!requestData.serial) {
            layer.msg("编号不能为空！");
            return false;
        } else if (!requestData.account) {
            layer.msg("账号不能为空！");
            return false;
        } else if (!requestData.password) {
            layer.msg("密码不能为空！");
            return false;
        // } else if (!requestData.role) {
        //     layer.msg("角色不能为空！");
        //     return false;
        } else if (!passwordRegularCheck()) {
            layer.msg("请输入6～12位密码，包含英文和数字");
            return false;
        }
        return true;
    }

    //获取查询条件
    var getRequestData = function () {
        var requestData = {};  //查询条件
        requestData.name = $(".name").val().trim(); //姓名
        requestData.serial = $(".serial").val().trim(); //编号
        requestData.account = $(".account").val().trim(); //账号
        requestData.password = $(".password").val().trim(); //密码
        // requestData.role = $(".role option:selected").val(); //角色
        if(type == "edit"){
            requestData.userId = userId; //用户id
        }
        return requestData;
    }

    //密码正则校验
    var passwordRegularCheck = function () {
        var pass = false;
        var newPassword = $(".password").val().trim();
        var reg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$/;
        if (newPassword && reg.test(newPassword)) {
            pass = true;
        }
        return pass;
    }

    //编辑初始化
    $(function () {
        if (type == "edit") { //编辑
            $(".title-text").text("编辑账号");
            // $("select").children("option").each(function () {
            //     var temp_value = $(this).val();
            //     if (temp_value == role) {
            //         $(this).attr("selected", "selected");
            //         form.render('select');
            //     }
            // });
        }
    });
});