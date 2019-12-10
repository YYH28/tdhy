(function() {
	
	/*$(function() { //页面加载完成执行
		//导航栏
		$(".navStatus").hover(function() {
			$(this).addClass("navChange");
			$(this).parent().children("ul").addClass("navChild");
		}).mouseout(function() {
			$(this).removeClass("navChange");
			$(this).parent().children("ul").removeClass("navChild");
		});
		
		$(".navlist").hover(function() {
			$(this).addClass("navChild");
			$(this).parent().addClass("navChange");
		}).mouseout(function() {
			$(this).removeClass("navChild");
			$(this).parent().removeClass("navChange");
		});
	});*/
//	导航栏效果方法
	function mouseOver(e) {
		$(e).addClass("navChange");
		$(e).children("ul").addClass("navChild");
		console.log($(e).parent().children("ul"))
	}
	function mouseOut(e) {
		$(e).removeClass("navChange");
		$(e).children("ul").removeClass("navChild");
	}
	window.result = {
		mouseOver : mouseOver,
		mouseOut : mouseOut
	};
	
	window.onload=function(){
//		大轮播图
		var nameBig='picImg';
		var nameControllerBig='nr';
		appendUl('#picDiv','#picUl',nameControllerBig);
		pic('#lf','.picImg','.nr',nameBig,nameControllerBig);
		/*新闻轮播图*/
		var namSmall='news_pic';
		var nameControllerSmall='nrSmall';
		appendUl('#news_image','#newsUl',nameControllerSmall);
		pic('#newsImage','.news_pic','.nrSmall',namSmall,nameControllerSmall);
		
		function appendUl(image,ul,nameController){
			var image=$(image);
			var ul=$(ul);
			for(var z=0;z<image.childElementCount;z++){
				var nrLi=document.createElement('li');
				nrLi.className=nameController;
				ul.append(nrLi);
			}
			ul.firstElementChild.className=nameController+' picActive';
			//根据传进的值获取对应对象
	        function $(name) {
	            if (name[0] == '#') {
	                return document.getElementById(name.substr(1));
	            } else if (name[0] == '.') {
	                return document.getElementsByClassName(name.substr(1));
	            } else {
	                return document.getElementsByTagName(name);
	            }
	        }
		}
		function pic(parent,mod,controller,classMod,classController){
			var num=0;
			var controller=$(controller);
			var mod=$(mod);
			var pic=$(parent);
<<<<<<< HEAD
			var autoPlayTime=3000;
=======
			var autoPlayTime=2000;
>>>>>>> branch 'master' of https://gitee.com/leaf28/tdhy.git
			var imgNum=mod.length-1;
			var auto;
			console.log(controller)
			autoPlay();
			//根据传进的值获取对应对象
	        function $(name) {
	            if (name[0] == '#') {
	                return document.getElementById(name.substr(1));
	            } else if (name[0] == '.') {
	                return document.getElementsByClassName(name.substr(1));
	            } else {
	                return document.getElementsByTagName(name);
	            }
	        }
	      //实现鼠标划过圆点,变化图片的效果
	        //function change(controller, mod){
	        //遍历控制器,绑定鼠标划过事件
	        for (var i = 0; i < controller.length; i++) {
	            //给控制器加个索引,并把i值赋值给索引
	            controller[i].index = i;
	            //给所有的控制器都加划过事件
	            controller[i].onmouseover = function() {
	                for (var j = 0; j < controller.length; j++) {
	                    //将所有控制器改为默认样式
	                    controller[j].className = classController;
	                }
	                //改变所选的控制器样式
	                this.className = classController+' picActive';
	                //将模型改为默认样式
	                for (var x = 0; x < mod.length; x++) {
	                    mod[x].className = classMod;
	                }
	                //改变所选控制器对应的模型的样式
	                mod[this.index].className = classMod+' active';
	            }
	        }
	        //}
	        //绑定鼠标移入,暂停播放图片
	        pic.onmouseover = function() {
	            clearInterval(auto);
	        }
	        //绑定鼠标离开,继续播放
	        pic.onmouseleave = function() {
	            autoPlay();
	        }
			//自动播放
			function autoPlay(){
				auto=setInterval(function(){
					if(num>imgNum){
						num=0;
					}
					play(num);
					num++;
				},autoPlayTime);
			}
			//指定播放图片
			function play(num){
//				console.log('=================')
//				console.log(num)
				for(var j=0;j<controller.length;j++){
					controller[j].className=classController;
				}
				controller[num].className=classController+' picActive';
				for(var x=0; x<mod.length;x++){
					mod[x].className=classMod;
				}
				mod[num].className=classMod+' active';
			}
		}
		
		
	};
	
})();
function friend(e){
	var friend=document.getElementById('friend_list');
	var map=document.getElementById('site_map');
	console.log(friend.style)
	friend.style.display='flex';
	map.style.display='none';
	clearFriendTabHover()
	e.classList.add("friend_tabAllHover")
	
}
function map(e){
	var friend=document.getElementById('friend_list');
	var map=document.getElementById('site_map');
	friend.style.display='none';
	map.style.display='flex';
	clearFriendTabHover()
	e.classList.add("friend_tabAllHover")
}

clearFriendTabHover = () => {
	console.log("输出class集合")
	console.log(document.getElementById('friend_tab').getElementsByTagName('div'))
	list = document.getElementById('friend_tab').getElementsByTagName('div')
	for(let i=0;i<list.length;i++){
		list[i].classList.remove("friend_tabAllHover")
	}
}

