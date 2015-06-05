
$(function(){
    $(".td_right_nav ul li").each(function(index,value){
        $(this).click(function(){
                $(".td_main>div:eq("+(index)+")").show().siblings().hide();
                $(this).addClass("td_nav_selected").siblings().removeClass("td_nav_selected");
        });
    })
})
