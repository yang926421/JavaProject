//var httpUrl="http://127.0.0.1:8000/api/v2";   //内网地址
//var baseUrl="http://10.9.254.161/wx_asb";
//var httpUrl2="http://10.9.254.202:8001/api/v2"
//var httpUrl="http://127.0.0.1:8000/api/v2";   //内网地址
//var httpUrl="http://117.158.148.162:8001/api/v1"; // 外网地址

//var httpUrl="http://10.9.3.133:8000/api/v1";   
//var write=0;  //测试数据放开填写
//var httpUrl="http://gsxt2.haaic.gov.cn/testv2/api/v2";


//文档下载
var downLoadUrl = "http://gsxt2.haaic.gov.cn/nbws/";

//var write=0;  //正式环境屏蔽填写
var httpUrl = "http://gsxt2.haaic.gov.cn/api/v2";
var baseUrl = "http://gsxt2.haaic.gov.cn/wechat";
//图片路径
var imgUrl = "http://gsxt2.haaic.gov.cn/app_images/";

var pageSize = 10;  //每页条数
var page = 1;   //当前页码
var totalPage = 1; //总共页数

document.title = "国家企业信用信息公示系统（河南）";

var btnArray = ['取消', '确定'];
//手机号正则表达式
var phone = /^1[34578]\d{9}$/;
//固定电话正则表达式
var tel = /^(\(\d{3,4}\)|\d{3,4}-|\s)?\d{7,14}$/;
//邮箱正则表达式
var email = /\w@\w*\.\w/;
//邮政编码正则表达式
var zipCode = /^[1-9][0-9]{5}$/;

//18位身份证号码正则表达式
var idCard = /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{4}$/;
//15位or18位身份证号码正则表达式
var idCard2 = /\d{15}|\d{18}/;
//网址正则
var website = /[\w\-_]+(\.[\w\-_]+)+([\w\-\.,@?^=%&:/~\+#]*[\w\-\@?^=%&/~\+#])?/;

/**
 * 返回字符串的实际长度, 一个汉字算2个长度
 * @param {Object} str
 */
function strlen(str) {
    return str.replace(/[^\x00-\xff]/g, "**").length;
}

//屏蔽输入字符
/***********************
 调用方法：
 在文本框中加上 onkeypress="return checkChar()"
 *************************/
function checkChar() {
    var keycode = event.keyCode;
    if (!(keycode >= 48 && keycode <= 57)) {
        return false;
    }
}

/**
 * 只能输入数字
 * @param {Object} obj
 */
function inputNum(obj) {
    obj.value = obj.value.replace(/\D/g, '')
}


/**
 * 只能输入数字和小数点
 * @param {Object} obj
 */
function inputNumPoint(obj) {
    //先把非数字的都替换掉，除了数字和.
    obj.value = obj.value.replace(/[^\d.]/g, "");
    //必须保证第一个为数字而不是.
    obj.value = obj.value.replace(/^\./g, "");
    //保证只有出现一个.而没有多个.
    obj.value = obj.value.replace(/\.{2,}/g, ".");
    //保证.只出现一次，而不能出现两次以上
    obj.value = obj.value.replace(".", "$#$").replace(/\./g, "").replace("$#$", ".");
    //能输入6个小数  
    obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d{6}).*$/, '$1$2.$3');
    //限制只能输入8位
    obj.value = obj.value.replace(/^\d{9}/g, obj.value.substring(0, 8));
}

/**
 * 是否为空
 * @param {Object} obj
 */
function isNotNull(obj) {
    obj = obj.replace(/(^\s*)|(\s*$)/g, "");
    if (obj == "")
        return false;
    else
        return true;
}

var currentDate = new Date();
var fullYear = currentDate.getFullYear();    //获取完整的年份(4位,1970)
//currentDate.getYear();        //获取当前年份(2位)
//currentDate.getMonth();       //获取当前月份(0-11,0代表1月)
//currentDate.getDate();        //获取当前日(1-31)
//currentDate.getDay();         //获取当前星期X(0-6,0代表星期天)
//currentDate.getTime();        //获取当前时间(从1970.1.1开始的毫秒数)
//currentDate.getHours();       //获取当前小时数(0-23)
//currentDate.getMinutes();     //获取当前分钟数(0-59)
//currentDate.getSeconds();     //获取当前秒数(0-59)
//currentDate.getMilliseconds();    //获取当前毫秒数(0-999)
//currentDate.toLocaleDateString();     //获取当前日期
var currentTime = currentDate.toLocaleTimeString();     //获取当前时间
//currentDate.toLocaleString( );        //获取日期与时间

