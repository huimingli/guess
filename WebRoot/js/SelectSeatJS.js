
$(function(){
    $(".seat_views i").each(function(index,value){
        $(this).click(function(){
            $(this).removeClass("seat_ture").addClass("seat_selected");
        });
    });
})
//$(window).load(function(){
//    $(".seat_views i").each(function(index,value){
//            $(this).click(function(){
//                alert(":aa");
//                $(this).removeClass("seat_ture").addClass("seat_selected");
//            });
//    });
//});