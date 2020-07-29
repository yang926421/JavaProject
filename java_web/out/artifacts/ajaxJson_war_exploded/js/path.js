/**
 * 获取连接
 * @param {Object} val
 * @param {Object} type
 */
function getPath(val,type){
	var paths=eval('path.'+val);
	window.location.href=paths;
}
/**
 * 获取年报连接
 * @param {Object} val  id标识
 * @param {Object} type 企业类型标识
 * @param {Object} ancheId 年报id
 */
function getAnchePath(val,type,ancheId){
	var paths="";
	if(type==1){
		paths=eval('path_qy.'+val);
	}else if(type==2){
		paths=eval('path_nz.'+val);
	}else if(type==3){
		paths=eval('path_gt.'+val);
	}
	window.location.href=paths+"?ANCHEID="+ancheId;
}

function getAnchePathShow(val,type,ancheId,isSearch){
	var paths="";
	if(isSearch==1){
		if(type==1){
			paths=eval('path_qy_show_search.'+val);
		}else if(type==2){
			paths=eval('path_nz_show_search.'+val);
		}else if(type==3){
			paths=eval('path_gt_show_search.'+val);
		}
	}else{
		if(type==1){
			paths=eval('path_qy_show.'+val);
		}else if(type==2){
			paths=eval('path_nz_show.'+val);
		}else if(type==3){
			paths=eval('path_gt_show.'+val);
		}
	}
	window.location.href=paths+"?ANCHEID="+ancheId;
}

//企业搜索要显示的菜单项和连接
var path={
	//以下是企业查询显示的
	"BASE_INFO":"businesslicense.html",
	"ADMIN_LICENSE":"xingzhengxuke.html",
	"ADMIN_SANCTION":"xingzhengchufa.html",
	"EXCEPTION_LIST":"yichangmulu.html",
	"SERIOUS_VIOLATION":"weifaqiye.html",
	//以下是政府提供的公示信息
	"HOLDER_CAPITAL":"shareholderInfo.html",
	"MAIN_PERSION":"companypersonnel.html",
	"BRANCH_INFO":"branchcompay.html",
	"LIQUIDATION":"qingsuan.html",
	"ALTER_INFO":"biangenInfo.html",
	"CHATTEL_MORTGAGE":"dongcandiya.html",
	"STOCK_OWNERSHIP":"guquanchuzhi.html",
	"INTELLECTUAL":"zhishichanquan.html",
	"TRADEMARK":"shangbiaozhuche.html",
	"DOUBLE_RANDOM":"jiancha.html",
	"JUDICIAL_ASSIST":"sifaxiezhu.html",
	"MULTI_CAR":"moreOneInfo.html",
	//以下是企业自行提供的公示信息
	"YEAR_REPORT":"ancheList.html",
	"YEAR_HOLDER_CAPITAL":"gudongchuzi.html",
	"YEAR_STOCK_ALTER":"anche_guquanbiangeng.html",
	"YEAR_ADMIN_LICENSE":"anche_xingzhengxuke.html",
	"YEAR_INTELLECTUAL":"company_zhishichanquan.html",
	"YEAR_ADMIN_SANCTION":"company_xingzhengchufa.html",
	"PARTNER_INFO":"partner-inf.html",
	"MEMBER_ROSTER":"member-inf.html",
	"FAMILY_MEMBER_NAME":"farmily-member-inf.html",
	"COMPETENT_DEPART":"contributor-inf.html",
	"YEAR_ANNOUNCE_CANCEL":"announceCancel.html",
	"YEAR_GROUP_MEMBER":"groupMember.html",
	"YEAR_LICENSE_NULLIFY":"licenseNullify.html"
}
//企业年报
var path_qy={
	"HOLDER_CAPITAL":"../subcapital/contribution.html",
	"WEBSITE":"../websiteInfo/website-inf.html",
	"STOCK_ALTER":"../alterstockInfo/equity-record.html",
	"INVESTMENT":"../forinvestment/investment-inf.html",
	"ASSET_STATUS":"asset-inf.html",
	"GUARANTEE":"../forguaranteeInfo/guarantee-inf.html",
	"SOCIAL_SECURITY":"../socsecinfo/social-security-inf.html",
	"PRODUCTION_MANAGE":"asset-inf.html",
	"PARTY_BUILDING":"add-partyinfo.html",
	"ADMIN_LICENSE":"行政许可情况",
	"BRANCH":"分支机构情况",
	"PRODUCTION_MANAGE":"资产状况信息",
	"CU_REGINFO":"../bg_info_qy/customs_index.html",
	"CU_TAXRELIEFGOODS":"../bg_info_qy/jmsjdhwInfo.html"
}
//农专年报
var path_nz={
	"HOLDER_CAPITAL":"股东及出资信息",
	"WEBSITE":"../sfc_websiteinfo/website-inf.html",
	"STOCK_ALTER":"股权变更信息",
	"INVESTMENT":"对外投资信息",
	"ASSET_STATUS":"资产状态",
	"GUARANTEE":"对外担保信息",
	"SOCIAL_SECURITY":"../sfc_socsecinfo/social-security-inf.html",
	"PRODUCTION_MANAGE":"asset-inf.html",
	"PARTY_BUILDING":"党建信息",
	"ADMIN_LICENSE":"../sfc_licenceinfo/licenceinfo.html",
	"BRANCH":"../sfc_branchinfo/branchinfo-list.html",
	"CU_REGINFO":"../sfc_bg_info/customs_index.html",
	"CU_TAXRELIEFGOODS":"../sfc_bg_info/jmsjdhwInfo.html"
}
//个体年报
var path_gt={
	"HOLDER_CAPITAL":"股东及出资信息",
	"WEBSITE":"../pb_websiteinfo/website-inf.html",
	"STOCK_ALTER":"股权变更信息",
	"INVESTMENT":"对外投资信息",
	"ASSET_STATUS":"asset-inf.html",
	"GUARANTEE":"对外担保信息",
	"SOCIAL_SECURITY":"社保信息",
	"PRODUCTION_MANAGE":"asset-inf.html",
	"PARTY_BUILDING":"add-partyinfo.html",
	"ADMIN_LICENSE":"../pb_licenceinfo/licenceinfo.html",
	"CU_REGINFO":"../pb_bg_info/customs_index.html",
	"CU_TAXRELIEFGOODS":"../pb_bg_info/jmsjdhwInfo.html"
}


