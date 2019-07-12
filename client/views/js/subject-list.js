getSubjectData();
function getSubjectData(){
    blockUi()
    $.ajax({
        url: "http://localhost:8080/subjects-manager"+"?SessionId="+getCookie('SessionId'),
        crossDomain: true,
        cache: false,
        dataType: 'json',
        type: 'GET',
        contentType: 'application/json',
        async: true,
        processData: false,
        success: function(data, textStatus, jQxhr) {
          setCookie(getCookie('SessionId'));
            let html=""
        $.each(data, function(key, val){
            html+='<tr id="'+val.id+'">'
                +'<td>'+val.id+'</td>'
                +'<td>'+val.subject+'</td>'
                +'</tr>'
        });
            $('#table-body').html(html);

            unblockUI();
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
