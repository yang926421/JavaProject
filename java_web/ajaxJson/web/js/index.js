$(document).ready(function(){
	$(".play span").click(function(){
		$(this).addClass("current").siblings().removeClass();
		$(".banner img").hide().eq($('.play span').index(this)).show(); 
		 n = $(".play span").index(this);
		 $("#num").text(n + 1)
	})
	
});

//自动轮播
 n = 0;  
function moveImg(){
	if(n < $(".banner img").length-1){
		n = n+1;
	}else{
		 n = 0;
	}
		
		$(".banner img").hide().eq(n).fadeIn();
		$(".play span").eq(n).addClass("current").siblings().removeClass();
//		n = $(".banner img").eq(n);
		$("#num").text(n + 1)
//	$(".banner").animate({marginLeft:-450*n},1000);
}
    setInterval(moveImg,6000);//设置定时器
			
	