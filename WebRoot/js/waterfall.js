

$(window).load(function(){
    waterfall();
        $(window).scroll(function(){
            var $lastBox = $("#main>.box").last();
            //最后一个盒子距离页面顶部的距离与自身高度一半的和
            var lastHeight = Math.floor($lastBox.outerHeight()/2) + $lastBox.offset().top;
            //滚动条下拉距离和浏览器高度之和
            var height = $(window).scrollTop() + $(window).height();
            //判断
            if(lastHeight<height){
                for(var i=0;i<5;i++){
                    var oBox = $("<div>").addClass("box").fadeIn(1000).appendTo($("#main"));
//                    oBox.fadeIn("slow");
                    var color = Math.floor(Math.random()*(parseInt("0xffffff",16).toString(10))).toString(16);
                    var oPic = $("<div>").addClass("pic").css({"background":"#"+color,"width":$lastBox.width()-22+"px","height":Math.random()*500+"px"}).fadeIn(1000).appendTo($(oBox));
//                oPic.fadeIn();
                    waterfall();
                }
            }
//            if($("#main>.box").length >= 30){
//                $(window).unbind();
//            }
        });



});
//    var $boxsArr = findBox();


function waterfall(){
    var $boxsArr = $('#main').find('.box');
    var boxHeightArr = [];

    //计算浏览器宽度再除以盒子宽度,并设置#main宽度
    var boxWidth = $(".box").outerWidth();
    console.log(boxWidth);
    var leftWidth = $(".allNews").width();
    var cols = Math.floor(leftWidth/boxWidth);
    $("#main").width(cols * boxWidth);
    $boxsArr.each(function(index,value){
        var h = $boxsArr.eq(index).outerHeight();
        if(index<cols){
            boxHeightArr[index] = h;
        }else{
            var minH = Math.min.apply(null,boxHeightArr);
            var minHIndex = $.inArray(minH,boxHeightArr); //在数组中找到某个值的索引
            $(value).css({
                "position":"absolute",
                "top":minH+"px",
                "left":minHIndex * boxWidth+"px"
            });
            boxHeightArr[minHIndex] += $boxsArr.eq(index).outerHeight();
        }
    });
}
