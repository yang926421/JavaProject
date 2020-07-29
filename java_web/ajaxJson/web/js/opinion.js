 //获取上传图片的元素
 var filechooser = $("#uploaderInput");
  //    用于压缩图片的canvas
  var canvas = document.createElement("canvas");
  var ctx = canvas.getContext('2d');
  //    瓦片canvas
  var tCanvas = document.createElement("canvas");
  var tctx = tCanvas.getContext("2d");
  var maxsize = 100 * 1024;
   var img = new Image();
 var uploadData;
   var type;
    
    //记录上传图片总数
 	var count=0;
  var formdata = getFormData();
  
$(function(){
	
	 //点击提交时
  $("#commit").on("click", function() {
		upload(uploadData,type);
		  img = null;
      })
      .on("touchstart", function() {
        $(this).addClass("touch")
      })
      .on("touchend", function() {
        $(this).removeClass("touch")
      });
	
	
    var tmpl = '<li class="weui-uploader__file" style="background-image:url(#url#)"></li>',
        $gallery = $("#gallery"), $galleryImg = $("#galleryImg"),
         $uploaderInput = $("#uploaderInput"),
        $uploaderFiles = $("#uploaderFiles");
  	$uploaderInput.on("change", function(e) {
	    
	    var src, url = window.URL || window.webkitURL || window.mozURL, files = e.target.files;
	    
	    if (!this.files.length) return;
	    var filesArray = Array.prototype.slice.call(this.files);
	    if (filesArray.length > 4) {
	      mui.toast("最多同时只可上传4张图片");
	      return;
	    }
	    count+=files.length;
        if(count>4){
        	mui.toast("最多可上传4张图片");
        }else{
	    	for (var i = 0, len = files.length; i < len; ++i) {
	    	    var file = files[i];
				//把源文件放入formdata去上传，这里formdata追加不会被覆盖
	    	     formdata.append('uploaderInput', file);
	    	    if (url) {
	    	        src = url.createObjectURL(file);
	    	    } else {
	    	        src = e.target.result;
	    	    }
	    	     if(count==1){
	    	    	tmpl= tmpl.replace('#img#', "img"+count);
	    	    	 tmpl=tmpl.replace('#deleteImg()#', "deleteImg("+count+")");
	    	    }else{
	    	    	tmpl= tmpl.replace('img'+(count-1), "img"+count);
	    	    	 tmpl=tmpl.replace('deleteImg('+(count-1)+')', "deleteImg("+count+")");
	    	    }
				$uploaderFiles.append($(tmpl.replace('#url#', src)));
	    	}
        	
        }
	   if(count==4){
        	  $(".weui-uploader__input-box").css("display","none");
        } 
	    
	    filesArray.forEach(function(file, i) {
		      if (!/\/(?:jpeg|png|gif)/i.test(file.type)) return;
		      var reader = new FileReader();
		      var li = document.createElement("li");
		//          获取图片大小
		      var size = file.size / 1024 > 1024 ? (~~(10 * file.size / 1024 / 1024)) / 10 + "MB" : ~~(file.size / 1024) + "KB";
		     
		     li.innerHTML = '<div class="progress"><span></span></div><div class="size">' + size + '</div>';
		      $(".img-list").append($(li));
	      
	      	reader.onload = function() {
		        var result = this.result;
		        img.src = result;
		        $(li).css("background-image", "url(" + result + ")");
		        
		        //如果图片大小小于100kb，则直接上传
		        if (result.length <= maxsize) {
		        	type=file.type;
		        	uploadData=result;
//			          img = null;
//			          upload(result, file.type, $(li));
			          return;
		        }
		//      图片加载完毕之后进行压缩，然后上传
		        if (img.complete) {
		        	type=file.type;
		        	uploadData=compress(img);
		        //  callback();
		        } else {
		         // img.onload = callback;
		        }
		        function callback() {
		          var data = compress(img);
		          upload(data, file.type, $(li));
		          img = null;
		        }
	      	};
	      reader.readAsDataURL(file);
	    })
  	});
  	
  	
  	 $uploaderFiles.on("click", "li", function(){
            $galleryImg.attr("style", this.getAttribute("style"));
            $gallery.fadeIn(100);
        });
        $gallery.on("click", function(){
            $gallery.fadeOut(100);
        });
  	
  	
});
  //    使用canvas对大图片进行压缩
  function compress(img) {
    var initSize = img.src.length;
    var width = img.width;
    var height = img.height;
    //如果图片大于四百万像素，计算压缩比并将大小压至400万以下
    var ratio;
    if ((ratio = width * height / 4000000) > 1) {
      ratio = Math.sqrt(ratio);
      width /= ratio;
      height /= ratio;
    } else {
      ratio = 1;
    }
    canvas.width = width;
    canvas.height = height;
//        铺底色
    ctx.fillStyle = "#fff";
    ctx.fillRect(0, 0, canvas.width, canvas.height);
    //如果图片像素大于100万则使用瓦片绘制
    var count;
    if ((count = width * height / 1000000) > 1) {
      count = ~~(Math.sqrt(count) + 1); //计算要分成多少块瓦片
//            计算每块瓦片的宽和高
      var nw = ~~(width / count);
      var nh = ~~(height / count);
      tCanvas.width = nw;
      tCanvas.height = nh;
      for (var i = 0; i < count; i++) {
        for (var j = 0; j < count; j++) {
          tctx.drawImage(img, i * nw * ratio, j * nh * ratio, nw * ratio, nh * ratio, 0, 0, nw, nh);
          ctx.drawImage(tCanvas, i * nw, j * nh, nw, nh);
        }
      }
    } else {
      ctx.drawImage(img, 0, 0, width, height);
    }
    //进行最小压缩
    var ndata = canvas.toDataURL('image/jpeg', 0.7);
    console.log('压缩前：' + initSize);
    console.log('压缩后：' + ndata.length);
    console.log('压缩率：' + ~~(100 * (initSize - ndata.length) / initSize) + "%");
    tCanvas.width = tCanvas.height = canvas.width = canvas.height = 0;
    return ndata;
  }
  //    图片上传，将base64的图片转成二进制对象，塞进formdata上传
  function upload(basestr, type) {
  	
  	var FEED_CONTENT=$("#FEED_CONTENT").val();
	if(FEED_CONTENT.length<1){
		mui.toast("请输入意见内容");
		return;
	}
	var CONTACT_TEL=$("#CONTACT_TEL").val();
	if(CONTACT_TEL.length>0){
		if(!phone.test(CONTACT_TEL) ){
			mui.toast("请输入正确的电话号码");
		return;
		}
	}
	var CONTACT_EMAIL=$("#CONTACT_EMAIL").val();
	if(CONTACT_EMAIL.length>0){
		if(!email.test(CONTACT_EMAIL) ){
			mui.toast("请输入正确的电子邮箱");
		return;
		}
	}
	var text;
	var buffer;
	var pecent;
	var blob;
  	if(basestr!=null && basestr!=""){
  		text = window.atob(basestr.split(",")[1]);
  		buffer = new Uint8Array(text.length);
  		pecent = 0, loop = null;
  		for (var i = 0; i < text.length; i++) {
  		  buffer[i] = text.charCodeAt(i);
  		}
  		blob = getBlob([buffer], type);
  	}
    var xhr = new XMLHttpRequest();
    formdata.append('FEED_CONTENT', $("#FEED_CONTENT").val());
    formdata.append('CONTACT_TEL', $("#CONTACT_TEL").val());
    formdata.append('CONTACT_EMAIL', $("#CONTACT_EMAIL").val());
    xhr.open('post', httpUrl+url);
    //创建遮罩加载点
	var dom=document.createElement("div");
	document.body.appendChild(dom);
	var loadDom=document.createElement("div");
	document.body.appendChild(loadDom);
	dom.className="overlayer";
	loadDom.className="loadbox";
	dom.style.display="block";
    loadDom.style.display="block";
	loadDom.innerHTML ="<div class=\"bounce1\"></div> <div class=\"bounce2\"></div><div class=\"bounce3\"></div>";
    xhr.onreadystatechange = function() {
    	
    	if (xhr.readyState == 4 && xhr.status == 200) {
    		dom.style.display="none";
           	loadDom.style.display="none";
	        var jsonData = JSON.parse(xhr.responseText);
	        if(jsonData.success){
	        	mui.toast(jsonData.codeMsg);	
	        	window.location.href="my-index.html";
	        }else{
	        	mui.toast(jsonData.codeMsg);	
	        }
        
      }
    };
    xhr.send(formdata);
  }
  /**
   * 获取blob对象的兼容性写法
   * @param buffer
   * @param format
   * @returns {*}
   */
  function getBlob(buffer, format) {
    try {
      return new Blob(buffer, {type: format});
    } catch (e) {
      var bb = new (window.BlobBuilder || window.WebKitBlobBuilder || window.MSBlobBuilder);
      buffer.forEach(function(buf) {
        bb.append(buf);
      });
      return bb.getBlob(format);
    }
  }
  /**
   * 获取formdata
   */
  function getFormData() {
    var isNeedShim = ~navigator.userAgent.indexOf('Android')
        && ~navigator.vendor.indexOf('Google')
        && !~navigator.userAgent.indexOf('Chrome')
        && navigator.userAgent.match(/AppleWebKit\/(\d+)/).pop() <= 534;
    return isNeedShim ? new FormDataShim() : new FormData()
  }
  /**
   * formdata 补丁, 给不支持formdata上传blob的android机打补丁
   * @constructor
   */
  function FormDataShim() {
    console.warn('using formdata shim');
    var o = this,
        parts = [],
        boundary = Array(21).join('-') + (+new Date() * (1e16 * Math.random())).toString(36),
        oldSend = XMLHttpRequest.prototype.send;
    this.append = function(name, value, filename) {
      parts.push('--' + boundary + '\r\nContent-Disposition: form-data; name="' + name + '"');
      if (value instanceof Blob) {
        parts.push('; filename="' + (filename || 'blob') + '"\r\nContent-Type: ' + value.type + '\r\n\r\n');
        parts.push(value);
      }
      else {
        parts.push('\r\n\r\n' + value);
      }
      parts.push('\r\n');
    };
    // Override XHR send()
    XMLHttpRequest.prototype.send = function(val) {
      var fr,
          data,
          oXHR = this;
      if (val === o) {
        // Append the final boundary string
        parts.push('--' + boundary + '--\r\n');
        // Create the blob
        data = getBlob(parts);
        // Set up and read the blob into an array to be sent
        fr = new FileReader();
        fr.onload = function() {
          oldSend.call(oXHR, fr.result);
        };
        fr.onerror = function(err) {
          throw err;
        };
        fr.readAsArrayBuffer(data);
        // Set the multipart content type and boudary
        this.setRequestHeader('Content-Type', 'multipart/form-data; boundary=' + boundary);
        XMLHttpRequest.prototype.send = oldSend;
      }
      else {
        oldSend.call(this, val);
      }
    };
  }