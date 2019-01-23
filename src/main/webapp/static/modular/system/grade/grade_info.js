/**
 * 初始化年级班务管理详情对话框
 */
var GradeInfoDlg = {
    gradeInfoData : {}
};

/**
 * 清除数据
 */
GradeInfoDlg.clearData = function() {
    this.gradeInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
GradeInfoDlg.set = function(key, val) {
    this.gradeInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
GradeInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
GradeInfoDlg.close = function() {
    parent.layer.close(window.parent.Grade.layerIndex);
}

/**
 * 收集数据
 */
GradeInfoDlg.collectData = function() {
	var gradeClassroomnameArray = $("input[name='ohterClassroomname']").val();
	if(gradeClassroomnameArray != ""){
		$("#gradeClassroomname").find("option:selected").val(gradeClassroomnameArray); 
		//$("#gradeClassroomname").val(gradeClassroomnameArray);
	};
    this
    .set('gradeId')
    .set('gradeClassroomname')
    .set('gradeNum')
    .set('gradeSeasonclass')
    .set('gradeLevel')
    .set('deleteFlag');
}

/**
 * 提交添加
 */
GradeInfoDlg.addSubmit = function() {
	
	
    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/grade/add", function(data){
    	if(data.code!=500){
            Feng.success("添加成功!");
    	}else{
            Feng.error("添加失败!" + data.message + "!");
    	}
        window.parent.Grade.table.refresh();
        GradeInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.gradeInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
GradeInfoDlg.editSubmit = function() {
	
    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/grade/update", function(data){
        Feng.success("修改成功!");
        window.parent.Grade.table.refresh();
        GradeInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.gradeInfoData);
    ajax.start();
}


$("#gradeClassroomname").change(function(){
            var $this = $(this);
            
            selectChange($this);
})

function selectChange($this){
    	if ($this.val() == "0") {    		
    		$(".hiddenContent").show();
        }else{
        	$(".hiddenContent").hide();
        	$("input[name='ohterClassroomname']").val("");
        }
}

$(function() {
	//编辑
	debugger
	if($("#gradeId").val() != null){
		var roomName = $("input[name='ohterClassroomname']").val();
		switch(roomName){
			case '好学' : 
			case '精进' : 
			case '志高' : $("#gradeClassroomname ").val(roomName);
			break;
			default:$("#gradeClassroomname ").val(0);		
		}
		if ($("#gradeClassroomname ").val() == 0) {    		
			$(".hiddenContent").show();
	    }
		$("#gradeSeasonclass").val($("#gradeSeasonclassSelect ").val());
		$("#gradeLevel").val($("#gradeLevelSelect").val());
	}
	
});
