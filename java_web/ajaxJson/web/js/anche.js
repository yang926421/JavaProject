var ANCHEYEAR=GetRequest("ANCHEYEAR");
function toSure(val){
	var url="";
	if(val==1){
		url="/e/an/copy.json";
	}else if(val==2){ //农专
		url="/c/an/copy.json";
	}else if(val==3){
		url="/i/an/copy.json";
	}
	if($('#read').is(':checked')) {
						$.ajax({
							type:'post',
							url:httpUrl+url,
							data:{"YEAR":ANCHEYEAR,"PRIPID":PRIPID,"SESSIONID":SESSIONID,"TOKEN":TOKEN,"CHECK":"1"},
							dataType:'json',
							complete: function (event,xhr,options) {
									if(xhr=="success"){
							           	var res=JSON.parse(event.responseText);
									    if(res.success==false){
									    	mui.alert(res.codeMsg,"提示","确定",function(){
												window.location.href="report.html?ANCHEYEAR="+ANCHEYEAR;
											});
									    }
						          	
						          	}
					          },
							success:function(res){
								
								if(res.success==true){
									if(res.data.msg==true){   //msg为true说明有上一年的年报信息，弹出提示弹框是否需要复制
										mui.confirm("请确认您是否需要复制上一年的年报信息？","提示",btnArray,function(e){
											if (e.index == 1) {
												$.ajax({
													type:"post",
													url:httpUrl+url,
													async:false,
													data:{"YEAR":ANCHEYEAR,"PRIPID":PRIPID,"SESSIONID":SESSIONID,"TOKEN":TOKEN},
													dataType:'json',
													success:function(r){
														if(r.success==true){
															window.location.href="report.html?ANCHEYEAR="+ANCHEYEAR+"&ANCHEID="+r.data.ANCHEID;
														}else{
															mui.toast(r.codeMsg);
														}
													}
												});
											}else{
												 window.location.href="report.html?ANCHEYEAR="+ANCHEYEAR;
											}
										});
									}else{ //msg为false说明没有上一年的年报信息，不需要弹框直接跳转到添加页面
										 window.location.href="report.html?ANCHEYEAR="+ANCHEYEAR;
									}
								
								}
							}
						});
					
	    
	 }
}
			
