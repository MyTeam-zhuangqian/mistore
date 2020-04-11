layui.use(['layer', 'upload'], function () {
    var layer = layui.layer //弹层
        ,
        upload = layui.upload;//上传图片

    //普通图片上传
    var uploadInst = upload.render({
        elem: '#upload_img'
        , url: 'http://localhost:8080/good/upload' //改成您自己的上传接口
        , before: function (obj) {
            //预读本地文件示例，不支持ie8
            obj.preview(function (index, file, result) {
                $('#selectImg').attr('src', result); //图片链接（base64）
            });
        }
        , done: function (res) {
            if (res.status == 0) {
                //上传成功
                $("#sc").val(res.message);
                //return layer.msg('上传成功');
            } else {
                return layer.msg('上传失败');
            }

        }
        , error: function () {
            layer.msg('网络繁忙，请重新选择');
            //演示失败状态，并实现重传
            var demoText = $('#demoText');
            demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
            demoText.find('.demo-reload').on('click', function () {
                uploadInst.upload();
            });
        }
    });
    //提交表格
    $("#submit").click(function () {
        $.ajax({
            url: 'http://localhost:8080/good/insert',
            type: 'POST',
            dataType: 'json',
            data: $('#insert_good_form').serialize(),
            success: function (res) {
                if (res.status==0){
                    layer.msg('添加成功');
                }else {
                    layer.msg(res.message)
                }
            },
            error:function () {
                layer.msg('网络繁忙请稍后重试');
            }
        })
    });

    //获取所有图书type
    $.ajax({
        url: 'http://localhost:8080/good/selectAllType',
        type: 'POST',
        dataType: 'json',
        data: '',
        success: function (res) {
            var html = '<option value="" selected="">请选择类型</option>';
            if (res.status==0){
                $.each(res.data,function (i,type) {
                    html += '<option value="'+type.idType+'">'+type.goodType+'</option>'
                });
                $('#good_type').html(html);
            }else {
                layer.msg(res.message);
            }
        },
        error:function () {
            layer.msg('网络繁忙请稍后重试');
        }
    })
});