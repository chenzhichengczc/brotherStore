var extCode = "";

$(function () {
    var username;
    var password ;
    var confirmPassword;
    var telephone;

    $("#zhucButton").click(function () {
        username = $("#username").val();
        password = $("#password").val();
        confirmPassword = $("#confirmPassword").val();
        telephone = $("#telephone").val();

        //功能以实现 若需要测试验证码 请打开下面这个方法
        //checkExt(extCode);

        if(checkUsernameInfo(username)+checkPasswordAndConfirmPassword(password,confirmPassword)+checkTelephone(telephone)+checkAgreement() == 4){
            var json={"user_name":username,"password":password,"mobile_phone":telephone};
            $.ajax({
                url: "../registeConsumer",
                type:"POST",
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                data: JSON.stringify(json),
                success : function (data) {
                    if(data.state==0){
                        window.location.href = "./dengl.html"
                    }
                }
            })
        }

    })



    /**
     * 检查用户名是否已经存在
     */
    $("#username").blur(function () {
        $("#hasUsernameBox").css("display","none")
        if($("#username").val() != ""){
            $.ajax({
                url: "../confirmUsername",
                type:"POST",
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                data:$("#username").val(),
                error : function(){
                    alert("拉取用户名失败")
                },
                success : function (data) {
                    if(data.state == 0){
                        if(data.data == false){
                            $("#hasUsernameBox").css("display","block");
                            return false;
                        }
                    }

                }
            })
        }

    })

    /**
     * 检查手机是否已经存在
     */
    $("#telephone").blur(function () {
        $("#hasPhoneBox").css("display","none")
        if($("#telephone").val() != ""){
            $.ajax({
                url: "../confirmTelephone",
                type: "POST",
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                data: $("#telephone").val(),
                error: function () {
                    alert("拉取手机号码失败")
                },
                success: function (data) {
                    if (data.state == 0) {
                        if (data.data == false) {
                            $("#hasPhoneBox").css("display", "block");
                            return false;
                        }
                    }
                }
            })
        }
    })

    /**
     * 短信验证码验证
     */
    /*$("#getIdentify").click(function () {
        if(!checkTelephone($("#telephone").val())){
            alert("手机号码有误");
            return;
        }
        $.ajax({
            url: "../sendIdentify",
            type:"POST",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            data:$("#telephone").val(),
            error : function(){
                alert("获取验证码失败")
            },
            success : function (data) {
                if(data.state == 0){
                    var jsonStr = eval('(' + data.data.response.body + ')');
                    extCode = jsonStr.ext;
                }
            }
        })
    })
    })*/



})
$("#password").keydown(function (event) {
    capsLock(event)
})
$("#confirmPassword").keydown(function (event) {
    capsLock(event)
})



function checkExt(extCode) {
    if(!extCode == $("#identifyingCode").val()){
        alert("验证码有误");
        return false;
    }
    return true;
}

/**
 * 检验政策是否勾选
 * @returns {boolean}
 */
function checkAgreement() {
    //JQ 1.6版本后可以直接使用prop方法获取是否被选中功能
    if(!$(":checkbox[value=english]").prop("checked")){
        alert("请阅读并勾选政策")
    }else{
        return true;
    }
}

/**
 * 校验信息是否存在
 * @param info  传递input的传递信息
 */
function checkInfoIsNull(info){
    if(info == null || info == undefined || info == ""){
        return false;
    }else{
        return true;
    }
}

/**
 * 校验用户名是否存在
 * @param username
 * @returns {boolean}
 */
function checkUsernameInfo(username) {
    $("#checkusernameBox").css("display","none");
    $("#usernameErrorBox").css("display","none");
    if(! checkInfoIsNull(username)){
        $("#checkusernameBox").css("display","block");
        return false;
    }
    //4-20个字符，支持汉字、字母、数字及“-”、“_”
    var reg = new RegExp(".{4,20}");
    if(!reg.test(username)){
        $("#usernameErrorBox").css("display","block");
        return false;
    }
    return true;
}

/**
 * 检验密码
 * @param password
 * @param confirmPassword
 * @returns {boolean}
 */
function checkPasswordAndConfirmPassword(password,confirmPassword) {
    $("#checkpasswordBox").css("display","none");
    $("#passwordErrorBox").css("display","none")

    var patrn=/^(\w){6,20}$/;
    if(!patrn.exec(password)){
        $("#passwordErrorBox").css("display","block")
        return false;
    }
    if(password != confirmPassword) {
        $("#checkpasswordBox").css("display", "block");
        return false;
    }
    return true;
}

/**
 * 检验电话
 * @param telephone
 * @returns {boolean}
 */
function checkTelephone(telephone) {
    $("#checkphoneBox").css("display", "none")
    $("#phoneErrorBox").css("display", "none")

    if (!checkInfoIsNull(telephone)) {
        $("#checkphoneBox").css("display", "block")
        return false;
    }

    var patrn = new RegExp(/^1(?:3\d|4[4-9]|5[0-35-9]|6[67]|7[013-8]|8\d|9\d)\d{8}$/);
    if (!patrn.test(telephone)) {
        $("#phoneErrorBox").css("display", "block")
        return false;
    }
    return true;
}

/**
 * 判断大小写是否被使用
 * @param e
 */
function capsLock(e) {
    var valueCapsLock  =  e.keyCode ? e.keyCode:e.which; // Caps Lock　是否打开
    if (valueCapsLock == 20){
        if($("#capLocksKey").attr("data-status")==1){
            $("#capLocksKey").removeAttr("data-status").css("display","none");
        }else{
            // Caps Lock 打开
            $("#capLocksKey").css("display","block").attr("data-status","1");
        }
    }else{
        $("#capLocksKey").css("display","none")
    }
}