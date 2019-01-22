define(function (require) {
    var $ = require("$");
    var h = $('body').height(),
        w = $('body').width();
    $('.content-bottom').height(h - 130);
    $(window).resize(function () {
        var h = $('body').height(),
            w = $('body').width();
        $('.content-bottom').height(h - 130);
    });
    var active;
    var PATH = address + "systemManage/accountManage";

    //点击其他区域关闭td详情
    $("body").on("click",function (e) {
        var target = $(e.target);
        if(!(target.is(".layui-table-tips-main")||target.is(".layui-table-grid-down")||target.is(".layui-icon-down"))){
            $(".layui-icon-close").click();//关闭表格详情弹出框
        }
    });

    //弹窗跳转至添加页面
    $(".add_btn").on("click", function () {
        //iframe层-父子操作
        layer.open({
            type: 2,
            area: ['700px', '450px'],
            fixed: false, //不固定
            maxmin: true,
            content: PATH + "/toAddAccount?type=add"
        });
    });

    // 调用layui表格
    layui.use('table', function () {
        var table = layui.table;
        table.render({
            elem: '#test',
            url: PATH + "/pageFindAccountInfo",
            height: 'full-135', // 差值，充满，并且距离底部的距离
            skin: 'line',
            cols: [[
                {field: '', width: '3%', title: ''},
                {field: 'USER_SERIAL', width: '20%', title: '人员编号'},
                {field: 'USER_ACCT_CN', width: '18%', title: '姓名', style: 'color: #676767;'},
                {field: 'USER_ACCT', width: '20%', title: '账号'},
                // {field: 'ROLE_NAME_CN', width: '15%', title: '角色'},
                {
                    field: 'CREATE_DT', width: '20%', title: '创建日期', templet: function (d) {
                        return timestampToTime(d.CREATE_DT)
                    }
                },
                {field: 'classify', width: '19%', title: '操作', templet: '#titleTpr'}
            ]],
            id: 'performReload',
            page: true,
            limit: 10,
            request: {
                pageName: 'page', //页码的参数名称，默认：page
                limitName: 'rows' //每页数据量的参数名，默认：limit
            }, where: {
                'queryCondition': JSON.stringify(getQueryCondition())
            }
        });
        //查询参数
        active = {
            reload: function () {
                table.reload('performReload', {   //执行重载
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {
                        'queryCondition': JSON.stringify(getQueryCondition())
                    }
                });
            }
        };
        //查询点击事件
        $('.check .query_btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

        //监听工具条
        table.on('tool(demo)', function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {   // 查看的提示框
            } else if (obj.event === 'del') {
                layer.confirm('真的删除行么', function (index) {// 删除的提示框
                    $.ajax({
                        url: PATH + "/deleteUserInfo",	//请求url
                        type: "POST",	//请求类型  post|get
                        data: {userId:obj.data.USER_ID},
                        success: function (date) {	//回调函数 和 后台返回的 数据
                            layer.msg(date["message"]);
                            layer.close(index);
                            refreshTable();
                        }
                    });
                });
                // 弹窗跳转至编辑页面
            } else if (obj.event === 'edit') {
                layer.open({
                    type: 2,
                    area: ['700px', '450px'],
                    fixed: false, //不固定
                    maxmin: true,
                    content: PATH + "/toEditAccount?type=edit&userId="+obj.data.USER_ID
                });
            }
        });
    });

    //获取查询条件
    var getQueryCondition = function () {
        var queryCondition = {};  //查询条件
        queryCondition.name = $(".name_input").val().trim(); //获取起始日期
        queryCondition.userSerial = $(".serial_input").val().trim(); //获取截至日期
        return queryCondition;
    }

    //时间戳格式化时间格式
    var timestampToTime = function (date) {
        if (date) {
            var datemat = date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8) + " " + date.substring(8, 10) + ":" + date.substring(10, 12);
            return datemat;
        }
        return "";
    }

    //刷新table（不清空查询条件）
    refreshTable = function refreshTable(){
        active["reload"].call(this);
    }

})