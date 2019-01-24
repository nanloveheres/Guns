/**
 * 初始化student_info详情对话框
 */
var InfoInfoDlg = {
    infoInfoData : {}
};

laydate.render({
	  elem: '#stuAdmissiontime',theme: 'molv'
	});

/**
 * 清除数据
 */
InfoInfoDlg.clearData = function() {
    this.infoInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
InfoInfoDlg.set = function(key, val) {
    this.infoInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
InfoInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
InfoInfoDlg.close = function() {
    parent.layer.close(window.parent.Info.layerIndex);
}

/**
 * 收集数据
 */
InfoInfoDlg.collectData = function() {
	var sexNumber = $("input[name='sex']:checked").val();
	$("#stuSex").val(sexNumber);
    this
    .set('stuId')
    .set('stuName')
    .set('stuClass')
    .set('stuGrade')
    .set('stuSex')
    .set('stuSchool')
    .set('stuParentphone')
    .set('stuAdmissiontime');
}

/**
 * 提交添加
 */
InfoInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/info/add", function(data){
        Feng.success("添加成功!");
        window.parent.Info.table.refresh();
        InfoInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.infoInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
InfoInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/info/update", function(data){
        Feng.success("修改成功!");
        window.parent.Info.table.refresh();
        InfoInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.infoInfoData);
    ajax.start();
}

$(function() {
//select 初始化
		　　//$("#stuClass").remove();//清空select列表数据
		　//　$("#stuGrade").remove();//清空select列表数据	
			var sex = $("#stuSex").val();
			if(sex==1){
				$("#stuBoy").attr("checked",true);
			}else{
				$("#stuGirl").attr("checked",true);
			}
		　　$.ajax({
		　　　　type : "POST",
		　　　　url : Feng.ctxPath + "/grade/listClassType",
		　　　　dataType : "JSON",
		　　success : function(msg) 
		　　{
			debugger
		　　　　$("#stuClass").prepend("<option value='0'>请选择</option>");//添加第一个option值
		　　　　for (var i = 0; i < msg.length; i++) {
		　　　　//如果在select中传递其他参数，可以在option 的value属性中添加参数
		　　　　//$("#selectSM").append("<option value='"+msg.rows[i].id+"'>"+msg.rows[i]+"</option>");
		　　　　$("#stuClass").append("<option>"+msg[i]+"</option>");
		　　}
			//编辑
			if($("#stuId").val() != null){
				var className = $("#stuClassHide").val();
				$("#stuClass").val(className);
			}

		　　},error:function(){
			Feng.error("获取数据失败!");
		　　}
		　　});
		
		　$.ajax({
		　　　　type : "POST",
		　　　　url : Feng.ctxPath + "/grade/listGradeType",
		　　　　dataType : "JSON",
		　　success : function(msg) 
		　　{
		　　　　$("#stuGrade").prepend("<option value='0'>请选择</option>");//添加第一个option值
		　　　　for (var i = 0; i < msg.length; i++) {
		　　　　//如果在select中传递其他参数，可以在option 的value属性中添加参数
		　　　　//$("#selectSM").append("<option value='"+msg.rows[i].id+"'>"+msg.rows[i]+"</option>");
		　　　　$("#stuGrade").append("<option>"+msg[i]+"</option>");
		　　}
			//编辑
			if($("#stuId").val() != null){
				var gradeName = $("#stuGradeHide").val();
				$("#stuGrade").val(gradeName);
			}

		　　},error:function(){
			Feng.error("获取数据失败!");
		　　}
		　　});
		

});