//*****Long转换为Date*****************************************************************
//扩展Date的format方法
Date.prototype.format = function (format) {
    var o = {
        "M+": this.getMonth() + 1,
        "d+": this.getDate(),
        "h+": this.getHours(),
        "m+": this.getMinutes(),
        "s+": this.getSeconds(),
        "q+": Math.floor((this.getMonth() + 3) / 3),
        "S": this.getMilliseconds()
    }
    if (/(y+)/.test(format)) {
        format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(format)) {
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
        }
    }

    return format;
}

/**
 * 根据用户传的日期格式转换日期对象为日期字符串
 * @param {Object} date
 * @param {Object} pattern
 */
function getFormatDate(date, pattern) {
    if (date == undefined || date == null || date == "") {
        date = new Date();
    }

    if (pattern == undefined) {
        pattern = "yyyy-MM-dd HH:mm:ss";
    }
    return date.format(pattern);
}

/**
 * 是否转换为带时间的日期字符串
 * @param {Object} date
 * @param {Object} isFull
 */
function getSmpFormatDate(date, isFull) {
    if (date == undefined || date == null || date == "") {
        return "";
    }
    var pattern = "";
    if (isFull == true || isFull == undefined) {
        pattern = "yyyy-MM-dd hh:mm:ss";
    } else {
        pattern = "yyyy-MM-dd";
    }
    return getFormatDate(date, pattern);
}

/**
 * 转换当前日期为带时间的日期字符串
 * @param {Object} isFull
 */
function getSmpFormatNowDate(isFull) {
    return getSmpFormatDate(new Date(), isFull);
}

/**
 * 是否转换long值为带时分秒日期字符串
 * @param {Object} l
 * @param {Object} isFull
 */
function getSmpFormatDateByLong(l, isFull) {
    if (l == undefined || l == null || l == "") {
        return "";
    }
    return getSmpFormatDate(new Date(l), isFull);
}

/**
 * 根据传入的格式转换long值为日期字符串
 * @param {Object} l
 * @param {Object} pattern
 */

function getFormatDateByLong(l, pattern) {
    if (l == undefined || l == null || l == "") {
        return "";
    }
    return getFormatDate(new Date(l), pattern);
}

//格式化日期,
function formatDate(date, format) {
    var paddNum = function (num) {
        num += "";
        return num.replace(/^(\d)$/, "0$1");
    }
    //指定格式字符
    var cfg = {
        yyyy: date.getFullYear() //年 : 4位
        , yy: date.getFullYear().toString().substring(2)//年 : 2位
        , M: date.getMonth() + 1  //月 : 如果1位的时候不补0
        , MM: paddNum(date.getMonth() + 1) //月 : 如果1位的时候补0
        , d: date.getDate()   //日 : 如果1位的时候不补0
        , dd: paddNum(date.getDate())//日 : 如果1位的时候补0
        , HH: date.getHours()  //时
        , mm: date.getMinutes() //分
        , ss: date.getSeconds() //秒
    }
    format || (format = "yyyy-MM-dd HH:mm:ss");
    return format.replace(/([a-z])(\1)*/ig, function (m) {
        return cfg[m];
    });
}

/**
 * 获取url参数值
 */
function GetRequest(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
}

/**
 * 填充select   codeType 代码类别   id DOM对象
 */
function loadData(codeType, id) {
    $.ajax({
        type: "get",
        url: httpUrl + "/code.json",
        async: false,
        data: {"CODETYPE": codeType},
        dataType: "json",
        success: function (res) {
            if (res.success == true) {
                var obj = res.data;
                if (obj != null && obj.length > 0) {
                    var htmlData = "";
                    for (var i = 0; i < obj.length; i++) {
                        htmlData += "<option value=\"" + obj[i].CODE_VALUE + "\">" + obj[i].CODE_NAME + "</option>";
                        //  $("#"+id).append(htmlData)
                    }
                    $("#" + id).append(htmlData).parent().html();

                }
            } else {
                mui.toast(res.codeMsg);
            }
        }
    });
}

