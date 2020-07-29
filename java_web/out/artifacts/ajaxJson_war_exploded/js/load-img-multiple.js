	var count=0;
 $(function(){
        var tmpl = '<li class="weui-uploader__file" style="background-image:url(#url#)"></li>',
            $gallery = $("#gallery"), $galleryImg = $("#galleryImg"),
            $uploaderInput = $("#uploaderInput"),
            $uploaderFiles = $("#uploaderFiles")
            ;
 	
        $uploaderInput.on("change", function(e){
            var src, url = window.URL || window.webkitURL || window.mozURL, files = e.target.files;
            count+=files.length;
            if(count>4){
            	mui.toast("最多可上传4张图片");
            }else{
            	for (var i = 0, len = files.length; i < len; ++i) {
            	    var file = files[i];

            	    if (url) {
            	        src = url.createObjectURL(file);
            	    } else {
            	        src = e.target.result;
            	    }
					$uploaderFiles.append($(tmpl.replace('#url#', src)));
            	}
            	
            }
        });
        $uploaderFiles.on("click", "li", function(){
            $galleryImg.attr("style", this.getAttribute("style"));
            $gallery.fadeIn(100);
        });
        $gallery.on("click", function(){
            $gallery.fadeOut(100);
        });
    });