//企业年报
var path_qy_show={
	"HOLDER_CAPITAL":"../subcapital/contribution-show.html",
	"WEBSITE":"../websiteInfo/website-inf-show.html",
	"STOCK_ALTER":"../alterstockInfo/equity-record-show.html",
	"INVESTMENT":"../forinvestment/investment-inf-show.html",
	"ASSET_STATUS":"asset-inf-show.html",
	"GUARANTEE":"../forguaranteeInfo/guarantee-inf-show.html",
	"SOCIAL_SECURITY":"../socsecinfo/social-security-inf-show.html",
	"PRODUCTION_MANAGE":"asset-inf-show.html",
	"PARTY_BUILDING":"partyinfo-show.html",
	"ADMIN_LICENSE":"行政许可情况",
	"BRANCH":"分支机构情况",
	"CU_REGINFO":"../bg_info_qy/customs_index_show.html",
	"CU_TAXRELIEFGOODS":"../bg_info_qy/jmsjdhwInfo_show.html"
}

var path_qy_show_search={
	"HOLDER_CAPITAL":"contribution-show.html",
	"WEBSITE":"website-inf-show.html",
	"STOCK_ALTER":"equity-record-show.html",
	"INVESTMENT":"investment-inf-show.html",
	"ASSET_STATUS":"asset-inf-show.html",
	"GUARANTEE":"guarantee-inf-show.html",
	"SOCIAL_SECURITY":"social-security-inf-show.html",
	"PRODUCTION_MANAGE":"asset-inf-show.html",
	"PARTY_BUILDING":"partyinfo-show.html",
	"ADMIN_LICENSE":"行政许可情况",
	"BRANCH":"分支机构情况",
}