/**
 * 下拉选择值改变时中文名同时赋值到隐藏域
 * @param {Object} obj 下拉框dom
 * @param {Object} id  隐藏域的id名称
 */
function selectType(obj, id) {
    $("#" + id).val($(obj).find("option:selected").text());
}

/**
 * 返回上一页
 */
function goBack() {
    history.go(-1);
}

//区域代码，市级4位 县级6位
var areas = {
    "郑州": "4101",
    "开封": "4102",
    "洛阳": "4103",
    "平顶山": "4104",
    "安阳": "4105",
    "鹤壁": "4106",
    "新乡": "4107",
    "焦作": "4108",
    "濮阳": "4109",
    "许昌": "4110",
    "漯河": "4111",
    "三门峡": "4112",
    "南阳": "4113",
    "商丘": "4114",
    "信阳": "4115",
    "周口": "4116",
    "驻马店": "4117",
    "济源": "419001",
    "巩义": "410181",
    "兰考": "410225",
    "汝州": "410482",
    "滑县": "410526",
    "邓州": "411381",
    "永城": "411481",
    "固始": "411525",
    "鹿邑": "411628",
    "新蔡": "411729",
    "长垣": "410728"
}

/**
 * 获取区域代码
 * @param {Object} txt
 */
function getArea(txt) {
    // return areas["+txt+"] //方法1
    return eval('areas.' + txt);  //方法2
}

var noticeTypes = {
    "noticeType1": {
        "列入公告": "11",
        "移出公告": "12",
        "期满三年公告": "13"
    },
    "noticeType2": {
        "列入公告": "21",
        "移出公告": "22"
    },

    "noticeType3": {
        "司法股权冻结公告": "21",
        "司法股东变更公告": "22"
    },
    "noticeType4": {
        "抽查工作计划": "21",
        "抽查任务": "22",
        "检查结果": "23"
    }
}

/**
 * 获取公告类型
 * @param {Object} num
 * @param {Object} txt
 */
function getNoticeType(num, txt) {
    return eval('noticeTypes.noticeType' + num + '.' + txt);
}

/**
 * 设置分页加载
 * @param {Object} res
 */
function loadPage(res) {
    totalPage = res.totalPage;
    page = res.page;
    if (totalPage <= 1) {
        $("#loadData").hide();
        $("#noData").hide();
    } else if (totalPage > 1 && totalPage != page) {
        $("#loadData").show();
    } else if (totalPage > 1 && page == totalPage) {
        $("#loadData").hide();
        $("#noData").show();
    }
    $("#totalPage").val(res.totalPage);
    $("#page").val(res.page + 1);
}

//请求拦截，需要登录才能操作的
//$(document).ajaxComplete(function(event,xhr,options){
//	var res=JSON.parse(xhr.responseText);
//  if(res.success==false){
//  	if(res.code==3){
//	    	mui.toast(res.codeMsg);
//	    	window.top.location.href="../login.html";
//  	}else if(res.error!=null && res.error.length>0){
//			mui.toast(res.error[0].message);
//		}else{
//			mui.toast(res.codeMsg);
//		}
//  }
//});

