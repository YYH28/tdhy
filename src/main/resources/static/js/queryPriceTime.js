var setLeavedCityName = "出发城市";
var setArrivedCityName = "到达城市";
var setWeight = "货物总重量";
var setVolumn = "货物总体积:长*宽*高(CM)";
var setInsurance = "请输入货物实际价值进行保价";
var setCollDeliveryAmount = "如您需要代收货款服务则填写";
var totalTransTypeCode = '';//选择线路支持的所有运输方式


$(document).ready(function () {

    $("#queryPricTime").click(function () {
        var leavedPriceTimeCityName = $("#leavedCityName").val();
        var arrivedPriceTimeCityName = $("#arrivedCityName").val();
        var reg = /^[\u4E00-\u9FA5]{2,}-[\u4E00-\u9FA5]{2,}-[\u4E00-\u9FA5]{2,}$/;
        if (!reg.test(leavedPriceTimeCityName) && !reg.test(arrivedPriceTimeCityName)) {
            return;
        } else {
            //首页跳到时效价格页面时保存自定义的城市编码属性值
            // $.session.set('key', 'value')
            $.session.set('tempLeavedCode', $("#leavedCityName").attr("cityCode"))
            $.session.set('tempArrivedCode', $("#arrivedCityName").attr("cityCode"))
            $("#priceTimeForm").submit();
        }
    });

    $(function () {
        var leavedCityName = $("#leavedCityName").val();
        var arrivedCityName = $("#arrivedCityName").val();
        var reg = /^[\u4E00-\u9FA5]{2,}-[\u4E00-\u9FA5]{2,}-[\u4E00-\u9FA5]{2,}$/;
        if (leavedCityName != null && reg.test(leavedCityName) && arrivedCityName != null && reg.test(arrivedCityName)) {
            $("#leavedCityName").attr("cityCode", $.session.get('tempLeavedCode'));
            $("#arrivedCityName").attr("cityCode", $.session.get('tempArrivedCode'));
            showPriceTime();
        }
    });

    /**
     * 查询价格时效
     */
    $("#queryPrice").click(function () {
        showPriceTime();
    });

    /**
     * 初始化禁用计算button
     */
    /*$(function(){
     $("#priceCale").attr({"disabled":"disabled"});
     });*/


    /**
     *删除数组指定下标或指定对象
     */
    Array.prototype.remove=function(obj){
        for(var i =0;i <this.length;i++){
            var temp = this[i];
            if(!isNaN(obj)){
                temp=i;
            }
            if(temp == obj){
                for(var j = i;j <this.length;j++){
                    this[j]=this[j+1];
                }
                this.length = this.length-1;
            }
        }
    }




    /**
     * 计算价格
     */
    $("#priceCale").click(function () {
        var leavedCityName = $("#leavedCityName").val();
        var leavedCode = $("#leavedCityName").attr("cityCode");
        //没有选择出发城市
        if (setLeavedCityName == leavedCityName) {
            $("#routeMsg").removeClass("hide");
            return;
        }

        var send = leavedCode.split("-");
        var sendProvinceCode = send[0];
        var sendCityCode = send[1];
        var sendAreaCode = send[2];

        var arrivedCityName = $("#arrivedCityName").val();
        var arrivedCode = $("#arrivedCityName").attr("cityCode");
        //没有选择出发城市
        if (setArrivedCityName == arrivedCityName) {
            $("#routeMsg").removeClass("hide");
            return;
        }

        var arrived = arrivedCode.split("-");
        var arriveProvinceCode = arrived[0];
        var arriveCityCode = arrived[1];
        var arriveAreaCode = arrived[2];

        //二次选择正确路线
        $("#routeMsg").addClass("hide");

        //重量
        var weight = $("#weight").val();
        if (setWeight == weight || weight == "") {
            $("#tips").text("请输入货物重量!");
            return;
        } else if (weight == 0) {
            $("#tips").text("货物重量不能为零!");
            return;
        } else if (isNaN(weight)) {
            $("#tips").text("请输入正确的货物重量!");
            return;
        }
        //体积
        var volumn = $("#volumn").val();
        if (setVolumn == volumn || volumn == "") {
            $("#tips").text("请输入货物体积!");
            return;
        } else if (volumn == 0) {
            $("#tips").text("货物体积不能为零!");
            return;
        } else if (isNaN(volumn)) {
            $("#tips").text("请输入正确的货物体积!");
            return;
        }
        //保价
        var insurance = $("#insurance").val();
        if (setInsurance == insurance || insurance == "") {
            $("#tips").text("请输入货物保价!");
            return;
        } else if (isNaN(insurance)) {
            $("#tips").text("请输入正确的保价金额!");
            return;
        }
        $("#tips").text("");
        //代收货款
        var collDeliveryAmount = $("#collDeliveryAmount").val();
        if (setCollDeliveryAmount == collDeliveryAmount || collDeliveryAmount == "") {
            collDeliveryAmount = 0;
        }

        //代收类型
        var collectDeliveryType = $("#collectDeliveryType").val();
        //提货
        var receiveShipment = $('#receiveShipment').attr('checked') == 'checked';
        //送货
        var deliverShipment = $('#deliverShipment').attr('checked') == 'checked';

        $(".black_overlay").css("display","block");
        $.ajax({
            type: "post",
            url: "",
            dataType: "json",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            data: {
                "priceTimeVo.priceTimeEntity.sendProvinceCode": sendProvinceCode,//出发省编码  用于 代收货款
                "priceTimeVo.priceTimeEntity.sendCityCode": sendCityCode,//出发市编码
                "priceTimeVo.priceTimeEntity.sendAreaCode": sendAreaCode,//出发区编码
                "priceTimeVo.priceTimeEntity.arriveProvinceCode": arriveProvinceCode,//到达省份编码
                "priceTimeVo.priceTimeEntity.arriveCityCode": arriveCityCode,//到达城市编码
                "priceTimeVo.priceTimeEntity.arriveAreaCode": arriveAreaCode,//到达区域编码
                "priceTimeVo.priceTimeEntity.standardTransTypeCode": totalTransTypeCode,//运输类型
                "priceTimeVo.totalWeight": weight,//重量
                "priceTimeVo.totalVolume": volumn,//体积
                "priceTimeVo.receiveShipment": receiveShipment,//是否接货
                "priceTimeVo.deliverShipment": deliverShipment,//是否送货
                //"priceTimeVo.discount": 1,//折扣
                "priceTimeVo.insuranceFee": insurance,//保价费
                "priceTimeVo.collectionFee": collDeliveryAmount,//代收货款
                'priceTimeVo.collectDeliveryType': collectDeliveryType//代收类型
            },
            success: function (data) {
                $(".black_overlay").css("display","none");
                if (data.success) {
                    var prices = data.priceTimeVos;
                    var tail = 0;
                    // var objModel = new Array();

                    var objModel=new Array("price_calc_inhome_title","price_calc_inhome_div","price_calc_install_title","price_calc_install_div","price_calc_package_title","price_calc_package_div")
                    for (var i = 0; i < prices.length; i++) {

                        var transType = prices[i].priceTimeEntity.standardTransTypeCode;
                        if (transType == '10000000000000000001') {//定日达
                            tail = 0;
                        } else if (transType == '20000000000000000001') {//整车
                            continue;
                        } else if (transType == '30000000000000000001') {//经济快运
                            tail = 1;
                        } else if (transType == '50000000000000000001') {// 偏线
                            continue;
                        } else if (transType == '60000000000000000001') {//易-入户
                            tail = 2;
                            objModel.remove('price_calc_inhome_title');
                            objModel.remove('price_calc_inhome_div');
                        } else if (transType == '70000000000000000001') {//易-安装
                            tail = 3;
                            objModel.remove('price_calc_install_title');
                            objModel.remove('price_calc_install_div');
                        } else if (transType == '80000000000000000001') {//易-包裹
                            tail = 4;
                            objModel.remove('price_calc_package_title');
                            objModel.remove('price_calc_package_div');
                        } else if (transType == '90000000000000000001') {//经济拼车
                            continue;
                        }


                        $("#freightFee" + tail).text(prices[i].calculateEntity.freightFee + " 元");
                        $("#favorable" + tail).text(prices[i].calculateEntity.favorable + " 元");
                        $("#insuranceFee" + tail).text(prices[i].calculateEntity.insuranceFee + " 元");
                        $("#collectionFee" + tail).text(prices[i].calculateEntity.collectionFee + " 元");
                        $("#pickupFee" + tail).text(prices[i].calculateEntity.pickupFee + " 元");
                        $("#deliveryFee" + tail).text(prices[i].calculateEntity.deliveryFee + " 元");
                        $("#smsFee" + tail).text(prices[i].calculateEntity.smsFee + " 元");
                        $("#paperFee" + tail).text(prices[i].calculateEntity.paperFee + " 元");
                        $("#totalFee" + tail).text(prices[i].calculateEntity.totalFee + " 元");
                    }


                    $("#price_cale").removeClass("hide");
                    $("#explain_div").removeClass("hide");
                    for (var i = 0; i < objModel.length; i++) {
                        $("#price_cale").find("#" + objModel[i]).css("display", "none");
                    }
                } else {
                    alert(data.message);
                }
            },
            error: function (data) {
                $(".black_overlay").css("display","none");
                alert("对不起，系统繁忙,请稍后操作！");
            }
        });
    });


});

