表格与分页说明

0初始化方法
0.1css：
	导入
		css/v3/bootstrap.min.css
	或导入
		css/v2/bootstrap.min.css
		css/v3/pagination.css
		css/v3/table.css
		css/v3/button.css

0.2js
	导入
		js/jquery-1.10.1.min.js
		js/lTable.js




1表格

1.1初始化方法
	$.lTable('id',{data,title,name,tid,chechBox});

1.2属性说明
	id:页面选择的填充块
	data:页面显示的json数据
	title:表格每一列与数据对应的字段
	name:表格第一行显示字段
	tid:每行对应的键值(可省略)
	checkBox:复选框对应的value(可省略)

1.3复选框说明
	当初始化添加 chechBox属性时 激活
	复选框 name="ids"
	获取已选列方法: $.lTable.getCheckboxIds() 返回值例 "1,2,3,4"

1.4操作咧说明
	当属性name=_opt时 表格头自动换位"操作"
	对应属性title 可添加按钮等操作 
	例:"<button onclick='updF(id)'>修改</button>"  
	点击方法为updF() 参数id 为属性tid对应字段


2分页

2.1初始化方法	
	$.lPaging('id',{pageNumber,totalPage,countSize,count,onPageChange(num),inputSearch});

2.2属性方法说明
	id:页面选择的填充块
	pageNumber:当前页数
	totalPage:总页数
	countSize:分页显示个数(可省略 默认5)
	count:数据总数
	onPageChange(num):返回点击事件
	inputSearch: 是否显示查询输入框 boolean  默认false
	getInputVal():返回输入框内数字

