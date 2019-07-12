$('button').click(function(){
    login();
});
function login(){
    blockUi();
    let username=$('#username').val();
    let password=$('#password').val();
    let InputUserAndScore={"username":username,"password":password};
    $.ajax({
        url: "http://localhost:8080/login",
        crossDomain: true,
        data:JSON.stringify(InputUserAndScore),
        cache: false,
        dataType: 'text',
        type: 'POST',
        contentType: 'application/json',
        async: true,
        processData: false,
        success: function(data, textStatus, jQxhr) {
        let id=data;
        setCookie(id);
        window.location.replace("http://localhost:3000/user-list");
        unblockUI();
        $('.alert-success').show("slow");
        setTimeout(function(){
            $(".alert-success").hide("slow");
        }, 5000);
        },
        error: function(jqXhr, textStatus, errorThrown) {
            unblockUI();
            $('.alert-danger').show("slow");
            setTimeout(function(){
                $(".alert-danger").hide("slow");
            }, 5000);
        }
      });

}
