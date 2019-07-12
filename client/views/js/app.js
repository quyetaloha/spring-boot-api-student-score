function blockUi(){
    $.blockUI.defaults.css = {};
    $.blockUI({
        message: '<div style="width: 50px; height: 50px; position: fixed; top:0; bottom: 0; left: 0; right: 0; margin: auto;"><img style="width:50px;height:50px" src="./icon/SkinnySeveralAsianlion.webp" /><h4 style ="animation: blink 1s infinite;color: #fff; margin-left: -18px;">Loading...</h4></div>',
    });
}
function unblockUI() {
	$.unblockUI();
}
function getCookie(c_name) {
    if (document.cookie.length > 0) {
        c_start = document.cookie.indexOf(c_name + "=");
        if (c_start != -1) {
            c_start = c_start + c_name.length + 1;
            c_end = document.cookie.indexOf(";", c_start);
            if (c_end == -1) {
                c_end = document.cookie.length;
            }
            return unescape(document.cookie.substring(c_start, c_end));
        }
    }
    return "";
}
function setCookie(id){
  var now = new Date();
  var time = now.getTime();
  var expireTime = time + 1000*600;
  now.setTime(expireTime);
  document.cookie = "SessionId="+id+';expires='+now.toGMTString();
}
