<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>添加角色</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="stylesheet" href="${re.contextPath}/plugin/layui/css/layui.css">
    <link rel="stylesheet" href="${re.contextPath}/plugin/ztree/css/metroStyle/metroStyle.css">
    <script type="text/javascript" src="${re.contextPath}/plugin/jquery/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${re.contextPath}/plugin/layui/layui.all.js" charset="utf-8"></script>
    <script type="text/javascript" src="${re.contextPath}/plugin/ztree/js/jquery.ztree.core.js"></script>
    <script type="text/javascript" src="${re.contextPath}/plugin/ztree/js/jquery.ztree.excheck.js"
            charset="utf-8"></script>
    <script type="text/javascript" src="${re.contextPath}/plugin/tools/tool.js"></script>
    <style>
        .x-red{
            color: red;
        }

        .icon-box{
            cursor: pointer;
            color: #1E9FFF;
            border: 1px solid #dddddd;
            height: 100px;
            width: 100px;
            text-align: center;
            line-height: 100px;
            float: left;
            margin: 0 3px;
        }
    </style>
</head>

<body>
<div class="x-body">
    <form class="layui-form layui-form-pane" style="margin-left: 20px;">
        <input type="hidden" name="tenantId" id="tenantId" value="${tenantId}">
        <input type="hidden" name="icon" id="icon" value="xe68e;">
        <div style="width:100%;height:300px;overflow: auto;">
            <div class="layui-form-item">
                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                    <legend style="font-size:16px;">项目信息</legend>
                </fieldset>
            </div>
            <div class="layui-form-item">
                <label for="roleName" class="layui-form-label">
                    <span class="x-red">*</span>项目名称
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="projectName" name="projectName" lay-verify="projectName"
                           autocomplete="off" class="layui-input">
                </div>
                <div id="ms" class="layui-form-mid layui-word-aux">
                    <span class="x-red">*</span><span id="ums">项目名称必填</span>
                </div>
            </div>
            <div class="layui-form-item">
                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                    <legend style="font-size:16px;">项目图标</legend>
                </fieldset>
            </div>
            <div class="layui-form-item">
                <div tag="icon" value="xe68e;" class="icon-box" style="border: 1px solid blue;">
                    <i class="layui-icon" style="padding: 0 5px;font-size: 50px;margin: auto;">&#xe68e;</i>
                </div>
                <div tag="icon" value="xe702;" class="icon-box">
                    <i class="layui-icon" style="padding: 0 5px;font-size: 50px;margin: auto;">&#xe702;</i>
                </div>
                <div tag="icon" value="xe653;" class="icon-box">
                    <i class="layui-icon" style="padding: 0 5px;font-size: 50px;margin: auto;">&#xe653;</i>
                </div>
            </div>
        </div>

        <div style="width: 100%;height: 55px;background-color: white;border-top:1px solid #e6e6e6;position: fixed;bottom: 1px;margin-left:-20px;">
            <div class="layui-form-item" style=" float: right;margin-right: 30px;margin-top: 8px">
                <button class="layui-btn layui-btn-normal" lay-filter="add" lay-submit>
                    增加
                </button>
                <button class="layui-btn layui-btn-primary" id="close">
                    取消
                </button>
            </div>
        </div>
    </form>
</div>
<script>
    layui.use(['form', 'layer'], function () {
        $ = layui.jquery;
        var form = layui.form,layer = layui.layer;

        //自定义验证规则
        form.verify({
            projectName: function (value) {
                if (value.trim() == "") {
                    return "项目名称不能为空";
                }
            }
        });

        $('#close').click(function () {
            var index = parent.layer.getFrameIndex(window.name);
            parent.layer.close(index);
        });

        //监听提交
        form.on('submit(add)', function (data) {
            //data.field.menus = menus;
            var index = parent.layer.getFrameIndex(window.name);
            $.post('addProject',data.field,function(data) {
                //parent.layer.msg('项目创建成功');
                parent.layer.close(index);
                window.parent.reloadProjects('projectList');
            },'json');

            return false;
        });


        $("[tag='icon']").click(function(){
            var value = $(this).attr("value");
            $("[tag='icon']").css("border","1px solid #dddddd");
            $(this).css("border","1px solid blue");
            $("#icon").val(value);
        });

    });
</script>
</body>

</html>
