//校验手机
    	function checkPhone(){
    		var id = $("#pid").val();
            var reg_id = /^1(3|4|5|6|7|8|9)\d{9}$/;
            var flag = reg_id.test(id);
            if (flag) {
                $("#pid").css("border", "");
                $(".lab0").fadeOut("slow");
            }
            else {
                $("#pid").css("border", "1px solid red");
                $(".lab0").fadeIn("slow");
            }
            return flag;
    	}
        //校验名字
        function checkName() {
            var no = $("#name").val();
            var reg_no = /^[\u4e00-\u9fa5]{2,5}$/;
            var flag = reg_no.test(no);
            if (flag) {
                $("#name").css("border", "");
                $(".lab1").fadeOut("slow");
            }
            else {
                $("#name").css("border", "1px solid red");
                $(".lab1").fadeIn("slow");
            }
            return flag;
        }
        //校验密码是否格式正确
        function checkPwdT() {
            var pwd = $("#pwd1").val();
            var reg_pwd = /^(?!^[0-9]+$)(?!^[A-z]+$)(?!^[^A-z0-9]+$)^[^\s\u4e00-\u9fa5]{6,16}$/;
            var flag = reg_pwd.test(pwd);
            if (flag) {
                $("#pwd1").css("border", "");
                $("#lab3").fadeOut("slow");
            }
            else {
                $("#pwd1").css("border", "1px solid red");
                $("#lab3").fadeIn("slow");
            }
            return flag;
        }
        //校验密码是否一致
        function checkPwd() {
            var g1 = $("#pwd1").val();
            var g2 = $("#pwd2").val();
            var flag = (g1 == g2);
            if (g1 == "" || g2 == "") {
                flag = false;
            }
            if (flag) {
                $("#pwd1").css("border", "");
                $("#pwd2").css("border", "");
                $("#lab2").fadeOut("slow");
            }
            else {
                $("#pwd1").css("border", "1px solid red");
                $("#pwd2").css("border", "1px solid red");
                $("#lab2").fadeIn("slow");
            }
            return flag;
        }

        //提交事件
        function sub () {
            return checkName() && checkPwd() && checkPwdT() && checkPhone();
        }
        function pwd () {
            return checkPwd() && checkPwdT();
        }
        function psub(){
        	return checkPhone() && checkName();
        }
        //光标移开事件
        $("#pid").blur(checkPhone);
        $("#name").blur(checkName);
        $("#pwd1").blur(checkPwd).blur(checkPwdT);
        $("#pwd2").blur(checkPwd).blur(checkPwdT);