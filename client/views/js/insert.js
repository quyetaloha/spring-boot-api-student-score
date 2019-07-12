
$('button').click(function(){
    setUserScore();
});
function setUserScore(){
    blockUi();
    let hoTen=$('#ho-ten').val();
    let lop=$('#lop').val();
    let toan1=$('input[name="toan1"]').val();
    let toan2=$('input[name="toan2"]').val();
    let ly1=$('input[name="ly1"]').val();
    let ly2=$('input[name="ly2"]').val();
    let hoa1=$('input[name="hoa1"]').val();
    let hoa2=$('input[name="hoa2"]').val();
    let van1=$('input[name="van1"]').val();
    let van2=$('input[name="van2"]').val();
    let su1=$('input[name="su1"]').val();
    let su2=$('input[name="su2"]').val();
    let dia1=$('input[name="dia1"]').val();
    let dia2=$('input[name="dia2"]').val();
    let diem1=[toan1,toan2];
    let diem2=[ly1,ly2];
    let InputUserAndScore={hoTen:hoTen,lop:lop,diem:[[toan1,toan2],[ly1,ly2],[hoa1,hoa2],[van1,van2],[su1,su2],[dia1,dia2]]};
    $.ajax({
        url: "http://localhost:8080/insert-score-user"+"?SessionId="+getCookie('SessionId'),
        crossDomain: true,
        data:JSON.stringify(InputUserAndScore),
        cache: false,
        dataType: 'text',
        type: 'POST',
        contentType: 'application/json',
        async: true,
        processData: false,
        success: function(data, textStatus, jQxhr) {
        setCookie(getCookie('SessionId'));
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
