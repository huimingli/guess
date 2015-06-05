
$(window).load(function(){
    var hot_play_ul = $(".hot_play_list ul");
    var hot_com_ul = $(".hot_com_list ul");
    var ul = $(".com_hot_moive_list ul");
    var singleList = $(".com_hot_moive_list");
    var ulWidth = ul.width();
    var listWidth = singleList.width();
    var play_last = $(".play_pre");
    var play_next = $(".play_next");
    var com_last = $(".com_pre");
    var com_next = $(".com_next");
    var n = Math.floor(ulWidth/listWidth);
    var flag = 0;
    console.log(n);


    $(".com_hot_moive_nav a").each(function(index,value){
        value.onclick = function(){
            $(this).addClass("selected").siblings().removeClass("selected");
            selectBox(index);
            flag = index;
        };
    });

    function selectBox(index){
        var select =  $(".first_nav>div:eq("+(index)+")");
        select.show().fadeIn().siblings().hide();
    }



    play_next.click(function(){
        animate(hot_play_ul,-listWidth,$(this))
    });
    play_last.click(function(){
        animate(hot_play_ul,listWidth,$(this))
    });

    com_next.click(function(){
        animate(hot_com_ul,-listWidth,$(this))
    });
    com_last.click(function(){
        animate(hot_com_ul,listWidth,$(this))
    });

    function animate(list,offset,operation){
        var left =  parseInt(list.css("left")) + offset;
        list.animate({'left':left},300,function(){
           if(flag == 0){
               play(list,offset);
           }else if(flag == 1){
                com(list,offset);
            }
        });
        operation.siblings().show().fadeIn();
    }

    function play(list,offset){
        if(-parseInt(list.css("left")) <= 0){
            play_last.hide().fadeOut();
        }else if(parseInt(list.css("left")) <= (n-1)* -listWidth){
            play_next.hide().fadeOut();
        }
    }

    function com(list,offset){
        if(-parseInt(list.css("left")) <= 0){
            com_last.hide().fadeOut();
        }else if(parseInt(list.css("left")) <= (n-1)*offset){
            com_next.hide().fadeOut();
        }
    }
});