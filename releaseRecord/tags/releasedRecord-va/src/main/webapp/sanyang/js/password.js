define(function (require) {
    var $ = require("$");
    var PATH = address + "systemManage/changePassword";
    layui.use(['layer', 'laypage', 'element']);
    //新密码焦点失去事件
    $(".newPassword").on("blur", function () {
        passwordRegularCheck(); //正则校验
    });

    //新密码焦点失去事件
    $(".repeatNewPassword").on("blur", function () {
        determinePasswordConsistency();
    });

    //确认更改
    $(".confirm-btn").on("click", function () {
        updateAcknowledge();
    });

    //密码正则校验
    var passwordRegularCheck = function () {
        var pass = false;
        var newPassword = $(".newPassword").val().trim();
        var reg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$/;
        if (newPassword && reg.test(newPassword)) {
            $(".newPassword_text").hide()
            pass = true;
        } else {
            $(".newPassword_text").show()
        }
        return pass;
    }

    //判断密码输入是否一致
    var determinePasswordConsistency = function () {
        var pass = false;
        var newPassword = $(".newPassword").val().trim();
        var repeatNewPassword = $(".repeatNewPassword").val().trim();
        if (newPassword == repeatNewPassword) {
            $(".repeatNewPassword_text").hide()
            pass = true;
        } else {
            $(".repeatNewPassword_text").show()
        }
        return pass;
    }

    //原密码校验
    var oldPasswordCheck = function () {
        var pass = false;
        var oldPassword = $(".oldPassword").val().trim();
        if (oldPassword) {
            $(".oldPassword_text").hide()
            pass = true;
        } else {
            $(".oldPassword_text").show()
        }
        return pass;
    }

    //获取参数
    var getParamJson = function () {
        var paramJson = {};
        paramJson.oldPassword = $(".oldPassword").val().trim();
        paramJson.newPassword = $(".newPassword").val().trim();
        paramJson.repeatNewPassword = $(".repeatNewPassword").val().trim();
        return paramJson;
    }

    //确认更改
    var updateAcknowledge = function () {
        var newPasswordPass = passwordRegularCheck();
        var repeatNewPasswordPass = determinePasswordConsistency();
        var oldPasswordPass = oldPasswordCheck();
        if (oldPasswordPass && newPasswordPass && repeatNewPasswordPass) {
            layer.confirm('确认修改密码', function(index){
                layer.close(index);
                $.ajax({
                    url: PATH + "/changePassword",	//请求url
                    type: "POST",	//请求类型  post|get
                    data: getParamJson(),
                    success: function (date) {	//回调函数 和 后台返回的 数据
                        if(date["result"] == "success"){
                            layer.msg("密码修改成功！");
                        }else{
                            layer.msg(date["message"])
                        }
                    }
                });
            });
        }
    }
});