$(function () {
    var dom = document.createElement("div");
    document.body.appendChild(dom);
    var loadDom = document.createElement("div");
    document.body.appendChild(loadDom);
    $.ajaxSetup({
        beforeSend: function () {
            dom.className = "overlayer";
            //创建加载点
            loadDom.className = "loadbox";
            dom.style.display = "block";
            loadDom.style.display = "block";
            loadDom.innerHTML = "<div class=\"bounce1\"></div> <div class=\"bounce2\"></div><div class=\"bounce3\"></div>";
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {

            dom.style.display = "none";
            loadDom.style.display = "none";
            if (textStatus == "timeout") {
                mui.toast("请求超时");
            } else {
                mui.toast("加载失败，请稍后再试");
            }
        },
        complete: function (event, xhr, options) {
            dom.style.display = "none";
            loadDom.style.display = "none";
            if (xhr == "success") {
                var res = JSON.parse(event.responseText);
                if (res.success == false) {
                    if (res.code == 3 || res.code == -1) {
                        mui.confirm(res.codeMsg, "提示", btnArray, function (e) {
                            if (e.index == 1) {
                                window.top.location.href = baseUrl + "/login.html";
                            }
                        })
                    }
//			    	else if(res.code==-1){
//			    		mui.confirm("登录超时，请重新登录","提示",btnArray,function(e){
//			    				window.top.location.href="../login.html";
//			    		});
//			    	}
                    else if (res.error != null && res.error.length > 0) {
                        mui.toast(res.error[0].message);
                    } else {
                        mui.toast(res.codeMsg);
                    }
                } else if (res.success == "timeout") {
                    mui.toast("请求超时");
                }

            }
        }

    });
});


//登录之后的值

var SESSIONID;  //会话Id
var TOKEN;
var EASY_CANCLE; //是否显示简易注销标识  true:可以   false:不可以
var BODY_TYPE; //主体具体类型，返回的是编码
var TYPE;   //主体类别，1：企业，2：农专，3：个体
var OTHER_PUBLICITY;  //是否显示其它公示标识  true:可以   false:不可以
var PRIPID;  //主体id
var BODY_NAME; //主体名称
var BODY_NO;  //注册号or信用代码号
var REGORG;  //注册机构代码
var REGORG_CN; //注册机构中文
var REGNO;  //注册号
var UNISCID;  //社会信用代码
var GROUP_MEMBER; //集团成员信息填报是否显示标识 true 有，false 无
var com_NAME;//工商联络员姓名
var com_MOBTEL;//工商联络员手机号
var com_CERNO;//工商联络员证件号码
var pubAcceptPicNum = 3; //违法、异常处理上传照片最大数量

var loginInfo = sessionStorage.getItem("loginInfo");

$(function () {
    console.info(loginInfo + "===logininfo");
    if (loginInfo != "undefined" && loginInfo != null && loginInfo != "") {
        loginInfo = JSON.parse(loginInfo);
        SESSIONID = loginInfo.SESSIONID;
        TOKEN = loginInfo.TOKEN;
        EASY_CANCLE = loginInfo.EASY_CANCLE; //是否显示简易注销标识  true:可以   false:不可以
        BODY_TYPE = loginInfo.BODY_TYPE; //主体具体类型，返回的是编码
        TYPE = loginInfo.TYPE;   //主体类别，1：企业，2：农专，3：个体
        OTHER_PUBLICITY = loginInfo.OTHER_PUBLICITY;  //是否显示其它公示标识  true:可以   false:不可以
        PRIPID = loginInfo.PRIPID;  //主体id
        BODY_NAME = loginInfo.BODY_NAME; //主体名称
        BODY_NO = loginInfo.NO;
        REGORG = loginInfo.REGORG;
        REGORG_CN = loginInfo.REGORG_CN;
        REGNO = loginInfo.REGNO;  //注册号
        UNISCID = loginInfo.UNISCID;  //信用代码号
        GROUP_MEMBER = loginInfo.GROUP_MEMBER;
        com_NAME = loginInfo.NAME;
        com_MOBTEL = loginInfo.MOBTEL;
        com_CERNO = loginInfo.CERNO;
    }
})

//当 AJAX 请求正在进行时显示 "loading" 的指示：
//$(document).ajaxStart(function(){
//  $("#wait").css("display","block");
//});
//$(document).ajaxComplete(function(){
//  $("#wait").css("display","none");
//});

function delHtmlTag(str) {
    return str.replace(/<[^>]+>/g, "");//去掉所有的html标记
}

//返回首页
function returnIndex() {
    window.top.location.href = "../index.html";
}

//跳转到其他信息登记的首页
function returnOtherInfoIndex() {
    window.location.href = "other-inf.html";
}


$(function () {
    //监听input输入框不能输入空格
    $("input[type=text]").keyup(function () {
        this.value = this.value.replace(/(^\s+)|\s+$/g, "");
    })
    //监听input输入框不能输入敏感词
//	$("input[type=text]").blur(function(){
//		getCheck(this.value);
//	})
})


function getCheck(val) {
    $.ajax({
        type: "get",
        url: httpUrl + "/p/an/params/check.json",
        data: {"keyword": val},
        dataType: "json",
        success: function (data) {
            console.info(data);
        }
    });
}

/**
 * 比较日期大小
 * @param {Object} date1
 * @param {Object} date2
 */
function testDate(date1, date2) {
    var oDate1 = new Date(date1);
    var oDate2 = new Date(date2);
    if (oDate1.getTime() > oDate2.getTime()) {
        return false;
    } else {
        return true;
    }
}