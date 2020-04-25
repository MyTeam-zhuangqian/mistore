$("#search-button").click(function () {
    $.ajax({
        url: '/good/search',
        type: 'POST',
        dataType: 'json',
        data: {key:$("#search").val()},
        success: function (res) {
            if (res.status==0){
                $(location).attr('href','/good')
            }else {
                layer.msg(res.message)
            }
        },
        error:function () {
            layer.msg('网络繁忙请稍后重试');
        }
    })
})