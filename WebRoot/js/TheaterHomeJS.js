$(function(){
   $(".selectOne ul li a").each(function(){
           click($("#cityName"),$(this));
   });

    $(".selectMoive ul li a").each(function(index){
            click($("#moive"),$(this),index);
    });

    $(".selectCinema ul li a").each(function(){
            click($("#TheaterName"),$(this));
    });
    clickType($("#city"));
    clickType($("#movName"));
    clickType($("#theater"));
    clickType($("#time"));

    $(".selectNav ul li a").click(function(){
        $(this).parent().addClass("border_bottom").siblings().removeClass("border_bottom");
        getCity($(this).html())
    });

});

function clickType(element){
    element.click(function(){
//        console.log("点击"+jsElement);
        $(this).parent().find(".select_icon").show();
        closeBox($(this).parent().find(".select_icon"),$(this));
    });
}
function click(element,thiz,index){
//    thiz.each(function(index,value){
//        $(this).click(function(){
//            console.log(index);
//            element.html(contentSubStr(thiz.html(),6));
//            thiz.parent().parent().parent().parent().hide().parent().children(".select_icon").hide();
//
//            if(thiz.attr("data") == "moive"){
//                console.log($("#moiveId").html());
//                $.ajax({
//                    url:"theaterJson_getTheaterByMovieId.do",
//                    data:{
//                        moiveId:$("#moiveId:eq("+index+")").html()
//                    },
//                    method:"GET",
//                    success:function(data){
//                        console.log(data);
//                    }
//                });
//            }
//        });
//    })


    thiz.click(function(){
//        console.log(index);
        element.html(contentSubStr(thiz.html(),6));
        thiz.parent().parent().parent().parent().hide().parent().children(".select_icon").hide();

        if(thiz.attr("data") == "moive"){
//            console.log($(".moiveId:eq("+index+")").html());
            $.ajax({
                url:"theaterJson_getTheaterByMovieId.do",
                data:{
                    movieId:$(".moiveId:eq("+index+")").html()
                },
                method:"GET",
                success:function(data){
                    alert(data);
                    console.log(data);
                }
            });
        }
    });
}

/* 限制字数 */
function contentSubStr(content,size){
    var newContent = content;
    if(content.length >= size){
        newContent = content.substr(0,size);
        newContent += "...";
    }
    return newContent;
}
function closeBox(boxName,parent){
    $(document).click(function(event){
        var aim = event.target;
        if(aim != boxName[0] && aim != parent[0] && aim != boxName.find("a")[0] && aim != boxName.find("a")[1] && aim != boxName.find("a")[2] && aim != boxName.find("a")[3] &&  aim != boxName.find("a")[4]){
            boxName.hide();
        }
    })
}
function getCity(str){
    $.ajax({
        url:"areaJson_getTheArea.do",
        data:{
            str:str
        },
        type:"GET",
        success: function (data){
            var json =eval(data);
            $(".selectOne ul li a").html("");
            for(var i = 0,len = json.length; i<len; i++){
                $(".selectOne ul li a:eq("+i+")").html(json[i].name);
            }
        }
    })
}