getUserData();
  $("#search").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $(".table > tbody > tr").filter(function() {      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
function getUserData(){
    blockUi();
    $.ajax({
        url: "http://localhost:8080/users-manager"+"?SessionId="+getCookie('SessionId'),
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
                +'<td>'+val.hoTen+'</td>'
                +'<td>'+val.lop+'</td>'
                +'</tr>'
        });
            $('#table-body').html(html);
            $('tr').click(function(){
                let id=$(this).attr("id");
                getScoreInfo(id);
            });

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

function  getScoreInfo(id){
    blockUi();
    $.ajax({
        url: "http://localhost:8080/get-user/"+id+"?SessionId="+getCookie('SessionId'),
        crossDomain: true,
        cache: false,
        dataType: 'json',
        type: 'GET',
        contentType: 'application/json',
        async: true,
        processData: false,
        success: function(data, textStatus, jQxhr) {
        setCookie(getCookie('SessionId'));
        let html="";
        let json=data.userScoreRelates;
        if (json.length<1){
            html='<tr><td colspan="5" style="text-align:center">Sinh viên chưa có điểm</td></tr>';
        }
        else{
            $.each(data.userScoreRelates, function(key, val){
              let finalScore=Math.round(val.processScore*0.3+val.examScore*0.7 * 10) / 10;
                html+='<tr>'
                    +'<td>'+val.subject.subject+'</td>'
                    +'<td>'+val.processScore+'</td>'
                    +'<td>'+val.examScore+'</td>'
                    +'<td>'+finalScore+'</td>';
                if(finalScore<4){
                    html+='<td>F</td>';
                }
                else if(finalScore>4&&finalScore<=4.9){
                    html+='<td>D</td>';
                }
                else if(finalScore>4.9&&finalScore<=5.4){
                    html+='<td>D+</td>';
                }
                else if(finalScore>5.4&&finalScore<=6.4){
                    html+='<td>C</td>';
                }
                else if(finalScore>6.4&&finalScore<=6.9){
                    html+='<td>C+</td>';
                }
                else if(finalScore>6.9&&finalScore<=7.9){
                    html+='<td>B</td>';
                }
                else if(finalScore>7.9&&finalScore<=8.4){
                    html+='<td>B+</td>';
                }
                else if(finalScore>8.4&&finalScore<=8.9){
                    html+='<td>A</td>';
                }
                else if(finalScore>8.9){
                    html+='<td>A+</td>';
                }

                html+='</tr>';
            });
        }
            $('#table-info-score-user').html(html);
            $('#score-info').modal('show');
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
};
