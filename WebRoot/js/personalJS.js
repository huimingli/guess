
$(function(){
    $(".ph_type").click(function(){
        $(".box_down").slideDown();
        $(document).click(function(event){
            if(event.target != $(".box_down")[0] && event.target != $(".ph_type>a")[0] && event.target != $(".ph_type>a>i")[0]){
                $(".box_down").slideUp();
            }
        })
    })
})