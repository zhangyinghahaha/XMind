$(function () {
    $("#loginForm").submit(function (){
        var username = $('#username').val();
        var publicKey;
        $.ajaxSettings.async = false;
        $.get("/community/rsa/publicKey/"+username, function (data) {
            console.log("1");
            data = $.parseJSON(data);
            if(data.code == 0) {
                publicKey = data.publicKey;

                // Encrypt with the public key
                var encrypt = new JSEncrypt();
                encrypt.setPublicKey(publicKey);
                var password = encrypt.encrypt($('#password').val());
                $('#password').val(password);
            } else {
                alert(data.msg);
                return false;
            }
        });
        $.ajaxSettings.async = true;
        console.log("2");
        return true;
    });
});

function refreshKaptcha() {
    var path = "/community/kaptcha?=" + Math.random();
    $("#kaptcha").attr("src", path);
}