function isEmpty(str){
    if($.trim(str) == '' || str == null){
        return true;
    }
    return false;
}

/**
 *
 * @author 龙海仁
 * @date 2015年8月21日下午2:07:52
 * @update
 */
function showPriceTime() {
    var leavedCityName = $("#leavedCityName").val();
    var leavedCode = $("#leavedCityName").attr("cityCode");
    //没有选择出发城市
    if (setLeavedCityName == leavedCityName) {
        $("#routeMsg").removeClass("hide");
        return;
    }
    //匹配格式
    var reg = /^[\u4E00-\u9FA5]{2,}-[\u4E00-\u9FA5]{2,}-[\u4E00-\u9FA5]{2,}$/;
    if (!reg.test(leavedCityName)) {
        $("#routeMsg").removeClass("hide");
        return;
    }


    var send = leavedCode.split("-");
    var sendProvinceCode = send[0];
    var sendCityCode = send[1];
    var sendAreaCode = send[2];

    //到达城市
    var arrivedCityName = $("#arrivedCityName").val();
    var arrivedCode = $("#arrivedCityName").attr("cityCode");
    //没有选择出发城市
    if (setArrivedCityName == arrivedCityName) {
        $("#routeMsg").removeClass("hide");
        return;
    }
    if (!reg.test(arrivedCityName)) {
        $("#routeMsg").removeClass("hide");
        return;
    }

    var arrived = arrivedCode.split("-");
    var arriveProvinceCode = arrived[0];
    var arriveCityCode = arrived[1];
    var arriveAreaCode = arrived[2];


    //二次选择正确路线
    $("#routeMsg").addClass("hide");

    $(".black_overlay").css("display","block");
    $.ajax({
        type: "post",
        url: "",
        dataType: "json",
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        data: {
//			"priceQueryVo.productTypeId":productTypeId,
//			"priceQueryVo.weight":weight,
//			"priceQueryVo.volumn":volu/*
            'priceTimeVo.operFlag': '2',//操作标识 按线路查询
            // 'priceTimeVo.sendSaleDepartment': formData.get('sendSaleDepartment'),//出发门店
            // 'priceTimeVo.arriveSaleDepartment': formData.get('arriveSaleDepartment'),//到达门店
            'priceTimeVo.priceTimeEntity.sendProvinceCode': sendProvinceCode,//出发 省
            'priceTimeVo.priceTimeEntity.sendCityCode': sendCityCode,//出发 市
            'priceTimeVo.priceTimeEntity.sendAreaCode': sendAreaCode,//出发 区县
            'priceTimeVo.priceTimeEntity.arriveProvinceCode': arriveProvinceCode,//到达 省
            'priceTimeVo.priceTimeEntity.arriveCityCode': arriveCityCode,//到达 市
            'priceTimeVo.priceTimeEntity.arriveAreaCode': arriveAreaCode,//到达 区县
            'priceTimeVo.priceTimeEntity.standardTransTypeCode': '',//运输类型 为空查询全部
            'priceTimeVo.deliverDate': new Date(),//发货日期
            // // 'priceTimeVo.printCompany': formData.get('printCompany'),//打印公司
            // 'priceTimeVo.ddCheck': formData.get('ddCheck'),//DD折扣
            // 'priceTimeVo.ddSale': formData.get('ddSale'),//DD折扣 具体的值
            // 'priceTimeVo.duCheck': formData.get('duCheck'),//DU折扣
            // 'priceTimeVo.duSale': formData.get('duSale'),//DU折扣 具体的值
            // 'priceTimeVo.easyCheck': formData.get('easyCheck'),//易到家折扣
            // 'priceTimeVo.easySale': 1,//易到家折扣 具体的值  界面暂时屏蔽 这里默认为1
            // 'priceTimeVo.customerCode': formData.get('customerCode'),//客户编号
            'priceTimeVo.priceDate': new Date()//价格时间


        },
        success: function (data) {
            $(".black_overlay").css("display","none");
            if (data.success) {
                var prices = data.priceTimeVo.priceTimeEntityList;
                var length = prices.length;

                if (length == 0) {
                    alert('没有所查线路信息，请选择相邻区县或市区查询或拨打服务热线400-808-6666');
                    return;
                }
                totalTransTypeCode = '';
                var tail = 0;
                for (var i = 0; i < length; i++) {

                    var transType = prices[i].standardTransTypeCode;
                    if (transType == '10000000000000000001') {//定日达
                        tail = 0;
                        jointTransTypeCode(transType);
                    } else if (transType == '20000000000000000001') {//整车
                        continue;
                    } else if (transType == '30000000000000000001') {//经济快运
                        tail = 1;
                        jointTransTypeCode(transType);
                    } else if (transType == '50000000000000000001') {// 偏线
                        if (length==1) {
                            alert('没有所查线路信息，请选择相邻区县或市区查询或拨打服务热线400-808-6666');
                            return;
                        }
                        continue;
                    } else if (transType == '60000000000000000001') {//易-入户
                        tail = 2;
                        jointTransTypeCode(transType);
                    } else if (transType == '70000000000000000001') {//易-安装
                        tail = 3;
                        jointTransTypeCode(transType);
                    } else if (transType == '80000000000000000001') {//易-包裹
                        tail = 4;
                        jointTransTypeCode(transType);
                    } else if (transType == '90000000000000000001') {//经济拼车
                        continue;
                    }
  
                    var arr=prices[i].transTime.split('-')
                    if(Array.prototype.isPrototypeOf(arr) && arr.length === 2) {
                        if (arr[0]==arr[1].substr(0, 1)){
                            $("#transTime" + tail).text(arr[1]);
                        }else {
                            $("#transTime" + tail).text(prices[i].transTime);
                        }
                        　　　　　
                    }else {
                        $("#transTime" + tail).text(prices[i].transTime);
                    }

                    //两套价格
                    var pickupWeightPrice = prices[i].pickupWeightPrice;
                    var pickupVolumnPrice = prices[i].pickupVolumnPrice;
                    if(isEmpty(pickupWeightPrice) &&isEmpty(pickupVolumnPrice)){
                        //自送价格
                        // $("#transTime" + tail).text(prices[i].transTime);
                        if (tail == 2 || tail == 3 || tail == 4) {
                            $("#startPrice" + tail).text(parseFloat(prices[i].standardLowestFee).toFixed(2));
                            // $("#firstWeightPrice" + tail).text(parseFloat(prices[i].standardFirstWeightPrice).toFixed(2));
                            $("#firstWeightPrice" + tail).text(prices[i].standardFirstWeight);
                            $("#firstAddWeightPrice" + tail).text(parseFloat(prices[i].standardFirstAddWeightPrice).toFixed(2));
                        } else {
                            $("#startPrice" + tail).text(parseFloat(prices[i].standardLowestFee).toFixed(2));
                            $("#heavyPrice" + tail).text(parseFloat(prices[i].standardWeightPrice).toFixed(2));
                            $("#lightPrice" + tail).text(parseFloat(prices[i].standardVolumePrice).toFixed(2));
                        }
                    }else {
                        //上门提货价格
                        var pickupLowestFee = (parseFloat(prices[i].standardLowestFee) + parseFloat(isEmpty(prices[i].pickupMinPrice) ? 0 : prices[i].pickupMinPrice)).toFixed(2);
                        pickupWeightPrice = isEmpty(pickupWeightPrice) ? 0 : parseFloat(pickupWeightPrice);
                        pickupVolumnPrice = isEmpty(pickupVolumnPrice) ? 0 : parseFloat(pickupVolumnPrice);
                        //自送价格
                        // $("#transTime" + tail).text(prices[i].transTime);
                        if (tail == 2 || tail == 3 || tail == 4) {
                            $("#startPrice" + tail).text(pickupLowestFee);
                            // $("#firstWeightPrice" + tail).text(   (parseFloat(prices[i].standardFirstWeightPrice)+pickupWeightPrice).toFixed(2)   );
                            $("#firstWeightPrice" + tail).text(prices[i].standardFirstWeight);
                            $("#firstAddWeightPrice" + tail).text(prices[i].standardFirstAddWeightPrice);
                        } else {
                            $("#startPrice" + tail).text(pickupLowestFee);
                            $("#heavyPrice" + tail).text((parseFloat(prices[i].standardWeightPrice)+pickupWeightPrice).toFixed(2));
                            $("#lightPrice" + tail).text((parseFloat(prices[i].standardVolumePrice)+pickupVolumnPrice).toFixed(2));
                        }
                    }


                    // $("#remark" + tail).text(prices[i].reamrk);
                    //如果有这个数据，才显示
                    // if (prices[i].exist == 0) {
                    $("#price" + tail).removeClass("hide");
                    // }
                }
                $("#price_time").removeClass("hide");
                $("#price_cale").removeClass("show").addClass("hide");
                $("#trans_illustrate").removeClass("show").addClass("hide");
            } else {
                alert(data.message);

            }
        },
        serror: function (data) {
            $(".black_overlay").css("display","none");
            alert("对不起，系统繁忙,请稍后操作！");
        }
    });
}

