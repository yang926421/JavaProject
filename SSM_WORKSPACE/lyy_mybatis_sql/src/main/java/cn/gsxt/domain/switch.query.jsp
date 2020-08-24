<%@page import="com.asc.commons.certification.AscUserCertification"%>
<%@page import="com.asc.commons.organization.entity.User"%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="com.asc.commons.engine.authority.exception.DesignObjectAuthorityException"%>
<%@page import="com.asc.commons.engine.authority.DesignObjectAuthorityService"%>
<%
	String panelid = request.getParameter("panelid");
	User user = AscUserCertification.instance().getUser(request);
	boolean allowUpload = false;
	boolean allowDownload = false;
	try {
		allowUpload = DesignObjectAuthorityService.instance().isUserHasDesignObjectAuth(user, "mSwitchData.upSwitchTop.btnUpload", null);
		// 获取是否允许导出权限
		allowDownload = DesignObjectAuthorityService.instance().isUserHasDesignObjectAuth(user, "mSwitchData.upSwitchTop.btnDownload", null);
	}catch(DesignObjectAuthorityException e){
  		e.printStackTrace();
  	}
%>
<script>
Ext.onReady(function(){
	var panel = Ext.getCmp('<%=panelid%>');
	//添加数据查询事件
	var tljFlag = 0,gwdFlag = 0,cjFlag = 0,gqFlag = 0,lineCodeFlag = 0,stationCodeFlag = 0;
	panel.addEvents('querysubmit');
	panel.addEvents('querysubmitQD');
	panel.addEvents('clearsubmit');
	//按钮权限
	var allowUpload = <%=allowUpload%>;
	var allowDownload = <%=allowDownload%>;
	// 获取应用的key
	var appKey = panel.appKey;
	var appManager = AscApp.getController('AscAppManager');
	var dicManager = AscApp.getController('AscDictionaryManager');
	// 获取应用direct方法
	var mainPage = panel.up('[pageId=mSwitchData.lyoSwitchTop]');
	var getOrgTree = appManager.getAppDirectFn(appKey,"RbdsDirect" ,"getOrgTree");
	var orgsFn = appManager.getAppDirectFn(appKey,"RbdsDirect","listOrgsByDataFilter");
	var linesFn = appManager.getAppDirectFn(appKey,"RailBaseDataDirect", "listLines");
	var orgsAttr = appManager.getAppDirectFn(appKey,"RbdsDirect","listOrgsByAttribute");
	// 根据字段key 获取字典数据信息
	var listCheckComboFn = appManager.getAppDirectFn(appKey, "RbdsDirect","listCheckCombo");
	// 道岔数据源
	var switchFn = appManager.getAppDirectFn(appKey,"LineBaseDataDirect", "asListSwitchIdsCombo");
	// 股道数据源
 	var trackFn = appManager.getAppDirectFn(appKey,"LineBaseDataDirect", "asListTrackIdsCombo");
 	
 	var isAllowDownload = appManager.getAppDirectFn(appKey, "RbdsDirect", "isAllowDownload");
 	var checkBaseDataExport = appManager.getAppDirectFn(appKey, "RbdsDirect", "checkBaseDataExport");
 	var deleteErrorDataExcel = appManager.getAppDirectFn(appKey, "RbdsDirect", "deleteErrorDataExcel");
 	
	Ext.syncRequire('Ext.ux.asc.cdru.CDRUProvider');
	var cdru = new Ext.ux.asc.cdru.CDRUProvider(appKey, {
		tljMulti: true, gwdMulti: true, lineMulti: true, xbMulti: true, xlcjMulti: true, xlgqMulti: true,stationMulti: true, 
		LINE: true, 			
		XB: true,
		XLCJ: true, 
		XLGQ: true, 
		STATION: true,lineAll: true, stationAll: true,
		initOrgId: <%=user.getF_company_id()%>
	});
	
	var tljCode = cdru.getTLJ();
	var gwdCode = cdru.getGWD();
	var lineCode = cdru.getLine();
	var lineRow = cdru.getXB();
	var xlcjCode = cdru.getXLCJ();
	var xlgqCode = cdru.getXLGQ();
	var stationCode = cdru.getStation();
	stationCode.on('collapse', function(){
		var tljCodeValue = tljCode.getValue();
		var gwdCodeValue = gwdCode.getValue();
		var xlcjCodeValue = xlcjCode.getValue();
		var xlgqCodeValue = xlgqCode.getValue();
		var lineCodeValue = lineCode.getValue();
		var lineRowValue = lineRow.getValue();
		var stationValue = stationCode.getValue();
		// 加载道岔信息
		switchId.clearValue();
		switchStore.removeAll();
		switchStore.load({ 
			params : {
				QI :{
					f_tlj_code : tljCodeValue,
					f_gwd_code : gwdCodeValue,
					f_cj_code : xlcjCodeValue,
					f_gq_code : xlgqCodeValue,
					f_line_code : lineCodeValue,
					f_line_row : lineRowValue,
					f_station_code : stationValue
				}
	    	}
		});
		
		// 加载股道信息
		trackId.clearValue();
		trackStore.removeAll();
		trackStore.load({ 
			params : {
				QI :{
					f_tlj_code : tljCodeValue,
					f_gwd_code : gwdCodeValue,
					f_cj_code : xlcjCodeValue,
					f_gq_code : xlgqCodeValue,
					f_line_code : lineCodeValue,
					f_line_cate : lineRowValue,
					f_station_code : stationValue
				}
	    	}
		});
	});
 	
	// 道岔
	var switchStore = Ext.create('Ext.data.Store', {
		autoDestroy : true,
		fields: ['key', 'input','value'],
	    proxy : {
			type : 'direct',
			directFn : switchFn,
			paramOrder : ['QI'],
			reader : {
				type: 'json',
				root : 'datas',
				messageProperty : 'message'
			}
		}
	});
	
	// 股道
	var trackStore = Ext.create('Ext.data.Store', {
		autoDestroy : true,
		fields: ['key', 'input','value'],
	    proxy : {
			type : 'direct',
			directFn : trackFn,
			paramOrder : ['QI'],
			reader : {
				type: 'json',
				root : 'datas',
				messageProperty : 'message'
			}
		}
	});
	
	// 道岔编号/道岔ID
	var switchId = Ext.create('Ext.ux.checkCombo.CheckCombo', {
		name: 'f_switch_id',
	    fieldLabel: '道岔号',
	    store: switchStore,
		labelWidth: 60,
		labelAlign: 'right',
		width: 150,
		queryMode: 'local',
		displayField: 'value',
		forceSelection: true,
		localFieldFilter : true,
		inputQueryField: 'input',
		valueField: 'key',
		margin: '5 0 0 0',
		padding: '0 0 0 0',
		maxPWidth: 500,//展开下拉面板的宽度
		minPWidth: 115,//展开的下拉面最小宽度
		columns: 1,//定义需要显示的列数
		editable: false,
        boxLabelField: 'value'
	});	
	
	// 股道号/股道ID
	var trackId = Ext.create('Ext.ux.checkCombo.CheckCombo', {
		name: 'f_track_Id',
	    fieldLabel: '股道号',
	    store: trackStore,
		labelWidth: 60,
		labelAlign: 'right',
		width: 150,
		queryMode: 'local',
		displayField: 'value',
		forceSelection: true,
		localFieldFilter : true,
		inputQueryField: 'input',
		valueField: 'key',
		margin: '5 0 0 0',
		padding: '0 0 0 0',
		suspendNum: 0, // 默认挂起次数为0
		
		editable: false,
		maxPWidth: 500,//展开下拉面板的宽度
		minPWidth: 115,//展开的下拉面最小宽度
		columns: 1,//定义需要显示的列数
        vertical: true,//checkbox排列方式，true为从左向右，false为从上到下，默认为false
        boxLabelField: 'value',
        displayField : 'value',
		valueField : 'key'
	});	
	
	// 数据状态
	var dataStateStore = Ext.create('Ext.data.Store', {
		fields: ['inputValue', 'boxLabel','checked'],
	    proxy : {
			type : 'direct',
			directFn : listCheckComboFn,
			reader : {
				type: 'json',
				root : 'datas',
				messageProperty : 'message'
			}
		}
	});
	dataStateStore.load({ 
		params : {
			key : 'SJYYZT'
    	}
	});
	var dataStateInput = Ext.create("Ext.ux.checkCombo.CheckCombo", Ext.applyIf({
		fieldLabel : '数据状态',
		name : 'f_data_state',
		editable : false,
		maxPWidth: 115,//展开下拉面板的宽度
		columns:1,//定义需要显示的列数
        vertical:true,//checkbox排列方式，true为从左向右，false为从上到下，默认为false
		store : dataStateStore,
		localFieldFilter : true,
		displayField : 'boxLabel',
		valueField : 'inputValue',
	    margin: '5 0 0 0',
		labelWidth : 60,
		labelAlign: 'right',
		width : 150,
		value: "QY"
	}, defaultConf));
	
	// 道岔位置
	var positionStore = Ext.create('Ext.data.Store', {
		fields: ['inputValue', 'boxLabel','checked'],
	    proxy : {
			type : 'direct',
			directFn : listCheckComboFn,
			reader : {
				type: 'json',
				root : 'datas',
				messageProperty : 'message'
			}
		}
	});
	positionStore.load({ 
		params : {
			key : 'GDLX'
    	}
	});
	var positionInput = Ext.create("Ext.ux.checkCombo.CheckCombo", Ext.applyIf({
		fieldLabel : '道岔位置',
		name : 'f_position',
		editable : false,
		maxPWidth: 115,//展开下拉面板的宽度
		columns:1,//定义需要显示的列数
        vertical:true,//checkbox排列方式，true为从左向右，false为从上到下，默认为false
		store : positionStore,
		localFieldFilter : true,
		displayField : 'boxLabel',
		valueField : 'inputValue',
	    margin: '5 0 0 0',
		labelWidth : 60,
		labelAlign: 'right',
		width : 150
	}, defaultConf));
	
	// 道岔类型
	var typeStore = Ext.create('Ext.data.Store', {
		fields: ['inputValue', 'boxLabel','checked'],
	    proxy : {
			type : 'direct',
			directFn : listCheckComboFn,
			reader : {
				type: 'json',
				root : 'datas',
				messageProperty : 'message'
			}
		}
	});
	typeStore.load({ 
		params : {
			key : 'DCLX'
    	}
	});
	var typeInput = Ext.create("Ext.ux.checkCombo.CheckCombo", Ext.applyIf({
		fieldLabel : '道岔类型',
		name : 'f_type',
		editable : false,
		maxPWidth: 115,//展开下拉面板的宽度
		columns:1,//定义需要显示的列数
        vertical:true,//checkbox排列方式，true为从左向右，false为从上到下，默认为false
		store : typeStore,
		localFieldFilter : true,
		displayField : 'boxLabel',
		valueField : 'inputValue',
	    margin: '5 0 0 0',
		labelWidth : 60,
		labelAlign: 'right',
		width : 150
	}, defaultConf));
	
	// 道岔种类
	var switchTypeStore = Ext.create('Ext.data.Store', {
		fields: ['inputValue', 'boxLabel','checked'],
	    proxy : {
			type : 'direct',
			directFn : listCheckComboFn,
			reader : {
				type: 'json',
				root : 'datas',
				messageProperty : 'message'
			}
		}
	});
	switchTypeStore.load({ 
		params : {
			key : 'DCZL'
    	}
	});
	var switchTypeInput = Ext.create("Ext.ux.checkCombo.CheckCombo", Ext.applyIf({
		fieldLabel : '道岔种类',
		name : 'f_species',
		editable : false,
		maxPWidth: 115,//展开下拉面板的宽度
		columns:1,//定义需要显示的列数
        vertical:true,//checkbox排列方式，true为从左向右，false为从上到下，默认为false
		store : switchTypeStore,
		localFieldFilter : true,
		displayField : 'boxLabel',
		valueField : 'inputValue',
	    margin: '5 0 0 0',
		labelWidth : 60,
		labelAlign: 'right',
		width : 150
	}, defaultConf));
	
	// 轨型
	var railTypeStore = Ext.create('Ext.data.Store', {
		fields: ['inputValue', 'boxLabel','checked'],
	    proxy : {
			type : 'direct',
			directFn : listCheckComboFn,
			reader : {
				type: 'json',
				root : 'datas',
				messageProperty : 'message'
			}
		}
	});
	railTypeStore.load({ 
		params : {
			key : 'GX'
    	}
	});
	var railTypeInput = Ext.create("Ext.ux.checkCombo.CheckCombo", Ext.applyIf({
		fieldLabel : '轨型',
		name : 'f_sleeper_type',
		editable : false,
		maxPWidth: 115,//展开下拉面板的宽度
		columns:1,//定义需要显示的列数
        vertical:true,//checkbox排列方式，true为从左向右，false为从上到下，默认为false
		store : railTypeStore,
		localFieldFilter : true,
		displayField : 'boxLabel',
		valueField : 'inputValue',
	    margin: '5 0 0 0',
		labelWidth : 60,
		labelAlign: 'right',
		width : 150
	}, defaultConf));

	// 辙叉构造
	var frogStructrueStore = Ext.create('Ext.data.Store', {
		fields: ['inputValue', 'boxLabel','checked'],
	    proxy : {
			type : 'direct',
			directFn : listCheckComboFn,
			reader : {
				type: 'json',
				root : 'datas',
				messageProperty : 'message'
			}
		}
	});
	frogStructrueStore.load({ 
		params : {
			key : 'CCGZ'
    	}
	});
	var frogStructrueInput = Ext.create("Ext.ux.checkCombo.CheckCombo", Ext.applyIf({
		fieldLabel : '辙叉构造',
		name : 'f_frog_structrue',
		editable : false,
		maxPWidth: 115,//展开下拉面板的宽度
		columns:1,//定义需要显示的列数
        vertical:true,//checkbox排列方式，true为从左向右，false为从上到下，默认为false
		store : frogStructrueStore,
		localFieldFilter : true,
		displayField : 'boxLabel',
		valueField : 'inputValue',
	    margin: '5 0 0 0',
		labelWidth : 60,
		labelAlign: 'right',
		width : 150
	}, defaultConf));
	
	// 联锁类别
	var chainTypeStore = Ext.create('Ext.data.Store', {
		fields: ['inputValue', 'boxLabel','checked'],
	    proxy : {
			type : 'direct',
			directFn : listCheckComboFn,
			reader : {
				type: 'json',
				root : 'datas',
				messageProperty : 'message'
			}
		}
	});
	chainTypeStore.load({ 
		params : {
			key : 'LSLB'
    	}
	});
	var chainTypeInput = Ext.create("Ext.ux.checkCombo.CheckCombo", Ext.applyIf({
		fieldLabel : '联锁类别',
		name : 'f_chain_type',
		editable : false,
		maxPWidth: 115,//展开下拉面板的宽度
		columns:1,//定义需要显示的列数
        vertical:true,//checkbox排列方式，true为从左向右，false为从上到下，默认为false
		store : chainTypeStore,
		localFieldFilter : true,
		displayField : 'boxLabel',
		valueField : 'inputValue',
	    margin: '5 0 0 0',
		labelWidth : 60,
		labelAlign: 'right',
		width : 150
	}, defaultConf));
	
	// 尖轨类型
	var sleeperTypeStore = Ext.create('Ext.data.Store', {
		fields: ['inputValue', 'boxLabel','checked'],
	    proxy : {
			type : 'direct',
			directFn : listCheckComboFn,
			reader : {
				type: 'json',
				root : 'datas',
				messageProperty : 'message'
			}
		}
	});
	sleeperTypeStore.load({ 
		params : {
			key : 'JGLX'
    	}
	});
	var sleeperTypeInput = Ext.create("Ext.ux.checkCombo.CheckCombo", Ext.applyIf({
		fieldLabel : '尖轨类型',
		name : 'f_rail_type',
		editable : false,
		maxPWidth: 115,//展开下拉面板的宽度
		columns:1,//定义需要显示的列数
        vertical:true,//checkbox排列方式，true为从左向右，false为从上到下，默认为false
		store : sleeperTypeStore,
		localFieldFilter : true,
		displayField : 'boxLabel',
		valueField : 'inputValue',
	    margin: '5 0 0 0',
		labelWidth : 60,
		labelAlign: 'right',
		width : 150
	}, defaultConf));
	
	// 里程
	var f_mileage_min = Ext.create('Ext.form.field.Number', {
		name: 'f_mileage_min',
	    fieldLabel: '里程(Km)',
	    margin: '5 0 0 0',
	    labelWidth: 60,
		labelAlign: 'right',
		width: 150
	});
	
	var f_mileage_max = Ext.create('Ext.form.field.Number', {
		name: 'f_mileage_max',
	    fieldLabel: '至',
	    margin: '5 0 0 0',
	    labelWidth: 60,
		labelAlign: 'right',
		width: 150
	});
	
	var defaultConf = {
			margin: '5 0 0 0',
		    labelWidth: 60,
			labelAlign: 'right',
			width : 150
		};
	
	//铺设日期store
	var currentTime = new Date();
    var now = currentTime.getFullYear();
    var y = 1975;
    var dateStore = Ext.create('Ext.data.Store', {
    	fields: ['key', 'value']
	});
    while(y<=now+5){
    	dateStore.loadRawData([{"key":y,"value":y}],true);
    	y++;
    }
	var layTimeStart = Ext.create('Ext.form.ComboBox', {
		name: 'f_investTime_start',
	    store: dateStore,
	    queryMode: 'local',
	    displayField: 'value',
	    inputQueryField : 'input',
	    valueField: 'key',
		width: 85,
		listeners: {
	        select: {
	        	fn: function(combo){
	        		//起始日期大于终止日期，则把终止日期改为起始日期
	        		if(combo.getValue() > layTimeEnd.getValue()){
	        			layTimeEnd.setValue(combo.getValue());
	        		}
	        	}
	        }
	    }
	});
	var layTimeEnd = Ext.create('Ext.form.ComboBox', {
		name: 'f_investTime_end',
	    store: dateStore,
	    queryMode: 'local',
	    displayField: 'value',
	    inputQueryField : 'input',
	    valueField: 'key',
	    width: 85,
		listeners: {
	        select: {
	        	fn: function(combo){
	        		//终止日期小于起始日期，则把起始日期改为终止日期
	        		if(combo.getValue() < layTimeStart.getValue()){
	        			layTimeStart.setValue(combo.getValue());
	        		}
	        	}
	        }
	    }
	});
	var timeInputStart = Ext.create("Ext.form.FieldContainer", Ext.applyIf({
		fieldLabel: '铺设年度',
		layout: 'hbox',
		items: [
				layTimeStart
        ]
	}, defaultConf));
	
	var timeInputEnd = Ext.create("Ext.form.FieldContainer", Ext.applyIf({
		fieldLabel: '至',
		layout: 'hbox',
		items: [
				layTimeEnd
        ]
	}, defaultConf));
	
	/***************************************************/
	var gjPanel = new Ext.Panel({       // 创建一个Ext面板，为高级查询
		width : 316,
		autoHeight: true, 
		border : false,
		/*  EXT由多个组件组成，每个组件可配置多个子组件（items），
			而每个子组件也可嵌套多个子组件（items）           */
		items : [{       //没有指定xtype:默认使用panel
			layout : 'column',
			columnWidth : 1,
			border : false,
			items : [{  
				// 行别
				xtype: 'container', width : 150, items: lineRow    //container:容器   
			}, {
				// 股道号/股道ID
				xtype: 'container', width : 150, items: trackId
			},{
				// 道岔位置
				xtype: 'container', width : 150, items: positionInput
			}, {
				// 道岔类型
				xtype: 'container', width : 150, items: typeInput
			}, {
				// 道岔种类
				xtype: 'container', width : 150, items: switchTypeInput
			},{
				// 尖轨类型
				xtype: 'container', width : 150, items: sleeperTypeInput
			},{
				// 轨型
				xtype: 'container', width : 150, items: railTypeInput
			},{
				// 辙叉构造
				xtype: 'container', width : 150, items: frogStructrueInput
			},{
				// 铺设年度
				xtype: 'container', width : 150, items: timeInputStart
			},{
				// 铺设年度
				xtype: 'container', width : 150, items: timeInputEnd
			}, {
				// 里程
				xtype: 'container', width : 150, items: f_mileage_min
			}, {
				// 里程
				xtype: 'container', width : 150, items: f_mileage_max
			},{
				// 联锁类别
				xtype: 'container', width : 150, items: chainTypeInput
			}]
		}],
		buttonAlign : 'right',
		buttons : [{
				text : '确定',
				margin: '5 10 5 0',
				padding : '2 5 2 8',
				iconCls : 'icon-app-rdmscommon-Search',
				width : 90,
				handler: function(btn) {
					panel.fireEvent('querysubmit', panel);
				}
			}
		]
	});
	
	var gjConfig = {};    
	gjConfig.items = gjPanel;
	gjConfig.handler = function(){
		panel.fireEvent('querysubmitQD', panel);
	}
	var qbt = new DefectSpace.AdvanceSearchBtn(gjConfig);
	var queryBtn = qbt.getSplitBtn();
	
	panel.getGJValues = function(){
		return queryBtn.getValues();
	}
	
	/**************************************************/
	var cBtn = Ext.create('Ext.Button', {
		text : '重置',
		width : 70,
		margin: '5 10 5 0',
		padding : '2 5 2 8',
		iconCls : 'icon-app-rdmscommon-Reset',
		handler : function() {
			clearResetValue();
		}
	});
	
	var dBtn = Ext.create('Ext.Button', {
        text:'导出数据',
        margin: '5 10 5 0',
        padding : '2 5 2 8',
        width : 100,
        iconCls : 'icon-app-rdmscommon-Export',
        handler : function(){
       		var queryData = form.getForm().getValues();
           	var param = JSON.stringify(queryData);
			checkBaseDataExport('switch',queryData,function(result, event){
           		if(!result.success){
           			Asc.common.Message.showInfo(result.message);
           		}else{
           			isAllowDownload(function(result, event){
           				if(!result.success){
           					Asc.common.Message.showInfo(result.message);
           				}else{
           					window.location=encodeURI("/rlms_rbds/exportBaseData?t=switch&param="+param);
           				}
           			});
           		}
           	}); 
        }
	});
	
	function clearResetValue(){
		//重置组织机构
		cdru.reset();
		trackId.clearValue();
		switchId.clearValue();
		dataStateInput.clearValue();
		dataStateInput.setValue("QY");
		dataStateInput.onRemove();
		positionInput.clearValue();
		typeInput.clearValue();
		switchTypeInput.clearValue();
		railTypeInput.clearValue();
		frogStructrueInput.clearValue();
		chainTypeInput.clearValue();
		f_mileage_min.setValue("");
		f_mileage_max.setValue("");
		layTimeStart.clearValue();
		layTimeEnd.clearValue();
		sleeperTypeInput.clearValue();
	}
	
	var form = Ext.create('Ext.form.Panel', {
		xtype : 'container',
		layout : 'column',
		width: '100%',
		border : false,
		defaults : {
			enableKeyEvents : true,
			listeners : {
			}
		},
		items :[{
			layout : 'column',
			columnWidth : 1,
			border : false,
			items : [{
				// 铁路局
				xtype: 'container', width : 150, items: tljCode
			}, {
				// 工务段
				xtype: 'container', width : 150, items: gwdCode
			}, {
				// 线路车间
				xtype: 'container', width : 150, items: xlcjCode
			}, {
				// 线路工区
				xtype: 'container', width : 150, items: xlgqCode
			}, {
				// 线名
				xtype: 'container', width : 150, items: lineCode
			}, {
				// 车站
				xtype: 'container', width:150, items: stationCode
			}, {
				// 道岔编号/道岔ID
				xtype: 'container', width:150, items: switchId
			}, {
				// 数据状态
				xtype: 'container', width:150, items: dataStateInput
			}]
		}, {
			layout : 'hbox',
			align : 'top',
			border : false,
			columnWidth : 1,
			items: [{
				xtype : 'tbspacer',
				flex : 1
			}, queryBtn, 
			<%if(allowUpload){%>
			{
				xtype:'button',
	            text:'下载导入模板',
	            width : 115,
	    		margin: '5 10 5 0',
	    		padding : '2 5 2 8',
	            iconCls : 'icon-app-rdmscommon-Download',
	            handler : function(){
					isAllowDownload(function(result, event){
						if(!result.success){
							Asc.common.Message.showInfo(result.message);
						}else{
							window.location="/rlms_rbds/templatefile?t=switch";
						}
					});
 			 	}
             },{
				xtype : 'AscUploadButton',
				text : '导入数据',
				width : 100,
	    		margin: '5 10 5 0',
	    		padding : '2 5 2 8',
				iconCls : 'icon-app-rdmscommon-Import',
				appKey : panel.appKey,
				uploader : {
					url : '/switchUploadAction'
				},
				listeners : {
					fileuploaded : {
						fn : function(btn, file, response) {
							mainPage.el.up('body').unRdmsMask();
							if (!response.isSuccess) {
								Asc.common.Message.showError('导入失败,' + response.message);
							}
							if (response.isSuccess) {
								var filepath = response.filepath;
								if(filepath){
									isAllowDownload(function(result, event){
				           				if(!result.success){
				           					Asc.common.Message.showInfo("同时导入导出人数太多，请您稍后再试");
				           					//删除临时文件
				           					deleteErrorDataExcel(filepath);
				           				}else{
				           					window.location="/rlms_rbds/exportErrorSwitchs?filepath="+filepath;
				           				}
				           			});
								}else{
									Asc.common.Message.showInfo('数据导入成功！',{width:150});
								}
							}
						}
					},
					afterwindowshow : {
						fn : function(com,win) {
							win.disable();
							mainPage.el.up('body').rdmsMask('正在导入...');
						}
					}
				} 
			},
			<%}%>
			<%if(allowDownload){%>
			dBtn,
			<%}%>cBtn]
		}]
		
	});
	//设置Combo组件
	var setCombo = function(cmp,defaultValue,isDisabled,queryItem){
		cmp.getStore().load({params : {QI : queryItem}});
		if(defaultValue && defaultValue!=null){
			cmp.setValue(defaultValue);
			cmp.setReadOnly(true);
		}
	};
	//设置Combo组件（不从后台查询）
	var setNoneQueryCombo = function(cmp,val,display){
		cmp.getStore().add({key : val,value : display});
		cmp.setValue(val);
		cmp.setReadOnly(true);
	}
	
	var setQueryCombo = function(cmp,val,display){
		cmp.getStore().add({key : val,value : display});
		cmp.setValue(val);
	}
	
	//设置combo组件blur事件(解决手动填写，value没有设值问题)
	var combos = form.query('combo');
	for(var i = 0; i < combos.length; i++){
		combos[i].on('blur', function(com){
			var value = com.getRawValue();
			var record = com.findRecordByDisplay(value);
			if(record){
				com.select(record);
			}
		});
	}
	// ***************外部接口**begin***************************
	// 获得查询表单数据
	panel.getQueryFormData = function(){
		return form.getForm().getValues();
	}
	// ***************外部接口**end***************************
	panel.add(form);
	panel.doLayout();
	cdru.initData();
	});
</script>