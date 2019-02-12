/**
 * student_info管理初始化
 */
var Info = {
    id: "InfoTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

laydate.render({
	  elem: '#stuAdmissiontime',theme: 'molv'
	});

/**
 * 初始化表格的列
 */
Info.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        	{title: 'id', field: 'stuId', visible: false, align: 'center', valign: 'middle'},
            {title: '学生姓名', field: 'stuName', visible: true, align: 'center', valign: 'middle'},
            {title: '学生班级', field: 'stuClass', visible: true, align: 'center', valign: 'middle',
            	formatter: function (value, row, index) {
                	return row.stuGrade+value+"班";
            	}
            },
             
            //{title: '所在年级', field: 'stuGrade', visible: true, align: 'center', valign: 'middle'},
            {title: '性别', field: 'stuSex', visible: true, align: 'center', valign: 'middle',
            	formatter: function (value, row, index) {
            	if(1==value){
            		return '男';
            	}else{
            		return '女';
            	}
            }},
            {title: '学校', field: 'stuSchool', visible: true, align: 'center', valign: 'middle'},
            {title: '家长电话', field: 'stuParentphone', visible: true, align: 'center', valign: 'middle'},
            {title: '入学时间', field: 'stuAdmissiontime', visible: true, align: 'center', valign: 'middle'}

    ];
};

/**
 * 检查是否选中
 */
Info.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
    	debugger
        Info.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加student_info
 */
Info.openAddInfo = function () {
    var index = layer.open({
        type: 2,
        title: '添加学生信息',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/info/info_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看学生数据详情
 */
Info.dataInfo = function () {
	if(this.check()){	
		debugger
		var url = Feng.ctxPath+"/info/info_dataInfo?stuName="+Info.seItem.stuName;
		//window.location.href=url;
		Feng.newCrontab(url,Info.seItem.stuName+"的数据信息");
	}
};

/**
 * 打开查看student_info详情
 */
Info.openInfoDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '学生信息详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/info/info_update/' + Info.seItem.stuId
        });
        this.layerIndex = index;
    }
};

/**
 * 删除student_info
 */
Info.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/info/delete", function (data) {
            Feng.success("删除成功!");
            Info.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("infoId",this.seItem.stuId);
        ajax.start();
    }
};

/**
 * 查询student_info列表
 */
Info.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Info.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Info.initColumn();
    var table = new BSTable(Info.id, "/info/list", defaultColunms);
    table.setPaginationType("client");
    Info.table = table.init();
});
