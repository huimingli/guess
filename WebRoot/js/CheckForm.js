
$(document).ready(function(){
    $(":input").blur(function(){
        var username = $("#name");
        var psw = $("#password");
        var psw2 = $("#repassword");
        var email = $("#email");
        var $parent = $(this).parent();
        var pattName = new RegExp("[A-Za-z0-9]{5,15}");

        $(this).parent().find(".info").remove();

        if($(this).attr("id") == "name"){
            if(!username.val()){
                $parent.append("<span class='info' style='color: red'>&nbsp;&nbsp;*用户名不能为空</span>");
            }else if(!pattName.test(username.val())){
                $parent.append("<span class='info' style='color: red'>&nbsp;&nbsp;用户名只能为5-15个数字或字母</span>");
            }else{
                $parent.append("<span class='info' style='color: green'>&nbsp;&nbsp;*该用户名可以用！</span>");
            }
        }

        if($(this).attr("id") == "password"){
            if(!psw.val()){
                $parent.append("<span class='info' style='color: red'>&nbsp;&nbsp;*密码不能为空</span>");
            }else if(!pattName.test(psw.val())){
                $parent.append("<span class='info' style='color: red'>&nbsp;&nbsp;密码只能为5-15个数字或字母</span>");
            }
        }

        if($(this).attr("id") == "repassword"){
            if(!psw2.val()){
                $parent.append("<span class='info' style='color: red'>&nbsp;&nbsp;*密码不能为空</span>");
            }else if(!pattName.test(psw2.val())){
                $parent.append("<span class='info' style='color: red'>&nbsp;&nbsp;密码只能为5-15个数字或字母</span>");
            }else if(psw2.val() != psw.val()){
                $parent.append("<span class='info' style='color: red'>密码不一致</span>");
            }
        }
        var patt2 = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/ ;
        if($(this).attr("id") == "email"){
            if(!email.val()){
                $parent.append("<span class='info' style='color: red'>&nbsp;&nbsp;*邮箱不能为空</span>");
            }else if(!patt2.test(email.val())){
                $parent.append("<span class='info' style='color: red'>&nbsp;&nbsp;*邮箱格式不正确</span>");
            }else{

            }
        }
    });

    $("#reset").click(function(){
        $(".info").remove();
    })
});