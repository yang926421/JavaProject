//带清除整行文字的input
//$(function(){
//	 $("input").focus(function(){  
//			    $(this).parent().children(".input_clear").show();  
//			});  
//			$("input").blur(function(){  
//			    if($(this).val()=='')  
//			    {  
//			        $(this).parent().children(".input_clear").hide();  
//			    }  
//			});  
//			$(".input_clear").click(function(){  
//			    $(this).parent().find('input').val('');  
//			    $(this).hide();  
//			});  
//});

var oldtime = 120;

function settime(val) {
    if (oldtime == 0) {
        val.value = "获取验证码";
        val.removeAttr("disabled");
        oldtime = 120;

    } else {
        val.val("重新发送(" + oldtime + "s" + ")");
        val.attr("disabled", true);
        oldtime--;
        setTimeout(function () {
            settime(val)
        }, 1000);
    }
}

function settimeHtml(val) {
    if (oldtime == 0) {
        val.html("获取验证码");
        val.attr("onclick", getYzm(this));
        ;
        oldtime = 120;
    } else {
        val.html("重新发送(" + oldtime + "s" + ")");
        val.removeAttr('onclick');
        oldtime--;
        setTimeout(function () {
            settimeHtml(val)
        }, 1000);
    }
}

var VER_CODE_ID;

function getCode(no, cardNo) {
    $.ajax({
        type: "get",
        url: httpUrl + "/p/sms/verifycode/send.json",
        data: {"NO": no, "CARD_NO": cardNo},
        dataType: "json",
        success: function (res) {
            if (res.success) {
                settime($("#getVerification"));
                mui.toast(res.codeMsg);
                VER_CODE_ID = res.data.VER_CODE_ID;
            }
        }
    });
}
