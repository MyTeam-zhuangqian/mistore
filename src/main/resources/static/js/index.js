$("#search-button").click(function () {
    $.ajax({
        url: 'http://localhost:8080/good/search',
        type: 'POST',
        dataType: 'json',
        data: {key:$("#search").val()},
        success: function (res) {
            if (res.status==0){
                $(location).attr('href','http://localhost:8080/good')
            }else {
                layer.msg(res.message)
            }
        },
        error:function () {
            layer.msg('网络繁忙请稍后重试');
        }
    })
})