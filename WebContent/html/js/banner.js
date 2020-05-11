$.fn.banner = function(cla,tim){
	var $obj = $(cla);
	var timer_1;
	var len = $obj.find(".kv").length;		
	var flg = 0;
	
	$obj.find(".kv").eq(flg).fadeIn();
	
	$obj.find(".next_btn").click(function(){
		
		flg<$obj.find(".kv").length-1 ? flg++ : flg=0;
		changeImg(flg);
		
	});
	
	$obj.find(".prev_btn").click(function(){
		
		flg>0 ? flg-- : flg=$obj.find(".kv").length-1;
		changeImg(flg);
		
	});
	
	
	timer_1 = setInterval(function(){
		flg<$obj.find(".kv").length-1 ? flg++ : flg=0;
		changeImg(flg);
	},tim);
	
	$obj.hover(function(){
		clearInterval(timer_1);
	},function(){
		timer_1 = setInterval(function(){
			flg<$obj.find(".kv").length-1 ? flg++ : flg=0;
			changeImg(flg);
		},tim);
	});
	
	
	
	

	
	function changeImg (index)
	{
		$obj.find(".kv").fadeOut(300).eq(index).fadeIn(400);	
	}
	
}