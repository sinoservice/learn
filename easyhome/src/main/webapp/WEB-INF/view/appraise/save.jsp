<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title> 对我们的师傅满意吗？</title>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0,minimum-scale=1.0, maximum-scale=1.0,user-scalable=no">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/appraiseone.css">
</head>
<body>
<!--整体-->
 <div class='entirety'>
     <!--头部-->
     <header class="header">
             <nav class="link">
                 <h2 style="background-color: #FF9000" align="center">居然之家满意度评价</h2>
             </nav>
         </header>
     <!--中间部分-->
     
     <div class="middle">
     <form method="post" id="submitForm">
       <div class='interval'>
           <div class="w">
         <div class='interval_one'>
             <div class="container">
                 <strong>完工确认：</strong>
                 <p><span>服务是否完成</span><br>
                     <span><input type="checkbox" class="input_check" id="check1" value="1"><label for="check1"></label>是</span>
                     <span><input type="checkbox" class="input_check" id="check2" value="0"><label for="check2"></label> 否</span>
                     <input type="hidden" name="evalServiceComplete"/>
                 </p>
                 <p><span>是否愿意接受电话回访</span><br>
                     <span><input type="checkbox" class="input_check" id="check3" value="1"><label for="check3"></label>是</span>
                     <span><input type="checkbox" class="input_check" id="check4" value="0"><label for="check4"></label> 否</span>
                     <input type="hidden" name="evalPhoneBack"/>
                 </p>
             </div>
         </div>
           </div>
     </div>

         <!--星级评价-->
         
         <div class="interval_two">
             <div class="interval_three">
                 <fieldset class="form">
                     <strong>技师服务评价：</strong>
                     <ul class="star" id="star">
                         <li id="one">
                             <label>服务态度评价</label>
                             <span value="1" class="score">1分</span>
                             <span value="2" class="score">2分</span>
                             <span value="3" class="score">3分</span>
                             <span value="4" class="score">4分</span>
                             <span value="5" class="score">5分</span>
                             <input type="hidden" value="0" id="satisfaction1" name="satisfaction1">
                         </li>
                         <li id="two">
                             <label>技能水平评价</label>
                             <span value="1" class="score">1分</span>
                             <span value="2" class="score">2分</span>
                             <span value="3" class="score">3分</span>
                             <span value="4" class="score">4分</span>
                             <span value="5" class="score">5分</span>
                             <input type="hidden" value="0" id="satisfaction2" name="satisfaction2">
                         </li>
                         <li id="three">
                             <label>服务准时性评价</label>
                             <span value="1" class="score">1分</span>
                             <span value="2" class="score">2分</span>
                             <span value="3" class="score">3分</span>
                             <span value="4" class="score">4分</span>
                             <span value="5" class="score">5分</span>
                             <input type="hidden" value="0" id="satisfaction3" name="satisfaction3">
                         </li>
                     </ul>
                 </fieldset>
                 <%-- <input type="hidden" id="workOrderId" name="workOrderId" value="${workOrderId }"> --%>
                 <%-- <input type="hidden" id="address" name="address" value="${address }">
                 <input type="hidden" id="time" name="date" value="${date }"> --%>
             </div>
         </div>
         <!--备注-->
         <div class='comment'>
             <div class='comment_text'>
             <strong>备注：</strong> <br>
             <textarea name="customerEval" class='texts' placeholder="(请输入0-72个字)"></textarea>
             </div>
         </div>
		</form>


         <!--提交按钮-->
         <div class='submit_one'>
                 <button class="submit" id="mySubmit" >提&nbsp;&nbsp;&nbsp;交</button>
         </div>
        </div>
     <!--底部-->
     <footer class="footer">
         <div class="top">客户端 | 触屏版 | 电脑版</div>
         <div class="center">致电我们：4001-176-176</div>
         <div class="bottom">Copyright(C) 北京居然之家智慧物联科技有限公司 2003-2018,All Rights Reserved.</div>
     </footer>
 </div>
 <script type="text/javascript" src="${pageContext.request.contextPath}/view/script/jquery-1.8.3.min.js"></script>
 <script>

    //单选框
    var box1 = document.getElementsByName('complete');
    for (var i = 0; i < box1.length; i++) {
        box1[i].onclick = function () {
            for (var i = 0; i < box1.length; i++) {
                box1[i].checked = false;
            }
            this.checked = true;
        }
    }

    var box2 = document.getElementsByName('delivery');
    for (var i = 0; i < box2.length; i++) {
        box2[i].onclick = function () {
            for (var i = 0; i < box2.length; i++) {
                box2[i].checked = false;
            }
            this.checked = true;
        }
    }


    // 星级评价
    star("one")
    star("two")
    star("three")
    function star(id) {
        var star = document.getElementById("star"),
                li = document.getElementById(id),
                spans = li.getElementsByTagName("span");
        var iStar;

        for (var i = 0; i < spans.length; i++) {
            spans[i].index = i + 1;

            spans[i].onmouseover = function () {
                onStar(this.index);
            };
            spans[i].onmouseout = function () {
                onStar();
            };
            spans[i].onclick = function () {
                iStar = this.index;
            };
        };

        //当前访问到第几个index
        function onStar(spanIndex) {
            var iScore = spanIndex || iStar;
            for (var i = 0; i < spans.length; i++) {
                spans[i].className = (i < iScore ? "active" : "");
            }
        };
    }

    //查找元素位置
    function getPosition(obj) {
        var top = 0,
                left = 0,
                width = obj.offsetWidth,
                height = obj.offsetHeight;

        while (obj.offsetParent) {
            top += obj.offsetTop;
            left += obj.offsetLeft;
            obj = obj.offsetParent;
        }
        return {"top": top, "left": left, "width": width, "height": height};
    }
    
    //点击获取值
    $(".score").click(function(){
    	$(this).parent().find("input").val($(this).attr('value'));
    });
    
    $(".input_check").click(function(){
    	var _value = $(this).attr('value');
    	var ss = $(this).parent().parent().find(".input_check").each(function(){
    		$(this).attr("checked",false);
    	});
    	$(this).attr("checked",true);
    	$(this).parent().parent().find("input[type=hidden]").val(_value);
    });
    
    //提交表单
    $("#mySubmit").click(function(){
    	$("#submitForm").submit();
    });
    
</script>
</body>
</html>
