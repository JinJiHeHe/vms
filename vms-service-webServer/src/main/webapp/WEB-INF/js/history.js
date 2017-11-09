// $.fn.datebox.defaults.formatter = function(date){
//     var y = date.getFullYear();
//     var m = date.getMonth()+1;
//     var d = date.getDate();
//     var h=date.getHours();
//     var M=date.getMinutes();
//     var s=date.getSeconds();
//     return y+'-'+m+'-'+d+' '+h+':'+M+':'+s;
// }
function initDate(){
     var date=new Date();
    var y = date.getFullYear();
    var m = date.getMonth()+1;
    var d = date.getDate();
    var h=date.getHours();
     var M=date.getMinutes();
     var s=date.getSeconds();
     var end_time=y+'-'+m+'-'+d+' '+h+':'+M+':'+s;
     var start_time=y+"-"+m+"-"+d+' '+'0:0:0';
    $('#start_time').datetimebox('setValue',start_time);
    $('#end_time').datetimebox('setValue',end_time);
}


//地图
var baiduMap=function(){
    var map ;          // 创建地图实例
    var lushu;
    // 创建点坐标
    var keyMap={};

    return{
        init:function(){
            map = new BMap.Map("baidumap");
            var point = new BMap.Point(116.404, 39.915);
            map.centerAndZoom(point, 12);               // 初始化地图，设置中心点坐标和地图级别
            map.addControl(new BMap.NavigationControl());
            map.enableScrollWheelZoom();   //启用滚轮放大缩小，默认禁用
            map.enableContinuousZoom();    //启用地图惯性拖拽，默认禁用

        },
        onStart:function () {
           lushu.start();
        },
        onPause:function(){
          lushu.pause();
         },
        queryHistory:function(){
            var start_time = $('#start_time').val();
            var end_time = $('#end_time').val();
            var id_num = $('#id_num').val();
            //alert(start_time + ' ' + end_time + ' ' + id_num);
            $.post('../map/getHistory.do', {"id_num": id_num, "start_time": start_time, "end_time": end_time}, function (data) {
                // console.log(data);
                var arry = eval("("+data+")");
                var arry1=[];
                for(var i=0;i<arry.length;i++){
                    var point=new BMap.Point(arry[i].lon,arry[i].lat);
                    arry1[i]=point;
                }
                lushu = new BMapLib.LuShu(map,arry1,{
                    autoView:true,//是否开启自动视野调整，如果开启那么路书在运动过程中会根据视野自动调整
                    icon  : new BMap.Icon('http://lbsyun.baidu.com/jsdemo/img/car.png', new BMap.Size(52,26),{anchor : new BMap.Size(27, 13)}),
                    speed: 4500,
                    enableRotation:true,//是否设置marker随着道路的走向进行旋转
                });
                $('#historyDataGrid').datagrid('loadData',arry);
                baiduMap.addhistoryLine(arry1);
            })
        },
        addhistoryLine:function(arry){
            var allOverlay = map.getOverlays();
            for(var i = 0;i<allOverlay.length;i++) {

                if(allOverlay[i].toString()=="[object Polyline]") {
                    map.removeOverlay(allOverlay[i]);
                    break;
                }
            }
           var gpspoint= arry[parseInt(arry.length/2)];
           var polyline = new BMap.Polyline(arry, {strokeColor:"blue", strokeWeight:6, strokeOpacity:0.5});
            map.addOverlay(polyline);
            map.centerAndZoom(gpspoint, 12);

        },

        deleteMarker:function(id_num){
            var allOverlay = map.getOverlays();
            for(var i = 0;i<allOverlay.length;i++) {
                if(allOverlay[i].toString()=="[object Marker]") {
                    //删除指定经度的点
                    if (allOverlay[i].getTitle() == id_num) {
                        map.removeOverlay(allOverlay[i]);
                        break;
                    }
                }
            }
        },

        translateSelect:function (arry) {
            var lon=arry.lon;
            var lat=arry.lat;
            var id_num=$('#id_num').val();

            var convertor=new BMap.Convertor();
            var gpsPoint = new BMap.Point(lon,lat);
            var pointArr = [];
            pointArr.push(gpsPoint);

            var mapVid=keyMap[id_num];

            if(mapVid!=null){  //判断上一个标记点
                baiduMap.deleteMarker(mapVid);
            }
                var myIcon = new BMap.Icon("http://lbsyun.baidu.com/jsdemo/img/car.png",new BMap.Size(52,26));
                var marker2 = new BMap.Marker(gpsPoint,{icon:myIcon});  // 创建标注
                marker2.setTitle(id_num);
                map.addOverlay(marker2);
                map.centerAndZoom(gpsPoint, 12);
                keyMap[id_num]=id_num;//存到map中

        },
    }
}();
function initTabs(){
   var row= parent.$("#vehicleGrid").datagrid('getSelected');
    var id_num;
    if(row){
        id_num=row.vehicleNumber;
    }
    document.getElementById("id_num").value=id_num;
}
   var historyGrid=function(){
        return {
            init:function () {
                $('#historyDataGrid').datagrid({
                    rownumbers: true, //显示行号
                    multiSort: true, //启用排序
                    sortable: true, //启用排序列
                    autoRowWidth: true,
                    fit: true, //自动适屏功能
                    singleSelect: true,
                    fitcolumns: true,
                    onClickRow:function(rowIndex,data){
                         baiduMap.translateSelect(data);
                    }
                })
            }
        }
}();




