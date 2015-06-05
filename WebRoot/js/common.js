
$(function(){
    $(".nav ul li").each(function(index,value){
        $(this).click(function(){
            $(this).addClass("nav_selected").siblings().removeClass("nav_selected");
            $(this).find("a").addClass("nav_selected_a").parent.siblings().find("a").removeClass("nav_selected_a");
        });
    });
})