//图片上传
$(function () {
    var tmpl = '<div id="scImg"><li class="weui-uploader__file" style="background-image:url(#url#);"></li><span class="delete-img" onclick="deleteImg()"><img src="../img/delete.png"/></span></div>',
        $gallery = $("#gallery"), $galleryImg = $("#galleryImg"),
        $uploaderInput = $("#uploaderInput"),
        $uploaderFiles = $("#uploaderFiles");

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
            $(".weui-uploader__input-box").css("display", "none");

        }
    });


    //图片预览
    $uploaderFiles.on("click", "li", function () {
        $galleryImg.attr("style", this.getAttribute("style"));
        $gallery.fadeIn(100);
    });
    $gallery.on("click", function () {
        $gallery.fadeOut(100);
    });
});

//图片删除
function deleteImg() {
    $("#scImg").remove();
    $(".weui-uploader__input-box").css("display", "inline-block");
}

/** * 图片压缩，默认同比例压缩 * @param {Object} path
 * *   pc端传入的路径可以为相对路径，但是在移动端上必须传入的路径是照相图片储存的绝对路径
 * * @param {Object} obj
 * *   obj 对象 有 width， height， quality(0-1)
 * * @param {Object} callback
 * *   回调函数有一个参数，base64的字符串数据 */
function dealImage(path, obj, callback) {
    var img = new Image();
    img.src = path;
    img.onload = function () {
        var that = this;
        // 默认按比例压缩
        var w = that.width,
            h = that.height,
            scale = w / h;
        w = obj.width || w;
        h = obj.height || (w / scale);
        var quality = 0.7;
        // 默认图片质量为0.7
        //生成canvas
        var canvas = document.createElement('canvas');
        var ctx = canvas.getContext('2d');
        // 创建属性节点
        var anw = document.createAttribute("width");
        anw.nodeValue = w;
        var anh = document.createAttribute("height");
        anh.nodeValue = h;
        canvas.setAttributeNode(anw);
        canvas.setAttributeNode(anh);
        ctx.drawImage(that, 0, 0, w, h);
        // 图像质量
        if (obj.quality && obj.quality <= 1 && obj.quality > 0) {
            quality = obj.quality;
        }
        // quality值越小，所绘制出的图像越模糊
        var base64 = canvas.toDataURL('image/jpeg', quality);
        // 回调函数返回base64的值
        callback(base64);
    }
}

//判断是否存在画布  
function isCanvasSupported() {
    var elem = document.createElement('canvas');
    return !!(elem.getContext && elem.getContext('2d'));
}

//压缩方法  
function compress(event, callback) {
    if (typeof (FileReader) === 'undefined') {
        console.log("当前浏览器内核不支持base64图标压缩");
        //调用上传方式  不压缩  
    } else {
        try {
            var file = event.currentTarget.files[0];
            if (!/image\/\w+/.test(file.type)) {
                alert("请确保文件为图像类型");
                return false;
            }
            var reader = new FileReader();
            reader.onload = function (e) {
                var image = $('<img/>');
                image.load(function () {
                    console.log("开始压缩");
                    var square = 700;
                    var canvas = document.createElement('canvas');
                    canvas.width = square;
                    canvas.height = square;
                    var context = canvas.getContext('2d');
                    context.clearRect(0, 0, square, square);
                    var imageWidth;
                    var imageHeight;
                    var offsetX = 0;
                    var offsetY = 0;
                    if (this.width > this.height) {
                        imageWidth = Math.round(square * this.width / this.height);
                        imageHeight = square;
                        offsetX = -Math.round((imageWidth - square) / 2);
                    } else {
                        imageHeight = Math.round(square * this.height / this.width);
                        imageWidth = square;
                        offsetY = -Math.round((imageHeight - square) / 2);
                    }
                    context.drawImage(this, offsetX, offsetY, imageWidth, imageHeight);
                    var data = canvas.toDataURL('image/jpeg');
                    //压缩完成执行回调
                    callback(data);
                });
                image.attr('src', e.target.result);
            };
            reader.readAsDataURL(file);
        } catch (e) {
            console.log("压缩失败!");
            //调用上传方式  不压缩  
        }
    }
} 