function jointTransTypeCode(transTypeCode) {

    if (totalTransTypeCode == '') {
        totalTransTypeCode = transTypeCode;
    } else {
        totalTransTypeCode = totalTransTypeCode + '-' + transTypeCode;
    }

}


/**
 * 输入框验证
 * @param id
 * @param operation
 * @param whichOne
 */
function initval(id, operation, whichOne) {
    var vs = $("#" + id).val();
    var setv;
    switch (whichOne) {
        case 0:
            setv = setLeavedCityName;
            break;
        case 1:
            setv = setArrivedCityName;
            break;
        case 2:
            if (operation == 2) {
                validateParam();
            }
            setv = setWeight;
            break;
        case 3:
            if (operation == 2) {
                //体积
                validateParam();
            }
            setv = setVolumn;
            break;
        case 4:
            if (operation == 2) {
                //保价
                validateParam();
            }
            setv = setInsurance;
            break;
        case 5:
            /*if(operation == 2){
             //代收货款
             validateParam() ;
             }*/
            setv = setCollDeliveryAmount;
            break;
    }
    if (operation == 1) {
        if (vs == setv) {
            $('#' + id).val("");
            $('#' + id).removeClass("grays");
        }
    }
    if (operation == 2) {
        if (vs.length == 0) {
            $('#' + id).val(setv);
            $('#' + id).addClass("grays");
        }
    }
}

