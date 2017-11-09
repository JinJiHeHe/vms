var datagrid=function(){

    return {
        init:function(){
            $("#vehicleGrid").datagrid({

            rowStyler:function(index,row){
                    var rows = $("#vehicleGrid").datagrid("getSelections");
                    if(rows!=null){
                        return 'background-color:pink;color:blue;font-weight:bold;';
                    }
                },
                fit:true,
                frozenColumns: [[
                    {field:'ck',checkbox:true},
                    {field:'vehicleNumber',title:'车号',width:100},
                ]],
                columns:[[
                    {field:'state',title:'车辆状态',width:100},
                    {field:'location',title:'位置',width:100},
                    {field:'lon',title:'经度',width:100},
                    {field:'lat',title:'纬度',width:100},
                    {field:'gTime',title:'时间',width:100},
                    {field:'speed',title:'速度',width:100},
                    {field:'sim',title:'sim卡号',width:100},
                    {field:'terminalID',title:'终端号',width:100},
                    {field:'direction',title:'方向',width:100},
                    {field:'mileage',title:'当日里程',width:100},
                    {field:'terminalType',title:'终端类型',width:100},

                ]],
                onRowContextMenu: function(e, rowIndex, rowData){
                    //alert("...");
                    if(rowIndex>=0) {
                        e.preventDefault();//阻止浏览器捕获右键事件
                        $("#vehicleGrid").datagrid("clearSelections"); //取消所有选中项
                        $("#vehicleGrid").datagrid("selectRow", rowIndex); //根据索引选中该行
                        $('#menu').menu('show', {
                            //显示右键菜单
                            left: e.pageX,//在鼠标点击处显示菜单
                            top: e.pageY
                        });
                    }
                }

//                   //全选
//                   onCheckAll:function() {
//                       $('#vehicleGrid').datagrid('selectAll');
//                   },
//                   //反选
//                   unselectRow:function() {
//                       var s_rows = $.map($('#vehicleGrid').datagrid('getSelections'),
//                           function(n) {
//                               return $('#vehicleGrid').datagrid('getRowIndex', n);
//                           });
//                       $('#vehicleGrid').datagrid('selectAll');
//                       $.each(s_rows, function(i, n) {
//                           $('#vehicleGrid').datagrid('unselectRow', n);
//                       });
//
//                   },
// //全清
//                   onUncheckAll:function() {
//                       $('#vehicleGrid').datagrid('clearSelections');
//                   }

            })
        },


    }
}();
//地图
var baiduMap=function(){
    var map ;          // 创建地图实例
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
            var lon=arry.rows[0].lon;
            var lat=arry.rows[0].lat;
            var vid=arry.rows[0].vehicleID;
            var id_num=arry.rows[0].vehicleNumber;

            var convertor=new BMap.Convertor();
            var gpsPoint = new BMap.Point(lon,lat);
            var pointArr = [];
            pointArr.push(gpsPoint);

            var mapVid=keyMap[id_num];

            if(mapVid!=null){  //判断上一个标记点
                baiduMap.deleteMarker(mapVid);
            }
            convertor.translate(pointArr,1,5,function(data){   //原始经纬度转成百度坐标

                var point=data.points[0];
                var myIcon = new BMap.Icon("http://lbsyun.baidu.com/jsdemo/img/car.png",new BMap.Size(200,157));
                var marker2 = new BMap.Marker(point,{icon:myIcon});  // 创建标注
                // var label=new BMap.Label(id_num);
                // label.setStyle({ color : "red", fontSize : "12px" });
                // marker2.setLabel(label);
                // marker2.setTitle(id_num);

                // var infoWindow = new BMap.InfoWindow(id_num);  // 创建信息窗口对象
                // map.openInfoWindow(infoWindow,point); //开启信息窗口

                map.addOverlay(marker2);
                map.centerAndZoom(point, 12);
                keyMap[id_num]=id_num;//存到map中
            });
            return arry;
        }

    }

}();
function addTab(title,url) {
    if ($('#maintab').tabs('exists', title)){
        $('#maintab').tabs('select', title);
    } else {
        var content = '<iframe id="history1" scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
        $('#maintab').tabs('add',{
            title:title,
            content:content,
            closable:true
        });


    }
}

