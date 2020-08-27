//类别选择切换
$(function () {
    $("#service_opt").change(function () {
        var checkValue = $("#service_opt").val();
        if (checkValue == 0) {
            $('#change').css('display', 'block');
            $('#zhuxiao-block').css('display', 'none');
            $('#diaoxiao-block').css('display', 'none');
            $('#wuxiao-block').css('display', 'none');
        }
        if (checkValue == 1) {
            $('#change').css('display', 'none');
            $('#zhuxiao-block').css('display', 'block');
            $('#diaoxiao-block').css('display', 'none');
            $('#wuxiao-block').css('display', 'none');
        }
        if (checkValue == 2) {
            $('#change').css('display', 'none');
            $('#zhuxiao-block').css('display', 'none');
            $('#diaoxiao-block').css('display', 'block');
            $('#wuxiao-block').css('display', 'none');
        }
        if (checkValue == 3) {
            $('#change').css('display', 'none');
            $('#diaoxiao-block').css('display', 'none');
            $('#zhuxiao-block').css('display', 'none');
            $('#wuxiao-block').css('display', 'block');
        }
    })

});
