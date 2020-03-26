
$.ajax({
    url:'/test',
    type:'POST',
    dataType:'json',
    data:'',
    success:function (res) {
        //alert(res[1].id)
        var html = '';
        $.each(res,function (index,book) {
            html += '<li class="goods-item">\n' +
                '            <a href=""><img src="' + book.img + '"/></a>\n' +
                '            <div class="goods-message">\n' +
                '                <p class="description">'+book.description+'</p>\n' +
                '                <span class="price">'+book.price+'</span>\n' +
                '                <p class="author">'+book.author+'</p>\n' +
                '                <a class="add-cart" href="">加入购物车</a>\n' +
                '                <a class="collect" href="">收藏</a>\n' +
                '            </div>\n' +
                '\n' +
                '        </li>';
        })
        $("#Goods").html(html);

    },
    error:function () {
        console.log("网络异常！！！");
    }
});