function validateParam() {
    //重量
    var weight = $("#weight").val();
    if (setWeight == weight || weight == "") {
        $("#tips").text("请输入货物重量!");
        return;
    } else if (weight == 0) {
        $("#tips").text("货物重量不能为零!");
        return;
    } else if (isNaN(weight)) {
        $("#tips").text("请输入正确的货物重量!");
        return;
    }
    //体积
    var volumn = $("#volumn").val();
    if (setVolumn == volumn || volumn == "") {
        $("#tips").text("请输入货物体积!");
        return;
    } else if (volumn == 0) {
        $("#tips").text("货物体积不能为零!");
        return;
    } else if (isNaN(volumn)) {
        $("#tips").text("请输入正确的货物体积!");
        return;
    }
    //保价
    var insurance = $("#insurance").val();
    if (setInsurance == insurance || insurance == "") {
        $("#tips").text("请输入货物保价!");
        return;
    } else if (isNaN(insurance)) {
        $("#tips").text("请输入正确的保价金额!");
        return;
    }
    //代收货款
    /*	var collDeliveryAmount = $("#collDeliveryAmount").val();
     if(collDeliveryAmount != null && collDeliveryAmount != '' && Number(collDeliveryAmount) > 100){
     $("#tips").text("代收货款最大只能输入100!");
     return;
     }*/

    $("#tips").text("");

}