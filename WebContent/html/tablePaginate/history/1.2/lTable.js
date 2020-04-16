/**
Author:Li Qiubai
Version:1.2
Date:2015-10-21
*	table		表格
*	paging		分页
**/
; (function ($) {
	'use strict';
	/*table*/
	$.lTable = function (el,options) {
		var data=options.data;
		var thids=options.title;
		var thnames=options.name;
		var checkBox=options.checkBox;
		var tid=options.tid;
        var htmls="";
        var self = this;
        var idsStr="";
       	self.$container = $(el);
  		self.getCheckboxIds=function (){
  			idsStr="";
			var ids=$(el).find("input[name='ids']");
			if(ids.length != undefined){
			   for(var i = 0; i < ids.length; i++){
			    	if(ids[i].checked){
			    		idsStr+=(ids[i].getAttribute("cbValue")+",");
			    	}
			    }
			}

			if(idsStr.length>0){
				idsStr=idsStr.substring(0, idsStr.length-1);
			}

  			return idsStr;
  		}

   		self.init = function () {
   			var ths="";
        	var thb="";
			ths+="<tr class='info'>";
			if(null!=checkBox&&checkBox!=""){
            	ths+='<th><input type="checkbox" class="checkAll" /></th>';
            }
			for(var k in thnames){
	        	if(thnames[k]=="_opt"){
	        		ths+='<th>操作</th>';
	        	}else{
	        		ths+='<th>'+thnames[k]+'</th>';
	        	}
	        }
			
        	ths+='</tr>';
        	
            for(var m in data){
            	thb+='<tr>';

            	//checkbox部分
            	if(null!=checkBox&&checkBox!=""){
            			//thb+='<td>'+checkBox+'</td>';
            			thb+='<td><input name="ids" type="checkbox" cbValue="'+data[m][checkBox]+'" /></td>';
            	}

            	//数据部分
            	for(var k=0;k<thids.length;k++){

            		for(var n in data[m]){
	        			if(n==thids[k]){
	        				//console.log(n+"---"+data[m][n])
	        				thb+=('<td>'+(data[m][n]==null?"":data[m][n])+'</td>');
	        				break;
	        			}
            		}
        		}
            	
            	//操作部分
            	for(var k=0;k<thids.length;k++){
            		if(thnames[k]=="_opt"){
            			thb+=('<td>'+thids[k].replace(/\id/g,("\""+data[m][tid]+"\""))+'</td>');
            		}
            	}
            	thb+='</tr>';
           	}
        	
			htmls="<table>"+(ths+thb)+"</table>";
			self.$container.html(htmls);
	   		
			$("th,td").css({"height":"40px","line-height":"30px","margin":"5px,0"});
			$("th,td").css({"text-align":"center"});
		}
		
		self.checkAll = function () {
			self.$container.find(".checkAll").on('click',function (){
				if(this.checked){
					$(this).parents('table').find("input[type='checkbox']").prop("checked",'true');
				}else{
					$(this).parents('table').find("input[type='checkbox']").removeAttr("checked");
				}
			});
		}
		self.init();
		self.checkAll();	

		$(el).find("table").addClass('table table-bordered');
		$(el).find("button").addClass("btn btn-default");
		return self;
	}

	
	/*paging*/
	$.lPaging = function (el,options) {
		var pageNumber=options.pageNumber;
		var totalPage=options.totalPage;
		var countSize=options.countSize;
		var count=options.count;
		var bl=5;

		if(countSize!=null&&countSize>0){
			bl=countSize;
		}
		var self = this;
       	self.$container = $(el);
		self.init = function () {
			var ul="<ul>";
			
			
			
			if(pageNumber!=1){
				ul+="<li><a href='javascript:;' pv='1'>首页</a></li>";
				ul+="<li><a href='javascript:;' pv='"+(pageNumber-1)+"'>上一页</a></li>";
			}
			
			if(bl>=totalPage){
				ul+=self.createUL(totalPage,pageNumber,0);
			}else{
				var bb=Math.floor(pageNumber-bl/2);

				if(bb<1){
					ul+=self.createUL(bl,pageNumber,0);

				}else if((bb+bl)>totalPage){
					ul+=self.createUL(bl,(pageNumber-totalPage+bl),(totalPage-bl));

				}else{

					ul+=self.createUL(bl,(pageNumber-bb),(bb));
			
				}
			}
			if(pageNumber!=totalPage){
				ul+="<li><a href='javascript:;' pv='"+(pageNumber+1)+"'>下一页</a></li>";
				ul+="<li><a href='javascript:;' pv='"+totalPage+"'>尾页</a></li>";
			}
			
			if(count!=null&&count>0){
				ul+="<li><span>共"+count+"条</span></li>";
			}
			ul+="</ul>";
			self.$container.html(ul);
		}

		self.createUL=function (f2,il,pv){
			var numHtml="";
			for(var k=1;k<=f2;k++){

				if(il==k){
					numHtml+="<li class='active'><a href='javascript:;' pv='"+(pv+k)+"'>"+(pv+k)+"</a></li>";
				}else{
					numHtml+="<li><a href='javascript:;' pv='"+(pv+k)+"'>"+(pv+k)+"</a></li>";
				}
			}
			return numHtml;
		}

		self.bindEvents = function () {
			self.$container.find("a").on('click',function (){
				options.onPageChange($(this).attr("pv"));
			});
		}
		self.init();
		self.bindEvents();
		
		
		$(el).find("ul").addClass('pagination').css({'float':'right'});
	}

	
})(jQuery);

