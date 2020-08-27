//图片上传
$(function () {

    var btns = $('.weui-uploader__input');
    btns.each(function (i, btn) {
        btn.addEventListener('tap', function () {
            var uploadId = this.getAttribute('id');
            var flag = uploadId.substring(13, 14);
            var tmpl = "<div id='scImg" + flag + "'><li class='weui-uploader__file' style='background-image:url(#url#);'></li></div>",
                $gallery = $("#gallery" + flag), $galleryImg = $("#galleryImg" + flag),
                $uploaderInput = $("#uploaderInput" + flag),
                $uploaderFiles = $("#uploaderFiles" + flag);


            $uploaderInput.on("change", function (e) {
                var src, url = window.URL || window.webkitURL || window.mozURL, files = e.target.files;
                for (var i = 0, len = files.length; i < len; ++i) {
                    var file = files[i];

                    if (url) {
                        src = url.createObjectURL(file);
                    } else {
                        src = e.target.result;
                    }
                    $uploaderFiles.append($(tmpl.replace('#url#', src)));
                    $("#uploadDiv" + flag).css("display", "none");
                }
            });

            //图片预览
            $uploaderFiles.on("click", "li", function () {
                $galleryImg.attr("style", this.getAttribute("style"));
                $gallery.fadeIn(200);
            });
            $gallery.on("click", function () {
                $gallery.fadeOut(200);
            });


        })
    })
})