//农专年报
var path_nz_show={
	"HOLDER_CAPITAL":"股东及出资信息",
	"WEBSITE":"../sfc_websiteinfo/website-inf-show.html",
	"STOCK_ALTER":"股权变更信息",
	"INVESTMENT":"对外投资信息",
	"ASSET_STATUS":"asset-inf-show.html",
	"GUARANTEE":"对外担保信息",
	"SOCIAL_SECURITY":"../sfc_socsecinfo/social-security-inf-show.html",
	"PRODUCTION_MANAGE":"asset-inf-show.html",
	"PARTY_BUILDING":"党建信息",
	"ADMIN_LICENSE":"../sfc_licenceinfo/licenceinfo-show.html",
	"BRANCH":"../sfc_branchinfo/branchinfo-list-show.html",
	"CU_REGINFO":"../sfc_bg_info/customs_index_show.html",
	"CU_TAXRELIEFGOODS":"../sfc_bg_info/jmsjdhwInfo_show.html"
}
var path_nz_show_search={
	"HOLDER_CAPITAL":"股东及出资信息",
	"WEBSITE":"website-inf-show.html",
	"STOCK_ALTER":"股权变更信息",
	"INVESTMENT":"对外投资信息",
	"GUARANTEE":"对外担保信息",
	"SOCIAL_SECURITY":"social-security-inf-show.html",
	"PRODUCTION_MANAGE":"asset-inf-show.html",
	"PARTY_BUILDING":"党建信息",
	"ADMIN_LICENSE":"licenceinfo-show.html",
	"BRANCH":"branchinfo-list-show.html"
}
//个体年报
var path_gt_show={
	"HOLDER_CAPITAL":"股东及出资信息",
	"WEBSITE":"../pb_websiteinfo/website-inf-show.html",
	"STOCK_ALTER":"股权变更信息",
	"INVESTMENT":"对外投资信息",
	"GUARANTEE":"对外担保信息",
	"SOCIAL_SECURITY":"社保信息",
	"PRODUCTION_MANAGE":"asset-inf-show.html",
	"PARTY_BUILDING":"partyinfo-show.html",
	"ADMIN_LICENSE":"../pb_licenceinfo/licenceinfo-show.html",
	"CU_REGINFO":"../pb_bg_info/customs_index_show.html",
	"CU_TAXRELIEFGOODS":"../pb_bg_info/jmsjdhwInfo_show.html"
}

var path_gt_show_search={
	"HOLDER_CAPITAL":"股东及出资信息",
	"WEBSITE":"website-inf-show.html",
	"STOCK_ALTER":"股权变更信息",
	"INVESTMENT":"对外投资信息",
	"ASSET_STATUS":"asset-inf-show.html",
	"GUARANTEE":"对外担保信息",
	"SOCIAL_SECURITY":"社保信息",
	"PRODUCTION_MANAGE":"asset-inf-show.html",
	"PARTY_BUILDING":"partyinfo-show.html",
	"ADMIN_LICENSE":"licenceinfo-show.html",
}

//中文解释
var path_zh={
	"BASE_INFO":"基础信息",
	"ADMIN_LICENSE":"行政许可信息",
	"ADMIN_SANCTION":"行政处罚信息",
	"EXCEPTION_LIST":"列入经营异常名录信息",
	"SERIOUS_VIOLATION":"列入严重违法失信企业名单（黑名单）信息",
	"HOLDER_CAPITAL":"股东及出资信息",
	"MAIN_PERSION":"主要人员信息",
	"BRANCH_INFO":"分支机构信息",
	"LIQUIDATION":"清算信息",
	"ALTER_INFO":"变更信息",
	"CHATTEL_MORTGAGE":"动产抵押登记信息",
	"STOCK_OWNERSHIP":"股权出质登记信息",
	"INTELLECTUAL":"知识产权出质登记信息",
	"TRADEMARK":"商标注册信息",
	"DOUBLE_RANDOM":"双随机抽查结果信息",
	"JUDICIAL_ASSIST":"司法协助信息",
	"YEAR_REPORT":"企业年报信息",
	"YEAR_HOLDER_CAPITAL":"股东及出资信息",
	"YEAR_STOCK_ALTER":"股权变更信息",
	"YEAR_ADMIN_LICENSE":"行政许可信息",
	"YEAR_INTELLECTUAL":"知识产权出质登记信息",
	"YEAR_ADMIN_SANCTION":"行政处罚信息",
	"PARTNER_INFO":"合伙人信息",
	"MEMBER_ROSTER":"成员名册信息",
	"FAMILY_MEMBER_NAME":"参加经营的家庭成员姓名",
	"COMPETENT_DEPART":"主管部门（出资人）信息",
	"MULTI_CAR":"多证合一",

	//以下是年报的
	"HOLDER_CAPITAL":"股东及出资信息",
	"WEBSITE":"网站或网店信息",
	"STOCK_ALTER":"股权变更信息",
	"INVESTMENT":"对外投资信息",
	"ASSET_STATUS":"资产状态信息",
	"GUARANTEE":"对外担保信息",
	"SOCIAL_SECURITY":"社保信息",
	"PRODUCTION_MANAGE":"资产状态信息(生产经营情况)",
	"PARTY_BUILDING":"党建信息",
	"ADMIN_LICENSE":"行政许可情况",
	"BRANCH":"分支机构情况",
	"PRODUCTION_MANAGE":"资产状况信息"
}


